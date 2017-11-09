package com.aharoldk.moviedicoding3.model

import com.google.gson.annotations.SerializedName

class Dates {

    @SerializedName("maximum")
    var maximum: String? = null

    @SerializedName("minimum")
    var minimum: String? = null

    override fun toString(): String {
        return "Dates{" +
                "maximum = '" + maximum + '\'' +
                ",minimum = '" + minimum + '\'' +
                "}"
    }
}