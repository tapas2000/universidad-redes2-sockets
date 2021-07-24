package logica;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Cuenta> lstCuentas =  new HashMap<>();
		//Datos de prueba
		Cuenta a =  new Cuenta(0, "Juan Tapasco");
		Cuenta b =  new Cuenta(1, "Angelica Arroyave");
		
		//Agregar Datos
		System.out.println("---------------------------------");
		lstCuentas.put("Juan Tapasco", a);
		lstCuentas.put("Angelica Arroyave", b);
		System.out.println(lstCuentas.containsKey(0));
		System.out.println(lstCuentas.keySet());
		System.out.println();
		
		//Buscar
		System.out.println("---------------------------------");
		System.out.println(lstCuentas.containsKey("Juan Tapasco"));
		System.out.println(lstCuentas.get("Juan Tapasco"));
		System.out.println();
		
		//Agregar
		System.out.println("---------------------------------");
		System.out.println(lstCuentas.containsKey("Stefania Aguirre ".trim()));
		System.out.println(agregarCuenta(" Stefania Aguirre", lstCuentas));
		System.out.println(lstCuentas.containsKey("Stefania Aguirre"));
		System.out.println();
		
		//Despositar
		System.out.println("---------------------------------");
		System.out.println("Saldo Antes: " + lstCuentas.get("Stefania Aguirre").getSaldo());
		System.out.println(depositar(2, 500, lstCuentas));
		System.out.println("Saldo Despuï¿½s: " + lstCuentas.get("Stefania Aguirre").getSaldo());
		System.out.println();
		
		//Retirar
		System.out.println("---------------------------------");
		System.out.println("Saldo Antes del Retiro: " + lstCuentas.get("Stefania Aguirre").getSaldo());
		System.out.println(retirar(2, 600, lstCuentas));
		System.out.println(retirar(2, 8, lstCuentas));
		System.out.println(retirar(2, 2, lstCuentas));
		System.out.println("Saldo Despuï¿½s del Retiro: " + lstCuentas.get("Stefania Aguirre").getSaldo());
		System.out.println();
		
		//CrearBolsillo
		System.out.println("---------------------------------");
		System.out.println("Idbolsillo antes : " + lstCuentas.get("Juan Tapasco").getBolsilloId());
		System.out.println(abrirBolsillo(0, lstCuentas));
		System.out.println("Idbolsillo despuï¿½s : " + lstCuentas.get("Juan Tapasco").getBolsilloId());
		System.out.println("Intento de crear cuenta si esta existe : "+abrirBolsillo(0, lstCuentas));
		System.out.println();
				
		//Trasladar a bolsillo
		System.out.println("---------------------------------");
		System.out.println("Saldo Antes del traslado: " + lstCuentas.get("Stefania Aguirre").getSaldo());
		System.out.println("SaldoBolsillo antes del traslado: " + lstCuentas.get("Stefania Aguirre").getBolsilloSaldo());
		System.out.println(trasladar(2, 600, lstCuentas));
		
		//Crear el bolsillo de prueba
		System.out.println("---------------------------------");
		lstCuentas.get("Stefania Aguirre").setBolsilloId("2b");
		System.out.println(trasladar(2, 90, lstCuentas));
		System.out.println("Saldo Despuï¿½s del traslado: " + lstCuentas.get("Stefania Aguirre").getSaldo());
		System.out.println("SaldoBolsillo Despuï¿½s del traslado: " + lstCuentas.get("Stefania Aguirre").getBolsilloSaldo());
		System.out.println();
		
		//Consultar saldo
		System.out.println("---------------------------------");
		System.out.println("Saldo: " + consultarSaldoCuenta("2", lstCuentas));
		System.out.println("SaldoBolsillo: " + consultarSaldoCuenta("2b", lstCuentas));
		System.out.println("SaldoBolsillo de una cuenta inexistente: " + consultarSaldoCuenta("3b", lstCuentas));
		System.out.println("Saldo de una cuenta inexistente: " + consultarSaldoCuenta("3", lstCuentas));
		System.out.println();
		
		
		//Cancelar Bolsillo
		System.out.println("---------------------------------");
		System.out.println("Eliminar un bolsillo de una cuenta que si lo tiene: " + cerrarBolsillo("0b", lstCuentas));
		System.out.println("Eliminar un bolsillo de una cuenta que no lo tiene: " + cerrarBolsillo("0b", lstCuentas));
		System.out.println();
		
		//Eliminar cuenta de ahorros
		System.out.println("---------------------------------");
		System.out.println("Eliminar una cuenta que existe: " + eliminarCuenta(0, lstCuentas));
		System.out.println("Eliminar una cuenta que no existe: " + eliminarCuenta(0, lstCuentas));
		System.out.println("---------------------------------");
		System.out.println(consultarSaldoCuenta("2", lstCuentas));
		System.out.println(retirar(2, 400, lstCuentas));
		System.out.println("---------------------------------");
		System.out.println(consultarSaldoCuenta("2", lstCuentas));
		System.out.println(consultarSaldoCuenta("2b", lstCuentas));
		System.out.println("Eliminar una cuenta que tiene bolsillo: " + eliminarCuenta(2, lstCuentas));
		System.out.println("---------------------------------");
		System.out.println(cerrarBolsillo("2b", lstCuentas));
		System.out.println(consultarSaldoCuenta("2", lstCuentas));
		System.out.println(consultarSaldoCuenta("2b", lstCuentas));
		System.out.println(retirar(2, 90, lstCuentas));
		System.out.println("---------------------------------");
		System.out.println("Eliminar una cuenta que si tiene bolsillo: " + eliminarCuenta(2, lstCuentas));
		System.out.println("Eliminar una cuenta que no tiene bolsillo: " + eliminarCuenta(2, lstCuentas));
		System.out.println();
	}
	
	//<---------------- Metodos de Transacciï¿½n ---------------------->
	/**
	 * Metodo que crea una nueva cuenta verificando si esta existe y agregandola en caso de que no se encuentre
	 * @param nuevoPropietario Es el nombre del nombre del propietario que se desee agregar
	 * @param lstCuentas Es la lista de cuentas donde se rectifica la exitencia
	 * @return Retorna el mensaje de confirmaciï¿½n o rechazo
	 */
	public static String agregarCuenta(String nuevoPropietario,HashMap<String, Cuenta> lstCuentas) {
		
		//Verificar que la cuenta no exista
		if(lstCuentas.containsKey(nuevoPropietario.trim())) {
			return "ERROR en apertura de cuenta de ahorros. Nombre de usuario repetido";
		}
		
		//Agregar la nueva cuenta
		int numCuenta = lstCuentas.size();
		Cuenta nuevo =  new Cuenta(numCuenta, nuevoPropietario.trim());
		lstCuentas.put(nuevoPropietario.trim(),nuevo);
		
		return "Apertura exitosa de cuenta de ahorros "+ numCuenta;		
	}
	/**
	 * Metodo que elimina una nueva cuenta verificando si esta existe y eliminandola si lo hace
	 * @param numeroCuenta Es el numero de cuenta la que se desea hacer el deposito
	 * @param lstCuentas Es la lista de cuentas donde se rectifica la exitencia
	 * @return Retorna el mensaje de confirmaciï¿½n o rechazo
	 */
	public static String eliminarCuenta(int numeroCuenta,HashMap<String, Cuenta> lstCuentas) {
		
		//Verificar que la cuenta  exista
		String llave = buscarNumeroCuenta(numeroCuenta,lstCuentas);
		
		if (!llave.equals("")) {
			Cuenta encontrada = lstCuentas.get(llave); 
			if(encontrada.getSaldo()==0) {
				if(encontrada.getBolsilloId().equals("")) {
					lstCuentas.remove(llave);
					return "Número de cuenta eliminado con exito " + numeroCuenta;	
				}
				return "Error, Bolsillo existente, en cuenta " + numeroCuenta;
			}
			return "Error, Saldo existente en cuenta " + numeroCuenta;
		}
		
		return "Error, Cuenta no encontrada "+ numeroCuenta;		
	}
	
	/**
	 * Metodo que consulta el saldo en una cuenta de ahorros
	 * @param numeroCuenta Es el numero de cuenta la que se desea saber su saldo, se debe de tener cuenta que puede ser de bolsillo o de ahorros
	 * @param lstCuentas Es la lista de cuentas donde se rectifica la exitencia
	 * @return Retorna el mensaje de confirmaciï¿½n o rechazo
	 */
	public static String consultarSaldoCuenta(String numCuenta,HashMap<String, Cuenta> lstCuentas) {
		
		
		if(numCuenta.contains("b")) {
			int  numeroCuenta = Integer.parseInt(numCuenta.substring(0,numCuenta.length()-1));	
			String llave = buscarNumeroCuenta(numeroCuenta,lstCuentas);
			if (!llave.equals("")) {
				Cuenta encontrada = lstCuentas.get(llave);
				if(!encontrada.getBolsilloId().equals("")) {
					return "Saldo en bolsillo " + encontrada.getBolsilloSaldo();
				}
				return "Error Bolsillo no encontrado " + numCuenta;
			}
			return "Error Bolsillo no encontrado " + numCuenta;
		}
		
		int  numeroCuenta = Integer.parseInt(numCuenta);
		//Verificar que la cuenta  exista
		String llave = buscarNumeroCuenta(numeroCuenta,lstCuentas);
		
		if (!llave.equals("")) {
			Cuenta encontrada = lstCuentas.get(llave);
			
			return "Saldo existente en cuenta " + encontrada.getSaldo();
		}
		
		return "Error, Cuenta no encontrada "+ numeroCuenta;		
	}
	/**
	 * Metodo que deposita a una cuenta dada el numero de esta
	 * @param numeroCuenta Es el numero de cuenta la que se desea hacer el deposito
	 * @param deposito Es el monto decimal que se le va a agregar a la cuenta
	 * @param lstCuentas Es la lista de cuentas donde se va a buscar el elemento deseado
	 * @return La respuesta del resultado de la transacciï¿½n
	 */
	public static String depositar(int numeroCuenta,double deposito,HashMap<String, Cuenta> lstCuentas) {
		
		String llave = buscarNumeroCuenta(numeroCuenta,lstCuentas);
		
		if (!llave.equals("")) {
			Cuenta encontrada = lstCuentas.get(llave); 
			encontrada.setSaldo(encontrada.getSaldo()+deposito);
			return "Depósito exitoso en cuenta de ahorros " + numeroCuenta;
		}
		
		return "ERROR en deposito de cuenta de ahorros. Número de cuenta no encontrada";
	}

	/**
	 * Metodo que deposita a una cuenta dada el numero de esta
	 * @param numeroCuenta Es el numero de cuenta la que se desea hacer el retiro
	 * @param deposito Es el monto decimal que se le va a quitar de la cuenta
	 * @param lstCuentas Es la lista de cuentas donde se va a buscar el elemento deseado
	 * @return La respuesta del resultado de la transacciï¿½n
	 */
	public static String retirar(int numeroCuenta,double retiro,HashMap<String, Cuenta> lstCuentas) {
		
		String llave = buscarNumeroCuenta(numeroCuenta,lstCuentas);
		
		if (!llave.equals("")) {
			Cuenta encontrada = lstCuentas.get(llave); 
			if (retiro <= encontrada.getSaldo()) {
				encontrada.setSaldo(encontrada.getSaldo()-retiro);
				return "Retiro exitoso en cuenta de ahorros " + numeroCuenta;
			}
			return "ERROR. Fondos insuficientes en cuenta de ahorros " + numeroCuenta;
		}
		
		return "ERROR en retiro de cuenta de ahorros. Número de cuenta no encontrada";
	}
	/**
	 * Metodo que traslada el dinero al saldo del bolsillo de la misma cuenta
	 * @param numeroCuenta Es el numero de cuenta la que se desea hacer el traslado
	 * @param traslado Es el monto decimal que se le trasladar al bolsillo de la cuenta
	 * @param lstCuentas Es la lista de cuentas donde se va a buscar el elemento deseado
	 * @return  La respuesta del resultado de la transacciï¿½n
	 */
	public static String trasladar(int numeroCuenta,double traslado,HashMap<String, Cuenta> lstCuentas) {
		
		String llave = buscarNumeroCuenta(numeroCuenta,lstCuentas);
		
		if (!llave.equals("")) {
			Cuenta encontrada = lstCuentas.get(llave); 
			if(encontrada.getBolsilloId().equals(numeroCuenta+"b")) {
				if(traslado <= encontrada.getSaldo()) {
					encontrada.setSaldo(encontrada.getSaldo() - traslado);
					encontrada.setBolsilloSaldo(encontrada.getBolsilloSaldo() + traslado);
					return "Traslado de saldo exitoso a cuenta bolsilo  " + encontrada.getBolsilloId() ;
				}
				return "ERROR. Fondos insuficientes en cuenta de ahorros " + numeroCuenta;
			}
			return "ERROR. No existe bolsillo en la cuenta " + numeroCuenta;
		}
		return "ERROR en traslado de cuenta de ahorros. Número de cuenta no encontrada";
	}
	
	/**
	 * 
	 * Metodo que crea un bolsillo en una cuenta buscada
	 * @param numeroCuenta Es el numero de cuenta la que se desea hacer la creaciï¿½n del bolsillo
	 * @param lstCuentas Es la lista de cuentas donde se va a buscar el elemento deseado
	 * @return  La respuesta del resultado de la transacciï¿½n
	 */
	public static String abrirBolsillo(int numeroCuenta, HashMap<String, Cuenta> lstCuentas) {
		String llave = buscarNumeroCuenta(numeroCuenta,lstCuentas);
		
		if (!llave.equals("")) {
			Cuenta encontrada = lstCuentas.get(llave); 
			if(!encontrada.getBolsilloId().equals(numeroCuenta+"b")) {
				encontrada.setBolsilloId(numeroCuenta+"b");
				encontrada.setBolsilloSaldo(0);
				return "Creación de bolsillo exitosa " +  encontrada.getBolsilloId();
			}
			return "ERROR. Ya existe un bolsillo en la cuenta " + numeroCuenta;
		}
		return "ERROR en traslado de cuenta de ahorros. Número de cuenta no encontrada";
	}
	
	/**
	 * 
	 * Metodo que elimina un bolsillo en una cuenta buscada
	 * @param numeroCuenta Es el numero de cuenta de bolsillo la que se desea hacer la creaciï¿½n del bolsillo
	 * @param lstCuentas Es la lista de cuentas donde se va a buscar el elemento deseado
	 * @return  La respuesta del resultado de la transacciï¿½n
	 */
	public static String cerrarBolsillo(String numeroCuentaBolsillo, HashMap<String, Cuenta> lstCuentas) {
		int  numeroCuenta = Integer.parseInt(numeroCuentaBolsillo.substring(0,numeroCuentaBolsillo.length()-1));
		String llave = buscarNumeroCuenta(numeroCuenta,lstCuentas);
		
		if (!llave.equals("")) {
			Cuenta encontrada = lstCuentas.get(llave); 
			if(encontrada.getBolsilloId().equals(numeroCuenta+"b")) {
				encontrada.setBolsilloId("");
				encontrada.setSaldo(encontrada.getSaldo()+ encontrada.getBolsilloSaldo());
				encontrada.setBolsilloSaldo(0);
				return "Cancelación de bolsillo exitosa " +  numeroCuenta;
			}
			return "ERROR. No existe un bolsillo en la cuenta " + numeroCuenta;
		}
		return "ERROR en eliminación de bolsillo. Número de cuenta no encontrada";
	}
	
	//<---------------- Metodos de Apoyo ---------------------->
	/**
	 * Metodo que busca a un propietario dentro de la lista de propietarios comparando sus numero de cuenta
	 * @param numeroCuenta Es el nï¿½mero de cuenta que se desea encontrar dentro de la lista
	 * @param lstCuentas Es la lista en donde estan todas las cuentas
	 * @return La llave en la que coinciden el numerCuenta con indeterminado elemento de lstCuentas, devuelve un String vacio en caso de no encontrarlo
	 */
	public static String buscarNumeroCuenta(int numeroCuenta, HashMap<String, Cuenta> lstCuentas) {
		
		Set<String> lstKeys =  lstCuentas.keySet();
		
		for (String key : lstKeys) {
			Cuenta a = lstCuentas.get(key);
			
			if (a.numeroCuenta == numeroCuenta) {
				return key;
			}
		}
		
		return "";
	}
}