package Day28;

public class DuplicateCharacters {

    public static void main(String[] args) {
        String name = "Programming";
        
        for (int i = 0; i < name.length(); i++) {
            for (int j = i + 1; j < name.length(); j++) {
                if (name.charAt(i) == name.charAt(j)) {
                    System.out.println("Duplicate Character in a String is : " + name.charAt(i));
                }
            }
        }
    }
}