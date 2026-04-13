void main() {
    PayContext payContext = new PayContext();
    payContext.setPayStrategy(new WeChatPay());
    payContext.executePayment(100);

    payContext.setPayStrategy(new AliPay());
    payContext.executePayment(200);
}