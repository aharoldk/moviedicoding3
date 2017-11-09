package com.aharoldk.moviedicoding3.model

import com.google.gson.annotations.SerializedName

class ResultsItem {

    @SerializedName("overview")
    var overview: String? = null

    @SerializedName("original_language")
    var originalLanguage: String? = null

    @SerializedName("original_title")
    var originalTitle: String? = null

    @SerializedName("video")
    var isVideo: Boolean = false

    @SerializedName("title")
    var title: String? = null

    @SerializedName("genre_ids")
    var genreIds: List<Int>? = null

    @SerializedName("poster_path")
    var posterPath: String? = null

    @SerializedName("backdrop_path")
    var backdropPath: String? = null

    @SerializedName("release_date")
    var releaseDate: String? = null

    @SerializedName("vote_average")
    var voteAverage: Double = 0.toDouble()

    @SerializedName("popularity")
    var popularity: Double = 0.toDouble()

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("adult")
    var isAdult: Boolean = false

    @SerializedName("vote_count")
    var voteCount: Int = 0

    override fun toString(): String {
        return "ResultsItem{" +
                "overview = '" + overview + '\'' +
                ",original_language = '" + originalLanguage + '\'' +
                ",original_title = '" + originalTitle + '\'' +
                ",video = '" + isVideo + '\'' +
                ",title = '" + title + '\'' +
                ",genre_ids = '" + genreIds + '\'' +
                ",poster_path = '" + posterPath + '\'' +
                ",backdrop_path = '" + backdropPath + '\'' +
                ",release_date = '" + releaseDate + '\'' +
                ",vote_average = '" + voteAverage + '\'' +
                ",popularity = '" + popularity + '\'' +
                ",id = '" + id + '\'' +
                ",adult = '" + isAdult + '\'' +
                ",vote_count = '" + voteCount + '\'' +
                "}"
    }

    constructor() {}

    constructor(overview: String, originalLanguage: String, originalTitle: String, video: Boolean, title: String, genreIds: List<Int>, posterPath: String, backdropPath: String, releaseDate: String, voteAverage: Double, popularity: Double, id: Int, adult: Boolean, voteCount: Int) {
        this.overview = overview
        this.originalLanguage = originalLanguage
        this.originalTitle = originalTitle
        this.isVideo = video
        this.title = title
        this.genreIds = genreIds
        this.posterPath = posterPath
        this.backdropPath = backdropPath
        this.releaseDate = releaseDate
        this.voteAverage = voteAverage
        this.popularity = popularity
        this.id = id
        this.isAdult = adult
        this.voteCount = voteCount
    }
}