package biz.cashewnut;

import biz.jpa.Hello;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CashewnutApplication {
	public static void main(String[] args) {

		Hello hello = new Hello();
		hello.setData("hello");
		String result = hello.getData();
		System.out.println("result : " + result);

		SpringApplication.run(CashewnutApplication.class, args);
	}

}
