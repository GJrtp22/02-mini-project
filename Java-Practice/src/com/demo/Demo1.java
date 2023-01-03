package com.demo;

import java.util.Arrays;

public class Demo1 implements Example{
	
	public Demo1()
	{
		System.out.println("super class");
		System.out.println(Example.a);
	}

	

}

class Demo extends Demo1{
	
	public Demo()
	{
		super();
	}
public static void main(String[] args) {
	
	Demo d=new Demo();
	
	System.out.println(d instanceof Demo);
		
		int[] arr= {1,9,45,7,5};
		
		
		 int[] copyOf = Arrays.copyOf(arr, 9);
		for(int i: copyOf)
		{
			System.out.println(i);
		}

	}
	
	
}
