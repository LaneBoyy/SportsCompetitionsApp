package ru.laneboy.sportscompetitionsapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.laneboy.sportscompetitionsapp.R
import ru.laneboy.sportscompetitionsapp.databinding.ActivityMainBinding
import ru.laneboy.sportscompetitionsapp.databinding.FragmentMatchListBinding

class MatchListFragment : Fragment() {

    private var _binding: FragmentMatchListBinding? = null
    private val binding: FragmentMatchListBinding
        get() = _binding ?: throw RuntimeException("FragmentMatchListBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickOnButtonAdd()

    }

    private fun clickOnButtonAdd() {
        binding.btnAddMatchItem.setOnClickListener {
            goneBottomNavigation()
            launchMatchItemAddFragment()
        }
    }

    private fun goneBottomNavigation() {
        requireActivity()
            .findViewById<BottomNavigationView>(R.id.bottom_navigation)
            .visibility = GONE
    }

    private fun launchMatchItemAddFragment() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_main, MatchItemAddFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MatchListFragment()
    }
}