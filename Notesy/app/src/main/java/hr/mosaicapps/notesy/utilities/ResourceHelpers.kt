package hr.mosaicapps.notesy.utilities

import hr.mosaicapps.notesy.R

fun mapPriorityToColorResource(priority: Int): Int{
    return when(priority){
        1 -> R.color.red
        2 -> R.color.yellow
        else -> R.color.green
    }
}