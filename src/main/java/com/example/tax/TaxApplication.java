package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class TaxApplication {

	public static void main(String[] args) {
		// Take ClassPathXmlApplicationContext from applicationContext.xml file
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Tax propertyTax = (Tax) classPathXmlApplicationContext.getBean("propertyTax");
		Tax incomeTax = (Tax) classPathXmlApplicationContext.getBean("incomeTax");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the type of tax you want to pay: ");
		// Input the type of tax from the user...
		String type = scanner.nextLine();

		System.out.println("Enter the taxable amount: ");
		double amount = scanner.nextDouble();

		if(type.equals("property")) {
			System.out.println("Is property tax paid or not - " + propertyTax.isTaxPayed());
			propertyTax.setTaxableAmount(amount);
			propertyTax.calculateTaxAmount();
			System.out.println("The tax amount to be paid is (in rupees): " + propertyTax.getTaxAmount());
			propertyTax.payTax();
			System.out.println("Is property tax paid or not - " + propertyTax.isTaxPayed());
		}

		else if(type.equals("income")) {
			System.out.println("Is income tax paid or not - " + incomeTax.isTaxPayed());
			incomeTax.setTaxableAmount(amount);
			incomeTax.calculateTaxAmount();
			System.out.print("The tax amount to be paid is (in rupees): " + incomeTax.getTaxAmount());
			incomeTax.payTax();
			System.out.println("Is income tax paid or not - " + incomeTax.isTaxPayed());
		}
		else {
			System.out.println("Please enter the correct type of tax!");
		}

	}

}
