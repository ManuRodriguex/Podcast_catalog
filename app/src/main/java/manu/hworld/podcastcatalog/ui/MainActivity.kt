package manu.hworld.podcastcatalog.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import manu.hworld.podcastcatalog.R
import manu.hworld.podcastcatalog.databinding.ActivityMainBinding
import manu.hworld.podcastcatalog.domain.models.PodcastOverview
import manu.hworld.podcastcatalog.ui.fragments.PodcastDetail
import manu.hworld.podcastcatalog.ui.fragments.adapters.PodcastsAdapter
import manu.hworld.podcastcatalog.ui.viewModels.MainActivityViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnQueryTextListener {
    private lateinit var binding: ActivityMainBinding

    companion object{
        const val PODCAST_DETAIL = "podcast_detail"
    }

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.mainToolbar)

        if (supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            binding.mainToolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }

        viewModel.updatePodcastList()
        binding.svPodcast.setOnQueryTextListener(this)

        viewModel.podcastList.observe(this){podcastsOverviewList ->

            displayRecyclerView(podcastsOverviewList) {
                viewModel.changeFragContVisibility()
                if (binding.myFragContainer.isVisible){
                    addFragment(PodcastDetail.newInstance(it.name), PODCAST_DETAIL)
                }
            }
        }

        viewModel.fragmentContainerVisibility.observe(this){
            //binding.myFragContainer.isGone = !it
            binding.myFragContainer.isVisible = it
        }



    }
    fun addFragment(fragment: Fragment, tag: String){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(binding.myFragContainer.id, fragment, tag)
            addToBackStack(tag)
        }
    }

    fun closeFragment(fragment: Fragment){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            closeFragment(fragment)
            addToBackStack(null)
        }
    }


    fun replaceFragment(fragment: Fragment){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(binding.myFragContainer.id, fragment)
            addToBackStack(null)
        }
    }

    private fun displayRecyclerView(
        list: List<PodcastOverview>,
        onClick: (PodcastOverview) -> Unit
    ) {
        binding.rvPodcasts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvPodcasts.adapter = PodcastsAdapter(list, onClick)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        viewModel.updatePodcastList(query)
        //requireContext().toast(query ?: "null")
        return true
    }
}