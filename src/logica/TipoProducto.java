package logica;

import java.util.ArrayList;
import java.util.List;

public class TipoProducto {
    private int id;
    private String nombre;
    private List<Producto> productos;

    public TipoProducto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
