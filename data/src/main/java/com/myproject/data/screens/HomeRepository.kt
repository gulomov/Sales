package com.myproject.data.screens

import com.google.firebase.database.FirebaseDatabase
import com.myproject.data.User
import com.myproject.data.generic.fetchFromDatabase
import com.myproject.data.resource.Resource
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getInfo(): Flow<Resource<User>>
    fun getCarsRealtime(): Flow<Resource<User>>
}

class HomeRepositoryImpl(
    private val database: FirebaseDatabase,
) : HomeRepository {
    override fun getInfo(): Flow<Resource<User>> =
        fetchFromDatabase("home/product", database)

    override fun getCarsRealtime(): Flow<Resource<User>> =
        fetchFromDatabase("FirstInfo", database)
}
