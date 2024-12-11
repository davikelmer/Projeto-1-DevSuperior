package com.devsuperior.Projeto_1;

import com.devsuperior.Projeto_1.entities.Order;
import com.devsuperior.Projeto_1.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Projeto1Application implements CommandLineRunner {
	private final OrderService orderService;
	Scanner sc = new Scanner(System.in);
	private int code;
	private double basic;
	private double discount;

	public Projeto1Application(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Projeto1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		sc.useLocale(Locale.US);

		System.out.println("Digite o código do pedido: ");
		code = sc.nextInt();

		System.out.println("Digite o valor do pedido: ");
		basic = sc.nextDouble();

		System.out.println("Digite o desconto do pedido: ");
		discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);
		System.out.println("Pedido Código " + code);
		System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));
	}
}
