import java.util.Scanner;
/*
 *  Hacer un programa en java para capturar por teclado dos cadenas e imprimir las cadenas carácter
    por carácter. Validando si digitó texto por cada cadena, convirtiéndola a mayúscula, a minúscula y si la
    cadena inicia con la letra U o con la letra F, validar la cantidad de caracteres de cada una.
 */
public class Cadenas {
    public static void main(String args[]){
        Scanner bring = new Scanner(System.in);
        // Obtenemos las cadenas del usuario
        System.out.print("Digite Primer Cadena: ");
        String cadena_1 = bring.next();
        System.out.print("Digite Segunda Cadena: ");
        String cadena_2 = bring.next();
        //
        // Imprimimos ambas cadenas caracter por caracter, luego minuscula y mayus
        // Cadena 1
        if(cadena_1.isEmpty() == true){
            System.out.println("ERROR: Cadena 1 Esta vacia.");
        }
        else{
            System.out.println("Cadena 1: ");
            for(int i = 0; i < cadena_1.length(); i++){
                System.out.println(cadena_1.charAt(i));
            }
        }
        System.out.println("En mayuscula: " + cadena_1.toUpperCase());
        System.out.println("En minuscula: " + cadena_1.toLowerCase());
        // Cadena 2
        if(cadena_2.isEmpty() == true){
            System.out.println("ERROR: Cadena 2 Esta vacia.");
        }
        else{
            System.out.println("\nCadena 2: ");
            for(int j = 0; j < cadena_2.length(); j++){
                System.out.println(cadena_2.charAt(j));
            }
        }
        System.out.println("En mayuscula: " + cadena_2.toUpperCase());
        System.out.println("En minuscula: " + cadena_2.toLowerCase());
        
        // Si la cadena empieza con U o F, verificar la longitud
        cadena_1 = cadena_1.toLowerCase();
        cadena_2 = cadena_2.toLowerCase();
        
        if(cadena_1.startsWith("u") || cadena_1.startsWith("f")){
            System.out.println("Longitud Cadena 1: " + cadena_1.length());
        }
        if(cadena_2.startsWith("u") || cadena_2.startsWith("f")){
            System.out.println("Longitud Cadena 2: " + cadena_2.length());
        }
        
        bring.close();
    }
}
