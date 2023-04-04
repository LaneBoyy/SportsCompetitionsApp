package ru.laneboy.sportscompetitionsapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import ru.laneboy.sportscompetitionsapp.domane.MatchItem
import ru.laneboy.sportscompetitionsapp.domane.MatchListRepository

class MatchListRepositoryImpl(
    application: Application
) : MatchListRepository {

    private val matchListDao = AppDatabase.getInstance(application).matchListDao()
    private val mapper = MatchListMapper()

    override suspend fun addMatchItem(matchItem: MatchItem) {
        matchListDao.addMatchItem(mapper.mapEntityToDbModel(matchItem))
    }

    override suspend fun deleteMatchItem(matchItem: MatchItem) {
        matchListDao.deleteMatchItem(matchItem.id)
    }

    override suspend fun editMatchItem(matchItem: MatchItem) {
        matchListDao.addMatchItem(mapper.mapEntityToDbModel(matchItem))
    }

    override suspend fun getMatchItem(matchItemId: Int): MatchItem {
        val dbModel = matchListDao.getMatchItem(matchItemId)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override fun getMatchList(): LiveData<List<MatchItem>> =
        Transformations.map(matchListDao.getMatchList()) {
            mapper.mapListDbModelToListEntity(it)
        }
}