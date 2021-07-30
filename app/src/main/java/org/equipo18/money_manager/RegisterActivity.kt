package org.equipo18.money_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val txtEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val txtPassword1 = findViewById<EditText>(R.id.editTextTextPassword)
        val txtPassword2 = findViewById<EditText>(R.id.editTextTextPassword2)
        val btnRegistrarse = findViewById<Button>(R.id.buttonRegistrar)

        val moneymaner = MoneyManager()

        btnRegistrarse.setOnClickListener {

            if (txtEmail.text.toString().isEmpty() ||
                txtPassword1.text.toString().isEmpty() ||
                txtPassword2.text.toString().isEmpty() ) {
                Snackbar.make(
                    it,
                    "Debes de llenar todos los campos obligatorios",
                    Snackbar.LENGTH_INDEFINITE
                ).show()
            }

            else {

                if (txtPassword1.text.toString() == txtPassword2.text.toString()) {

                    if (moneymaner.isEmailValid(txtEmail.text.toString())) {
                        val usuario = User(txtEmail.toString(), txtPassword1.toString())
                        moneymaner.usersList.add(usuario)
                        Snackbar.make(
                            it,
                            "El usuario ha sido agregado",
                            Snackbar.LENGTH_INDEFINITE
                        ).show()
                    } else {
                        Snackbar.make(
                            it,
                            "Debes de ingresar un correo valido",
                            Snackbar.LENGTH_INDEFINITE
                        ).show()
                    }

                } else {
                    Snackbar.make(
                        it,
                        "Las contraseñas no coinciden",
                        Snackbar.LENGTH_INDEFINITE
                    ).show()
                }

            }

        }
    }

}
