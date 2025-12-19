public class GbpConverter implements CurrencyConverter {

    @Override
    public CurrencyType getCurrencyType() {
        return CurrencyType.GBP;
    }

    @Override
    public double convertTo(double amount, CurrencyType selectedCurrency) {
        return switch (selectedCurrency) {
            case GBP -> amount;
            case SEK -> amount * 12.47;
            case USD -> amount * 1.34;
            case EUR -> amount * 1.14;
        };
    }
}
