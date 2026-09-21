package Day29;

public class ReverseOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] reversed = new int[arr.length];

        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            reversed[j] = arr[i];
            j++;
        }

        for (int num : reversed) {
            System.out.print(num + " ");
        }
    }
}