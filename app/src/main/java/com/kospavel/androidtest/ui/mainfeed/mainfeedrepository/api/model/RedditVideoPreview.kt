package com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api.model

data class RedditVideoPreview(
    val dash_url: String,
    val duration: Int,
    val fallback_url: String,
    val height: Int,
    val hls_url: String,
    val is_gif: Boolean,
    val scrubber_media_url: String,
    val transcoding_status: String,
    val width: Int
)