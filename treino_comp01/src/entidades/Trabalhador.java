/**
 * 
 */
package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelTrabalhador;

/**
 * @author leo_dias
 *
 */
public class Trabalhador {
	
	private String nome;
	private NivelTrabalhador nivel;
	private double salarioBase;
	
	private Departamento departamento;
	private List<ContratoPorHoras> contratos = new ArrayList<>();
	
	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, 
			double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoPorHoras> getContratos() {
		return contratos;
	}

	public void setContratos(List<ContratoPorHoras> contratos) {
		this.contratos = contratos;
	}
	
	public void adicionarContrato(ContratoPorHoras contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato(ContratoPorHoras contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		
		for(ContratoPorHoras c : contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			
			if(c_ano == ano && c_mes == mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}

}
