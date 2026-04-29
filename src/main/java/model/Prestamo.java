package model;

public class Prestamo {

    private int id;
    private int usuarioId;
    private int libroId;

    public Prestamo() {
    }

    public Prestamo(int id,
                    int usuarioId,
                    int libroId) {

        this.id = id;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
    }

    public int getId() {
        return id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public int getLibroId() {
        return libroId;
    }
}
