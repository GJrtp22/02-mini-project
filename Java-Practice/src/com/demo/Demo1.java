package com.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo1 implements Example {

	public static void main(String[] args) {
		
		List<Integer> l1=new ArrayList<>();
		List<Integer> l2=new ArrayList<>();
		
		l1.add(10);
		l1.add(20);
		l1.add(30);
		l1.add(20);
		
		l2.add(5);
		
		l2.addAll(1,l1);
		//l2.add(1, 100);
		
		//Integer integer = l2.get(0);
		
		//l2.remove(1);
		
		l2.set(1, 99);
		
		Integer integer=l2.indexOf(l1);
		
		
		
		//l1.stream().forEach(System.out::print);
		System.out.println();
		System.out.println(integer);
		l2.stream().forEach(System.out::print);
	}
}
