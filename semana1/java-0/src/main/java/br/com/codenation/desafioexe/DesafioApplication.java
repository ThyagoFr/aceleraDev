package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		ArrayList<Integer> fibNumbers = new ArrayList<>();
		fibNumbers.add(0);
		fibNumbers.add(1);
		int index = 1;
		Integer fib = 0;
		do {
		    fib = fibNumbers.get(index - 1) + fibNumbers.get(index);
		    fibNumbers.add(fib);
		    index++;
		    
		}while (fib <= 350);
		// System.out.println(fibNumbers);
		return fibNumbers;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}