package com.tarasenko.shop.currency;

import java.io.Serializable;

public class UAHCurrency extends Currency implements Serializable {
    public UAHCurrency(String internationalCode, String name, int dollarExchangeRate) {
        super(internationalCode, name, dollarExchangeRate);
    }
}
