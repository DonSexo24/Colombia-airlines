package uniquindio.logic;
import java.util.*;
public class Avion {
	
	/*
	 * 
	 *  @version 1.0
	 *  
	 *  @propiedad de Juan Manuel Giraldo 2023-1
	 * 
	 * 
	 * */

    //Datos pasajeros
    private ArrayList<String> nombresPasajero;
    private ArrayList<String> edadesPasajero;
    private ArrayList<String> direccionesPasajero;
    private ArrayList<String> telefonosPasajero;
    private ArrayList<String> nacimientosPasajero;
    private ArrayList<String> contactosEmergenciaPasajero;
    private ArrayList<Double> gastoTotalPasajero;


    private ArrayList<Double> compras;

    private ArrayList<String> gastoAlimentosPasajeros;

    private double dineroRecaudadoAlimentos;

    private ArrayList<String> ccPasajero;

    private ArrayList<Integer> cantidadArticulosPasajero;

    //Datos Tripulacion
    String[] nombresTripulacion= {"Jack Anderson","Olivia Reynolds","Chloe Walker","Grace Morgan","Juanita Delgado" };
    String[] ccTripulacion={"1245","2233","4553","9098","4587"};

    String[] telefonoTripulacion={" 555-123-4567","555-987-6543",": 555-246-8139","555-369-2580","555-789-0123"};

    String[] NacimientoTripulacion={"12 de enero de 1985","5 de marzo de 1992","20 de julio de 1988","15 de abril de 1990","8 de noviembre de 1987"};

   private String[][]sillas;

    //Datos sillas

    private double precioSillaVIP;

    private double precioSillaGeneral;

    double valorCompra;

    private int filas;
    private int columnas;

