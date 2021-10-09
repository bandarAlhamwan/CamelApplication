package com.bandar.example1;

import org.apache.camel.builder.RouteBuilder;

public class HelowWroldRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		System.out.println("Hello World In Camel");
		
	}

}
