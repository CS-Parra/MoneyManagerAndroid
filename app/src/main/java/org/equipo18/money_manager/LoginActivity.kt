package org.equipo18.money_manager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

const val USER_NAME = "org.equipo18.money_manager.USER_NAME"

class LoginActivity : AppCompatActivity() {

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

           if (txtEmail.editText?.text.toString().isEmpty() ||
               txtPassword.editText?.text.toString().isEmpty() ) {

               Toast.makeText(this, "Debes de llenar todos los campos obligatorios", Toast.LENGTH_LONG).show()
           }

           else {

               val moneymanager = MoneyManager()

               val validacion = moneymanager.isEmailValid(txtEmail.editText?.text.toString())

               if(validacion){

                   val moneyManager = MoneyManager()

                   moneyManager.usersList.forEach {

                       if(txtEmail.editText?.text.toString() == it.getEmail() &&
                           txtPassword.editText?.text.toString() == it.getPassword() ){

                           Toast.makeText(this, "Bienvenido ${it.getUserName()}", Toast.LENGTH_LONG).show()

                       }

                       else {
                           Toast.makeText(this, "El usuario no esta registrado en nuestra base de datos", Toast.LENGTH_LONG).show()
                       }

                   }

               }

               else {
                   Toast.makeText(this, "Porfavor ingresa un correo valido", Toast.LENGTH_LONG).show()

               }

           }

       }

    }
}