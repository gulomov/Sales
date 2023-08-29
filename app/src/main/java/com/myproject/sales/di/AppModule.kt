package com.myproject.sales.di

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.myproject.data.screens.AboutAppRepository
import com.myproject.data.screens.AboutAppRepositoryImpl
import com.myproject.data.screens.HomeRepository
import com.myproject.data.screens.HomeRepositoryImpl
import com.myproject.data.screens.PersonalInfoRepository
import com.myproject.data.screens.PersonalInfoRepositoryImpl
import com.squareup.moshi.Moshi
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
    fun providePersonalInfoRepository(
        database: FirebaseDatabase,
        reference: DatabaseReference,
    ): PersonalInfoRepository =
        PersonalInfoRepositoryImpl(database, reference)

    @Provides
    @Singleton
    fun provideHomeRepository(database: FirebaseDatabase): HomeRepository =
        HomeRepositoryImpl(database)

    @Provides
    @Singleton
    fun provideAboutAppRepository(database: FirebaseDatabase): AboutAppRepository =
        AboutAppRepositoryImpl(database)

    @Provides
    @Singleton
    fun provideRealtimeDatabase(): FirebaseDatabase =
        Firebase.database("https://sales-e1c93-default-rtdb.europe-west1.firebasedatabase.app")

    @Provides
    @Singleton
    fun provideDatabaseReference(): DatabaseReference = Firebase.database.reference

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }
}
