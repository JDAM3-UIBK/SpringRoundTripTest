package org.gradle;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@EnableAutoConfiguration
public class HelloWorld {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/")
	@ResponseBody String home(){
		return "Wilkommenen bei Compare!";
	}
	@RequestMapping("/jsonOutput")
	    public @ResponseBody JsonOutput jsonOutput(
	            @RequestParam(value="name", required=false, defaultValue="World") String name) {
	        return new JsonOutput(counter.incrementAndGet(),
	                            String.format(template, name));
	  	}
	/*
	 @RequestMapping("/tmp")
	 	public @ResponseBody String doPost(HttpServletRequest request, HttpServletResponse response){
		  int length = request.getContentLength();
          byte[] input = new byte[length];
          ServletInputStream sin;
          
          Integer doubledValue = 0;
          
		try {
			sin = request.getInputStream();
			int c, count = 0 ;
	          while ((c = sin.read(input, count, input.length-count)) != -1) {
	              count +=c;
	          }
	          sin.close();    
	 
	          String recievedString = new String(input);
	          
	          response.setStatus(HttpServletResponse.SC_OK);
              OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream());

              doubledValue = Integer.parseInt(recievedString) * 2;

              writer.write(doubledValue.toString());
              writer.flush();
              writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try{
	               response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	               response.getWriter().print(e.getMessage());
	               response.getWriter().close();
	           } catch (IOException ioe) {
	           }
		}
		   
		return Integer.toString(doubledValue);
          
	 }
	 */
	
	//alternative zu ResponseBody Response Entity
	//http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-ann-requestbody
	
	 @RequestMapping(value = "/logs", method = RequestMethod.POST)
	 public @ResponseBody String logs(@RequestParam("json") String json) {
     System.out.println("Received POST request:" + json);
     	
	     return json + " neu";
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SpringApplication.run(HelloWorld.class, args);
	}

}
