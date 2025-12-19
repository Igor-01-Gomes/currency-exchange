public interface CurrencyConverter {
    CurrencyType getCurrencyType();
    double convertTo(double amount, CurrencyType selectedCurrency);
}
