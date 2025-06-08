package org.galla.chefs;

public class Chef {
    private int id;
    private String nombrecompleto;
    private String biografia;
    private String especialidad;
    private String contacto;

    public Chef() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnombrecompleto() {
        return nombrecompleto;
    }

    public void setnombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getbiografia() {
        return biografia;
    }

    public void setbiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getespecialidad() {
        return especialidad;
    }

    public void setespecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getcontacto() {
        return contacto;
    }

    public void setcontacto(String contacto) {
        this.contacto = contacto;
    }
}
