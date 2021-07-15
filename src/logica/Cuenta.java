package logica;

public class Cuenta {
	
	public int numeroCuenta;
	public String nombrePropietario;
	public double sueldo;
	public Cuenta bolsillo;
	
	public Cuenta(int numeroCuenta, String nombrePropietario) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.nombrePropietario = nombrePropietario;
		this.sueldo = 0;
	}
	
	
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
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	public Cuenta getBolsillo() {
		return bolsillo;
	}
	public void setBolsillo(Cuenta bolsillo) {
		this.bolsillo = bolsillo;
	}
	
	
	
	
}
