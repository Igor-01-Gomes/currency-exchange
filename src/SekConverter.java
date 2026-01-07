public class SekConverter implements CurrencyConverter {

    @Override
    public CurrencyType getCurrencyType() {
        return CurrencyType.SEK;
    }

    @Override
    public double convertTo(double amount, CurrencyType selectedCurrency) {
        return switch (selectedCurrency) {
            case SEK -> amount;
            case USD -> amount / 9.19;
            case GBP -> amount / 12.44;
            case EUR -> amount / 10.8;
        };
    }
}
