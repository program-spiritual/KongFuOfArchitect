public class CommonToolsDemo1 {
    public static void main(String[] args) {
//求绝对值：
        Math.abs(-100); // 100
        Math.abs(-7.8); // 7.8
//        取最大或最小值
        Math.max(100, 99); // 100
        Math.min(1.2, 2.3); // 1.2
//        计算xy次方：

        Math.pow(2, 10); // 2的10次方=1024
//        计算√x：

        Math.sqrt(2); // 1.414...
//        计算以e为底的对数：
        Math.log(4); // 1.386...
//        计算以10为底的对数：
        Math.log10(100); // 2
//        三角函数：

        Math.sin(3.14); // 0.00159...
        Math.cos(3.14); // -0.9999...
        Math.tan(3.14); // -0.0015...
        Math.asin(1.0); // 1.57079...
        Math.acos(1.0); // 0.0

//        数学常量
        double pi = Math.PI; // 3.14159...
        double e = Math.E; // 2.7182818...
        Math.sin(Math.PI / 6); // sin(π/6) = 0.5
//        生成一个随机数x，x的范围是0 <= x < 1：
        Math.random(); // 0.53907... 每次都不一样
    }
}
