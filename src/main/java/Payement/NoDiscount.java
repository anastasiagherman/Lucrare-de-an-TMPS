package Payement;

import Payement.Strategy;

public class NoDiscount implements Strategy {
    public NoDiscount() {}

    @Override
    public double getDiscount(double price) {
        return price;
    }

}
