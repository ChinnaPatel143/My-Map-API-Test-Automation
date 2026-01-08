package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderUtil{
	
	
	public static RequestSpecification getReqSpec() throws FileNotFoundException
	{
		PrintStream log = new PrintStream(new FileOutputStream("Logs.txt"));
		return new RequestSpecBuilder()
				.addQueryParam("key", "qaclick123")
				.addHeader("ContentType", "application/json")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
		
	}

}

