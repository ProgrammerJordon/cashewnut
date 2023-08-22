package biz.cashewnut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CashewnutApplication {
	public static void main(String[] args) {

		Hello h = new Hello();
		h.setData("hello");
		String result = h.getData();
		System.out.println("result : " + result);

		SpringApplication.run(CashewnutApplication.class, args);
	}

}
