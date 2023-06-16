package com.myproject.sales.di

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.myproject.sales.screens.home.HomeRepository
import com.myproject.sales.screens.home.HomeRepositoryImpl
import com.myproject.sales.screens.menu.PersonalInfoRepository
import com.myproject.sales.screens.menu.PersonalInfoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePersonalInfoRepository(database: FirebaseDatabase): PersonalInfoRepository =
        PersonalInfoRepositoryImpl(database)

    @Provides
    @Singleton
    fun provideHomeRepository(database: FirebaseDatabase): HomeRepository =
        HomeRepositoryImpl(database)

    @Provides
    @Singleton
    fun provideRealtimeDatabase(): FirebaseDatabase =
        Firebase.database("https://sales-e1c93-default-rtdb.europe-west1.firebasedatabase.app")
}
