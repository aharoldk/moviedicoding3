package com.aharoldk.moviedicoding3.model.Detail

import com.google.gson.annotations.SerializedName

class GenresItem {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("id")
    var id: Int = 0

    override fun toString(): String {
        return "GenresItem{" +
                "name = '" + name + '\'' +
                ",id = '" + id + '\'' +
                "}"
    }
}