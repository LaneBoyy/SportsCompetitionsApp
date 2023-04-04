package ru.laneboy.sportscompetitionsapp.domane

import androidx.lifecycle.LiveData

interface MatchListRepository {

    suspend fun addMatchItem(matchItem: MatchItem)

    suspend fun deleteMatchItem(matchItem: MatchItem)

    suspend fun editMatchItem(matchItem: MatchItem)

    suspend fun getMatchItem(matchItemId: Int): MatchItem

    fun getMatchList(): LiveData<List<MatchItem>>
}