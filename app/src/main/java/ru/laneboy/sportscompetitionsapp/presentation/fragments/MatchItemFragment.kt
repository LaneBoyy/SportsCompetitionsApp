package ru.laneboy.sportscompetitionsapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.laneboy.sportscompetitionsapp.R
import ru.laneboy.sportscompetitionsapp.databinding.FragmentMatchItemBinding

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

    companion object {

        fun newInstance() = MatchItemFragment()
    }
}