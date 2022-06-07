package pattern.strategy;

public class PriceCalculator {
    private Strategy strategy;
    private double price;

    public void calculatePrice(double roomPrice, int nrDays){
        this.price = roomPrice * nrDays;
    }

    public double getPrice(){
        return this.price;
    }


    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public double executeStrategy(double price){
       return strategy.getDiscount(price);
    }
}
