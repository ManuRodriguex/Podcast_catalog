package manu.hworld.podcastcatalog.data.network

import manu.hworld.podcastcatalog.data.models.PodcastsResponse
import retrofit2.Response
import retrofit2.http.GET

interface PodcastApiClient {

    @GET("rss/toppodcasts/limit=100/genre=1310/json")
    suspend fun getPodcastResponse(): Response<PodcastsResponse>

}