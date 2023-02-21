package com.generation.clase1602;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication
public class Clase1602Application {


		//Primero debemos crear las funciones que ocuparemos en este ejercicio:

		//FUNCIÓN 1: para calcular el promedio de notas. Los parámetros que se usan son el array que contiene cada una de las notas de cada alumno.
		public static Double promedioNotas(ArrayList<Double> notas){
			Double suma = 0.0;
			for (int i = 0; i < notas.size(); i++) {
				//suma = suma + notas.get(i) -> es lo mismo :D
				suma += notas.get(i);
			}
			//Retorna la suma de las notas de cada alumno y la divide por el total (notas.size)
			/*Más abajo, cuando llamamos a la función promedioNotas(), le agregamos como parámetro el HashMap que va a contener el arreglo con las notas.
			Por ahora, agregamos como parámetro algo descriptivo como un arreglo llamado notas, que se creará más tarde.*/
			return suma/notas.size();
		}
		
		//FUNCIÓN 2: para verificar si el promedio del alumno está por sobre o debajo de la nota aprobatoria, en este caso, 4.0
		public static Boolean aprobado(ArrayList<Double> notas, Double notaAprobatoria){
			Double promedio = promedioNotas(notas);
			if(promedio >= notaAprobatoria){
				return true;
			}else{
				return false; 
			}
		}

		//FUNCIÓN 3: verifica si el promedio del alumno es mayor al promedio general
		public static void sobrePromedio(Double promedioGeneral, ArrayList<Double> notas, String nombreAlum){
			//Creamos una variable que guarde la función 1 que calcula el promedio
			Double promedioAlumno = promedioNotas(notas);
			//Creamos una condición if que verifica si el promedio de cada alumno está por sobre o debajo del promedio general
			if(promedioAlumno>promedioGeneral){
				System.out.println("El alumno "+nombreAlum+" está sobre el promedio");
			}else if(promedioAlumno == promedioGeneral){
				System.out.println("El alumno "+nombreAlum+" es igual al promedio general");
			}else{
				System.out.println("El alumno "+nombreAlum+" está bajo el promedio");
			}
		}



