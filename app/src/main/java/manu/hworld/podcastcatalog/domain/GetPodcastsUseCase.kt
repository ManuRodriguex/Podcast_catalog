package manu.hworld.podcastcatalog.domain

import android.util.Log
import kotlinx.coroutines.runBlocking
import manu.hworld.podcastcatalog.data.PodcastRepository
import manu.hworld.podcastcatalog.domain.internUseCases.CurrentDate
import manu.hworld.podcastcatalog.domain.internUseCases.GetPodcastsFromDbUseCase
import manu.hworld.podcastcatalog.domain.internUseCases.InsertPodcastEntityToDb
import manu.hworld.podcastcatalog.domain.models.PodcastOverview
import javax.inject.Inject

class GetPodcastsUseCase @Inject constructor(
    private val getPodcastsFromDbUseCase: GetPodcastsFromDbUseCase,
    private val insertPodcastEntityToDb: InsertPodcastEntityToDb,
    private val currentDate: CurrentDate
) {



    suspend operator fun invoke(
        query: String?,
        timeThresholdMs: Long = 24 * 60 * 60 * 1000
    ): List<PodcastOverview>{
        var retList: List<PodcastOverview> = getPodcastsFromDbUseCase(query)

        if (retList.isEmpty()){
            runBlocking {
                insertPodcastEntityToDb()
            }
            retList = getPodcastsFromDbUseCase(query)
        }else{
            val timeNow = currentDate().time
            val timeThen = retList[0].dbInsertionDate
            val timeDifference = timeNow - timeThen
            if (timeDifference >= timeThresholdMs){
                runBlocking {
                    insertPodcastEntityToDb()
                }
                retList = getPodcastsFromDbUseCase(query)
            }
        }

        return retList
    }

}