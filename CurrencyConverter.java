package Task3;

import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    private HashMap<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        initializeExchangeRates();
    }

    private void initializeExchangeRates() {
        // Add exchange rates for currencies
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.72);
        exchangeRates.put("JPY", 110.29);
        // Add more currencies and exchange rates as needed
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        double rateFrom = exchangeRates.getOrDefault(fromCurrency.toUpperCase(), 1.0);
        double rateTo = exchangeRates.getOrDefault(toCurrency.toUpperCase(), 1.0);

        return amount * (rateTo / rateFrom);
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");

        while (true) {
            System.out.print("Enter the amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter the currency code of the amount (e.g., USD, EUR, GBP, JPY, etc.): ");
            String fromCurrency = scanner.next();

            System.out.print("Enter the currency code you want to convert to (e.g., USD, EUR, GBP, JPY, etc.): ");
            String toCurrency = scanner.next();

            double convertedAmount = converter.convertCurrency(amount, fromCurrency, toCurrency);
            System.out.println(amount + " " + fromCurrency + " is equal to " + convertedAmount + " " + toCurrency);

            System.out.print("Do you want to convert another amount? (Y/N): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("N")) {
                break;
            }
        }

        System.out.println("Thank you for using Currency Converter!");
        scanner.close();
    }
}
