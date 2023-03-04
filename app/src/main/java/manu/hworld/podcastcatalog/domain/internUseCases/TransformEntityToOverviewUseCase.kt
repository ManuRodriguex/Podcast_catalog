package manu.hworld.podcastcatalog.domain

import manu.hworld.podcastcatalog.data.room.entities.PodcastEntity
import manu.hworld.podcastcatalog.domain.internUseCases.GetPodcastsFromNetworkUseCase
import manu.hworld.podcastcatalog.domain.models.PodcastOverview
import javax.inject.Inject

class TransformEntityToOverviewUseCase @Inject constructor(

) {
    suspend operator fun invoke(entityList: List<PodcastEntity>): List<PodcastOverview>{
        return entityList.map {
            PodcastOverview(
                id = it.id,
                name = it.name,
                author = it.author,
                description = it.description,
                image = it.image,
                price = it.price,
                lastRelease = it.lastRelease,
                dbInsertionDate = it.dbInsertionDate
            )
        }
    }

}