package com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api.model

data class Preview(
    val enabled: Boolean,
    val images: List<Image>,
    val reddit_video_preview: RedditVideoPreview
)