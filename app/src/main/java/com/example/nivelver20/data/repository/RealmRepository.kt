package com.example.nivelver20.data.repository

import com.example.nivelver20.data.local.realm.User
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RealmRepository {

    private val config = RealmConfiguration.Builder(
        schema = setOf(User::class)
    ).build()

    private val realm = Realm.open(config)

    suspend fun registerUser(username: String, password: String) {
        withContext(Dispatchers.IO) {
            realm.write {
                copyToRealm(User().apply {
                    id = java.util.UUID.randomUUID().toString()
                    this.username = username
                    this.password = password
                })
            }
        }
    }

    suspend fun findUser(username: String): User? {
        return realm.query<User>("username == $0", username)
            .first()
            .find()
    }
}