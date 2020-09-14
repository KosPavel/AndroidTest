package com.kospavel.androidtest.ui.mainfeed.mainfeedrepository.api.model

data class Image(
    val id: String,
    val resolutions: List<Resolution>,
    val source: Source,
    val variants: Variants
)