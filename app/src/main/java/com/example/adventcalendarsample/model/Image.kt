package com.example.adventcalendarsample.model

import kotlin.random.Random

sealed interface Image: Contents {
    override val id: Long
    override val title: String
    val isPdf: Boolean
    val size: Long

    companion object {
        /**
         * 適当に画像用サンプルを作る関数
         */
        fun createSample(): List<Image> {
            val list = mutableListOf<Image>()
            for (i in 1..20) {
                val range = (0..3)
                when(range.random()) {
                    0 -> {
                        list.add(
                            AnimeImageImpl(
                                id = i.toLong(),
                                title = "aのアニメ画像${(0..100).random()}",
                                isPdf = (0..1).random() != 0,
                                size = (1200000..2400000).random().toLong(),
                                aNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    1 -> {
                        list.add(
                            IdolImageImpl(
                                id = i.toLong(),
                                title = "iのアイドル画像${(0..100).random()}",
                                isPdf = (0..1).random() != 0,
                                size = (1200000..2400000).random().toLong(),
                                iNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    2 -> {
                        list.add(
                            GameImageImpl(
                                id = i.toLong(),
                                title = "gのゲーム画像${(0..100).random()}",
                                isPdf = (0..1).random() != 0,
                                size = (1200000..2400000).random().toLong(),
                                gNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    3 -> {
                        list.add(
                            RockImageImpl(
                                id = i.toLong(),
                                title = "rのロックな画像${(0..100).random()}",
                                isPdf = (0..1).random() != 0,
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

data class AnimeImageImpl(
    override val id: Long,
    override val title: String,
    override val isPdf: Boolean,
    override val size: Long,
    override val aNumber: Int
): Image, Anime

data class IdolImageImpl(
    override val id: Long,
    override val title: String,
    override val isPdf: Boolean,
    override val size: Long,
    override val iNumber: Int
): Image, Idol

data class GameImageImpl(
    override val id: Long,
    override val title: String,
    override val isPdf: Boolean,
    override val size: Long,
    override val gNumber: Int
): Image, Game

data class RockImageImpl(
    override val id: Long,
    override val title: String,
    override val isPdf: Boolean,
    override val size: Long,
    override val rNumber: Int
): Image, Rock

