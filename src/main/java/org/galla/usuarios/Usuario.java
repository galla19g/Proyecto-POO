package org.galla.usuarios;

public class Usuario {
    private int id;
    private String username;
    private String apellido;
    private String email;
    private String contraseña;


    public Usuario(){

    }

    public Usuario(String nombreusuario, String nombrecompleto, String apellido, String  email, String contraseña){

    }

    public int getId() {
        return id;
    }

    public void setId(int id ){
        this. id = id;
    }

    public String getusername(){
        return username;
    }


    public void apellido(){
        this. apellido = apellido;
    }

    public String getapellido (){
        return apellido;
    }

    public void setemail(){
        this. email = email;
    }

    public String getemail(){
        return email;
    }

    public void setcontraseña(){
        this. contraseña = contraseña;
    }

    public String getcontraseña(){
        return contraseña;
    }
}
