public class JSONDataProcessor extends DataProcessor{
    // 不同的类实现不同的父类抽象方法 但是最终实现的是父类的固定process方法
    @Override
    protected void readData() {
        System.out.println("read JSON data");
    }

    @Override
    protected void processData() {
        System.out.println("process JSON data");
    }
}
