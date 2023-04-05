package ru.laneboy.sportscompetitionsapp.domane

class EditMatchItemUseCase(private val matchListRepository: MatchListRepository) {

    suspend fun editMatchItem(matchItem: MatchItem) {
        matchListRepository.editMatchItem(matchItem)
    }
}