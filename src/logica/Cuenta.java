package logica;

/**
 * Clase Cuenta
 * @author Stefania Aguirre López, Angelica Arroyave Duque, Juan Felipe Tapasco Henao
 */
public class Cuenta {
	
	public int numeroCuenta;
	public String nombrePropietario;
	public double saldo;
	public String bolsilloId;
	public double bolsilloSaldo;
	
	/**
	 * Constructor
	 * @param numeroCuenta número de cuenta
	 * @param nombrePropietario nombre de la persona dueña de la cuenta
	 */
	public Cuenta(int numeroCuenta, String nombrePropietario) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.nombrePropietario = nombrePropietario;
		this.saldo = 0;
		this.bolsilloId = "";
		this.bolsilloSaldo = 0;
	}
	
	// Getters y Setters
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	
	public String getNombrePropietario() {
		return nombrePropietario;
	}
	
	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}
	
	
	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getBolsilloId() {
		return bolsilloId;
	}


	public void setBolsilloId(String bolsilloId) {
		this.bolsilloId = bolsilloId;
	}


	public double getBolsilloSaldo() {
		return bolsilloSaldo;
	}


	public void setBolsilloSaldo(double bolsilloSaldo) {
		this.bolsilloSaldo = bolsilloSaldo;
	}

	
	
}
