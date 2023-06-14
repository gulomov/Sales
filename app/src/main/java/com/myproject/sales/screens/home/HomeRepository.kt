package com.myproject.sales.screens.home

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import com.myproject.sales.data.Resource
import com.myproject.sales.data.User
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import timber.log.Timber

interface HomeRepository {
    fun getInfo(): Flow<Resource<User>>
    fun getCarsRealtime(): Flow<Resource<User>>
}

class HomeRepositoryImpl(
    private val database: FirebaseDatabase,
) : HomeRepository {
    override fun getInfo(): Flow<Resource<User>> = callbackFlow {
        database.getReference("home/product").get()
            .addOnCompleteListener { task ->
                val response = if (task.isSuccessful) {
                    val user = task.result.getValue<User>()
                    Resource.Success(user)
                } else {
                    Resource.Error(task.exception?.localizedMessage.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose { close() }
    }

    override fun getCarsRealtime(): Flow<Resource<User>> = callbackFlow {
        database.getReference("FirstInfo")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val user = snapshot.getValue<User>()
                    trySend(Resource.Success(user)).isSuccess
                }

                override fun onCancelled(error: DatabaseError) {
                    Timber.d("Error : $error")
                    trySend(Resource.Error(error = error.message)).isFailure
                }
            })

        awaitClose { close() }
    }
}
