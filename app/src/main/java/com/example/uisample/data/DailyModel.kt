package com.example.uisample.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "Routine_Table")
@Parcelize
data class DailyModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var description: String
):Parcelable