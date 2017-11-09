package com.aharoldk.moviedicoding3.model.Detail

import com.google.gson.annotations.SerializedName

class Detail {

    @SerializedName("original_language")
    var originalLanguage: String? = null

    @SerializedName("imdb_id")
    var imdbId: String? = null

    @SerializedName("video")
    var isVideo: Boolean = false

    @SerializedName("title")
    var title: String? = null

    @SerializedName("backdrop_path")
    var backdropPath: String? = null

    @SerializedName("revenue")
    var revenue: Int = 0

    @SerializedName("genres")
    var genres: List<GenresItem>? = null

    @SerializedName("popularity")
    var popularity: Double = 0.toDouble()

    @SerializedName("production_countries")
    var productionCountries: List<ProductionCountriesItem>? = null

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("vote_count")
    var voteCount: Int = 0

    @SerializedName("budget")
    var budget: Int = 0

    @SerializedName("overview")
    var overview: String? = null

    @SerializedName("original_title")
    var originalTitle: String? = null

    @SerializedName("runtime")
    var runtime: Int = 0

    @SerializedName("poster_path")
    var posterPath: String? = null

    @SerializedName("spoken_languages")
    var spokenLanguages: List<SpokenLanguagesItem>? = null

    @SerializedName("production_companies")
    var productionCompanies: List<ProductionCompaniesItem>? = null

    @SerializedName("release_date")
    var releaseDate: String? = null

    @SerializedName("vote_average")
    var voteAverage: Double = 0.toDouble()

    @SerializedName("belongs_to_collection")
    var belongsToCollection: BelongsToCollection? = null

    @SerializedName("tagline")
    var tagline: String? = null

    @SerializedName("adult")
    var isAdult: Boolean = false

    @SerializedName("homepage")
    var homepage: String? = null

    @SerializedName("status")
    var status: String? = null

    override fun toString(): String {
        return "Detail{" +
                "original_language = '" + originalLanguage + '\'' +
                ",imdb_id = '" + imdbId + '\'' +
                ",video = '" + isVideo + '\'' +
                ",title = '" + title + '\'' +
                ",backdrop_path = '" + backdropPath + '\'' +
                ",revenue = '" + revenue + '\'' +
                ",genres = '" + genres + '\'' +
                ",popularity = '" + popularity + '\'' +
                ",production_countries = '" + productionCountries + '\'' +
                ",id = '" + id + '\'' +
                ",vote_count = '" + voteCount + '\'' +
                ",budget = '" + budget + '\'' +
                ",overview = '" + overview + '\'' +
                ",original_title = '" + originalTitle + '\'' +
                ",runtime = '" + runtime + '\'' +
                ",poster_path = '" + posterPath + '\'' +
                ",spoken_languages = '" + spokenLanguages + '\'' +
                ",production_companies = '" + productionCompanies + '\'' +
                ",release_date = '" + releaseDate + '\'' +
                ",vote_average = '" + voteAverage + '\'' +
                ",belongs_to_collection = '" + belongsToCollection + '\'' +
                ",tagline = '" + tagline + '\'' +
                ",adult = '" + isAdult + '\'' +
                ",homepage = '" + homepage + '\'' +
                ",status = '" + status + '\'' +
                "}"
    }
}