package logica;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
    private int numero;
    private Date fecha;
    private Cajero cajero;
    private double valorTotal;
    private double iva;
    private ArrayList<String> productos;
    private ArrayList<String> ingredientes;
    private ArrayList<String> bebidas;
    private ArrayList<String> extras;
    private boolean Combo;
	private double descuento; 

    public Factura(int numero, Date fecha, Cajero cajero) {
        this.numero = numero;
        this.fecha = fecha;
        this.cajero = cajero;
        this.productos = new ArrayList<>();
        this.ingredientes = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.extras = new ArrayList<>();
    }
    public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public ArrayList<String> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<String> productos) {
		this.productos = productos;
	}

	public ArrayList<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public ArrayList<String> getBebidas() {
		return bebidas;
	}

	public void setBebidas(ArrayList<String> bebidas) {
		this.bebidas = bebidas;
	}

	public ArrayList<String> getExtras() {
		return extras;
	}

	public void setExtras(ArrayList<String> extras) {
		this.extras = extras;
	}

	@Override
    public String toString() {
        return "Factura [Número: " + numero + ", Fecha: " + fecha + ", Cajero: " + cajero.getNombre() + " " + cajero.getApellido() + "]";
    }
	public void agregarProducto(String producto) {
        productos.add(producto);
    }

    public void agregarIngrediente(String ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void agregarBebida(String bebida) {
        bebidas.add(bebida);
    }

    public void agregarExtra(String extra) {
        extras.add(extra);
    }

    public void setDescuento(double descuentoValor) {
        this.descuento = descuentoValor;
    }
}