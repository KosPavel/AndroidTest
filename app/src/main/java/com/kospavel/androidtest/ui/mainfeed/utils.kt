package com.kospavel.androidtest.ui.mainfeed

data class RawPostData(
    val author: String,
    val title: String,
    val url: String
)

class NoPosts

data class Title(val title: String)
data class Author(val author: String)

abstract class BasePost(
) {
    abstract var items: List<Any>
}

class Post(override var items: List<Any>): BasePost()