package Payement;

import Payement.Strategy;

public class PercentageDiscount implements Strategy {

    private int percent;

    public PercentageDiscount(int percentage) {
        percent = percentage;
    }

    @Override
    public double getDiscount(double price) {
        return price * (100 - percent) / 100;
    }
}
