package com.aharoldk.moviedicoding3.adapter;

public interface DetailClickListener {
    void onItemDetailClicked(String idMovie);
    void onItemDetailShareClicked(String title, String overView, String releaseDate);
}
