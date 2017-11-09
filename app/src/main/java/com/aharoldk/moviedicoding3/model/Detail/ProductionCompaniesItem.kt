package com.aharoldk.moviedicoding3.model.Detail

import com.google.gson.annotations.SerializedName

class ProductionCompaniesItem {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("id")
    var id: Int = 0

    override fun toString(): String {
        return "ProductionCompaniesItem{" +
                "name = '" + name + '\'' +
                ",id = '" + id + '\'' +
                "}"
    }
}