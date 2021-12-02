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
                            AnimeMusicImpl(
                                id = i.toLong(),
                                title = "aのアニメ楽曲${(0..100).random()}",
                                artist = "レコチョク太郎",
                                bitrate = if ((0..1).random() == 0) 128000 else 44100,
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                aNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    1 -> {
                        list.add(
                            IdolMusicImpl(
                                id = i.toLong(),
                                title = "iのアイドル楽曲${(0..100).random()}",
                                artist = "レコチョク次郎",
                                bitrate = if ((0..1).random() == 0) 128000 else 44100,
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                iNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    2 -> {
                        list.add(
                            GameMusicImpl(
                                id = i.toLong(),
                                title = "gのゲーム楽曲${(0..100).random()}",
                                artist = "レコチョク三郎",
                                bitrate = if ((0..1).random() == 0) 128000 else 44100,
                                duration = (10000000..20000000).random().toLong(),
                                size = (1200000..2400000).random().toLong(),
                                gNumber = Random((0..300).random()).nextInt()
                            )
                        )
                    }
                    3 -> {
                        list.add(
                            RockMusicImpl(
                                id = i.toLong(),
                                title = "rのロックな楽曲${(0..100).random()}",
                                artist = "レコチョク四郎",
                                bitrate = if ((0..1).random() == 0) 128000 else 44100,
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

data class AnimeMusicImpl(
    override val id: Long,
    override val title: String,
    override val artist: String,
    override val bitrate: Long,
    override val duration: Long,
    override val size: Long,
    override val aNumber: Int,
): Music, Anime

data class IdolMusicImpl(
    override val id: Long,
    override val title: String,
    override val artist: String,
    override val bitrate: Long,
    override val duration: Long,
    override val size: Long,
    override val iNumber: Int
): Music, Idol

data class GameMusicImpl(
    override val id: Long,
    override val title: String,
    override val artist: String,
    override val bitrate: Long,
    override val duration: Long,
    override val size: Long,
    override val gNumber: Int
): Music, Game

data class RockMusicImpl(
    override val id: Long,
    override val title: String,
    override val artist: String,
    override val bitrate: Long,
    override val duration: Long,
    override val size: Long,
    override val rNumber: Int
): Music, Rock