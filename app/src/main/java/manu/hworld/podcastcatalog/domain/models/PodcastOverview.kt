package manu.hworld.podcastcatalog.domain.models

import androidx.room.PrimaryKey
import manu.hworld.podcastcatalog.data.models.Image
import java.util.*

/*
data class PodcastOverview(
    val name: String,
    val author: String,
    val image: String = ""
)

 */

data class PodcastOverview(
    val id: String,
    val name: String,
    val author: String,
    val description: String,
    val image: String = "",
    val price: String = "free", //todo mirar lo de las monedas
    val lastRelease: String,
    val dbInsertionDate: Long
)
