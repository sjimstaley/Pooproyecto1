package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import persistencia.Archivo;

public class Willy {
    private ArrayList<Cajero> cajeros;
    private ArrayList<Factura> facturas;
    private ArrayList<Producto> productos;
    private List<TipoProducto> tiposProductos;
    private ArrayList<Ingrediente> ingredientes;
    private ArrayList<Bebida> bebidas;
    private ArrayList<Extra> extras;
    private ArrayList<Carne> carnes;
    private ArrayList<String> ingredientesSeleccionados;
    private ArrayList<Integer> preciosIngredientes;
    private ArrayList<String> bebidasSeleccionados;
    private ArrayList<Integer> preciosBebidas;
    private ArrayList<String> extrasSeleccionados;
    private ArrayList<Integer> preciosExtras;
    private ArrayList<String> productosSeleccionados;
    private ArrayList<Integer> preciosProductos;
    private Scanner sc;
    
    public Willy(Scanner sc) {
        this.cajeros = new ArrayList<Cajero>();
        this.facturas = new ArrayList<Factura>();
        this.productos = new ArrayList<Producto>();
        this.tiposProductos = new ArrayList<TipoProducto>();
        this.ingredientes = new ArrayList<Ingrediente>();
        this.bebidas = new ArrayList<Bebida>();
        this.extras = new ArrayList<Extra>();
        this.carnes = new ArrayList<Carne>();
        this.ingredientesSeleccionados = new ArrayList<>();
        this.preciosIngredientes = new ArrayList<>();
        this.bebidasSeleccionados = new ArrayList<>();
        this.preciosBebidas = new ArrayList<>();
        this.extrasSeleccionados = new ArrayList<>();
        this.preciosExtras = new ArrayList<>();
        this.productosSeleccionados = new ArrayList<>();
        this.preciosProductos = new ArrayList<>();
        this.sc = sc;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Willy willy = new Willy(sc);
        willy.menu();
        sc.close();
    }
    public void ingresarCajero(int idCaja, String nombre, String apellido) {
        Cajero cajero = new Cajero(idCaja, nombre, apellido);
        this.cajeros.add(cajero);
    }
    private Cajero buscarCajero(int idCaja) {
        for (Cajero cajero : this.cajeros) {
            if (cajero.getId() == idCaja) {
                return cajero;
            }
        }
        return null;
    }
    public void ingresarProducto() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Tipos de productos existentes:");
        for (TipoProducto tipo : tiposProductos) {
            System.out.println(tipo.getId() + " - " + tipo.getNombre());
        }

        System.out.println("Ingrese el ID del tipo de producto:");
        int tipoId = sc.nextInt();
        sc.nextLine();

        TipoProducto tipoProducto = buscarTipoProducto(tipoId);

