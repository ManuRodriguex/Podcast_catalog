package manu.hworld.podcastcatalog.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import manu.hworld.podcastcatalog.data.room.entities.PodcastEntity

@Database(entities = [PodcastEntity::class], version = 1)
abstract class PodcastDatabase: RoomDatabase() {
    abstract fun getPodcastDao():PodcastDao
}