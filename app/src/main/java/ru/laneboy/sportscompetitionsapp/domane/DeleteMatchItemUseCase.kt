package ru.laneboy.sportscompetitionsapp.domane

class DeleteMatchItemUseCase(private val matchListRepository: MatchListRepository) {

    suspend fun deleteMatchItem(matchItem: MatchItem) {
        matchListRepository.deleteMatchItem(matchItem)
    }
}