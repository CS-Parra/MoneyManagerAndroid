package org.equipo18.money_manager.controller

class User(
    private var email: String,
    private var password: String,
    private var username: String = "Desconocido") {

    val accountLists = mutableListOf<Account>()

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