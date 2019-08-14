package br.com.cielo.desafio.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

	public static List<List<Integer>> generateRandomMatriz(){
		List<List<Integer>> matriz = new ArrayList<List<Integer>>();
		for (int i = 0; i < 6; i++) {
			List<Integer> linha = new ArrayList<Integer>();
			for (int j = 0; j < 6; j++) {
				linha.add(new Random().nextInt(4));
			}
			matriz.add(linha);
		}
		return matriz;
	}
	
}
