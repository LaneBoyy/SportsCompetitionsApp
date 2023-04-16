package ru.laneboy.sportscompetitionsapp.presentation.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.laneboy.sportscompetitionsapp.R
import ru.laneboy.sportscompetitionsapp.databinding.FragmentMatchItemAddBinding
import ru.laneboy.sportscompetitionsapp.presentation.MatchAddViewModel

class MatchItemAddFragment : Fragment() {

    private var _binding: FragmentMatchItemAddBinding? = null
    private val binding: FragmentMatchItemAddBinding
        get() = _binding ?: throw RuntimeException("FragmentMatchItemAddBinding == null")

    private lateinit var viewModel: MatchAddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchItemAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationIsGone()
        viewModel = ViewModelProvider(this)[MatchAddViewModel::class.java]
        observeViewModel()
        setOnButtonCreateClick()
    }

    private fun bottomNavigationIsGone() {
        requireActivity()
            .findViewById<BottomNavigationView>(R.id.bottom_navigation)
            .visibility = View.GONE
    }


    private fun setOnButtonCreateClick() {
        binding.btnCreateMatch.setOnClickListener {
            viewModel.addMatchItemUseCase()
        }
    }

    private fun observeViewModel() {
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner) {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance() = MatchItemAddFragment()
    }
}