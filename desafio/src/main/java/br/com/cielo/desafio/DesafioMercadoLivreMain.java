package br.com.cielo.desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.cielo.desafio.model.Campo;
import br.com.cielo.desafio.util.Util;

public class DesafioMercadoLivreMain {
	public static void main(String[] args) {
		
		List<List<Integer>> matriz = Util.generateRandomMatriz();
		
		// matriz original
		System.out.println("MATRIZ ORIGINAL");
		matriz.forEach(linha -> {
			linha.forEach(valor -> System.out.print(String.format("[%s]", valor)));
			System.out.println();
		});
		System.out.println();
		
		
		List<Campo> campos = new ArrayList<Campo>();
		
		// classifica os campos
		matriz.stream().forEachOrdered(linha -> {
			linha.stream().forEachOrdered(valorColuna -> {
				Campo campo = new Campo();
				campo.setLinha(matriz.indexOf(linha));
				campo.setColuna(linha.indexOf(valorColuna));
				campo.setValor(valorColuna);
				campos.add(campo);
			});
		});
		
		// configura os vizinhos com mesm)o valor
		campos.stream().forEachOrdered(campo1 -> {
			campos.stream()
				.filter(campo2 -> !campo1.equals(campo2))
				.forEachOrdered(campo2 -> {
					if(campo1.isVizinhoIgual(campo2)) {
						campo1.getVizinhosIguais().add(campo2);
					}
				}); 
		}); 

		// imprime resultado
		campos.stream().collect(Collectors.groupingBy(Campo::getLinha))
			.forEach((linha, camposLinha) -> {
				System.out.print(String.format("Linha: %s: ", linha));
				camposLinha.stream().forEach(campo -> {
					String valor = String.format("[%s]", campo.getValor());
					if(campo.getVizinhosIguais().isEmpty()) {
						System.out.print(valor);
					} else {
						System.err.print(valor);
					}
				});
				System.out.println();
			});
	}
	
}