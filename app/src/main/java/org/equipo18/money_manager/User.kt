package org.equipo18.money_manager

class User(
    private var email: String,
    private var password: String,
    private var username: String = "Desconocido") {


    fun getUserName() : String{
        return username
    }

    fun getEmail() : String {
        return email
    }

    fun getPassword(): String {
        return password
    }

}