package com.credibanco.util;

import java.util.Random;

public class CardUtil {
	
	public String generateComplementNumber() {
		int cont = 0;
		Random rnd = new Random();
		String aleatoryNumber = String.valueOf(rnd.nextDouble()).substring(9);
		System.out.println(aleatoryNumber.length());
		System.out.println(aleatoryNumber);
		
		while (aleatoryNumber.length()!=10) {
			System.out.println(cont++);
			aleatoryNumber = String.valueOf(rnd.nextDouble()).substring(9);
		}
		System.out.println(aleatoryNumber.length());
		System.out.println(aleatoryNumber);
        return aleatoryNumber;
	}

}
