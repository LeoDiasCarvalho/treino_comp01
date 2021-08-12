/**
 * 
 */
package entidades;

import java.util.Date;

/**
 * @author leo_dias
 *
 */
public class ContratoPorHoras {

	private Date data;
	private double valorPorHoras;
	private int horas;
	
	public ContratoPorHoras() {
	}
	
	public ContratoPorHoras(Date data, double valorPorHoras, int horas) {
		this.data = data;
		this.valorPorHoras = valorPorHoras;
		this.horas = horas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValorPorHoras() {
		return valorPorHoras;
	}

	public void setValorPorHoras(double valorPorHoras) {
		this.valorPorHoras = valorPorHoras;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
	
	public double valorTotal() {
		
		return valorPorHoras * horas;
	}
}
