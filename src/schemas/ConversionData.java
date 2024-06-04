package schemas;

public class ConversionData {
    private final Currency originCurrency;
    private final Currency targetCurrency;
    private final double value;

    public ConversionData(Currency originCurrency, Currency targetCurrency, double value) {
        this.originCurrency = originCurrency;
        this.targetCurrency = targetCurrency;
        this.value = value;
    }

    public Currency getOriginCurrency() {
        return originCurrency;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Valor: %.2f, Moeda de Origem: %s e Moeda de Conversão: %s", value, originCurrency, targetCurrency);
    }
}
