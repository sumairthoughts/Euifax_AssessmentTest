package com.RESTAPISAMPLE.Test;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GETEmployeeAPIRequestTest {
/*
 * author : Sumair
 * Test Get Employee details using rest Assured APIs
 * 
 * NOTE: This dummy.resapiexample.com website behaves weird, 
 * some time returns 500 error or 429 Too Many request
 */
@Test
void getEmployeeDetails() {
//Mention the base URI end point details
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employee";
	
	RequestSpecification http_req = RestAssured.given();

//Specify the GET Method in the request and input employee id to be fetched	
	Response res = http_req.request(Method.GET,"/1");
	
	int status_code = res.getStatusCode();
	
	System.out.println("Response Status Code:  "+status_code);
	
//Assert the status code is 200 or not	
	Assert.assertEquals(status_code,200);
	
	String res_body = res.getBody().asString();
	
	System.out.println("Response Body:  "+res_body);
	
//Assert the response body contains expected Name for the employee id given above
	Assert.assertTrue(res_body.contains("Tiger Nixon"));

}
}
