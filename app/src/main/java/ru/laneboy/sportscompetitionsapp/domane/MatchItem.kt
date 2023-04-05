package ru.laneboy.sportscompetitionsapp.domane

import androidx.annotation.DrawableRes

data class MatchItem(

//    @DrawableRes
    val labelTeamOne: String,
//    @DrawableRes
    val labelTeamTwo: String,

    val scoreTeamOne: Int,
    val scoreTeamTwo: Int,
    var id: Int = UNDEFINED_ID
) {

    companion object {
        const val UNDEFINED_ID = 0
    }
}