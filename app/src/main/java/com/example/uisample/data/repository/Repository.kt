package com.example.uisample.data.repository

import androidx.lifecycle.LiveData
import com.example.uisample.data.DailyModel
import com.example.uisample.data.Dao

class Repository(private val note:Dao) {
    val getallData:LiveData<List<DailyModel>> = note.getalldata()

    suspend fun addData(add:DailyModel){
        note.addData(add)

    }
    suspend fun updateData(update:DailyModel){
        note.updatedata(update)
    }

    suspend fun deleteData(delete:DailyModel){
        note.deletedata(delete)

    }
}