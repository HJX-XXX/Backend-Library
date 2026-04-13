// 抽象类
abstract class DataProcessor {
    // 模版方法，定死执行顺序
    public final void process() {
        readData();
        processData();
        writeData();
    }

    // 子类必须覆盖
    protected abstract void readData();

    protected abstract void processData();

    // 默认实现 这种叫做钩子函数 子类可选择性覆盖 用于控制流程
    protected void writeData() {
        System.out.println("write data!");
    }
}
