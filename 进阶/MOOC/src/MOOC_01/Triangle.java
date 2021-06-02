package MOOC_01;

public class Triangle {

    public boolean judgeEdges(int a, int b, int c) {
        boolean result = true;

        if (a <= 0 || b <= 0 || c <= 0) {
            result = false;
        }
        if (b + c <= a) {
            result = false;
        }
        if (a + b <= c) {
            result = false;
        }
        if (a + c <= b) {
            result = false;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("嘿嘿嘿");
    }
}
