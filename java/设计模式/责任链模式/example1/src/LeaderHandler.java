public class LeaderHandler extends Handler{
    // 组长500以内
    @Override
    public void handle(int amount) {
        if(amount <= 500) {
            System.out.println("组长审批通过");
        }else {
            next.handle(amount);
        }
    }

}
