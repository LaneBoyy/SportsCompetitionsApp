package ru.laneboy.sportscompetitionsapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MatchListDao {

    @Query("SELECT * FROM match_items")
    fun getMatchList(): LiveData<List<MatchItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMatchItem(matchItemDbModel: MatchItemDbModel)

    @Query("DELETE FROM match_items WHERE id=:matchItemId")
    suspend fun deleteMatchItem(matchItemId: Int)

    @Query("SELECT * FROM match_items WHERE id=:matchItemId LIMIT 1")
    suspend fun getMatchItem(matchItemId: Int): MatchItemDbModel
}