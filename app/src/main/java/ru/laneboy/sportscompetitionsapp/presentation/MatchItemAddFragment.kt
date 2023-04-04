package ru.laneboy.sportscompetitionsapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.laneboy.sportscompetitionsapp.R
import ru.laneboy.sportscompetitionsapp.databinding.FragmentMatchItemAddBinding

class MatchItemAddFragment : Fragment() {

    private var _binding: FragmentMatchItemAddBinding? = null
    private val binding: FragmentMatchItemAddBinding
        get() = _binding ?: throw RuntimeException("FragmentMatchItemAddBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchItemAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupBottomNavigation() {
        requireActivity()
            .findViewById<BottomNavigationView>(R.id.bottom_navigation)
            .visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        setupBottomNavigation()
        _binding = null
    }

    companion object {

        fun newInstance() = MatchItemAddFragment()
    }
}