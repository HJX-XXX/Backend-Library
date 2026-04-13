public class PayContext {

    private PayStrategy payStrategy;

    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public void executePayment(int amount) {
        payStrategy.pay(amount);
    }

}
