package com.example.nivelver20.data.repository

import com.example.nivelver20.data.local.realm.*
import com.example.nivelver20.utils.SecurityUtils
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RealmRepository {
    private val config = RealmConfiguration.Builder(
        schema = setOf(
            UserRealm::class,
            WordRealm::class,
            LecturaRealm::class,
            AudioRealm::class
        )
    )
        .name("nivelver.realm")
        .schemaVersion(2)
        .build()

    private val realm: Realm = Realm.open(config)

    // === USER OPERATIONS ===
    suspend fun createUser(username: String, password: String) {
        realm.write {
            copyToRealm(UserRealm().apply {
                this.username = username
                this.password = SecurityUtils.hashPassword(password)  // Хешированный пароль
                this.nivel = "A0"  //Начальный уровень A0
            })
        }
    }

    suspend fun getUserByUsername(username: String): UserRealm? {
        return realm.query<UserRealm>("username == $0", username).first().find()
    }

    suspend fun verifyUserPassword(username: String, password: String): UserRealm? {
        val user = getUserByUsername(username)
        return if (user != null && SecurityUtils.verifyPassword(password, user.password)) {
            user
        } else {
            null
        }
    }

    fun getAllUsers(): Flow<List<UserRealm>> {
        return realm.query<UserRealm>().asFlow().map { it.list }
    }

    // === WORD OPERATIONS ===
    suspend fun addWord(spanish: String, russian: String, nivel: String) {
        realm.write {
            copyToRealm(WordRealm().apply {
                this.spanish = spanish
                this.russian = russian
                this.nivel = nivel
            })
        }
    }

    fun getWordsByNivel(nivel: String): Flow<List<WordRealm>> {
        return realm.query<WordRealm>("nivel == $0", nivel).asFlow().map { it.list }
    }

    // === LECTURA OPERATIONS ===
    suspend fun addLectura(text: String, question: String, answers: String, correctAnswer: Int, nivel: String) {
        realm.write {
            copyToRealm(LecturaRealm().apply {
                this.text = text
                this.question = question
                this.answers = answers
                this.correctAnswer = correctAnswer
                this.nivel = nivel
            })
        }
    }

    fun getLecturaByNivel(nivel: String): Flow<List<LecturaRealm>> {
        return realm.query<LecturaRealm>("nivel == $0", nivel).asFlow().map { it.list }
    }

    // === AUDIO OPERATIONS ===
    suspend fun addAudio(audioPath: String, question: String, answers: String, correctAnswer: Int, nivel: String) {
        realm.write {
            copyToRealm(AudioRealm().apply {
                this.audioPath = audioPath
                this.question = question
                this.answers = answers
                this.correctAnswer = correctAnswer
                this.nivel = nivel
            })
        }
    }

    fun getAudioByNivel(nivel: String): Flow<List<AudioRealm>> {
        return realm.query<AudioRealm>("nivel == $0", nivel).asFlow().map { it.list }
    }

    // Закрытие Realm при завершении
    fun close() {
        realm.close()
    }
}