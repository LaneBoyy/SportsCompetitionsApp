package ru.laneboy.sportscompetitionsapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "match_items")
data class MatchItemDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val labelTeamOne: String,
    val labelTeamTwo: String,
    val scoreTeamOne: Int,
    val scoreTeamTwo: Int
)