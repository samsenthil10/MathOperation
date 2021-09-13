package com.bridegelabz.mathoperation;

@FunctionalInterface
interface IMathFunction {
	int calculate(int a, int b);
	static void printResult(int a,int b,String function,IMathFunction functionObject) {
		
		System.out.println("Result of "+function+" is "+functionObject.calculate(a, b));
	}
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
		System.out.println();
		IMathFunction.printResult(2, 3, "Subtraction ", subtract);
		IMathFunction.printResult(2, 3, "Multiplication ", multiply);
		IMathFunction.printResult(4, 2, "Division ", divide);
	}
}