package manu.hworld.podcastcatalog.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import manu.hworld.podcastcatalog.data.room.PodcastDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val PODCAST_DATABASE_NAME = "podcast_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): PodcastDatabase{
        return Room.databaseBuilder(context, PodcastDatabase::class.java, PODCAST_DATABASE_NAME).
                fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun providePodcastDao(db: PodcastDatabase) = db.getPodcastDao()

}

