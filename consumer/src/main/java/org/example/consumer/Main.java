package org.example.consumer;



import org.example.service.CurrencyConverter;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        ServiceLoader<CurrencyConverter> loader = ServiceLoader.load(CurrencyConverter.class);


        int option = 1;
        String[] currencyNames = new String[100];
        System.out.println("Convert SEK to: ");
        for (CurrencyConverter converter : loader) {
            String converterName = converter.getClass().getSimpleName();
            String currencyName = converterName.replace("Convert","");
            currencyNames[option] = currencyName;
            System.out.println(option + ". " + currencyName);
            option++;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice >= option) {
            System.out.println("Invalid choice");
            return;
        }

        System.out.println("Enter amount: ");
        int amount = scanner.nextInt();

        String selectedCurrency = currencyNames[choice];

        int count = 1;
        for (CurrencyConverter converter : loader) {
            if (count == choice) {
                System.out.println(String.format("%.2f", converter.convert(amount)) + " " + selectedCurrency);
                break;
            }
            count++;
        }
    }
}