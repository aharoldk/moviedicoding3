package com.aharoldk.moviedicoding3.model.Detail

import com.google.gson.annotations.SerializedName

class BelongsToCollection {

    @SerializedName("backdrop_path")
    var backdropPath: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("poster_path")
    var posterPath: String? = null

    override fun toString(): String {
        return "BelongsToCollection{" +
                "backdrop_path = '" + backdropPath + '\'' +
                ",name = '" + name + '\'' +
                ",id = '" + id + '\'' +
                ",poster_path = '" + posterPath + '\'' +
                "}"
    }
}