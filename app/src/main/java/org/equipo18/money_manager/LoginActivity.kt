package org.equipo18.money_manager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

const val USER_NAME = "org.equipo18.money_manager.USER_NAME"

class LoginActivity : AppCompatActivity() {

    fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login1)

        val txtEmail     = findViewById<TextInputLayout>(R.id.txtEmail)
        val txtPassword  = findViewById<TextInputLayout>(R.id.txtPassword)
        val btnSinCuenta = findViewById<Button>(R.id.btnSinCuenta)
        val btnLogin     = findViewById<Button>(R.id.btnLogin)

        btnSinCuenta.setOnClickListener {

            val bundle = Bundle()
            bundle.putString(USER_NAME, "Bienvenido Usuario")
            
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtras(bundle)
            }
            startActivity(intent)
        }

       btnLogin.setOnClickListener{

           when {
               txtEmail.editText?.text.toString().isEmpty() -> {
                   Snackbar.make(
                       findViewById(R.id.main),
                       "Ingresa el correo porfavor",
                       Snackbar.LENGTH_INDEFINITE
                   ).show()
               }
               txtPassword.editText?.text.toString().isEmpty() -> {
                   Snackbar.make(
                       findViewById(R.id.main),
                       "Ingresa la contraseña por favor",
                       Snackbar.LENGTH_INDEFINITE
                   ).show()
               }
               else -> {
                   val validacion = isEmailValid(txtEmail.editText?.text.toString())

                   if(validacion){
                       
                   }

                   else {
                       Snackbar.make(
                           findViewById(R.id.main),
                           "Por Favor Ingresa un correo valido",
                           Snackbar.LENGTH_INDEFINITE
                       ).show()
                   }
               }
           }

       }

    }
}