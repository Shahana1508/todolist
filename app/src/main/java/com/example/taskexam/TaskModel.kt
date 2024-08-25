package com.example.taskexam

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize

@Parcelize
data class TaskModel(
    @DrawableRes val image:Int,
    val task:String,
):Parcelable
