package Assign4;

public class Tester4_2 {
    public static void main(String[] args) {
        Assignment4_2 a = new Assignment4_2("1101010000", "ABCDE");
        System.out.println(a.report_bits_preorder());
        System.out.println(a.report_bits_levelorder());
        System.out.println(a.report_preorder());
        System.out.println(a.report_levelorder());
    }
}
