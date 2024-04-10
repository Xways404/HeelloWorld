public class Scaer {
    public static void main(String[] args) {
        int size = 9;

        // 上半分の三角形
        for (int i = 0; i < size; i++) {
            // 左側の 'o' を出力
            for (int j = 0; j < size - i - 1; j++) {
                System.out.print(" ");
            }

            // 'x' を出力
            System.out.print("x");

            // 右側の 'o' を出力
            for (int k = 0; k < i; k++) {
                System.out.print(" ");
            }

            System.out.println();
        }

        // 下半分の三角形
        for (int i = size - 1; i > 0; i--) {
            // 左側の 'o' を出力
            for (int j = 0; j < size - i; j++) {
                System.out.print(" ");
            }

            // 'x' を出力
            System.out.print("x");

            // 右側の 'o' を出力
            for (int k = size - i - 1; k > 0; k--) {
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}


