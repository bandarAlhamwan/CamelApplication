package com.bandar.example2;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFile {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("file:input_box?noop=true") /// ?noop=true will remove .camel folder
				.to("file:output_box");
				
			}
		});
		
		while(true) {
			context.start();
		}
	}

}
