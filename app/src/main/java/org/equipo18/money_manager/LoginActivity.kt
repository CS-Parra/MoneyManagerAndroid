package org.equipo18.money_manager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

const val USER_MSG = "org.equipo18.money_manager.USER_MSG"

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login1)

        val txtEmail     = findViewById<TextInputLayout>(R.id.txtEmail)
        val txtPassword  = findViewById<TextInputLayout>(R.id.txtPassword)
        val btnSinCuenta = findViewById<Button>(R.id.btnSinCuenta)
        val btnLogin     = findViewById<Button>(R.id.btnLogin)
        val bundle = Bundle()

        btnSinCuenta.setOnClickListener {
            bundle.putString(USER_MSG, "Bienvenido Usuario")
            beginIntent(bundle)
        }

        btnLogin.setOnClickListener{

            val inputEmail = txtEmail.editText?.text.toString()
            val inputPassword = txtPassword.editText?.text.toString()
            val validacion = MoneyManager.isEmailValid(inputEmail)

            when {

                inputEmail.isEmpty() || inputPassword.isEmpty() -> {
                    sendSnackBar(it, "Debes de llenar todos los campos obligatorios")
                }

                validacion -> {

                    val user = findUser(inputEmail, inputPassword)

                    if (user != "Unknown"){
                        bundle.putString(USER_MSG, "Bienvenido $user")
                        beginIntent(bundle)
                    }

                    else {
                        sendSnackBar(it, "El usuario no se encuentra registro registrado en nuestra base datos")
                    }

                }

                else -> {
                    sendSnackBar(it, "Porvafor Ingresa un correo valido")
                }
            }

        }

    }

    private fun findUser(email: String, password: String): String {

        val moneymanager = MoneyManager()
        var userName = ""

        for (user in moneymanager.usersList){

            if (email == user.getEmail() && password == user.getPassword()){
                userName = user.getUserName()
                break
            }

            else {
                userName = "Unknown"
            }
        }

        return userName

    }

    private fun beginIntent(bundle: Bundle){

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtras(bundle)
        }

        startActivity(intent)

    }

    private fun sendSnackBar(view: View, msj: String){
        Snackbar.make(
            view,
            msj,
            Snackbar.LENGTH_SHORT
        ).show()
    }

}
