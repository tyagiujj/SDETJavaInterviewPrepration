package Day7;

import java.util.Scanner;

public class CountOfEvenAndOddDigitsInANumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number:");
        int num = sc.nextInt();

        int even_count = 0;
        int odd_count = 0;

        while (num != 0) {

            int rem = num % 10;

            if (rem % 2 == 0) {
                even_count++;
            } else {
                odd_count++;
            }

            num = num / 10;
        }

        System.out.println("Count of Even Digits: " + even_count);
        System.out.println("Count of Odd Digits: " + odd_count);

        sc.close();
    }
}