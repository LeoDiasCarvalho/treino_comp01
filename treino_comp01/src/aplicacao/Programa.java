/**
 * 
 */
package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.ContratoPorHoras;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

/**
 * @author leo_dias
 *
 */
public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Qual o departamento do trabalhador: ");
		String dep = sc.nextLine();
		//Convertendo de String para Departamento
		Departamento nomeDep = new Departamento(dep);
		
		System.out.println();
		System.out.println("Entre com os dados do trabalhador: ");
		
		System.out.print("Nome: ");
		String nomeTrab = sc.nextLine();
		
		System.out.print("Nível: ");
		String n = sc.nextLine();
		//Convertendo de String para NivelTrabalhador
		NivelTrabalhador nivel = NivelTrabalhador.valueOf(n);

		System.out.print("Salário Base: ");
		double salarioBase = sc.nextDouble();
		
		Trabalhador trabalhador = new Trabalhador(nomeTrab, nivel, salarioBase, nomeDep);
		
		System.out.println();
		System.out.print("Quantos contratos: ");
		int quant = sc.nextInt();
		
		for(int i = 1; i <= quant; i++) {
			System.out.println();
			System.out.println("Contrato #" + i);
			
			System.out.print("Data(dd/mm/aaaa): ");
			sc.nextLine();
			String d = sc.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date data = sdf.parse(d);
			
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			
			System.out.print("Duracao: ");
			int horas = sc.nextInt();
			
			ContratoPorHoras contrato = new ContratoPorHoras(data, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Qual mês deseja calcular a renda(MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println();
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda para " + mes + "/" + ano + ": $" + 
						String.format("%.2f", trabalhador.renda(ano, mes)));
		
		
		sc.close();
	}

}
