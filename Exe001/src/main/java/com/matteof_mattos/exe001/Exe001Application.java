package com.matteof_mattos.exe001;

import com.matteof_mattos.exe001.entities.Order;
import com.matteof_mattos.exe001.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Exe001Application implements CommandLineRunner {

	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Exe001Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.println("Insira o código do pedido: ");
		String code = sc.next();

		System.out.println("Insira o valor do pedido: ");
		Double basic = sc.nextDouble();

		System.out.println("Insira o desconto refente ao pedido: ");
		Double discount = sc.nextDouble();

		Order order = new Order(code,basic,discount);

		Double total = orderService.total(order);

		System.out.println("Valor final do pedido (incluso frete e desconto) R$ "+total);

	}
}
