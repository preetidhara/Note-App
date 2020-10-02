package com.example.uisample.data.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.uisample.data.DailyModel
import com.example.uisample.data.Dao
import com.example.uisample.data.RouTineDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RepoModel(application: Application):AndroidViewModel(application) {

    private val repository : Repository

    val getAlldata:LiveData<List<DailyModel>>
    init {

        val dao =RouTineDatabase.getDatabase(application).dao()
        repository= Repository(dao)
        getAlldata=repository.getallData

    }

    fun addData(todoData:DailyModel){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addData(todoData)
        }
    }
    fun updateData(todoData: DailyModel){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateData(todoData)
        }
    }
    fun deleteData(todoData: DailyModel){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteData(todoData)
        }
    }
}