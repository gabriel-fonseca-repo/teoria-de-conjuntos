package br.fonseca.discreta.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import br.fonseca.discreta.modelo.Aluno;
import br.fonseca.discreta.modelo.Busologo;
import br.fonseca.discreta.modelo.Pessoa;
import br.fonseca.discreta.modelo.VitimaDengue;

public class Util {

	public static Scanner criarScanner(String path) throws FileNotFoundException {
		File csv = new File("resources" + File.separatorChar + path);
		return new Scanner(csv);
	}

	public static HashMap<Integer, Pessoa> criarMapa(Scanner sc, String regex) throws ParseException {
		if (regex.contains("Busologo")) {
			return Util.criarMapaOnibus(sc);
		}
		if (regex.contains("Aluno")) {
			return Util.criarMapaAlunos(sc);
		}
		if (regex.contains("VitimaDengue")) {
			return Util.criarMapaDengue(sc);
		}
		return null;
	}

	private static HashMap<Integer, Pessoa> criarMapaAlunos(Scanner sc) throws ParseException {
		HashMap<Integer, Pessoa> mapa = new HashMap<>();
		sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		while (sc.hasNextLine()) {
			String[] str = sc.nextLine().split(";");
			String[] strData = str[5].split(" ");
			Date dataNascimento = sdf.parse(strData[0]);
			Pessoa v = new Aluno(str[0], // id
					str[1], // nome
					str[2], // nomePai
					str[3], // nomeMae
					str[4], // sexo
					dataNascimento // dataNascimento
			);
			System.out.println(strData[0]);
			System.out.println(sdf.format(dataNascimento));
			System.out.println();
			mapa.put(v.getId(), v);
		}
		return mapa;
	}

	private static HashMap<Integer, Pessoa> criarMapaDengue(Scanner sc) throws ParseException {
		HashMap<Integer, Pessoa> mapa = new HashMap<>();
		sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		while (sc.hasNextLine()) {
			String[] str = sc.nextLine().split(";");
			Date dataNascimento = sdf.parse(str[5]);
			Date dataDengue = sdf.parse(str[6]);
			Pessoa v = new VitimaDengue(str[0], // id
					str[1], // nome
					str[2], // nomePai
					str[3], // nomeMae
					str[4], // sexo
					dataNascimento, // dataNascimento
					dataDengue // dataDengue
			);
			System.out.println(str[6]);
			System.out.println(sdf.format(dataNascimento));
			System.out.println();
			mapa.put(v.getId(), v);
		}
		return mapa;
	}

	private static HashMap<Integer, Pessoa> criarMapaOnibus(Scanner sc) throws ParseException {
		HashMap<Integer, Pessoa> mapa = new HashMap<>();
		sc.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		while (sc.hasNextLine()) {
			String[] str = sc.nextLine().split(";");
			Date dataNascimento = sdf.parse(str[5]);
			Pessoa v = new Busologo(str[0], // id
					str[1], // nome
					str[2], // nomePai
					str[3], // nomeMae
					str[4], // sexo
					dataNascimento, // dataNascimento
					str[6] // linhasOnibus
			);
			System.out.println(str[5]);
			System.out.println(sdf.format(dataNascimento));
			System.out.println();
			mapa.put(v.getId(), v);
		}
		return mapa;
	}
}
