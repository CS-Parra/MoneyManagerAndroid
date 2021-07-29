package org.equipo18.money_manager

class MoneyManager {

    val usersList = mutableListOf<User>()

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}