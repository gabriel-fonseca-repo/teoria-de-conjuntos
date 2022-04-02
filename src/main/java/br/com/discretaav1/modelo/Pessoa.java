package br.com.discretaav1.modelo;

import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa {

	@Id
	private Integer id;
	private String nome;
	private String nomeMae;
	private String nomePai;
	private String sexo;
	private String sexoPorExtenso;
	private Date dataNascimento;

	public Pessoa(String id, String nome, String nomePai, String nomeMae, String sexo, Date dataNascimento) {
		this.id = Integer.valueOf(id);
		this.nome = nome;
		this.nomePai = nomePai;
		this.nomeMae = nomeMae;
		this.sexo = sexo.substring(0).toUpperCase(Locale.ROOT);
		this.sexoPorExtenso = foum();
		this.dataNascimento = dataNascimento;
	}

	public Pessoa() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pessoa pessoa = (Pessoa) o;
		return Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome)
				&& Objects.equals(nomeMae, pessoa.nomeMae) && Objects.equals(nomePai, pessoa.nomePai)
				&& Objects.equals(sexo, pessoa.sexo) && Objects.equals(dataNascimento, pessoa.dataNascimento);
	}

	public String foum() {
		return this.sexo.equalsIgnoreCase("m") ? "Masculino" : "Feminino";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getSexoPorExtenso() {
		return sexoPorExtenso;
	}

	public void setSexoPorExtenso(String sexoPorExtenso) {
		this.sexoPorExtenso = sexoPorExtenso;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}