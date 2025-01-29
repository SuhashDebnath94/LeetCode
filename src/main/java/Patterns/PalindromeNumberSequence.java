package Patterns;

public class PalindromeNumberSequence {
    public static void main(String[] args) {
//        1
//        121
//        12321
//        1234321

        printPattern();
    }

    private static void printPattern() {

        boolean isMaxReached = false;
        for (int i = 0; i < 4; i++) {
            int j = 1;
            while (j != 0) {
                System.out.print(j);
                if (j <= i && (!isMaxReached)) {
                    j = j + 1;
                } else {
                    j = j - 1;
                    isMaxReached = true;
                }
            }
            isMaxReached = false;
            System.out.println();
        }
    }


}
