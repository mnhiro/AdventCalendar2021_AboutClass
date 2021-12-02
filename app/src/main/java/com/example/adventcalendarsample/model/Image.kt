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
                            DWeekImageImpl(
                                id = i.toLong(),
                                title = "dのなんちゃら画像${(0..100).random()}",
                                isPdf = (0..1).random() != 0,
                                size = (1200000..2400000).random().toLong(),
                                dNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    1 -> {
                        list.add(
                            PraypassImageImpl(
                                id = i.toLong(),
                                title = "pのへんちゃら画像${(0..100).random()}",
                                isPdf = (0..1).random() != 0,
                                size = (1200000..2400000).random().toLong(),
                                pNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    2 -> {
                        list.add(
                            MerketImageImpl(
                                id = i.toLong(),
                                title = "mのうんちゃら画像${(0..100).random()}",
                                isPdf = (0..1).random() != 0,
                                size = (1200000..2400000).random().toLong(),
                                mNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    3 -> {
                        list.add(
                            TrachokuImageImpl(
                                id = i.toLong(),
                                title = "tのらんちゃら画像${(0..100).random()}",
                                isPdf = (0..1).random() != 0,
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

data class DWeekImageImpl(
    override val id: Long,
    override val title: String,
    override val isPdf: Boolean,
    override val size: Long,
    override val dNumber: Int
): Image, DWeek

data class PraypassImageImpl(
    override val id: Long,
    override val title: String,
    override val isPdf: Boolean,
    override val size: Long,
    override val pNumber: Int
): Image, Praypass

data class MerketImageImpl(
    override val id: Long,
    override val title: String,
    override val isPdf: Boolean,
    override val size: Long,
    override val mNumber: Int
): Image, Merket

data class TrachokuImageImpl(
    override val id: Long,
    override val title: String,
    override val isPdf: Boolean,
    override val size: Long,
    override val tNumber: Int
): Image, Trachoku

