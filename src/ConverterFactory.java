public class ConverterFactory {
    public static CurrencyConverter getConverter(CurrencyType baseCurrency) {
        return switch (baseCurrency) {
            case EUR -> new EuroConverter();
            case USD -> new UsdConverter();
            case GBP -> new GbpConverter();
            case SEK -> new SekConverter();
        };
    }
}
