package ru.laneboy.sportscompetitionsapp.domane

class GetMatchItemUseCase(private val matchListRepository: MatchListRepository) {

    suspend fun getMatchItem(matchItemId: Int): MatchItem {
        return matchListRepository.getMatchItem(matchItemId)
    }
}