package ru.laneboy.sportscompetitionsapp.domane

import androidx.lifecycle.LiveData

class GetMatchListUseCase(private val matchListRepository: MatchListRepository) {

    fun getMatchList(): LiveData<List<MatchItem>> {
        return matchListRepository.getMatchList()
    }
}