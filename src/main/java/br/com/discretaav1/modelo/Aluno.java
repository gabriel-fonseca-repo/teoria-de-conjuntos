package br.com.discretaav1.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Aluno extends Pessoa {

	public Aluno(String id, String nome, String nomePai, String nomeMae, String sexo, Date dataNascimento) {
		super(id, nome, nomePai, nomeMae, sexo, dataNascimento);
	}

	public Aluno() {

	}

	@Override
	public String foum() {
		return super.getSexo().equalsIgnoreCase("m") ? "Masculino" : "Feminino";
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("%05d", this.getId()) + "," + sdf.format(this.getDataNascimento()) + ","
				+ this.getSexoPorExtenso().charAt(0) + "," + this.getNome() + "," + this.getNomeMae() + ","
				+ this.getNomePai();
	}

}
