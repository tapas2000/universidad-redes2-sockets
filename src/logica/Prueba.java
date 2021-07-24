package logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Cuenta> lstCuentas =  new HashMap<>();
		//Datos de prueba
		Cuenta a =  new Cuenta(0, "Juan Tapasco");
		Cuenta b =  new Cuenta(1, "Angelica Arroyave");
		
		//Agregar Datos
		lstCuentas.put(lstCuentas.size(), a);
		lstCuentas.put(lstCuentas.size(), b);
		
		System.out.println(lstCuentas.containsKey(0));
		System.out.println(lstCuentas.keySet());
		
		//Buscar
		System.out.println(buscarPropietario("Juan Tapasco",lstCuentas));
		//Agregar
		System.out.println(agregarCuenta("Claudia Henao", lstCuentas));
	}
	
	public static String agregarCuenta(String nuevoPropietario,HashMap<Integer, Cuenta> lstCuentas) {
		int validacion = buscarPropietario(nuevoPropietario, lstCuentas);
		
		if (validacion < 0) {
			int numCuenta = lstCuentas.size();
			Cuenta nuevo = new Cuenta(numCuenta, nuevoPropietario);
			lstCuentas.put(lstCuentas.size(), nuevo);
			//Tomar fecha y hora actual
			DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			System.out.println("yyyy/MM/dd HH:mm:ss-> "+date.format(LocalDateTime.now()));
			
			return "Apertura exitosa de cuenta de ahorros " + numCuenta;
			//return "Cuenta de ahorros abierta con exito, Datos :"+ (lstCuentas.size()-1)+"-"+nuevoPropietario+"-"+0; 
		}else {
			return "Error en la apertura de cuenta de ahorros. Nombre de usuario repetido";
		}
	}
	
	/**
	 * Metodo que busca a un propietario dentro de la lista de propietarios comparando sus nombres
	 * @param nombre Es el nombre del propietario que se desea buscar
	 * @param lstCuentas Es la lista en donde estan todas las cuentas
	 * @return El indice que conincidan el nombre de propietario con el nombre enviado o -1 si no encontro ningun propietario con el nombre que se envio,
	 */
	public static int buscarPropietario(String nombre, HashMap<Integer, Cuenta> lstCuentas) {
		
		Set<Integer> lstKeys =  lstCuentas.keySet();
		
		for (Integer key : lstKeys) {
			Cuenta a = lstCuentas.get(key);
			if (a.nombrePropietario.equals(nombre)) {
				return key;
			}
		}
		
		return -1;
	}

}
