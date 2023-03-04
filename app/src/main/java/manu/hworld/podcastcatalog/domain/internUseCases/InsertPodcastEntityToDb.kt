package manu.hworld.podcastcatalog.domain.internUseCases

import manu.hworld.podcastcatalog.data.PodcastRepository
import manu.hworld.podcastcatalog.data.room.PodcastDao

import javax.inject.Inject

class InsertPodcastEntityToDb @Inject constructor(
    private val podcastRepository: PodcastRepository,
    private val getPodcastsFromNetworkUseCase: GetPodcastsFromNetworkUseCase
) {

    suspend operator fun invoke(){
        podcastRepository.insertPodcastsInDatabase(getPodcastsFromNetworkUseCase())
    }

}