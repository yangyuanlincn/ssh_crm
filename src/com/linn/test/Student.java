package com.linn.test;

public class Student extends Person{
	public void fun() {
		System.out.println("student");
	}
	public void print() {
		super.print();
		System.out.println("我是学生");
	}
}
