package com.kospavel.androidtest.ui.mainfeed

data class RawPostData(
    val author: String,
    val title: String,
    val url: String
)

class NoPosts

data class Title(val title: String)

open class BasePost(
    val title: Title
)

class Post(title: Title): BasePost(title)