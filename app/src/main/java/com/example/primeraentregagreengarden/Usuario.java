package com.example.primeraentregagreengarden;

public class Usuario {
    private String nombre="usuario";
    private String correo="usuario@user.com";
    private String passwordData="contrasena";

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPasswordData() {
        return passwordData;
    }



    public Usuario(String nombre, String correo, String passwordData) {
    }
}
