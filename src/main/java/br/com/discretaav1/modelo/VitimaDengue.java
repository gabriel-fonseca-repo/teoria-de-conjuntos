package br.com.discretaav1.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dengue")
public class VitimaDengue extends Pessoa {

	private Date dataDengue;

	public VitimaDengue(String id, String nome, String nomePai, String nomeMae, String sexo, Date dataNascimento,
			Date dataDengue) {
		super(id, nome, nomePai, nomeMae, sexo, dataNascimento);
		this.setDataDengue(dataDengue);
	}

	public VitimaDengue() {

	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("%05d", this.getId()) + "," + sdf.format(this.getDataNascimento()) + ","
				+ this.getSexoPorExtenso().charAt(0) + "," + this.getNome() + "," + this.getNomeMae() + ","
				+ this.getNomePai() + "," + sdf.format(this.getDataDengue());
	}

	public Date getDataDengue() {
		return dataDengue;
	}

	public void setDataDengue(Date dataDengue) {
		this.dataDengue = dataDengue;
	}

}
