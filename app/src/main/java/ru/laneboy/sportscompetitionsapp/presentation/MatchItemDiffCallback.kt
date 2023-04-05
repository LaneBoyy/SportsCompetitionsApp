package ru.laneboy.sportscompetitionsapp.presentation

import androidx.recyclerview.widget.DiffUtil
import ru.laneboy.sportscompetitionsapp.domane.MatchItem

class MatchItemDiffCallback : DiffUtil.ItemCallback<MatchItem>() {

    override fun areItemsTheSame(oldItem: MatchItem, newItem: MatchItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MatchItem, newItem: MatchItem): Boolean {
        return oldItem == newItem
    }
}