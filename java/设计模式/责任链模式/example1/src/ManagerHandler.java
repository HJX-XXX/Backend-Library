public class ManagerHandler extends Handler{
    @Override
    public void handle(int amount) {
        if(amount <= 2000) {
            System.out.println("经理审批通过");
        }else {
            next.handle(amount);
        }
    }
}
