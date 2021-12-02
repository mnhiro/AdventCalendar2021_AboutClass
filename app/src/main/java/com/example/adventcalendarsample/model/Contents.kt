package com.example.adventcalendarsample.model

/**
 * 音楽・動画・画像が共通で持つプロパティ
 */
sealed interface Contents {
    val id: Long
    val title: String
}