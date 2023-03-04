package manu.hworld.podcastcatalog.domain.internUseCases

import java.util.*
import javax.inject.Inject

class CurrentDate @Inject constructor() {
    operator fun invoke(): Date{
        return Date()
    }
}