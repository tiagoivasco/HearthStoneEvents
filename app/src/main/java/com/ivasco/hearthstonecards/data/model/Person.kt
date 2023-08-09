package com.ivasco.hearthstonecards.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val name: String,
    val email: String
): Parcelable