  //Constructor
    public Avion(int filas,int columnas){
        this.filas = filas;
        this.columnas = columnas;
        sillas =  new String[filas][columnas];
        precioSillaVIP = 2000.0;
        precioSillaGeneral = 500.0;
        valorCompra = 0.0;
        nombresPasajero = new ArrayList<String>();
        edadesPasajero = new ArrayList<String>();
        direccionesPasajero = new ArrayList<String>();
        telefonosPasajero = new ArrayList<String>();
        nacimientosPasajero = new ArrayList<String>();
        contactosEmergenciaPasajero = new ArrayList<String>();
        ccPasajero=new ArrayList<String>();
        compras = new ArrayList<Double>();
        gastoAlimentosPasajeros = new ArrayList<String>();
        dineroRecaudadoAlimentos = 0.0;
        cantidadArticulosPasajero = new ArrayList<Integer>(70);
        gastoTotalPasajero = new ArrayList<Double>();
        for (int i = 0; i < 70; i++) {
            cantidadArticulosPasajero.add(0);
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sillas[i][j] = "Disponible";
            }
        }
    }

    public void comprarSilla(int fila, int columna, String nombre, String cc, String edad, String direccion, String telefono, String nacimiento, String contactoEmergencia) {
        if (sillas[fila][columna].equals("Disponible")) {
            sillas[fila][columna] = "Ocupada";
            double precioSilla = (fila < 2) ? precioSillaVIP : precioSillaGeneral;
            valorCompra += precioSilla;
            nombresPasajero.add(nombre);
            ccPasajero.add(cc);
            edadesPasajero.add(edad);
            direccionesPasajero.add(direccion);
            telefonosPasajero.add(telefono);
            nacimientosPasajero.add(nacimiento);
            contactosEmergenciaPasajero.add(contactoEmergencia);
            System.out.println("La silla en la fila " + fila + " y columna " + columna + " ha sido comprada por " + nombre);
        } else {
            System.out.println("La silla en la fila " + fila + " y columna " + columna + " no está disponible");
        }
    }



    public void cancelarSilla(int fila, int columna) {
        if (sillas[fila][columna].equals("Ocupada")) {
            sillas[fila][columna] = "Disponible";
            double precioSilla = (fila < 2) ? precioSillaVIP : precioSillaGeneral;
            valorCompra -= precioSilla * 0.7;
            int index = -1;
            for (int i = 0; i < nombresPasajero.size(); i++) {
                if (nombresPasajero.get(i).equals(nombresPasajero.get(i)) && ccPasajero.get(i).equals(ccPasajero.get(i))) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                nombresPasajero.remove(index);
                ccPasajero.remove(index);
                edadesPasajero.remove(index);
                direccionesPasajero.remove(index);
                telefonosPasajero.remove(index);
                nacimientosPasajero.remove(index);
                contactosEmergenciaPasajero.remove(index);
                System.out.println("La silla en la fila " + fila + " y columna " + columna + " ha sido cancelada");
            } else {
                System.out.println("No se encontró el pasajero para la silla en la fila " + fila + " y columna " + columna);
            }
        } else {
            System.out.println("La silla en la fila " + fila + " y columna " + columna + " no está ocupada");
        }
    }



    public String obtenerUbicacionSilla(int fila, int columna) {
        if (columna == 0 || columna == 6) {
            return "Ventana";
        } else if (columna == 1 || columna == 5) {
            return "Pasillo";
        } else {
            return "Centro";
        }
    }

    public void inactivarSilla() {
        Random random = new Random();
        int numAleatorio = random.nextInt(71); // Generamos un número aleatorio entre 0 y 70

        if (numAleatorio <= 10) { // Si el número generado es menor o igual a 10, la silla estará inactiva
            int fila = random.nextInt(filas);
            int columna = random.nextInt(columnas);

            if (!sillas[fila][columna].equals("Inactiva")) { // Verificamos que la silla no esté ya inactiva
                sillas[fila][columna] = "Inactiva";
                System.out.println("La silla en la fila " + fila + " y columna " + columna + " ha sido inactivada");
            } else {
                System.out.println("La silla en la fila " + fila + " y columna " + columna + " ya está inactiva");
            }
        } else {
            System.out.println("No se ha inactivado ninguna silla");
        }
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void comprarAlimento(int fila, int columna, String nombrePasajero, String articulo) {
        if (sillas[fila][columna].equals("Ocupada")) {
            int index = nombresPasajero.indexOf(nombrePasajero);
            if (index != -1) {
                if (articulo.equalsIgnoreCase("café") && !gastoAlimentosPasajeros.contains(nombrePasajero)) {
                    // El primer café es gratis
                    gastoAlimentosPasajeros.add(nombrePasajero);
                } else {
                    double precioArticulo = 0.0;
                    switch (articulo.toLowerCase()) {
                        case "café":
                            precioArticulo = 1.0;
                            break;
                        case "vino":
                            precioArticulo = 30.0;
                            break;
                        case "desayuno":
                            precioArticulo = 2.0;
                            break;
                        case "almuerzo":
                            precioArticulo = 5.0;
                            break;
                        case "gaseosa":
                            precioArticulo = 2.0;
                            break;
                        case "postre":
                            precioArticulo = 4.0;
                            break;
                        default:
                            System.out.println("El artículo " + articulo + " no está disponible para compra.");
                            return;
                    }
                    dineroRecaudadoAlimentos += precioArticulo;
                    compras.add(precioArticulo);

                    // Incrementar contador de artículos comprados por pasajero
                    int cantidadArticulos = cantidadArticulosPasajero.get(fila * 7 + columna);
                    cantidadArticulosPasajero.set(fila * 7 + columna, cantidadArticulos + 1);
                }
                System.out.println("El pasajero " + nombrePasajero + " ha comprado " + articulo);
            } else {
                System.out.println("No se encontró al pasajero " + nombrePasajero);
            }
        } else {
            System.out.println("La silla en la fila " + fila + " y columna " + columna + " no está ocupada");
        }
    }

    public int getCantidadArticulosComprados(String nombrePasajero) {
        int cantidadArticulos = 0;
        for (int i = 0; i < nombresPasajero.size(); i++) {
            if (nombresPasajero.get(i).equals(nombrePasajero)) {
                int fila = i / 7;
                int columna = i % 7;
                cantidadArticulos = cantidadArticulosPasajero.get(fila * 7 + columna);
                break;
            }
        }
        return cantidadArticulos;
    }

    public double calcularTotalRecaudado() {
        double totalRecaudado = valorCompra + dineroRecaudadoAlimentos;
        return totalRecaudado;
    }
    
    public void imprimirEstadoSillas() {
        int sillasLibres = 0;
        int sillasOcupadas = 0;
        
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (sillas[i][j].equals("Disponible")) {
                    sillasLibres++;
                } else if (sillas[i][j].equals("Ocupada")) {
                    sillasOcupadas++;
                }
            }
        }
        
        System.out.println("Sillas libres: " + sillasLibres);
        System.out.println("Sillas ocupadas: " + sillasOcupadas);
    }
    
    public String obtenerPasajeroMayorCompra() {
        int maxCompra = 0;
        String pasajero = "";
        
        for (int i = 0; i < nombresPasajero.size(); i++) {
            String compraActual = gastoAlimentosPasajeros.get(i);
            if (Integer.parseInt(compraActual) > maxCompra) {
                maxCompra = Integer.parseInt(compraActual);
                pasajero = nombresPasajero.get(i);
            }
        }
        
        return pasajero;
    }
    
    public String obtenerPasajeroMayorGasto() {
        double maxGasto = 0.0;
        String pasajero = "";
        
        for (int i = 0; i < nombresPasajero.size(); i++) {
            double gastoActual = gastoTotalPasajero.get(i);
            if (gastoActual > maxGasto) {
                maxGasto = gastoActual;
                pasajero = nombresPasajero.get(i);
            }
        }
        
        return pasajero;
    }

    public int obtenerCantidadMenoresEdad() {
        int contadorMenoresEdad = 0;
        
        for (String edad : edadesPasajero) {
            int edadInt = Integer.parseInt(edad);
            if (edadInt < 18) {
                contadorMenoresEdad++;
            }
        }
        
        return contadorMenoresEdad;
    }
    
    public String generarMensajeListaProductos() {
        ArrayList<String> listaProductos = new ArrayList<>();

        listaProductos.add("Café");
        listaProductos.add("Vino");
        listaProductos.add("Pan");
        listaProductos.add("Papas fritas");
        listaProductos.add("Soda");

        // Crear un comparador personalizado para ordenar en base al precio
        Comparator<String> comparador = new Comparator<String>() {
            @Override
            public int compare(String producto1, String producto2) {
                double precioProducto1 = obtenerPrecioProducto(producto1);
                double precioProducto2 = obtenerPrecioProducto(producto2);
                return Double.compare(precioProducto2, precioProducto1);
            }
        };

        // Ordenar la lista de productos en base al comparador
        Collections.sort(listaProductos, comparador);

        // Generar el mensaje de la lista de productos
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Lista de alimentos:\n");
        for (String producto : listaProductos) {
            int cantidadComprada = obtenerCantidadCompradaProducto(producto);
            mensaje.append("- ").append(producto).append(" (Comprados: ").append(cantidadComprada).append(")\n");
        }

        return mensaje.toString();
    }
    public double obtenerPrecioProducto(String producto) {
        double precio = 0.0;

        switch (producto) {
        case "café":
        	precio = 1.0;
            break;
        case "vino":
        	precio = 30.0;
            break;
        case "desayuno":
        	precio = 2.0;
            break;
        case "almuerzo":
        	precio = 5.0;
            break;
        case "gaseosa":
        	precio = 2.0;
            break;
        case "postre":
        	precio = 4.0;
            break;
        }

        return precio;
    }
    
    public int obtenerCantidadCompradaProducto(String producto) {
        int contador = 0;
        
        for (int i = 0; i < compras.size(); i++) {
            Double compra = compras.get(i);
            if (compra.equals(producto)) {
                contador++;
            }
        }
        
        return contador;
    }

   
}
