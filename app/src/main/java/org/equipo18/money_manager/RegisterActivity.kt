package org.equipo18.money_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val txtEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val txtPassword1 = findViewById<EditText>(R.id.editTextTextPassword)
        val txtPassword2 = findViewById<EditText>(R.id.editTextTextPassword2)
        val btnRegistrarse = findViewById<Button>(R.id.buttonRegistrar)
        val inputEmail = txtEmail.text.toString()
        val inputPassword1 = txtPassword1.text.toString()
        val inputPassword2 = txtPassword2.text.toString()
        val moneymaner = MoneyManager()

        btnRegistrarse.setOnClickListener {

            if (inputEmail.isEmpty() || inputPassword1.isEmpty() || inputPassword2.isEmpty()){
                MoneyManager.sendSnackBar(it,"Debes de llenar todos los campos obligatorios")
            }

            else {
                if (inputPassword1 == inputPassword2){

                    if (MoneyManager.isEmailValid(inputEmail)){

                        val usuario = User(inputEmail, inputPassword1)
                        moneymaner.usersList.add(usuario)
                        MoneyManager.sendSnackBar(it,"El usuario ha sido agregado")

                    }

                    else  {
                        MoneyManager.sendSnackBar(it,"Debes de ingresar un correo valido")
                    }

                }

                else {
                    MoneyManager.sendSnackBar(it,"Las contraseñas no coinciden")
                }
            }
        }
    }
}
