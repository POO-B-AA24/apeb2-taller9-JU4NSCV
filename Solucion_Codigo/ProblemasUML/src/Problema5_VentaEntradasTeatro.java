
import java.util.ArrayList;
import java.util.List;

public class Problema5_VentaEntradasTeatro {

    public static void main(String[] args) {
        Teatro teatro = new Teatro();
        teatro.agregarZona(new Zona("Principal", 200, 25, 17.5));
        teatro.agregarZona(new Zona("PalcoB", 40, 70, 40));
        teatro.agregarZona(new Zona("Central", 400, 20, 14));
        teatro.agregarZona(new Zona("Lateral", 100, 15.5, 10));

        Entrada entrada1 = teatro.venderEntrada("Principal", "Juan Perez", "normal");
        if (entrada1 != null) {
            System.out.println("Identificador de entrada: " + entrada1.id);
            System.out.println("Precio: " + entrada1.precio + "$");
        }

        Entrada consulta = teatro.consultarEntrada(1);
        if (consulta != null) {
            System.out.println("Consulta de entrada: ");
            System.out.println("Nombre del comprador: " + consulta.nombreComprador);
            System.out.println("Precio: " + consulta.precio + "$");
            System.out.println("Zona: " + consulta.zona.nombre);
        } else {
            System.out.println("No existe ninguna entrada con ese identificador.");
        }

    }
}

class Zona {

    public String nombre;
    public int numeroLocalidades;
    public double precioNormal;
    public double precioAbonado;
    public int localidadesVendidas;

    public Zona(String nombre, int numeroLocalidades, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.numeroLocalidades = numeroLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
        this.localidadesVendidas = 0;
    }

    public boolean estaCompleta() {
        return localidadesVendidas >= numeroLocalidades;
    }

    public Entrada venderEntrada(int id, String nombreComprador, String tipo) {
        if (estaCompleta()) {
            return null;
        }

        localidadesVendidas++;
        return switch (tipo) {
            case "normal" ->
                new Normal(id, this, nombreComprador, precioNormal);
            case "abonado" ->
                new Abonado(id, this, nombreComprador, precioAbonado);
            case "reducida" ->
                new Reducida(id, this, nombreComprador, precioNormal);
            default ->
                null;
        };
    }
}

abstract class Entrada {

    public int id;
    public Zona zona;
    public String nombreComprador;
    public double precio;

    public Entrada(int id, Zona zona, String nombreComprador) {
        this.id = id;
        this.zona = zona;
        this.nombreComprador = nombreComprador;
        this.precio = calcularPrecio();
    }

    public abstract double calcularPrecio();

}

class Normal extends Entrada {

    private double precioNormal;

    public Normal(int id, Zona zona, String nombreComprador, double precioNormal) {
        super(id, zona, nombreComprador);
        this.precioNormal = precioNormal;
    }

    @Override
    public double calcularPrecio() {
        return precioNormal;
    }
}

class Abonado extends Entrada {

    private double precioAbonado;

    public Abonado(int id, Zona zona, String nombreComprador, double precioAbonado) {
        super(id, zona, nombreComprador);
        this.precioAbonado = precioAbonado;
    }

    @Override
    public double calcularPrecio() {
        return precioAbonado;
    }
}

class Reducida extends Entrada {

    private double precioNormal;

    public Reducida(int id, Zona zona, String nombreComprador, double precioNormal) {
        super(id, zona, nombreComprador);
        this.precioNormal = precioNormal;
    }

    @Override
    public double calcularPrecio() {
        return precioNormal * 0.85;
    }
}

class Teatro {

    private List<Zona> zonas;
    private List<Entrada> entradas;
    private int ultimoId;

    public Teatro() {
        this.zonas = new ArrayList<>();
        this.entradas = new ArrayList<>();
        this.ultimoId = 0;
    }

    public void agregarZona(Zona zona) {
        zonas.add(zona);
    }

    public Entrada venderEntrada(String nombreZona, String nombreComprador, String tipo) {
        Zona zona = null;
        for (Zona z : zonas) {
            if (z.nombre.equalsIgnoreCase(nombreZona)) {
                zona = z;
                break;
            }
        }

        if (zona != null) {
            Entrada entrada = zona.venderEntrada(++ultimoId, nombreComprador, tipo);
            if (entrada != null) {
                entradas.add(entrada);
                return entrada;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public Entrada consultarEntrada(int id) {
        for (Entrada entrada : entradas) {
            if (entrada.id == id) {
                return entrada;
            }
        }
        return null;
    }
}
