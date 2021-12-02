package com.example.adventcalendarsample.model

/** 各種コンテンツを売っているサービスの持つプロパティ
 *  例として、サービスはそれぞれの特色を持つ
 * */
sealed interface BusinessService{
    val serviceCompany: String
}

sealed interface DWeek: BusinessService {
    val dNumber: Int
    override val serviceCompany: String
        get() = "A社"
}

sealed interface Praypass: BusinessService {
    val pNumber: Int
    override val serviceCompany: String
        get() = "B社"
}

sealed interface Merket: BusinessService {
    val mNumber: Int
    override val serviceCompany: String
        get() = "C社"
}

sealed interface Trachoku: BusinessService {
    val tNumber: Int
    override val serviceCompany: String
        get() = "D社"
}