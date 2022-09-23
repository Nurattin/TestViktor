package com.example.testviktor.data.di

import com.example.testviktor.data.repository.*
import com.example.testviktor.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun binBlogRepository(repo: GetBlogRepositoryImpl): GetBlogRepository

    @Binds
    abstract fun binChildRepository(repo: GetChildRepositoryImpl): GetChildRepository

    @Binds
    abstract fun binEntertainmentRepository(repo: GetEntertainmentRepositoryImpl): GetEntertainmentRepository

    @Binds
    abstract fun binFoodRepository(repo: GetFoodRepositoryImpl): GetFoodRepository

    @Binds
    abstract fun binPlaceRepository(repo: GetPlaceRepositoryImpl): GetPlaceRepository

    @Binds
    abstract fun binRoomRepository(repo: GetRoomRepositoryImpl): GetRoomRepository

    @Binds
    abstract fun binToursRepository(repo: GetToursRepositoryImpl): GetToursRepository

    @Binds
    abstract fun binMainRepository(repo: GetMainRepositoryImpl): GetMainRepository
}