package utils;

import schemas.Currency;
import schemas.SelectedCurrencies;

import java.util.ArrayList;
import java.util.List;

public class CurrencySelector {
    List<SelectedCurrencies> currenciesList = new ArrayList<>(10);

    public CurrencySelector() {
        currenciesList.add(new SelectedCurrencies(Currency.USD, Currency.ARS));
        currenciesList.add(new SelectedCurrencies(Currency.ARS, Currency.USD));
        currenciesList.add(new SelectedCurrencies(Currency.USD, Currency.BRL));
        currenciesList.add(new SelectedCurrencies(Currency.BRL, Currency.USD));
        currenciesList.add(new SelectedCurrencies(Currency.USD, Currency.COP));
        currenciesList.add(new SelectedCurrencies(Currency.COP, Currency.USD));
    }

    public SelectedCurrencies selectCurrencies(int index) {
        return currenciesList.get(index);
    }
}
