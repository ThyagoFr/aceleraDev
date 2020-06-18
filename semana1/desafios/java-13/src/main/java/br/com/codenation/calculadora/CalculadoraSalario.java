package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		
		if (salarioBase < 1039) {
			return Math.round(0.0);
		}
		salarioBase = calcularInss(salarioBase);
		return Math.round(calcularIrrf(salarioBase));
		
	}
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {

		if (salarioBase >=1039 && salarioBase <= 1500) {
			salarioBase -= salarioBase*0.08;
		} else if (salarioBase > 1500 && salarioBase <= 4000) {
			salarioBase -= salarioBase*0.09;
		} else {
			salarioBase -= salarioBase*0.11;
		}
		return salarioBase;
	}

	private double calcularIrrf(double salarioBase) {

		if (salarioBase > 3000 && salarioBase <= 6000) {
			salarioBase -= salarioBase*0.075;
		} else if (salarioBase > 6000 ){
			salarioBase -= salarioBase*0.15;
		}
		return Math.round(salarioBase);
	}

}