	public static void main(String[] args) {

	/* vamos a pedir al usuario que ingrese la cantidad de alumnos
	 * a los cuales les asignará una nota
	 * luego de que ingrese la cantidad de alumno y la cantidad de notas por alumnos
	 * se le mostrará un menú.
	 * opciones del menú: 
	 * mostrar el promedio de notas
	 * mostrar si la nota es aprobatria y reprobatoria
	 * mostrar si la nota está por sobre o por debajo del promedio del curso
	 */

	 /* solicitar al usuario la cantidad de alumnos*
	 *Solicitar el nombre de cada alumnos*
	 *solicitar la cantidad de notas de por alumno*
	  *ingresar notas por alumno*
	  *definir la nota aprobatoria*
	  *sacar el promedio por alumnos y general 
	  *verificar si el promedio del alumnos esta por sobre o 
	  por debajo del promedio general
	  *verificar si la nota aprueba o reprueba
	  *hacer el menú con solo 3 opciones con cero finalizando el menú
	  *hacer validaciones sobre las notas y la cantidad de alumnos
	  *verificar que el promedio se calcule previamente antes de las 
	  operaciones que lo requieren
	  */
		
		//Primero debemos abrir el Scanner
		Scanner teclado = new Scanner(System.in);
		//Crear las variables que vamos a utilizar junto con el HashMap
		String nomAlum = "";
		Double notaAprobatoria = 4.0;
		HashMap <String, ArrayList<Double>> libroClase = new HashMap<String, ArrayList<Double>>();
		  
		//Se declara fuera del do...while ya que si la declaramos adentro
		//la variable pasa a ser local por ende no podríamos ocuparla fuera de este
		//Declaramos variables que van a contener la cantidad de alumnos y de notas
		int cantAlum;
		int cantNotas;
		//Hacemos dos do while para que le pida al usuario dos datos, que NO deben ser negativos
		do{
			System.out.print("Indique la cantidad de alumnos que va a ingresar: ");
			cantAlum = teclado.nextInt();
			if(cantAlum <= 0){
				System.out.print("La cantidad de alumnos debe ser mayor a cero, porfavor intente denuevo");
			}

		}while(cantAlum <= 0);

		do{
			System.out.print("Indique la cantidad de notas por alumnos: ");
			cantNotas = teclado.nextInt();
			if(cantNotas <= 0){
				System.out.print("La cantidad de notas debe ser mayor a cero, por favor entente mas tarde");
			}
		}while(cantNotas <= 0);
		
		//Recorremos el array para que vaya preguntando el nombre de cada alumno según la cantidad de alumnos ingresados por el usuario
		for(int i = 1; i <= cantAlum; i++){
			teclado.nextLine();
			ArrayList <Double> notasAlumnos = new ArrayList<Double>();
			System.out.print("Ingresa nombre del alumno: ");
			nomAlum = teclado.nextLine();
			//Hacemos un for dentro del otro for para preguntar por las notas de cada alumno ingresado
			for(int x = 1; x <= cantNotas; x++){
				System.out.print("Ingresa nota " +x+ " del alumno "+ nomAlum +": ");
				Double nota = teclado.nextDouble();
				notasAlumnos.add(nota);
			}
			//Ponemos estas la llave y el arreglo que en este caso representa el valor (los nombres de los alumnos, junto con las notas de estos) en el HashMap con put
			libroClase.put(nomAlum, notasAlumnos);
			//desafio, verificar donde deberia o como deberia limpíar el arreglo para que funcione
			//con la declaración de manera global
			//notasAlumnos.clear();
		}
		
		// for(String i : libroClase.keySet()){
		// 	System.out.println("key: "+ i +" Valor:" + libroClase.get(i));
		// }

		//Ahora creamos el menú
		int opcion = 1; 

		while(opcion != 0){
			//Hacemos un do while para que le pida al usuario que ingrese un número entre 0 y 3
			do{
				System.out.println("**************Comienzo de Menú***************");
				System.out.println("Bienvenido/a");
				System.out.println("Seleccione 1 si quiere obtener el promedio de las notas por alumno.");
				System.out.println("Seleccione 2 si quiere ver si el alumno aprueba o reprueba");
				System.out.println("Seleccione 3 para ver si la nota está sobre o por debajo del promedio general");
				System.out.println("Seleccione 0 para salir del menú");
				System.out.print("Seleccione su opción: ");
				opcion = teclado.nextInt();
				
			}while(opcion < 0 || opcion > 3);
			/*Si el usuario escoge la opción 1, el programa llama a la función para calcular el promedio y
			 * como parámetro le indicamos el HashMap con 'i' para que acceda a cada valor (array con notas)
			*/
			if(opcion == 1){
				for(String i : libroClase.keySet()){
					//cada vez que ocupemos un for opara hashmap
					//el valor de la llave (en este caso el array)
					//está contenido dentro de la sintaxis nomHasmap.get(i)
					Double promAlum = promedioNotas(libroClase.get(i));
					System.out.println("El promedio del alumno: "+ i +" es de: " + promAlum);
				}
				/*Si el usuario escoge la opción 2, llamamos a la función aprobado y le entregamos como
				 * parámetros el valor del HM y la nota aprobatoria
				 */
			}else if (opcion == 2){
				for(String i : libroClase.keySet()){
					Boolean aprobar = aprobado(libroClase.get(i), notaAprobatoria);
					//es lo mismo que poner if (aprobar == true)
					if(aprobar){
						System.out.println("El alumno/a "+i+" está aprobado");
					}else{
						System.out.println("El alumno/a "+i+" está reprobado");
					}
					/*Si el usuario escoge la opción 3, llamamos a la función promedioNotas y hacemos una variable
					 * que vaya sumando todos estos promedios (que están dentro del HM)
					 */
				}
			}else if(opcion == 3){
				Double sumaPromedio = 0.0;
				for(String i : libroClase.keySet()){
					sumaPromedio = sumaPromedio + promedioNotas(libroClase.get(i));
					/*La suma de los promedios de cada alumno se dividen por la cantidad de alumnos
					 * para finalmente poder calcular el promedio general 
					 */
				}
				Double promedioGeneral = sumaPromedio / cantAlum;
				for(String i : libroClase.keySet()){
					/*Se llama a la función sobrePromedio y se le entregan como parámetros el promedioGeneral
					 * el promedio de los alumnos y el nombre de estos.
					 */
					sobrePromedio(promedioGeneral, libroClase.get(i), i);
				}
				/*Si el usuario escoge la opción 0 se cierra el menú */
			}else{
				System.out.println("Gracias por cerrar el menú, hasta pronto :D");
			}

		}

		

		
	}

}
