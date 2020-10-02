package com.example.uisample.data

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao


@Dao
interface Dao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  suspend fun addData(user:DailyModel)

    @Query("select * from routine_table order by id asc")
    fun getalldata(): LiveData<List<DailyModel>>            //function declaration karyyu 6e by livedata

    @Update
    suspend fun updatedata(user: DailyModel)

    @Delete
    suspend fun deletedata(user: DailyModel)
}