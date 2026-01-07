public class EuroConverter implements CurrencyConverter {

    @Override
    public CurrencyType getCurrencyType() {
        return CurrencyType.EUR;
    }

    @Override
    public double convertTo(double amount, CurrencyType selectedCurrency) {
        return switch (selectedCurrency) {
            case EUR -> amount;
            case USD -> amount * 1.17;
            case GBP -> amount * 0.88;
            case SEK -> amount * 10.81;
        };
    }
}
