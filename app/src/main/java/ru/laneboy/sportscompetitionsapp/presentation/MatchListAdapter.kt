package ru.laneboy.sportscompetitionsapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import ru.laneboy.sportscompetitionsapp.R
import ru.laneboy.sportscompetitionsapp.domane.MatchItem

class MatchListAdapter:  ListAdapter<MatchItem, MatchItemViewHolder>(MatchItemDiffCallback()) {

    var onMatchItemClickListener: ((MatchItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchItemViewHolder {
        val layout = R.layout.match_item
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return MatchItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MatchItemViewHolder, position: Int) {
        val matchItem = getItem(position)

        with(viewHolder) {
            ivTeamOneLabel.text = matchItem.labelTeamOne
            ivTeamTwoLabel.text = matchItem.labelTeamTwo
            tvTeamOneScore.text = matchItem.scoreTeamOne.toString()
            tvTeamOneScore.text = matchItem.scoreTeamTwo.toString()
            tvButtonAddScore.setOnClickListener {
                onMatchItemClickListener?.invoke(matchItem)
            }
        }
    }

    companion object {

        const val VIEW_TYPE = 101
        const val MAX_POOL_SIZE = 30
    }
}