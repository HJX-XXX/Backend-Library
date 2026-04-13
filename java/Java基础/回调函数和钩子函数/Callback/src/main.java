void main() {
    Calculator calculator = new Calculator();

    calculator.add(1, 2, new Callback() {
        @Override
        public void onResult(int result) {
            System.out.println("回调函数接收到了参数");
        }
    });
}