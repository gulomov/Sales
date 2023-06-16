package com.myproject.sales.screens.menu

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.getValue
import com.myproject.sales.data.Resource
import com.myproject.sales.data.PersonalInfoData
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

interface PersonalInfoRepository {
    fun getUserInf(): Flow<Resource<PersonalInfoData>>
}

class PersonalInfoRepositoryImpl(
    private val database: FirebaseDatabase,
) : PersonalInfoRepository {
    override fun getUserInf(): Flow<Resource<PersonalInfoData>> = callbackFlow {
        database.getReference("personal-info/userInfo").get()
            .addOnCompleteListener { task ->
                val response = if (task.isSuccessful) {
                    val userInfo = task.result.getValue<PersonalInfoData>()
                    Resource.Success(userInfo)
                } else {
                    Resource.Error(task.exception?.localizedMessage.toString())
                }
                trySend(response).isSuccess
            }
        awaitClose { close() }
    }

}