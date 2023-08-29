package com.myproject.data.screens

import com.google.firebase.database.FirebaseDatabase
import com.myproject.data.AboutApp
import com.myproject.data.generic.fetchFromDatabase
import com.myproject.data.resource.Resource
import kotlinx.coroutines.flow.Flow

interface AboutAppRepository {
    fun getAboutAppText(): Flow<Resource<AboutApp>>
}

class AboutAppRepositoryImpl(private val database: FirebaseDatabase) : AboutAppRepository {

    override fun getAboutAppText(): Flow<Resource<AboutApp>> {
        return fetchFromDatabase("aboutApp", database)
    }
}
