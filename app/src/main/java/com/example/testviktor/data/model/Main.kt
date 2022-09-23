package com.example.testviktor.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Main(
    @SerialName("success")
    val success: Boolean,
    @SerialName("time")
    val time: String,
    @SerialName("data")
    val `data`: Data
) {
    @Serializable
    data class Data(
        @SerialName("buttons")
        val buttons: List<Button>,
        @SerialName("content")
        val content: List<Content>
    ) {
        @Serializable
        data class Button(
            @SerialName("icon")
            val icon: String,
            @SerialName("color")
            val color: String,
            @SerialName("title")
            val title: String,
            @SerialName("type")
            val type: String,
            @SerialName("url")
            val url: String
        )

        @Serializable
        data class Content(
            @SerialName("title")
            val title: String,
            @SerialName("template")
            val template: Template,
            @SerialName("url")
            val url: String
        ) {
            @Serializable
            data class Template(
                @SerialName("card")
                val card: String,
                @SerialName("object")
                val objectX: String,
                @SerialName("size")
                val size: String,
                @SerialName("direction")
                val direction: String
            )
        }
    }
}