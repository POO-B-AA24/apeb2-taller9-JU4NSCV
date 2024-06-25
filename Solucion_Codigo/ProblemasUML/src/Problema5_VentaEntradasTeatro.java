
import java.util.ArrayList;
import java.util.List;

public class Problema5_VentaEntradasTeatro {
    
}

class Zona {

    private String nombre;
    private int numeroLocalidades;
    private double precioNormal;
    private double precioAbonado;
    private int localidadesVendidas;

    public Zona(String nombre, int numeroLocalidades, double precioNormal, double precioAbonado) {
        this.nombre = nombre;
        this.numeroLocalidades = numeroLocalidades;
        this.precioNormal = precioNormal;
        this.precioAbonado = precioAbonado;
        this.localidadesVendidas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaCompleta() {
        return localidadesVendidas >= numeroLocalidades;
    }

    public Entrada venderEntrada(int id, String nombreComprador, String tipo) {
        if (estaCompleta()) {
            return null;
        }

        localidadesVendidas++;
        switch (tipo) {
            case "normal":
                return new Normal(id, this, nombreComprador, precioNormal);
            case "abonado":
                return new Abonado(id, this, nombreComprador, precioAbonado);
            case "reducida":
                return new Reducida(id, this, nombreComprador, precioNormal);
            default:
                return null;
        }
    }
}

abstract class Entrada {

    protected int id;
    protected Zona zona;
    protected String nombreComprador;
    protected double precio;

    public Entrada(int id, Zona zona, String nombreComprador) {
        this.id = id;
        this.zona = zona;
        this.nombreComprador = nombreComprador;
        this.precio = calcularPrecio();
    }

    public abstract double calcularPrecio();

    public int getId() {
        return id;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public double getPrecio() {
        return precio;
    }

    public Zona getZona() {
        return zona;
    }
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
            if (z.getNombre().equalsIgnoreCase(nombreZona)) {
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
                System.out.println("La zona está completa.");
                return null;
            }
        } else {
            System.out.println("No existe ninguna zona con ese nombre.");
            return null;
        }
    }

    public Entrada consultarEntrada(int id) {
        for (Entrada e : entradas) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
