public class UsdConverter implements CurrencyConverter {

    @Override
    public CurrencyType getCurrencyType() {
        return CurrencyType.USD;
    }

    @Override
    public double convertTo(double amount, CurrencyType selectedCurrency) {
        return switch (selectedCurrency) {
            case USD -> amount;
            case EUR -> amount * 0.85;
            case GBP -> amount * 0.75;
            case SEK -> amount * 9.3;
        };
    }
}
