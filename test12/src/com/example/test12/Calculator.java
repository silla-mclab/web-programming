package com.example.test12;

public class Calculator {
	private int first;
	private int second;
	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	public int add() {
		return first + second;
	}
	
	public int subtract() {
		return first - second;
	}
	
	public int multiply() {
		return first * second;
	}
	
	public double divide() {
		return (double)first / (double)second;
	}
}
