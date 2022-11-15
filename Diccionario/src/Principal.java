import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


/**
 * A traves de un menu el usuario puede insertar eliminar y consultar las definiciones. Ademas de consultar
 * el numero de definiciones
 */
public class Principal {
    private static Scanner sn = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        List<Definicion> definiciones = new ArrayList<Definicion>();
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
            
            System.out.println("MENU:");
            System.out.println("1. Añadir un termino al diccionario");
            System.out.println("2. Eliminar un termino del diccionario");
            System.out.println("3. Número de terminos");
            System.out.println("4. Localizar y presentar la definición correspondiente a un término");
            System.out.println("5. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado añadir un termino al diccionario");
                        definiciones= insertarDefinicion(definiciones);
                        break;
                    case 2:
                        System.out.println("Has seleccionado eliminar un término");
                        eliminarDefinicion(definiciones);
                        break;
                    case 3:
                        System.out.println("Has seleccionado indicar el número de términos");
                        System.out.println("Hay "+definiciones.size()+" definiciones");
                        break;
                    case 4:
                        System.out.println("Has seleccionado localizar y presentar la definición correspondiente a un término");
                        System.out.println(buscarDefinicion(definiciones).toString());
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 5");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sn.next();
            }
        }
        sn.close();
    }
    /**
     * Lee una cadena del usuario, verifica si la cadena ya está en la lista y, si no lo está, lee otra
     * cadena del usuario y la agrega a la lista.
     * 
     * @param definiciones Lista de definiciones
     * @return La lista de definiciones.
     */
    private static List<Definicion> insertarDefinicion(List<Definicion> definiciones){
        sn.nextLine();
        String termino =leerString("Introduce un termino a definir");
        if(definiciones.contains(new Definicion(termino)))
            System.out.println("La definicion "+termino+" ya existe");
        else{
            String definicion= leerString("Introduce la definicion");
            String mensaje= "Deseas introducir la definicion\n" + termino+": "+definicion;
            if (leerConfirmacion(mensaje))
            definiciones.add(new Definicion(termino, definicion));
            //Posterior ordena las definiciones
            Collections.sort(definiciones);            
        }
        return definiciones;
    }

 
    /**
     * Toma una lista de definiciones, le pide al usuario un término para eliminar y, si el término
     * existe, le pregunta al usuario si desea eliminarlo.
     * 
     * @param definiciones Lista de definiciones
     * @return Una lista de definiciones.
     */
    private static List<Definicion> eliminarDefinicion(List<Definicion> definiciones){
        sn.nextLine();
        String termino=leerString("Introduce un termino a eliminar");
        if(!definiciones.contains(new Definicion(termino)))
            System.out.println("La definicion "+termino+" no existe");
        else{
            Definicion definicion= definiciones.get(definiciones.indexOf(new Definicion(termino)));
            String mensaje= "Deseas eliminar la definicion\n" +definicion;
            if (leerConfirmacion(mensaje))
            definiciones.remove(definicion);
        }
        return definiciones;
    }

    /**
     * Toma una lista de definiciones y devuelve una definición.
     * 
     * @param definiciones Lista de definiciones
     * @return El índice de la definición en la lista.
     */
    private static Definicion buscarDefinicion(List<Definicion> definiciones){
        sn.nextLine();
        String termino=leerString("Introduce un termino a buscar");
        
        if(!definiciones.contains(new Definicion(termino))){
        System.out.println("La definicion "+termino+" no existe");
        return null;
        }
        else
            return definiciones.get(definiciones.indexOf(new Definicion(termino)));
    }
    /**
     * Toma una cadena como argumento y la imprime en la consola. Luego espera a que el usuario ingrese
     * una cadena y devuelve esa cadena
     * 
     * @param mensaje El mensaje que se mostrará al usuario.
     * @return El método está devolviendo la variable de texto.
     */
    private static String leerString(String mensaje){
        System.out.println(mensaje);
        String texto= sn.nextLine();
        return texto;
    }
    /**
     * Le pide al usuario una confirmación, y si el usuario no responde con un "sí" o "no", vuelve a
     * preguntar
     * 
     * @param mensaje El mensaje que se mostrará al usuario.
     * @return El método devuelve un valor booleano.
     */
    private static boolean leerConfirmacion(String mensaje){
        System.out.println(mensaje);
        String confirmacion=sn.next().toUpperCase();
        if (confirmacion.equals("SI")|| confirmacion.equals("NO"))
        return confirmacion.equals("SI");
        else
        return leerConfirmacion(mensaje);
    }
}
