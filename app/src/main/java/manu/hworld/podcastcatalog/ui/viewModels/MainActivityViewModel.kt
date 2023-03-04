package manu.hworld.podcastcatalog.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import manu.hworld.podcastcatalog.domain.GetPodcastsUseCase
import manu.hworld.podcastcatalog.domain.models.PodcastOverview
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getPodcastUseCase: GetPodcastsUseCase
): ViewModel() {
    private val _podcastList = MutableLiveData<List<PodcastOverview>>()
    val podcastList: MutableLiveData<List<PodcastOverview>> = _podcastList

    private val _fragmentContainerVisibility = MutableLiveData<Boolean>(false)
    val fragmentContainerVisibility: MutableLiveData<Boolean> = _fragmentContainerVisibility

    fun updatePodcastList(query: String? = null){
        viewModelScope.launch {
            _podcastList.value = getPodcastUseCase(query) ?: emptyList()
        }
    }

    fun changeFragContVisibility(){
        _fragmentContainerVisibility.value = !_fragmentContainerVisibility.value!!
    }

}