package Day28;

public class DuplicateCharacterPratice {

    public static void main(String[] args) {

        String name = "abcbu%56788";

        int len = name.length();

        for (int i = 0; i < len; i++) {

            for (int j = i + 1; j < len; j++) {

                if (name.charAt(i) == name.charAt(j)) {

                    System.out.println("Duplicate Character in a String is : "
                            + name.charAt(i));
                }
            }
        }
    }
}