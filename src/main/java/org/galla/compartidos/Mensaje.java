package org.galla.compartidos;

public class Mensaje<T> {
    private String mensaje;
    private T data;

    public Mensaje(String mensaje, T data) {
        this.mensaje = mensaje;
        this.data = data;
    }

    public Mensaje() {

}

public String getMensaje() {
    return this.mensaje;
}

public void setMensaje(String mensaje){
    this.mensaje = mensaje;
}

public T getData(){
    return this.data;
}

public void setData(T data){
    this.data = data;
}

}
