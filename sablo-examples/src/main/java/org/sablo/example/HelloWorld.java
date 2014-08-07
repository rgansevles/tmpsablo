package org.sablo.example;

import org.sablo.WebApplication;
import org.sablo.specification.WebComponentApiDefinition; 

public class HelloWorld extends WebApplication
{
	public HelloWorld()
	{
		super(HelloWorld.class.getName());
	}

	@Override
	public Object executeEvent(String eventType, Object[] args) {
		// TODO Auto-generated method stub
		return null;
	}
}
