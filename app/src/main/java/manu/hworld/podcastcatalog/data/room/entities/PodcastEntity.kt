package manu.hworld.podcastcatalog.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import manu.hworld.podcastcatalog.data.models.*
import java.util.*

/*
data class PodcastEntity1(
    @SerializedName("im:name")
    val name: Name,
    @SerializedName("im:image")
    val image: List<Image>,
    val summary: Summary,
    @SerializedName("im:price")
    val price: Price,
    @SerializedName("im:contentType")
    val contentType: ContentType,
    val rights: Rights,
    val title: Title,
    val link: Link,
    val id: Id,
    @SerializedName("im:artist")
    val artist: Artist,
    val category: Category,
    @SerializedName("im:releaseDate")
    val releaseDate: ReleaseDate
)

 */

@Entity(tableName = "podcast_table")
data class PodcastEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val author: String,
    val description: String,
    val image: String,
    val price: String = "free", //todo mirar lo de las monedas
    val lastRelease: String,
    val dbInsertionDate: Long
)
