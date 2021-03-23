package hr.mosaicapps.notesy.model

import java.io.Serializable

data class Note(
    val title: String,
    val description: String,
    val importance: Int
) : Serializable