package br.com.discretaav1.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.discretaav1.modelo.Pessoa;
import br.com.discretaav1.util.Util;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, ParseException {

		Scanner scDengue = Util.criarScanner("BaseDengueIn.csv");
		Scanner scAlunos = Util.criarScanner("BaseAlunosIn.csv");
		Scanner scOnibus = Util.criarScanner("BaseOnibusIn.csv");

		HashMap<Integer, Pessoa> mapDengue = Util.criarMapa(scDengue, "VitimaDengue");
		HashMap<Integer, Pessoa> mapBusologo = Util.criarMapa(scOnibus, "Busologo");
		HashMap<Integer, Pessoa> mapAluno = Util.criarMapa(scAlunos, "Aluno");

		File arqCsvDengue = new File("resources" + File.separatorChar + "BaseDengueOut.csv");
		File arqCsvAlunos = new File("resources" + File.separatorChar + "BaseAlunosOut.csv");
		File arqCsvOnibus = new File("resources" + File.separatorChar + "BaseOnibusOut.csv");

		PrintStream pwDengue = new PrintStream(arqCsvDengue);
		PrintStream pwAlunos = new PrintStream(arqCsvAlunos);
		PrintStream pwOnibus = new PrintStream(arqCsvOnibus);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("discretaav1");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		pwAlunos.println("ID,DataNascimento,Sexo,Nome,NomeMae,NomePai");
//        System.out.println("ID,DataNascimento,Sexo,Nome,NomeMae,NomePai");
		for (Map.Entry<Integer, Pessoa> map : mapAluno.entrySet()) {
			pwAlunos.println(map.getValue());
			em.persist(map.getValue());
//            System.out.println(map.getValue().getSexoPorExtenso().charAt(0)+", "+map.getValue().getNome().split(" ")[0]);
		}
		pwAlunos.close();

		pwDengue.println("ID,DataNascimento,Sexo,Nome,NomeMae,NomePai,DataDengue");
//        System.out.println("ID,DataNascimento,Sexo,Nome,NomeMae,NomePai,DataDengue");
		for (Map.Entry<Integer, Pessoa> map : mapDengue.entrySet()) {
			pwDengue.println(map.getValue());
			em.persist(map.getValue());
//            System.out.println(map.getValue().getSexoPorExtenso().charAt(0)+", "+map.getValue().getNome().split(" ")[0]);
		}
		pwDengue.close();

		pwOnibus.println("ID,DataNascimento,Sexo,Nome,NomeMae,NomePai,LinhasOnibus");
//        System.out.println("ID,DataNascimento,Sexo,Nome,NomeMae,NomePai,LinhasOnibus");
		for (Map.Entry<Integer, Pessoa> map : mapBusologo.entrySet()) {
			pwOnibus.println(map.getValue());
			em.persist(map.getValue());
//            System.out.println(map.getValue().getSexoPorExtenso().charAt(0)+", "+map.getValue().getNome().split(" ")[0]);
		}
		pwOnibus.close();

		em.getTransaction().commit();

	}
}