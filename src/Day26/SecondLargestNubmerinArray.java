package Day26;

public class SecondLargestNubmerinArray {

    public static void main(String[] args) {

        int a[] = {1, 2, 3, 5, 7, 8};

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : a) {

            if (number > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = number;
            }
            else if (number > secondLargest && number != firstLargest) {
                secondLargest = number;
            }
        }

        System.out.println("Second Largest Number: " + secondLargest);
    }
}