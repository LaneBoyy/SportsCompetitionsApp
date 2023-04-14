package ru.laneboy.sportscompetitionsapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.laneboy.sportscompetitionsapp.data.MatchListRepositoryImpl
import ru.laneboy.sportscompetitionsapp.domane.*

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MatchListRepositoryImpl(application)

    private val getMatchListUseCase = GetMatchListUseCase(repository)
    private val deleteMatchItemUseCase = DeleteMatchItemUseCase(repository)
    private val addMatchItemUseCase = AddMatchItemUseCase(repository)
    private val editShopItemCase = EditMatchItemUseCase(repository)

    val matchList = getMatchListUseCase.getMatchList()

    fun deleteMatchItem(matchItem: MatchItem) {
        viewModelScope.launch {
            deleteMatchItemUseCase.deleteMatchItem(matchItem)
        }
    }

    fun addMatchItem(matchItem: MatchItem) {
        viewModelScope.launch {
            addMatchItemUseCase.addMatchItem(matchItem)
        }
    }
}