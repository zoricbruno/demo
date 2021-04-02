package hr.mosaicapps.notesy.model

import java.io.Serializable

data class Note(
    val title: String,
    val details: String,
    val priority: Int
) : Serializable