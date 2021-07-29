package org.equipo18.money_manager

class User(
    private var email: String,
    private var password: String,
    private var username: String) {

    val accountLists = mutableListOf<Account>()
    var validSes: Boolean = false

    fun logIn(inputEmail: String, inputPassword: String): Boolean {

        if (inputEmail == email && inputPassword == password) {
            //println("Bienvenido $username")
            validSes = true
            return true

        } else {
            validSes = false
            //println("Email y/o contraseña incorrectos")
            return false
        }
    }

    fun validSesion(): Boolean {
        return validSes
    }

    fun logOut() {
        if (validSesion()) {
            validSes = false
            //println("Cerrando Sesión")
        }
    }

    // funcion para crear una cuenta
    fun createAccount(
        accountName: String,
        accountBalanceSheet: Float,
        accountCoin: String = "MXN"
    ) {

        if (validSesion()) {

            val accountCreated = Account(accountName, accountBalanceSheet, accountCoin)

            accountLists.add(accountCreated)

            //println("La cuenta $accountName ha sido creada")
            //println()
        }

    }

}