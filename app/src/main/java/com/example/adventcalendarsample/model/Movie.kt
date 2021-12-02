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
                            DWeekMovieImpl(
                                id = i.toLong(),
                                title = "dのなんちゃら動画${(0..100).random()}",
                                resolution = when((0..2).random()){
                                    0 -> 480
                                    1 -> 720
                                    else -> 1080
                                },
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                dNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    1 -> {
                        list.add(
                            PraypassMovieImpl(
                                id = i.toLong(),
                                title = "pのなんちゃら動画${(0..100).random()}",
                                resolution = when((0..2).random()){
                                    0 -> 480
                                    1 -> 720
                                    else -> 1080
                                },
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                pNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    2 -> {
                        list.add(
                            MerketMovieImpl(
                                id = i.toLong(),
                                title = "mのなんちゃら動画${(0..100).random()}",
                                resolution = when((0..2).random()){
                                    0 -> 480
                                    1 -> 720
                                    else -> 1080
                                },
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                mNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    3 -> {
                        list.add(
                            TrachokuMovieImpl(
                                id = i.toLong(),
                                title = "tのなんちゃら動画${(0..100).random()}",
                                resolution = when((0..2).random()){
                                    0 -> 480
                                    1 -> 720
                                    else -> 1080
                                },
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                tNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                }
            }
            return list
        }
    }
}

data class DWeekMovieImpl(
    override val id: Long,
    override val title: String,
    override val resolution: Int,
    override val duration: Long,
    override val size: Long,
    override val dNumber: Int,
): Movie, DWeek

data class PraypassMovieImpl(
    override val id: Long,
    override val title: String,
    override val resolution: Int,
    override val duration: Long,
    override val size: Long,
    override val pNumber: Int
): Movie, Praypass

data class MerketMovieImpl(
    override val id: Long,
    override val title: String,
    override val resolution: Int,
    override val duration: Long,
    override val size: Long,
    override val mNumber: Int
): Movie, Merket

data class TrachokuMovieImpl(
    override val id: Long,
    override val title: String,
    override val resolution: Int,
    override val duration: Long,
    override val size: Long,
    override val tNumber: Int
): Movie, Trachoku