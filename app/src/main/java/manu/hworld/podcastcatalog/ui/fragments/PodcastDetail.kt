package manu.hworld.podcastcatalog.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import manu.hworld.podcastcatalog.R
import manu.hworld.podcastcatalog.databinding.FragmentPodcastDetailBinding


@AndroidEntryPoint
class PodcastDetail : Fragment() {
    private lateinit var binding: FragmentPodcastDetailBinding
    private var podcastName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            podcastName = it.getString(PODCAST_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPodcastDetailBinding.inflate(inflater, container, false)

        binding.tvPodcastsTitle.text = podcastName

        return binding.root
    }

    companion object {

        private const val PODCAST_NAME = "PODCAST_NAME"


        @JvmStatic
        fun newInstance(podcastName: String) =
            PodcastDetail().apply {
                arguments = Bundle().apply {
                    putString(PODCAST_NAME, podcastName)
                }
            }
    }
}