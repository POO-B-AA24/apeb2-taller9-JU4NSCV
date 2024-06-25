
public class Problema6_Banco {
    public static void main(String[] args) {
        Cuenta cuenta1 = new CuentaCheques(123, "Juan");
        CuentaAhorros cuenta2 = new CuentaAhorros(456, "Luis");
        CuentaPlatino cuenta3 =  new CuentaPlatino(678, "Pedro");
        
        cuenta1.depositar(1000);
        cuenta2.depositar(2000);
        cuenta3.depositar(3000);
        
        cuenta1.retirar(500);
        cuenta2.retirar(250);
        cuenta3.retirar(1000);
        
        cuenta2.aplicarInteres();
        cuenta3.aplicarInteres();

        // Mostrar dineroCuentas
        System.out.println(cuenta1);
        System.out.println(cuenta2);
        System.out.println(cuenta3);
    }
}

class Cuenta {

    public int numeroCuenta;
    public String nombreCliente;
    public double dineroCuenta;

    public Cuenta(int numeroCuenta, String nombreCliente) {
        this.numeroCuenta = numeroCuenta;
        this.nombreCliente = nombreCliente;
        this.dineroCuenta = 0;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            dineroCuenta += cantidad;
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0) {
            dineroCuenta -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cuenta [numeroCuenta=" + numeroCuenta + ", nombreCliente=" + nombreCliente + ", dineroCuenta=" + dineroCuenta + "]";
    }
}

class CuentaCheques extends Cuenta {

    public CuentaCheques(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    @Override
    public boolean retirar(double cantidad) {
        return super.retirar(cantidad);
    }
}

class CuentaAhorros extends Cuenta {

    public double interes = 0.02;

    public CuentaAhorros(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    @Override
    public boolean retirar(double cantidad) {
        if (dineroCuenta - cantidad >= 0) {
            return super.retirar(cantidad);
        }
        return false;
    }

    public void aplicarInteres() {
        dineroCuenta += dineroCuenta * interes;
    }
}

class CuentaPlatino extends Cuenta {
    public double interes = 0.10; // 10% de interés

    public CuentaPlatino(int numeroCuenta, String nombreCliente) {
        super(numeroCuenta, nombreCliente);
    }

    @Override
    public boolean retirar(double cantidad) {
        return super.retirar(cantidad);
    }

    public void aplicarInteres() {
        dineroCuenta += dineroCuenta * interes;
    }
}