package com.kospavel.androidtest.ui.mainfeed.mainfeedrepository

import com.kospavel.androidtest.ui.mainfeed.*

class PostBuilder {

    companion object {

        fun build(rawPostData: RawPostData): Post {
            val items = mutableListOf<Any>()
            items.apply {
                add(Title(rawPostData.title))
                add(Author(rawPostData.author))
            }
            when (type(rawPostData)) {
                PostType.IMAGE -> {
                    items.add(Image(rawPostData.url))
                }
                PostType.GIF -> {
                    items.add(Gif(rawPostData.url))
                }
                else -> {

                }
            }
            return Post(items = items)
        }

        private fun type(rawPostData: RawPostData): PostType {
            return when {
                isImage(rawPostData) -> {
                    PostType.IMAGE
                }
                isGif(rawPostData) -> {
                    PostType.GIF
                }
                else -> {
                    PostType.TITLE_ONLY
                }
            }
        }

        private fun isImage(rawPostData: RawPostData): Boolean {
            return rawPostData.url.let {
                it.contains("i.redd.it", ignoreCase = true) && !it.contains(
                    ".gif",
                    ignoreCase = true
                )
            }
        }

        private fun isGif(rawPostData: RawPostData): Boolean {
            return rawPostData.url.let {
                it.contains("i.redd.it", ignoreCase = true) && it.contains(
                    ".gif",
                    ignoreCase = true
                )
            }
        }

    }
}