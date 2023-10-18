package Presentacion;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import logica.Willy;
import logica.Factura;

public class Principal {
	private Willy willy;
    private Scanner sc;

    public Principal() {
        this.sc = new Scanner(System.in);
        this.willy = new Willy(sc);
    }
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.iniciar();
	}
	private void iniciar() {
	    Scanner sc = new Scanner(System.in);
	    int op;
	    do {
	        System.out.println("Digite una opcion:\n"
	                + "0. Salir\n"
	                + "1. Menu\n"
	                + "2. Nuevo Tipo Producto\n"
	                + "3. Ingresar Producto\n"
	                + "4. Ingresar Cajero\n"
	                + "5. Ingresar Factura\n"
	                + "6. Imprimir Facturas\n"
	                + "7. Leer Datos\n");
	        op = sc.nextInt();
	        sc.nextLine();
	        switch (op) {
	        case 1: this.willy.menu();
	        break;
	        case 2 :
	        	System.out.println("Digite id: ");
	        	int id = sc.nextInt();
	        	System.out.println("Digite nombre: ");
	        	String nombre = sc.next();	
	        	this.willy.ingresarTipoProducto(id,nombre);
	        break;
	        case 3:this.willy.ingresarProducto();
	        break;
	        case 4: 
	        	System.out.println("Digite numero de empleado (ID): ");
	        	int idCaja = sc.nextInt();
	        	System.out.println("Digite nombre: ");
	        	String nombre1 = sc.next();				
	        	System.out.println("Digite apellido: ");
	        	String apellido = sc.next();								
	        	this.willy.ingresarCajero(idCaja, nombre1, apellido);
	        	break;
	        case 5: 
	        	System.out.println("Digite ID del Cajero: ");
				int idCajero = sc.nextInt();
				System.out.println("Digite la fecha:\n"
						+ "Year/Month/Day\n");
				String fechaTexto = sc.next();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = null;
				try {
					fecha = dateFormat.parse(fechaTexto);
				} catch (ParseException e) {
					e.printStackTrace();
				} 
				this.willy.ingresarFactura(idCajero,fecha);
				break;
	        case 6: 
	        	this.willy.imprimirFacturas();
	        	break;
	        case 7: this.willy.leerDatos();
    			break;
	        default: ;
	        }
	    }while (op != 0);
	    sc.close();
	}
}
