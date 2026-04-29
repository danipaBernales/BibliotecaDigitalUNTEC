package model;

public class Usuario {

    private int id;
    private String nombre;
    private String correo;
    private String password;

    public Usuario() {
    }

    public Usuario(int id,
                   String nombre,
                   String correo,
                   String password) {

        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }
}
