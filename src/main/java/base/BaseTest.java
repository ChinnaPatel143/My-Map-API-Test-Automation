package base;

import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.RequestSpecBuilderUtil;

public class BaseTest {

	protected RequestSpecification reqSpec;
	
	public BaseTest() throws FileNotFoundException
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		reqSpec = RequestSpecBuilderUtil.getReqSpec();
	}
}
