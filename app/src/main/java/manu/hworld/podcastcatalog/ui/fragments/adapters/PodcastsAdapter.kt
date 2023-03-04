package manu.hworld.podcastcatalog.ui.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.squareup.picasso.Picasso
import manu.hworld.podcastcatalog.databinding.PodcastListItemBinding
import manu.hworld.podcastcatalog.domain.models.PodcastOverview

class PodcastsAdapter(
    private val items: List<PodcastOverview>,
    private val onClick: (PodcastOverview) -> Unit
) : RecyclerView.Adapter<PodcastsAdapter.PodcastViewHolder>() {

    inner class PodcastViewHolder(binding: PodcastListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            val name = binding.tvPodcastsTitle
            val author = binding.tvAuthor
            val image = binding.ivPodcast
            val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodcastViewHolder {
        return PodcastViewHolder(
            PodcastListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: PodcastViewHolder, position: Int) {
        holder.name.text = items[position].name
        holder.author.text = items[position].author
        if (!items[position].image.isNullOrEmpty()){
            Picasso.get().load(items[position].image).into(holder.image)
        }
        holder.root.setOnClickListener {
            onClick(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

}