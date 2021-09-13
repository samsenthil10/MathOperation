package com.bridegelabz.mathoperation;

@FunctionalInterface
interface IMathFunction {
	int calculate(int a, int b);
}

public class MathOperationApp {
	public static void main(String[] args) {
		
		IMathFunction add = (a, b) -> a + b;
		IMathFunction multiply = (a, b) -> a * b;
		IMathFunction divide = (a, b) -> a / b;
		IMathFunction subtract = (a, b) -> a - b;
		
		System.out.println("addition " + add.calculate(2, 3));
		System.out.println("multiplication " + multiply.calculate(2, 3));
		System.out.println("subtraction " + subtract.calculate(2, 3));
		System.out.println("division " + divide.calculate(4, 2));
	}
}