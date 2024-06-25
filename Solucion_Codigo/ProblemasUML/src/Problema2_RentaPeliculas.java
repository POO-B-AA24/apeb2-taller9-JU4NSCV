
public class Problema2_RentaPeliculas {
    Pelicula peli = new Pelicula("Intensamente", "Luis", "10/20/2024", "Español");
    
}

class Pelicula {

    public String titulo;
    public String autor;
    public String anioEdicion;
    public String Idioma;

    public Pelicula(String titulo, String autor, String anioEdicion, String idioma) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioEdicion = anioEdicion;
        this.Idioma = idioma;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", autor=" + autor + ", anioEdicion=" + anioEdicion + ", Idioma=" + Idioma + '}';
    }
    
}

abstract class Soporte {

    public double precio;

    public Soporte() {
    }

    @Override
    public String toString() {
        return "Soporte{" + '}';
    }

}

class DVD extends Soporte {

    public double capacidadGB;

    public DVD(double capacidadGB, double precio) {
        this.capacidadGB = capacidadGB;
    }

    public void calcularPrecio() {
        this.precio *= 1.1;
    }

    @Override
    public String toString() {
        return "DVD{" + "capacidadGB=" + capacidadGB + '}';
    }
    
}

class VHS extends Soporte {

    public String tipoCintaMagnetica;

    public VHS(String tipoCintaMagnetica, double precio) {
        this.tipoCintaMagnetica = tipoCintaMagnetica;
    }

    @Override
    public String toString() {
        return "VHS{" + "tipoCintaMagnetica=" + tipoCintaMagnetica + '}';
    }

}
