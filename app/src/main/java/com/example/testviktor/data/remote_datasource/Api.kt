package com.example.testviktor.data.remote_datasource

import com.example.testviktor.data.model.*
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("base-app/fun?id=117&type=food")
    suspend fun getFood(): com.example.mappa.data.result.Result<Foods>

    @GET("base-app/rooms?id=117")
    suspend fun getRooms(): com.example.mappa.data.result.Result<Rooms>

    @GET("base-app/fun?id=117&type=fun")
    suspend fun getEntertainment(): com.example.mappa.data.result.Result<Entertainment>

    @GET("base-app/fun?id=117&type=child")
    suspend fun getChild(): com.example.mappa.data.result.Result<Child>

    @GET("base-app/tours?id=117")
    suspend fun getTours(): com.example.mappa.data.result.Result<Tours>

    @GET("base-app/fun?id=117&type=place")
    suspend fun getPlace(): com.example.mappa.data.result.Result<Place>

    @GET("base-app/blog?id=117&format=card")
    suspend fun getBlog(): com.example.mappa.data.result.Result<Blog>

    @GET("base-app/blog-info?id=117")
    suspend fun getBlogById(
        @Query("blog_id") blogId: Int
    ): com.example.mappa.data.result.Result<BlogDetail>

    @GET("base-app/main?id=117")
    suspend fun getMain(): com.example.mappa.data.result.Result<Main>

}