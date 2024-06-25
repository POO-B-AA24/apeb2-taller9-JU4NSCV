
public class Problema3_EnvioMensajes {

    public static void main(String[] args) {
        Movil remitente = new Movil(123456789, "Alex");
        Movil destinatario = new Movil(987654321, "Luis");

        Mensaje sms = new MensajeTexto(remitente, destinatario, "Hola Mundo");
        Mensaje mms = new MensajeImagen(destinatario, remitente, "imagen.jpg");

        sms.enviarMensaje();
        System.out.println(sms.visualizarMensaje());

        mms.enviarMensaje();
        System.out.println(mms.visualizarMensaje());
    }
}

class Movil {

    public int numero;
    public String nombre;

    public Movil(int numeroMovil, String nombre) {
        this.numero = numeroMovil;
        this.nombre = nombre;
    }
}

abstract class Mensaje {

    protected Movil remitente;
    protected Movil destinatario;

    public Mensaje(Movil remitente, Movil destinatario) {
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public void enviarMensaje() {
    }

    ;
    public abstract String visualizarMensaje();
}

class MensajeTexto extends Mensaje {

    private String texto;

    public MensajeTexto(Movil remitente, Movil destinatario, String texto) {
        super(remitente, destinatario);
        this.texto = texto;
    }

    @Override
    public String visualizarMensaje() {
        return texto;
    }
}

class MensajeImagen extends Mensaje {

    private String nombreFicheroImagen;

    public MensajeImagen(Movil remitente, Movil destinatario, String nombreFicheroImagen) {
        super(remitente, destinatario);
        this.nombreFicheroImagen = nombreFicheroImagen;
    }

    @Override
    public String visualizarMensaje() {
        return nombreFicheroImagen;
    }
}
