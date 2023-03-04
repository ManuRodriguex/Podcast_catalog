package manu.hworld.podcastcatalog.data.models

import com.google.gson.annotations.SerializedName

data class Entry(
    @SerializedName("im:name")
    val name: Name,
    @SerializedName("im:image")
    val image: List<Image>,
    val summary: Summary,
    @SerializedName("im:price")
    val price: Price,
    @SerializedName("im:contentType")
    val contentType: ContentType,
    val rights: Rights,
    val title: Title,
    val link: Link,
    val id: Id,
    @SerializedName("im:artist")
    val artist: Artist,
    val category: Category,
    @SerializedName("im:releaseDate")
    val releaseDate: ReleaseDate
)

data class Name(
    val label: String
)

data class Image(
    val label: String,
    val attributes: ImageAttributes
)

data class ImageAttributes(
    val height: String
)

data class Summary(
    val label: String
)

data class Price(
    val label: String,
    val attributes: PriceAttributes
)

data class PriceAttributes(
    val amount: String,
    val currency: String
)

data class ContentType(
    val attributes: ContentTypeAttributes
)

data class ContentTypeAttributes(
    val term: String,
    val label: String
)

data class Rights(
    val label: String
)

data class Title(
    val label: String
)

data class Link(
    val attributes: LinkAttributes
)

data class LinkAttributes(
    val rel: String,
    val type: String,
    val href: String
)

data class Id(
    val label: String,
    val attributes: IdAttributes
)

data class IdAttributes(
    @SerializedName("im:id")
    val id: String
)

data class Artist(
    val label: String,
    val attributes: ArtistAttributes
)

data class ArtistAttributes(
    val href: String
)

data class Category(
    val attributes: CategoryAttributes
)

data class CategoryAttributes(
    @SerializedName("im:id")
    val id: String,
    val term: String,
    val scheme: String,
    val label: String
)

data class ReleaseDate(
    val label: String,
    val attributes: ReleaseDateAttributes
)

data class ReleaseDateAttributes(
    val label: String
)

