package org.example.provider;

import org.example.service.CurrencyConverter;

public class ConvertYen implements CurrencyConverter {

    public double convert(double amount) {
        return amount * 14.32;
    }
}
