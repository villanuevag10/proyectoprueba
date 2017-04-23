package example.com.co.taller;

/**
 * Created by Cesar on 22/04/2017.
 */
public class Operacion {
    public String descripcion;
    public String datos;
    public double resultado;

    public Operacion(String descripcion, String datos, double resultado) {
        this.descripcion = descripcion;
        this.datos = datos;
        this.resultado = resultado;
    }

    public Operacion() {
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }


    @Override
    public String toString() {
        return "descripcion='" + descripcion + '\'' +
                ", datos='" + datos + '\'' +
                ", resultado=" + resultado;
    }
}

