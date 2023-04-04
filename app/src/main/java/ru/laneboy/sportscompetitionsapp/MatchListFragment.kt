package ru.laneboy.sportscompetitionsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MatchListFragment()
    }
}