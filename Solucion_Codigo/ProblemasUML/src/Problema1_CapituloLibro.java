
public class Problema1_CapituloLibro {
    Secciones sec1 = new Secciones();
    ComponenteSecciones comsec1 = new ComponenteSecciones();
    Parrafo par1 = new Parrafo("holi");
    Sentencia sen = new Sentencia("holi");
    Palabra palabra = new Palabra("hola");
    Figura fig = new Figura("holi");
    
}

class Secciones{

    public Secciones() {
    }
    
}

class ComponenteSecciones {

    public ComponenteSecciones() {
    }
    
}

class Parrafo extends ComponenteSecciones {
    public String sentencias;

    public Parrafo(String sentencias) {
        this.sentencias = sentencias;
    }

    @Override
    public String toString() {
        return "Parrafo{" + "sentencias=" + sentencias + '}';
    }
    
}

class Figura extends ComponenteSecciones {

    public String figura;

    public Figura(String figura) {
        this.figura = figura;
    }

    @Override
    public String toString() {
        return "Figura{" + "figura=" + figura + '}';
    }

}

class Sentencia {

    public String sentencia;

    public Sentencia(String sentencia) {
        this.sentencia = sentencia;
    }

    @Override
    public String toString() {
        return "Sentencia{" + "sentencia=" + sentencia + '}';
    }

}

class Palabra {

    public String sentencia;

    public Palabra(String sentencia) {
        this.sentencia = sentencia;
    }

    @Override
    public String toString() {
        return "Palabra{" + "sentencia=" + sentencia + '}';
    }

}
