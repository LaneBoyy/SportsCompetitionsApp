package ru.laneboy.sportscompetitionsapp.domane

class AddMatchItemUseCase(private val matchListRepository: MatchListRepository) {

    suspend fun addMatchItem(matchItem: MatchItem) {
        matchListRepository.addMatchItem(matchItem)
    }
}