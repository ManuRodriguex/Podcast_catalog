package manu.hworld.podcastcatalog.data

import androidx.room.Query
import manu.hworld.podcastcatalog.data.models.PodcastsResponse
import manu.hworld.podcastcatalog.data.network.PodcastApiService
import manu.hworld.podcastcatalog.data.room.PodcastDao
import manu.hworld.podcastcatalog.data.room.entities.PodcastEntity
import manu.hworld.podcastcatalog.domain.models.PodcastOverview
import javax.inject.Inject

class PodcastRepository @Inject constructor(
    private val podcastApiService: PodcastApiService,
    private val podcastDao: PodcastDao
) {

    suspend fun getPodcastsFromNetwork(): PodcastsResponse{
        return podcastApiService.getPodcastResponse()
    }

    suspend fun insertPodcastsInDatabase(list: List<PodcastEntity>){
        podcastDao.insertPodcastToDatabase(list)
    }
    suspend fun fetchPodcastsFromDatabase(): List<PodcastEntity>{
        return podcastDao.fetchPodcastsFromDatabase()
    }

    suspend fun fetchPodcastByName(query: String): List<PodcastEntity>{
        return podcastDao.fetchPodcastByName("$query%")
    }

}