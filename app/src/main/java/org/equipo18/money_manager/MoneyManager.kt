package org.equipo18.money_manager

import android.view.View
import com.google.android.material.snackbar.Snackbar

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

        fun sendSnackBar(view: View, msj: String){
            Snackbar.make(
                view,
                msj,
                Snackbar.LENGTH_SHORT
            ).show()
        }

    }

}