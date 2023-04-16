package ru.laneboy.sportscompetitionsapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.laneboy.sportscompetitionsapp.R
import ru.laneboy.sportscompetitionsapp.databinding.FragmentMatchItemBinding
import ru.laneboy.sportscompetitionsapp.presentation.MainActivity

class MatchItemFragment : Fragment() {

    private var _binding: FragmentMatchItemBinding? = null
    private val binding: FragmentMatchItemBinding
        get() = _binding ?: throw RuntimeException("FragmentMatchItemBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationIsGone()
    }

    private fun bottomNavigationIsGone() {
        requireActivity()
            .findViewById<BottomNavigationView>(R.id.bottom_navigation)
            .visibility = View.GONE
    }

    companion object {

        fun newInstance() = MatchItemFragment()
    }
}