package com.tarasenko.shop.currency;

import java.io.Serializable;

public class PLNCurrency extends Currency implements Serializable {
    public PLNCurrency(String internationalCode, String name, int dollarExchangeRate) {
        super(internationalCode, name, dollarExchangeRate);
    }
}
