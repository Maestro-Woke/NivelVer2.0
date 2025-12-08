package com.example.nivelver20.utils

import java.security.MessageDigest

object SecurityUtils {
    //Хеширование пароля с использованием SHA-256
    fun hashPassword(password: String): String {
        val bytes = password.toByteArray()
        val digest = MessageDigest.getInstance("SHA-256")
        val hashedBytes = digest.digest(bytes)
        return hashedBytes.joinToString("") { "%02x".format(it) }
    }

    //Проверка пароля
    fun verifyPassword(inputPassword: String, hashedPassword: String): Boolean {
        return hashPassword(inputPassword) == hashedPassword
    }
}