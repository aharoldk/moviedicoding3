package com.aharoldk.moviedicoding3.model

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("dates")
    var dates: Dates? = null

    @SerializedName("page")
    var page: Int = 0

    @SerializedName("total_pages")
    var totalPages: Int = 0

    @SerializedName("results")
    var results: List<ResultsItem>? = null

    @SerializedName("total_results")
    var totalResults: Int = 0

    constructor(dates: Dates?, page: Int, totalPages: Int, results: List<ResultsItem>?, totalResults: Int) {
        this.dates = dates
        this.page = page
        this.totalPages = totalPages
        this.results = results
        this.totalResults = totalResults
    }

    constructor()


    override fun toString(): String {
        return "Movie{" +
                "dates = '" + dates + '\'' +
                ",page = '" + page + '\'' +
                ",total_pages = '" + totalPages + '\'' +
                ",results = '" + results + '\'' +
                ",total_results = '" + totalResults + '\'' +
                "}"
    }

}