import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
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
       
                        break;
                    case 2:
                        System.out.println("Has seleccionado eliminar un término");
                        
                        break;
                    case 3:
                        System.out.println("Has seleccionado indicar el número de términos");
                        
                        break;
                    case 4:
                        System.out.println("Has seleccionado localizar y presentar la definición correspondiente a un término");
                        
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
    }
  
