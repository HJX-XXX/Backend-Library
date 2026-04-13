void main() {
    LeaderHandler chain = new LeaderHandler();
    chain.setNext(new ManagerHandler());
    chain.handle(1500);
}
