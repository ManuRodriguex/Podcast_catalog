package manu.hworld.podcastcatalog.domain.internUseCases

import android.util.Log
import manu.hworld.podcastcatalog.data.PodcastRepository
import manu.hworld.podcastcatalog.data.models.Entry
import manu.hworld.podcastcatalog.data.room.entities.PodcastEntity
import manu.hworld.podcastcatalog.domain.models.PodcastOverview
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.Date
import javax.inject.Inject

class GetPodcastsFromNetworkUseCase @Inject constructor(
    private val podcastRepository: PodcastRepository,
    private val currentDate: CurrentDate
) {

    suspend operator fun invoke(): List<PodcastEntity>{
        var entryList: List<Entry>? = null
        entryList = try{
            podcastRepository.getPodcastsFromNetwork().feed.entry
        }catch (e: UnknownHostException) {
            Log.e("UnknownHostException", "---------------------------------------------")
            emptyList()
        } catch (e: ConnectException) {
            Log.e("ConnectException", "---------------------------------------------")
            emptyList()
        } catch (e: SocketTimeoutException) {
            Log.e("SocketTimeoutException", "---------------------------------------------")
            emptyList()
        }

        return entryList!!.map{
            PodcastEntity(
                id = it.id.attributes.id,
                name = it.name.label,
                author = it.artist.label,
                description = it.summary.label,
                image = it.image[2].label,
                price = it.price.attributes.amount,
                lastRelease = it.releaseDate.attributes.label,
                dbInsertionDate = currentDate().time
            )
        }
    }



}

