package com.bandar.example4;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Processer {

	/// this example send message from producer to consumer
	public static void main(String[] args) throws Exception {
		
		CamelContext context = new DefaultCamelContext();
		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("direct:start")
				.process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {

						String message = exchange.getIn().getBody(String.class);
						
						message += " + (this part add from Processoer)"; 
						
						exchange.getOut().setBody(message);
					}
				})
				.to("seda:end");
				
			}
		});
		
		context.start();
		
		ProducerTemplate producer = context.createProducerTemplate();
		producer.sendBody("direct:start", "(Hello this message from Producer , Printed from consumer)");
		
		ConsumerTemplate consumer = context.createConsumerTemplate();
		String message = consumer.receiveBody("seda:end", String.class);
		
		System.out.println(message);

	}

}
