package com.kospavel.androidtest.ui.mainfeed

data class RawPostData(
    val author: String,
    val title: String,
    val url: String
)

class NoPosts

data class Title(val title: String)
data class Author(val author: String)
data class Image(val downloadUrl: String)
data class Gif(val downloadUrl: String)

abstract class BasePost(
) {
    abstract var items: List<Any>
}

class Post(override var items: List<Any>) : BasePost()

enum class PostType {
    IMAGE,
    TITLE_ONLY,
    TEXT,
    GIF,
    VIDEO,
    NEWS
}