package com.example.testviktor.data.model


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Blog(
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
        @SerialName("subtitle")
        val subtitle: String,
        @SerialName("view")
        val view: Int,
        @SerialName("like")
        val like: Int,
        @SerialName("date")
        val date: Date
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
            val typeDate: String,
            @SerialName("date")
            val date: String
        )
    }
}