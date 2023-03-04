package manu.hworld.podcastcatalog.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import manu.hworld.podcastcatalog.data.room.entities.PodcastEntity

@Dao
interface PodcastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPodcastToDatabase(podcastList: List<PodcastEntity>)

    @Query("select * from `podcast_table`")
    suspend fun fetchPodcastsFromDatabase(): List<PodcastEntity>

    @Query("SELECT * FROM podcast_table WHERE name LIKE '%' || :query || '%' OR author LIKE '%' || :query || '%'")
    suspend fun fetchPodcastByName(query: String): List<PodcastEntity>

}