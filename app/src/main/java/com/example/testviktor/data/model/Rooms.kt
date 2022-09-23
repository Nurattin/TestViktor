package com.example.testviktor.data.model


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Rooms(
    @SerialName("success")
    val success: Boolean,
    @SerialName("time")
    val time: String,
    @SerialName("data")
    val `data`: List<Data>
) {
    @Keep
    @Serializable
    data class Data(
        @SerialName("id")
        val id: Int,
        @SerialName("image")
        val image: Image,
        @SerialName("title")
        val title: String,
        @SerialName("date")
        val date: Date,
        @SerialName("duration")
        val duration: Duration,
        @SerialName("price")
        val price: Price,
        @SerialName("countTourist")
        val countTourist: Int,
        @SerialName("type")
        val type: String
    ) {
        @Keep
        @Serializable
        data class Image(
            @SerialName("sm")
            val sm: String,
            @SerialName("md")
            val md: String,
            @SerialName("lg")
            val lg: String
        )
        @Keep
        @Serializable
        data class Date(
            @SerialName("typeDate")
            val typeDate: String
        )
        @Keep
        @Serializable
        data class Duration(
            @SerialName("night")
            val night: Int
        )
        @Keep
        @Serializable
        data class Price(
            @SerialName("factPrice")
            val factPrice: Int,
            @SerialName("price")
            val price: Int,
            @SerialName("currency")
            val currency: String,
            @SerialName("typePrice")
            val typePrice: String
        )
    }
}