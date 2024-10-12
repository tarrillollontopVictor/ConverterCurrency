
package com.holaweb.currencyconvertion.model;

public record Currency(
        String currencyCode,
        double money,
        String countryImg,
        String moneySymbol) {

}
