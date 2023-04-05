package ru.laneboy.sportscompetitionsapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.laneboy.sportscompetitionsapp.data.MatchListRepositoryImpl
import ru.laneboy.sportscompetitionsapp.domane.DeleteMatchItemUseCase
import ru.laneboy.sportscompetitionsapp.domane.EditMatchItemUseCase
import ru.laneboy.sportscompetitionsapp.domane.GetMatchListUseCase
import ru.laneboy.sportscompetitionsapp.domane.MatchItem

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MatchListRepositoryImpl(application)

    private val getMatchListUseCase = GetMatchListUseCase(repository)
    private val deleteMatchItemUseCase = DeleteMatchItemUseCase(repository)
    private val editShopItemCase = EditMatchItemUseCase(repository)

    val matchList = getMatchListUseCase.getMatchList()

    fun deleteShopItem(matchItem: MatchItem) {
        viewModelScope.launch {
            deleteMatchItemUseCase.deleteMatchItem(matchItem)
        }
    }
}