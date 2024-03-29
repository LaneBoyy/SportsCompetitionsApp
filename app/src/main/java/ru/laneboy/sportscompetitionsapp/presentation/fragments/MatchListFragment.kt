package ru.laneboy.sportscompetitionsapp.presentation.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.laneboy.sportscompetitionsapp.R
import ru.laneboy.sportscompetitionsapp.databinding.FragmentMatchListBinding
import ru.laneboy.sportscompetitionsapp.domane.MatchItem
import ru.laneboy.sportscompetitionsapp.presentation.MainViewModel
import ru.laneboy.sportscompetitionsapp.presentation.MatchListAdapter

class MatchListFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private var matchListAdapter: MatchListAdapter? = null

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
        bottomNavigationIsVisible()
        setupRecyclerView()
        clickOnButtonAdd()

        viewModel.matchList.observe(viewLifecycleOwner) {
            matchListAdapter?.submitList(it)
        }
    }

    private fun bottomNavigationIsVisible() {
        requireActivity()
            .findViewById<BottomNavigationView>(R.id.bottom_navigation)
            .visibility = VISIBLE
    }

    private fun clickOnButtonAdd() {
        binding.btnAddMatchItem.setOnClickListener {
            //            <ДОБАВЛЕНИЕ В БД>
//            viewModel.addMatchItem(
//                MatchItem(
//                    labelTeamOne = "А",
//                    labelTeamTwo = "Б",
//                    0,
//                    1,
//                )
//            )
            //            </ДОБАВЛЕНИЕ В БД>
            launchFragment(MatchItemAddFragment.newInstance())
        }
    }

    private fun launchFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_main, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun setupRecyclerView() {
        with(binding.rvMatchList) {
            matchListAdapter = MatchListAdapter()
            adapter = matchListAdapter
            recycledViewPool.setMaxRecycledViews(
                MatchListAdapter.VIEW_TYPE,
                MatchListAdapter.MAX_POOL_SIZE
            )
        }
        setupClickListener()
    }

    private fun setupClickListener() {
        matchListAdapter?.onMatchItemClickListener = {
            launchFragment(MatchItemFragment.newInstance())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MatchListFragment()
    }
}