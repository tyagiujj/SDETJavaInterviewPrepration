package Day14;

import java.util.Scanner;

public class SumOfAnArrayPracticeScanner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int size = sc.nextInt();

        int a[] = new int[size];
        int sum = 0;

        System.out.println("Enter the array elements:");

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
            sum = sum + a[i];
        }

        System.out.println("Sum of an Array is : " + sum);

        sc.close();
    }
}