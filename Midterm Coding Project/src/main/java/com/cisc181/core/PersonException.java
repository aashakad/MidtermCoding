package com.cisc181.core;

public class PersonException extends Exception{
	Person p;
	
	public PersonException(Person p)
	{
		this.p = p;
	}
}
