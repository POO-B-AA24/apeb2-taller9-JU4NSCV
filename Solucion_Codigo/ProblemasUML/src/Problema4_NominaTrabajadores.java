
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problema4_NominaTrabajadores {
    public static void main(String[] args) {
        Jefe jefe1 = new Jefe("Floy ", "Velez", "centro", 110101020, 1500);
        List<Trabajador> trabajadores = new ArrayList(Arrays.asList(
            new FijoMensual(1000, "Luis", "Solano", "centro", 111010240,jefe1),
            new Comisionista(10, 10.5, "Luis", "Solano", "centro", 10101011, jefe1),
            new PorHoras(20, 10.5 , 5.4, "Luis", "Solano", "centro", 11101123, jefe1)));
        for (Trabajador trabajador : trabajadores) {
            trabajador.calcularNomina();
            System.out.println(trabajador);
        }
    }
}

class Jefe {

    public String nombre;
    public String apellidos;
    public String direccion;
    public int dni;
    public double salario;

    public Jefe(String nombre, String apellidos, String direccion, int dni, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Jefe{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", dni=" + dni + ", salario=" + salario + '}';
    }
    
}

abstract class Trabajador {

    public String nombre;
    public String apellidos;
    public String direccion;
    public int dni;
    public Jefe jefe;

    public Trabajador(String nombre, String apellidos, String direccion, int dni, Jefe jefe) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.jefe = jefe;
    }

    public abstract void calcularNomina();

    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", dni=" + dni + ", jefe=" + jefe + '}';
    }
    
}

class FijoMensual extends Trabajador {

    public double salarioMensual;

    public FijoMensual(double salarioMensual, String nombre, String apellidos, String direccion, int dni, Jefe jefe) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public void calcularNomina() {
        this.salarioMensual /= 30;
    }

    @Override
    public String toString() {
        return "FijoMensual{" +super.toString()+ "salarioMensual=" + salarioMensual + '}';
    }
    
}

class Comisionista extends Trabajador {

    public int ventasRealizadas;
    public double porcentajeComision;
    public double salario;

    public Comisionista(int ventasRealizadas, double porcentajeComision, String nombre, String apellidos, String direccion, int dni, Jefe jefe) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.ventasRealizadas = ventasRealizadas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public void calcularNomina() {
        this.salario = ventasRealizadas * porcentajeComision;
    }

    @Override
    public String toString() {
        return "Comisionista{" +super.toString()+ "ventasRealizadas=" + ventasRealizadas + ", porcentajeComision=" + porcentajeComision + ", salario=" + salario + '}';
    }
    
}

class PorHoras extends Trabajador {

    public double numHoras;
    public double tarifaHora;
    public double numHorasExtras;
    public double salario;

    public PorHoras(int numHoras, double tarifaHora, double numHorasExtras, String nombre, String apellidos, String direccion, int dni, Jefe jefe) {
        super(nombre, apellidos, direccion, dni, jefe);
        this.numHoras = numHoras;
        this.tarifaHora = tarifaHora;
        this.numHorasExtras = numHorasExtras;
    }

    @Override
    public void calcularNomina() {
        this.salario = (numHoras + numHorasExtras) * tarifaHora;
    }

    @Override
    public String toString() {
        return "PorHoras{" +super.toString()+ "numHoras=" + numHoras + ", tarifaHora=" + tarifaHora + ", numHorasExtras=" + numHorasExtras + ", salario=" + salario + '}';
    }
    
}
