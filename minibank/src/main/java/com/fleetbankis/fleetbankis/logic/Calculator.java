package com.fleetbankis.fleetbankis.logic;

import java.math.BigDecimal;

public class Calculator {

    public static BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return (a).multiply(b);
    }

    public static BigDecimal divide(BigDecimal a, BigDecimal b) {
        return (a).divide(b);
    }

    public static BigDecimal add(BigDecimal a, BigDecimal b) {
        return (b).add(a);
    }

    public static BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return (a).subtract(b);
    }

}