        if (tipoProducto == null) {
            System.out.println("El tipo de producto no existe. No se puede agregar un nuevo producto.");
        } else {
            System.out.println("Ingrese el codigo del nuevo producto:");
            int codigo = sc.nextInt();
            sc.nextLine();

            if (productoExistente(codigo)) {
                System.out.println("El producto ya existe. No se puede agregar otro con el mismo codigo.");
            } else {
                System.out.println("Ingrese el nombre del nuevo producto:");
                String nombre = sc.nextLine();

                System.out.println("Ingrese el precio del nuevo producto:");
                int precio = sc.nextInt();
                sc.nextLine();
                
                System.out.println("Ingrese la cantidad del nuevo producto:");
                int cantidad = sc.nextInt();
                sc.nextLine();
                
                Producto nuevoProducto = new Producto(codigo, nombre, precio, new ArrayList<String>(), cantidad);
                productos.add(nuevoProducto);

                System.out.println("Producto agregado correctamente.");
            }
        }
        sc.close();
    }

    private boolean productoExistente(int codigo) {
        for (Producto producto : productos) {
            if (producto.getId() == codigo) {
                return true; 
            }
        }
        return false;
    }

    public void ingresarTipoProducto(int id, String nombre) {
		TipoProducto tipoProducto = new TipoProducto(id, nombre);		
		this.tiposProductos.add(tipoProducto);
	}
	public void leerDatos() {
		ArrayList<String> lineas;
		lineas = Archivo.leerDatos("tipoProducto.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarTipoProducto(Integer.parseInt(datos[0]), datos[1]);
		}
		lineas = Archivo.leerDatos("productos.dat");
		for (String linea : lineas) {
	        String datos[] = linea.split(";");
	        int codigo = Integer.parseInt(datos[0]);
	        int id = Integer.parseInt(datos[1]);
	        String nombre = datos[2];
	        int precio = Integer.parseInt(datos[3]);
	        int cantidad = Integer.parseInt(datos[4]);

	        if (codigo == 100) {
	            this.ingresarIngrediente(id, nombre, precio, cantidad);
	        } else if (codigo == 200) {
	            this.ingresarBebida(id, nombre, precio, cantidad);
	        } else if (codigo == 300) {
	            this.ingresarExtra(id, nombre, precio, cantidad);
	        } else if (codigo == 400) {
	            this.ingresarCarne(id, nombre, precio, cantidad);
	        }
		}		
		lineas = Archivo.leerDatos("cajero.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarCajero(Integer.parseInt(datos[0]), datos[1], datos[2]);
		}				
	}
	public void ingresarIngrediente(int id, String nombre, int precio, int cantidad) {
	    Ingrediente ingrediente = new Ingrediente(id, nombre, precio, cantidad);
	    ingredientes.add(ingrediente);
	}

	public void ingresarBebida(int id, String nombre, int precio, int cantidad) {
	    Bebida bebida = new Bebida(id, nombre, precio, cantidad);
	    bebidas.add(bebida);
	}

	public void ingresarExtra(int id, String nombre, int precio, int cantidad) {
	    Extra extra = new Extra(id, nombre, precio, cantidad);
	    extras.add(extra);
	}

	public void ingresarCarne(int id, String nombre, int precio, int cantidad) {
	    Carne carne = new Carne(id, nombre, precio, cantidad);
	    carnes.add(carne);
	}
	private TipoProducto buscarTipoProducto(int tipoId) {
	    for (TipoProducto tipo : tiposProductos) {
	        if (tipo.getId() == tipoId) {
	            return tipo;
	        }
	    }
	    return null;
	}

	public void menu() {
        int op;
        do {
            System.out.println("Digite una opcion para visualizar: \n"
                    + "0. Salir\n"
                    + "1. Carnes \n"
                    + "2. Ingredientes Hamburgesas \n"
                    + "3. Bebidas\n"
                    + "4. Otros\n");
            if (sc.hasNextInt()) {
                op = sc.nextInt();
                sc.nextLine();
                switch (op) {
                    case 1:
                        MostrarProductosID(400);
                        break;
                    case 2:
                        MostrarProductosID(100);
                        break;
                    case 3:
                        MostrarProductosID(200);
                        break;
                    case 4:
                        MostrarProductosID(300);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Por favor, seleccione una opcion valida.");
                        break;
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un numero valido.");
                sc.nextLine();
                op = -1;
            }
        } while (op != 0);
    }

	public void MostrarProductosID(int codigo) {
	    int op;
	    if (codigo == 100) {
	        System.out.println("Seleccione ingredientes para la hamburguesa (Ingrese el numero del ingrediente o '0' para finalizar):");

	        boolean Ingredientes = true;

	        for (Ingrediente ingrediente : ingredientes) {
	            System.out.println(ingrediente.getId() + ". " + ingrediente.getNombre() + " - $" + ingrediente.getPrecio());
	        }

	        while (Ingredientes) {
	            op = Integer.parseInt(sc.nextLine());

	            if (op == 0) {
	                Ingredientes = false;
	            } else {
	                boolean ingredienteSeleccionado = false;
	                for (Ingrediente ingrediente : ingredientes) {
	                    if (ingrediente.getId() == op) {
	                        ingresarH(ingrediente.getNombre(), ingrediente.getPrecio());
	                        System.out.println("Ingrediente agregado: " + ingrediente.getNombre());
	                        ingredienteSeleccionado = true;
	                        break;
	                    }
	                }
	                if (!ingredienteSeleccionado) {
	                    System.out.println("Por favor, seleccione un ingrediente valido.");
	                }
	            }
	        }
	        op = 0;
	    }
	    else if (codigo == 200) {
	        System.out.println("Seleccione bebidas (Ingrese el numero de la bebida o '0' para finalizar):");
	        boolean seleccionandoBebidas = true;

	        for (Bebida bebida : bebidas) {
	            System.out.println(bebida.getId() + ". " + bebida.getNombre() + " - $" + bebida.getPrecio());
	        }

	        while (seleccionandoBebidas) {
	            op = Integer.parseInt(sc.nextLine());

	            if (op == 0) {
	                seleccionandoBebidas = false;
	            } else {
	                boolean bebidaSeleccionada = false;

	                for (Bebida bebida : bebidas) {
	                    if (bebida.getId() == op) {
	                        ingresarBebida(bebida.getNombre(), bebida.getPrecio());
	                        System.out.println("Bebida agregada: " + bebida.getNombre());
	                        bebidaSeleccionada = true;
	                        break;
	                    }
	                }

	                if (!bebidaSeleccionada) {
	                    System.out.println("Por favor, seleccione una bebida valida.");
	                }
	            }
	        }
	        op = 0;
	    }
	    else if (codigo == 300) {
	        System.out.println("Seleccione algún Extra (Ingrese el número o '0' para finalizar):");
	        boolean seleccionandoExtra = true;
	        for (Extra extra : extras) {
	            System.out.println(extra.getId() + ". " + extra.getNombre() + " - $" + extra.getPrecio());
	        }
	        while (seleccionandoExtra) {
	            op = Integer.parseInt(sc.nextLine());

	            if (op == 0) {
	                seleccionandoExtra = false;
	            } else {
	                boolean ExtraSeleccionado = false;
	                for (Extra extra : extras) {
	                    if (extra.getId() == op) {
	                        ingresarExtra(extra.getNombre(), extra.getPrecio());
	                        System.out.println("Extra agregado: " + extra.getNombre());
	                        ExtraSeleccionado = true;
	                        break;
	                    }
	                }

	                if (!ExtraSeleccionado) {
	                    System.out.println("Por favor, seleccione un Extra valido.");
	                }
	            }
	        }
	        op = 0;
	    }
	    else if (codigo == 400) {
	        System.out.println("Seleccione carnes para la hamburguesa (Ingrese el numero de la carne o '0' para finalizar):");
	        boolean seleccionandoCarnes = true;

	        for (Carne carne : carnes) {
	            System.out.println(carne.getId() + ". " + carne.getNombre() + " - $" + carne.getPrecio());
	        }
	        while (seleccionandoCarnes) {
	            op = Integer.parseInt(sc.nextLine());

	            if (op == 0) {
	                seleccionandoCarnes = false;
	            } else {
	                boolean carneSeleccionada = false;

	                for (Carne carne : carnes) {
	                    if (carne.getId() == op) {
	                        ingresarH(carne.getNombre(), carne.getPrecio());
	                        System.out.println("Carne agregada: " + carne.getNombre());
	                        carneSeleccionada = true;
	                    }
	                }

	                if (!carneSeleccionada) {
	                    System.out.println("Por favor, seleccione una carne valida.");
	                }
	            }
	        }
	        op = 0;
	    }
	    else if (codigo != 100 && codigo != 200 && codigo != 300 && codigo != 400) {
	        boolean seleccionandoProductos = true;
	        for (Producto producto : productos) {
	            System.out.println(producto.getId() + ". " + producto.getNombre() + " - $" + producto.getPrecio());
	        }
	        while (seleccionandoProductos) {
	            op = Integer.parseInt(sc.nextLine());

	            if (op == 0) {
	                seleccionandoProductos = false;
	            } else {
	                boolean productoSeleccionado = false;
	                for (Producto producto : productos) {
	                    if (producto.getId() == op) {
	                        agregarProducto(producto.getNombre(), producto.getPrecio());
	                        System.out.println("Producto agregado: " + producto.getNombre());
	                        productoSeleccionado = true;
	                    }
	                }
	                if (!productoSeleccionado) {
	                    System.out.println("Por favor, seleccione un producto válido.");
	                }
	            }
	        }
	        op = 0;
	    }
	}	
	private void agregarProducto(String nombre, int precio) {
		productosSeleccionados.add(nombre);
		preciosProductos.add(precio);
	}
	public void ingresarH(String nombre, int precio) {
	    ingredientesSeleccionados.add(nombre);
	    preciosIngredientes.add(precio);
	}
	public void ingresarBebida (String nombre, int precio) {
        bebidasSeleccionados.add(nombre);
        preciosBebidas.add(precio);
    }
	public void ingresarExtra(String nombre, int precio) {
        extrasSeleccionados.add(nombre);
        preciosExtras.add(precio);
    }
	public void ingresarFactura(int idCaja, Date fecha) {
	    Cajero cajero = buscarCajero(idCaja);

	    if (cajero == null) {
	        System.out.println("Cajero no encontrado. No se puede crear la factura.");
	        return;
	    }

	    if (fecha == null) {
	        System.out.println("La fecha no es válida. No se puede crear la factura.");
	        return;
	    }

	    int numero = facturas.size() + 1;
	    Factura factura = new Factura(numero, fecha, cajero);

	    double totalProductos = calcularTotal(preciosProductos);
	    double totalIngredientes = calcularTotal(preciosIngredientes);
	    double totalBebidas = calcularTotal(preciosBebidas);
	    double totalExtras = calcularTotal(preciosExtras);

	    double total = totalProductos + totalIngredientes + totalBebidas + totalExtras;
	    
	    System.out.println("¿Es combo? (1 para sí): ");
	    int op = sc.nextInt();
	    if (op == 1) {
	        double descuentoValor = total * 0.15;
	        total -= descuentoValor;
	        factura.setDescuento(descuentoValor);
	    }

	    factura.setValorTotal(total);

	    productosSeleccionados.clear();
	    preciosProductos.clear();
	    ingredientesSeleccionados.clear();
	    preciosIngredientes.clear();
	    bebidasSeleccionados.clear();
	    preciosBebidas.clear();
	    extrasSeleccionados.clear();
	    preciosExtras.clear();

	    facturas.add(factura);

	    System.out.println("Factura ingresada correctamente.");
	}

	private double calcularTotal(ArrayList<Integer> precios) {
	    double total = 0;
	    for (int precio : precios) {
	        total += precio;
	    }
	    return total;
	}
	public void imprimirFacturas() {
	    for (Factura factura : this.facturas) {
	        System.out.println("-------");
	        System.out.println("Número de Factura: " + factura.getNumero());
	        System.out.println("Fecha: " + factura.getFecha());
	        System.out.println("Valor Total: " + factura.getValorTotal());
	        System.out.println("Cajero: " + factura.getCajero().getNombre() + " " + factura.getCajero().getApellido());
	        System.out.println("Productos:");

	        for (String productoNombre : factura.getProductos()) {
	            System.out.println(productoNombre);
	        }

	        System.out.println("Ingredientes:");

	        for (String ingrediente : factura.getIngredientes()) {
	            System.out.println(ingrediente);
	        }

	        System.out.println("Bebidas:");

	        for (String bebida : factura.getBebidas()) {
	            System.out.println(bebida);
	        }

	        System.out.println("Extras:");

	        for (String extra : factura.getExtras()) {
	            System.out.println(extra);
	        }
	    }
	}
}