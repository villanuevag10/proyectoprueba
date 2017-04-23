package example.com.co.taller;

import java.util.ArrayList;

/**
 * Created by Cesar on 22/04/2017.
 */
public abstract class Datos {

    public static ArrayList<Operacion> operaciones = new ArrayList<>();
    public static void guardar(Operacion op){
        operaciones.add(op);
    }
    public static ArrayList<Operacion> mostrar(){
        return operaciones;
    }
}
