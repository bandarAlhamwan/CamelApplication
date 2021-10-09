package com.bandar.example1;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class HelowWrold {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new HelowWroldRoute());

		context.start(); 	 
	}

}
