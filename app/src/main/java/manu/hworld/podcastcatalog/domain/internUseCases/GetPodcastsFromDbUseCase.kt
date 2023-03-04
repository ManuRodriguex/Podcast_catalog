package manu.hworld.podcastcatalog.domain.internUseCases

import manu.hworld.podcastcatalog.data.PodcastRepository
import manu.hworld.podcastcatalog.data.room.PodcastDao
import manu.hworld.podcastcatalog.data.room.entities.PodcastEntity
import manu.hworld.podcastcatalog.domain.TransformEntityToOverviewUseCase
import manu.hworld.podcastcatalog.domain.models.PodcastOverview
import javax.inject.Inject

class GetPodcastsFromDbUseCase @Inject constructor(
    private val podcastRepository: PodcastRepository,
    private val transformEntityToOverviewUseCase: TransformEntityToOverviewUseCase
) {
    suspend operator fun invoke(query: String?): List<PodcastOverview>{
        return if (query.isNullOrEmpty()) {
            transformEntityToOverviewUseCase(
                podcastRepository.fetchPodcastsFromDatabase()
            ) ?: emptyList()
        }else{
            transformEntityToOverviewUseCase(
                podcastRepository.fetchPodcastByName(query)
            ) ?: emptyList()
        }
    }
}