package com.example.adventcalendarsample.model

/** 各コンテンツが区分されるジャンルのプロパティ
 *  例として、ジャンルはそれぞれの特色を持つ
 *  今回はジャンルタイトルと番号を持つ
 * */
sealed interface Genre {
    val genreTitle: String
}

sealed interface Anime: Genre {
    val aNumber: Int
    override val genreTitle: String
        get() = "アニメ"
}

sealed interface Idol: Genre {
    val iNumber: Int
    override val genreTitle: String
        get() = "アイドル"
}

sealed interface Game: Genre {
    val gNumber: Int
    override val genreTitle: String
        get() = "ゲーム"
}

sealed interface Rock: Genre {
    val rNumber: Int
    override val genreTitle: String
        get() = "ロック"
}