package com.example.testviktor.data.model


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Foods(
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
        @SerialName("image")
        val image: Image,
        @SerialName("title")
        val title: String,
        @SerialName("subtitle")
        val subtitle: String
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
    }
}