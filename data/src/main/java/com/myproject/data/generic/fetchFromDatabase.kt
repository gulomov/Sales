package com.myproject.data.generic

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import com.myproject.data.resource.Resource
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

inline fun <reified T : Any> fetchFromDatabase(
    path: String,
    database: FirebaseDatabase,
): Flow<Resource<T>> =
    callbackFlow {
        val reference = database.getReference(path).get()

        reference.addOnCompleteListener { task ->
            val response = if (task.isSuccessful) {
                val result = task.result.getValue<T>()
                Resource.Success(result)
            } else {
                Resource.Error(task.exception?.localizedMessage.toString())
            }
            trySend(response).isSuccess
        }

        awaitClose {
            close()
        }
    }
