package com.example.adventcalendarsample.model

import kotlin.random.Random

sealed interface Music: Contents {
    override val id: Long
    override val title: String
    val artist: String
    val bitrate: Long
    val duration: Long
    val size: Long

    companion object{
        /**
         * 適当に楽曲用サンプルを作る関数
         */
        fun createSample(): List<Music> {
            val list = mutableListOf<Music>()
            for (i in 1..3) {
                val range = (0..3)
                when(range.random()) {
                    0 -> {
                        list.add(
                            DWeekMusicImpl(
                                id = i.toLong(),
                                title = "dのなんちゃら楽曲${(0..100).random()}",
                                artist = "レコチョク太郎",
                                bitrate = if ((0..1).random() == 0) 128000 else 44100,
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                dNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    1 -> {
                        list.add(
                            PraypassMusicImpl(
                                id = i.toLong(),
                                title = "pのなんちゃら楽曲${(0..100).random()}",
                                artist = "レコチョク次郎",
                                bitrate = if ((0..1).random() == 0) 128000 else 44100,
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                pNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    2 -> {
                        list.add(
                            MerketMusicImpl(
                                id = i.toLong(),
                                title = "mのなんちゃら楽曲${(0..100).random()}",
                                artist = "レコチョク三郎",
                                bitrate = if ((0..1).random() == 0) 128000 else 44100,
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                mNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    3 -> {
                        list.add(
                            TrachokuMusicImpl(
                                id = i.toLong(),
                                title = "tのなんちゃら楽曲${(0..100).random()}",
                                artist = "レコチョク四郎",
                                bitrate = if ((0..1).random() == 0) 128000 else 44100,
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

data class DWeekMusicImpl(
    override val id: Long,
    override val title: String,
    override val artist: String,
    override val bitrate: Long,
    override val duration: Long,
    override val size: Long,
    override val dNumber: Int,
): Music, DWeek

data class PraypassMusicImpl(
    override val id: Long,
    override val title: String,
    override val artist: String,
    override val bitrate: Long,
    override val duration: Long,
    override val size: Long,
    override val pNumber: Int
): Music, Praypass

data class MerketMusicImpl(
    override val id: Long,
    override val title: String,
    override val artist: String,
    override val bitrate: Long,
    override val duration: Long,
    override val size: Long,
    override val mNumber: Int
): Music, Merket

data class TrachokuMusicImpl(
    override val id: Long,
    override val title: String,
    override val artist: String,
    override val bitrate: Long,
    override val duration: Long,
    override val size: Long,
    override val tNumber: Int
): Music, Trachoku