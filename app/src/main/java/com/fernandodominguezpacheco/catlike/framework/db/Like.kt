package com.fernandodominguezpacheco.catlike.framework.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Like constructor(
    @PrimaryKey(autoGenerate = true) val id: Int,
    var breedId: String,
    var date: Date
) {
}