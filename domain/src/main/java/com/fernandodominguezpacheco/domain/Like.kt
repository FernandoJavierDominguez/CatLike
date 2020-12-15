package com.fernandodominguezpacheco.domain

import java.util.*

data class Like(
    var id: Int = 0,
    var breedId: String = "",
    var date: Date = Date()
) {
}