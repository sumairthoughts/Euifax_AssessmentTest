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

public class DELETEEmployeeAPIRequestTest {

	/*
	 * author : Sumair
	 * Test Delete Employee details using rest Assured APIs
	 * 
	 * NOTE: This dummy.resapiexample.com website behaves weird, 
	 * some time returns 500 error or 429 Too Many request or 404
	 */
@Test
void deleteEmployeeDetails() {
//Mention the base URI end point details
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/delete";
	
	RequestSpecification http_req = RestAssured.given();

//Mention the DELETE method in the http request and input which employee id to be deleted
	Response res = http_req.request(Method.DELETE,"/24");
	//Response res = http_req.request(Method.GET,"/delete/24");
	int status_code = res.getStatusCode();
	
	System.out.println("Response Status Code:  "+status_code);
	
//Assert the status code as 200	
	Assert.assertEquals(status_code,200);
	
	String res_body = res.getBody().asString();
	
	System.out.println("Response Body:  "+res_body);
	
//Assert the response body returns successfully deleted message	
	Assert.assertTrue(res_body.contains("Successfully! Record has been deleted"));
	//Assert.assertTrue(res_body.contains("successfully! deleted Records"));
	
		
}
}
