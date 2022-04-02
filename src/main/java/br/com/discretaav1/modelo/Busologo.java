package br.com.discretaav1.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_busologo")
public class Busologo extends Pessoa {

	private String linhasOnibus;

	public Busologo(String id, String nome, String nomePai, String nomeMae, String sexo, Date dataNascimento,
			String linhasOnibus) {
		super(id, nome, nomePai, nomeMae, sexo, dataNascimento);
		String[] str = linhasOnibus.split(", ");
		ArrayList<Integer> linhasOnibusTmp = new ArrayList<>();
		for (String s : str) {
			linhasOnibusTmp.add(Integer.valueOf(s));
		}
		this.setLinhasOnibus(linhasOnibusTmp.toString());
	}

	public Busologo() {

	}

	@Override
	public String foum() {
		return super.getSexo().equalsIgnoreCase("m") ? "Feminino" : "Masculino";
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("%05d", this.getId()) + "," + sdf.format(this.getDataNascimento()) + ","
				+ this.getSexoPorExtenso().charAt(0) + "," + this.getNome() + "," + this.getNomeMae() + ","
				+ this.getNomePai() + "," + this.getLinhasOnibus();
	}

	public String getLinhasOnibus() {
		return linhasOnibus;
	}

	public void setLinhasOnibus(String linhasOnibus) {
		this.linhasOnibus = linhasOnibus;
	}
}
