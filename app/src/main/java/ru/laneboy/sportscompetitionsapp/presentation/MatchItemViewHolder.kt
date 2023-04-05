package ru.laneboy.sportscompetitionsapp.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ru.laneboy.sportscompetitionsapp.R

class MatchItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val ivTeamOneLabel = view.findViewById<TextView>(R.id.team_one_label)
    val ivTeamTwoLabel = view.findViewById<TextView>(R.id.team_two_label)
    val tvTeamOneScore = view.findViewById<TextView>(R.id.team_one_score)
    val tvTeamTwoScore = view.findViewById<TextView>(R.id.team_two_score)
    val tvButtonAddScore = view.findViewById<TextView>(R.id.button_add_score)
}
