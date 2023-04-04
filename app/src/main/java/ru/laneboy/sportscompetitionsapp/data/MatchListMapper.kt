package ru.laneboy.sportscompetitionsapp.data

import ru.laneboy.sportscompetitionsapp.domane.MatchItem

class MatchListMapper {

    fun mapEntityToDbModel(matchItem: MatchItem) = MatchItemDbModel(
        id = matchItem.id,
        labelTeamOne = matchItem.labelTeamOne,
        labelTeamTwo = matchItem.labelTeamTwo,
        scoreTeamOne = matchItem.scoreTeamOne,
        scoreTeamTwo = matchItem.scoreTeamTwo
    )

    fun mapDbModelToEntity(matchItemDbModel: MatchItemDbModel) = MatchItem(
        id = matchItemDbModel.id,
        labelTeamOne = matchItemDbModel.labelTeamOne,
        labelTeamTwo = matchItemDbModel.labelTeamTwo,
        scoreTeamOne = matchItemDbModel.scoreTeamOne,
        scoreTeamTwo = matchItemDbModel.scoreTeamTwo
    )

    fun mapListDbModelToListEntity(list: List<MatchItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}