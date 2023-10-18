package logica;

import java.util.ArrayList;

public class Producto {
    private int id;
    private String nombre;
    private int precio;
    private ArrayList<String> ingredientes;
    private int cantidad;

    public Producto(int id, String nombre, int precio, ArrayList<String> ingredientes, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
        this.cantidad = cantidad;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}

