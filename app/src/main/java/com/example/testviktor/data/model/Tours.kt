package com.example.testviktor.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tours(
    @SerialName("success")
    val success: Boolean,
    @SerialName("time")
    val time: String,
    @SerialName("data")
    val `data`: List<Data>
) {
    @Serializable
    data class Data(
        @SerialName("id")
        val id: Int,
        @SerialName("url")
        val url: String,
        @SerialName("image")
        val image: Image,
        @SerialName("title")
        val title: String,
        @SerialName("location")
        val location: String,
        @SerialName("date")
        val date: Date,
        @SerialName("duration")
        val duration: Duration,
        @SerialName("price")
        val price: Price,
        @SerialName("home")
        val home: Home
    ) {
        @Serializable
        data class Image(
            @SerialName("sm")
            val sm: String,
            @SerialName("md")
            val md: String,
            @SerialName("lg")
            val lg: String
        )

        @Serializable
        data class Date(
            @SerialName("typeDate")
            val typeDate: String,
            @SerialName("date")
            val date: String
        )

        @Serializable
        data class Duration(
            @SerialName("hour")
            val hour: Int?,
            @SerialName("day")
            val day: Int?,
            @SerialName("night")
            val night: Int?
        )

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

        @Serializable
        data class Home(
            @SerialName("id")
            val id: Int,
            @SerialName("name")
            val name: String,
            @SerialName("type")
            val type: String,
            @SerialName("night")
            val night: Int?,
            @SerialName("url")
            val url: String,
            @SerialName("image")
            val image: Image,
            @SerialName("base")
            val base: Base
        ) {
            @Serializable
            data class Image(
                @SerialName("lg")
                val lg: String,
                @SerialName("md")
                val md: String,
                @SerialName("sm")
                val sm: String
            )

            @Serializable
            data class Base(
                @SerialName("id")
                val id: Int,
                @SerialName("name")
                val name: String,
                @SerialName("url")
                val url: String
            )
        }
    }
}