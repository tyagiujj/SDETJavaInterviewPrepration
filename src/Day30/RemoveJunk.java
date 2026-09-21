package Day30;

public class RemoveJunk {

    public static void main(String[] args) {

        String s = "abcbu%56788@#$88";
        String l= "%$#@&7878";

        // Regular expression: [^a-zA-Z0-9]

        s = s.replaceAll("[^a-zA-Z0-9]", "");
        l= l.replaceAll("[^a-zA-Z0-9]", "");

        System.out.println("Without junk: " + s);
        System.out.println("Without junk : " +l);
    }
}