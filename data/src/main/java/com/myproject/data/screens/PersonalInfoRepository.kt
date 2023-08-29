package com.myproject.data.screens

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.myproject.data.PersonalInfoData
import com.myproject.data.generic.fetchFromDatabase
import com.myproject.data.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

interface PersonalInfoRepository {
    fun getUserInf(): Flow<Resource<PersonalInfoData>>
    fun updateUserInfo(name: String): Flow<Resource<PersonalInfoData>>
}

class PersonalInfoRepositoryImpl(
    private val database: FirebaseDatabase,
    private val databaseReference: DatabaseReference,
) : PersonalInfoRepository {
    override fun getUserInf(): Flow<Resource<PersonalInfoData>> {
        return fetchFromDatabase("personal-info/userInfo", database)
    }

    override fun updateUserInfo(name: String): Flow<Resource<PersonalInfoData>> = callbackFlow {
        databaseReference.child("personal-info")
            .child("userInfo")
            .child("name")
            .setValue(name)
    }
}
