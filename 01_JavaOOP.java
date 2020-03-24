/*
// Calculator.java

package operator;

public interface Calculator {
	public int sum(int firstNumber, int secondNumber);
}

*/

/*
// CalAdd.java

package operator;

public class CalAdd implements Calculator {

	@Override
	public int sum(int firstNumber, int secondNumber) {
		return firstNumber + secondNumber;
	}

}

*/

/*
// CalSub.java

package operator;

public class CalSub implements Calculator {

	@Override
	public int sum(int firstNumber, int secondNumber) {
		return firstNumber - secondNumber;
	}

}

*/

/*
// CalMul.java

package operator;

public class CalMul implements Calculator {

	@Override
	public int sum(int firstNumber, int secondNumber) {
		return firstNumber * secondNumber;
	}

}

*/

/*
// CalDiv.java

package operator;

public class CalDiv implements Calculator {

	@Override
	public int sum(int firstNumber, int secondNumber) {
		return secondNumber != 0 ? (firstNumber / secondNumber) : 0;
	}

}

*/

/*
// MyCalculator.java

package main;

import operator.Calculator;

public class MyCalculator {

	public int fNum, sNum;
	public Calculator calculator;

	public MyCalculator(int fNum, int sNum, Calculator calculator) {
		this.fNum = fNum;
		this.sNum = sNum;
		this.calculator = calculator;
	}

	public void result() {
		int value = calculator.sum(this.fNum, this.sNum);
		System.out.println("result : " + value);
	}

	public int getfNum() {
		return fNum;
	}

	public void setfNum(int fNum) {
		this.fNum = fNum;
	}

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}

	public Calculator getCalculator() {
		return calculator;
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

}

*/

/*
// MainClass.java

package main;

import operator.*;

public class MainClass {

	public static void main(String[] args) {

		MyCalculator myCalculator;

		myCalculator = new MyCalculator(20, 10, new CalAdd());
		myCalculator.result();

		myCalculator = new MyCalculator(20, 10, new CalSub());
		myCalculator.result();

		myCalculator = new MyCalculator(20, 10, new CalMul());
		myCalculator.result();

		myCalculator = new MyCalculator(20, 10, new CalDiv());
		myCalculator.result();

	}

}

*/
