package com.example.adventcalendarsample.model

import kotlin.random.Random

sealed interface Movie: Contents {
    override val id: Long
    override val title: String
    val resolution: Int
    val duration: Long
    val size: Long

    companion object {
        /**
         * 適当に動画用サンプルを作る関数
         */
        fun createSample(): List<Movie> {
            val list = mutableListOf<Movie>()
            for (i in 1..3) {
                val range = (0..3)
                when(range.random()) {
                    0 -> {
                        list.add(
                            AnimeMovieImpl(
                                id = i.toLong(),
                                title = "aのアニメ動画${(0..100).random()}",
                                resolution = when((0..2).random()){
                                    0 -> 480
                                    1 -> 720
                                    else -> 1080
                                },
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                aNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    1 -> {
                        list.add(
                            IdolMovieImpl(
                                id = i.toLong(),
                                title = "iのアイドル動画${(0..100).random()}",
                                resolution = when((0..2).random()){
                                    0 -> 480
                                    1 -> 720
                                    else -> 1080
                                },
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                iNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    2 -> {
                        list.add(
                            GameMovieImpl(
                                id = i.toLong(),
                                title = "gのゲーム動画${(0..100).random()}",
                                resolution = when((0..2).random()){
                                    0 -> 480
                                    1 -> 720
                                    else -> 1080
                                },
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                gNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    3 -> {
                        list.add(
                            RockMovieImpl(
                                id = i.toLong(),
                                title = "rのロックな動画${(0..100).random()}",
                                resolution = when((0..2).random()){
                                    0 -> 480
                                    1 -> 720
                                    else -> 1080
                                },
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                rNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                }
            }
            return list
        }
    }
}

data class AnimeMovieImpl(
    override val id: Long,
    override val title: String,
    override val resolution: Int,
    override val duration: Long,
    override val size: Long,
    override val aNumber: Int,
): Movie, Anime

data class IdolMovieImpl(
    override val id: Long,
    override val title: String,
    override val resolution: Int,
    override val duration: Long,
    override val size: Long,
    override val iNumber: Int
): Movie, Idol

data class GameMovieImpl(
    override val id: Long,
    override val title: String,
    override val resolution: Int,
    override val duration: Long,
    override val size: Long,
    override val gNumber: Int
): Movie, Game

data class RockMovieImpl(
    override val id: Long,
    override val title: String,
    override val resolution: Int,
    override val duration: Long,
    override val size: Long,
    override val rNumber: Int
): Movie, Rock