public class RisingWords {
    public static void main(String[] args) {
        String s;

        // Read sentences until *. Count words whose letters strictly increase.
        while (true) {
            s = readSentence();
            if (s.equals("*"))
                break;
            System.out.printf("Matching words = %d\n", matchCount(s));
        }
        System.out.println("Done");
    }

    public static String readSentence() {
        System.out.print("Sentence: ");
        return In.nextLine();
    }

    // sentence → words
    public static int matchCount(String sentence) {
        int ans = 0;
        String[] words;

        words = sentence.split(" +");
        for (String word : words)
            if (rising(word))
                ans++;
        return ans;
    }

    // word → consecutive characters (ignore case; strict < )
    public static boolean rising(String word) {
        for (int i = 1; i < word.length(); i++)
            if (ord(word.charAt(i-1)) >= ord(word.charAt(i)))
                return false;
        return true;
    }

    private static int ord(char c) {
        if (c >= 'a' && c <= 'z')
            c = (char)((int)c - 32);
        //System.out.println(c - 'A');
        return c - 'A';
    }
}