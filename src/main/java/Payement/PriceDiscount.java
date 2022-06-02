package Payement;

import Payement.Strategy;

public class PriceDiscount implements Strategy {
    double discount;

    public PriceDiscount(double discountPrice) {
        discount = discountPrice;
    }

    @Override
    public double getDiscount(double price) {
        if (discount > price) {
            System.out.println("Discount denied, the price is bigger than the room's price");
            return price;
        } else {
            return price - discount;
        }
    }
}
