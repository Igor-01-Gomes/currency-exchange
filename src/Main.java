void main() {

    Scanner scanner = new Scanner(System.in);
    boolean running = true;

    while (running) {

        IO.println("\n=== Currency Converter ===");


        IO.println("Available currencies:");
        for (CurrencyType currency : CurrencyType.values()) {
            IO.println("- " + currency);
        }


        IO.print("\nConvert FROM: ");
        CurrencyType fromCurrency =
                CurrencyType.valueOf(scanner.nextLine().toUpperCase());


        IO.print("Convert TO: ");
        CurrencyType toCurrency =
                CurrencyType.valueOf(scanner.nextLine().toUpperCase());


        IO.print("Amount: ");
        double amount = Double.parseDouble(scanner.nextLine());


        CurrencyConverter converter =
                ConverterFactory.getConverter(fromCurrency);

        double result = converter.convertTo(amount, toCurrency);


        IO.println(
                "\nResult: " + amount + " " + fromCurrency +
                        " = " + result + " " + toCurrency
        );


        IO.print("\nDo you want to convert again? (y/n): ");
        String choice = scanner.nextLine();

        if (!choice.equalsIgnoreCase("y")) {
            running = false;
        }
    }

    IO.println("\nGoodbye");
    scanner.close();
}
