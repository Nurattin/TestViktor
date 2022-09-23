package com.example.testviktor.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BlogDetail(
    @SerialName("success")
    val success: Boolean,
    @SerialName("time")
    val time: String,
    @SerialName("data")
    val `data`: Data
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
        @SerialName("subtitle")
        val subtitle: String,
        @SerialName("like")
        val like: Int,
        @SerialName("date")
        val date: String,
        @SerialName("content")
        val content: String
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