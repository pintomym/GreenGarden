package com.example.primeraentregagreengarden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class PantallaRegistrarUsuario extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registrar_usuario);

        // Obtener referencias a los elementos de la interfaz
        Intent intent1 = new Intent(this,PantallaInicioSesion.class);
        Button buttonLogin = findViewById(R.id.btnRegistrar);
        EditText nombre = findViewById(R.id.txtNombreRegistrar);
        EditText correo = findViewById(R.id.txtCorreo);
        EditText password1 = findViewById(R.id.txtContrasenaRegistrar);
        CheckBox terminosCondiciones = findViewById(R.id.checkBoxRegistrar);
        Button Login=findViewById(R.id.btnPantLogin);

        //* Botón para registrar usuarios

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (terminosCondiciones.isChecked()) {
                    // El RadioButton está activado

                    // Revisar si los campos están diligenciados
                    if (!nombre.getText().toString().isEmpty() && !correo.getText().toString().isEmpty() &&
                            !password1.getText().toString().isEmpty() &&
                            !password1.getText().toString().isEmpty()) {
                        // Revisar si las contraseñas coinciden
                        if (password1.getText().toString().equals(password1.getText().toString())) {
                            // Validar si los datos ya existen en el archivo
                            if (datosExisten(correo.getText().toString(), nombre.getText().toString())) {
                                // Los datos ya existen
                                Toast.makeText(getApplicationContext(), "El correo, usuario o nickname ya existen", Toast.LENGTH_SHORT).show();
                            } else {
                                // Los datos no existen, realizar el registro
                                // Crear un nuevo objeto Usuario
                                Usuario nuevoUsuario = new Usuario(nombre.getText().toString(),
                                        correo.getText().toString(),
                                        password1.getText().toString());
                                // Guardar los datos en el archivo
                                guardarRegistro(nuevoUsuario);
                                // Ir al activity de inicio de sesión
                                startActivity(intent1);
                            }
                        } else {
                            // Las contraseñas no coinciden
                            Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Los campos estan vacios
                        Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // El RadioButton no está activado
                    Toast.makeText(getApplicationContext(), "Debe aceptar los términos y condiciones, " +
                            "tratamiento de datos", Toast.LENGTH_SHORT).show();
                }
            }

            private void guardarRegistro(Usuario nuevoUsuario) {
            }
        });

        /**
         * Botón para retroceder
         */
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });
    }

    private boolean datosExisten(String correo, String nombre) {
        return false;
    }

    
}