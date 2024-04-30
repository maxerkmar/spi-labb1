package org.example.provider;

import org.example.service.CurrencyConverter;

public class ConvertDollar implements CurrencyConverter {
    @Override
    public double convert(double amount) {
        return amount * 0.09;
    }
}
