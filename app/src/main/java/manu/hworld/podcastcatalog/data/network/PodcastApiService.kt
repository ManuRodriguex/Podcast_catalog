package manu.hworld.podcastcatalog.data.network

import manu.hworld.podcastcatalog.data.models.Entry
import manu.hworld.podcastcatalog.data.models.PodcastsResponse
import javax.inject.Inject

class PodcastApiService @Inject constructor(
    private val podcastApiClient: PodcastApiClient
) {
    suspend fun getPodcastResponse(): PodcastsResponse{
        return podcastApiClient.getPodcastResponse().body() as PodcastsResponse
    }
}

