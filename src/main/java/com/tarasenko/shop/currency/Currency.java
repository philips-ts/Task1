package com.tarasenko.shop.currency;

import lombok.Data;
import java.io.Serializable;


@Data
public abstract class Currency implements Serializable {
    protected String internationalCode;
    protected String name;
    protected int dollarExchangeRate;

    public Currency(String internationalCode, String name, int dollarExchangeRate) {
        this.internationalCode = internationalCode;
        this.name = name;
        this.dollarExchangeRate = dollarExchangeRate;
    }

    public int convertToUSD(int amount) {
        return amount * dollarExchangeRate;
    }

    public int convertFromUSD(int amount) {
        return amount / dollarExchangeRate;
    }
}
