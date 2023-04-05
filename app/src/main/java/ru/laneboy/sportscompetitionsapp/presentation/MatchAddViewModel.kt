package ru.laneboy.sportscompetitionsapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.laneboy.sportscompetitionsapp.data.MatchListRepositoryImpl
import ru.laneboy.sportscompetitionsapp.domane.*

class MatchAddViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = MatchListRepositoryImpl(application)

    private val getMatchItemUseCase = GetMatchItemUseCase(repository)
    private val addMatchItemUseCase = AddMatchItemUseCase(repository)
    private val editShopItemCase = EditMatchItemUseCase(repository)

    private val _matchItem = MutableLiveData<MatchItem>()
    val matchItem: LiveData<MatchItem>
        get() = _matchItem

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    fun getMatchItem(matchItemId: Int) {
        viewModelScope.launch {
            val item = getMatchItemUseCase.getMatchItem(matchItemId)
            _matchItem.value = item

        }
    }

    private fun parseTeamLabel(inputTeamLabel: String?): String {
        return inputTeamLabel?.trim() ?: ""
    }

    private fun parseTeamScore(inputTeamScore: String?): Int {
        return if ((inputTeamScore?.trim()?.toInt() ?: 0) > 0) {
            inputTeamScore?.trim()?.toInt() ?: 0
        } else {
            0
        }
    }
}