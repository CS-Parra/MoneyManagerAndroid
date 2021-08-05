package org.equipo18.money_manager

class MoneyManager {

    val usersList = mutableListOf(
        User("devmmanuel@gmail.com","devmmanuel","Emmanuel Eduardo"),
        User("csparra@gmail.com","csparra","Carlos Parra"),
        User("gissel@gmail.com","gissel","Gissel Carpinteiro"),
        User("nat@gmail.com","nat","Natalia"),
        User("u@gmail.com","u","Usuario"),
        User("dev@gmail.com","dev","Developer"),
    )

    companion object {
        fun isEmailValid(email: String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
    }

}