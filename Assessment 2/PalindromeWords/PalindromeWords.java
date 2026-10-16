public class PalindromeWords {
    public static void main(String[] args) {
        // Read sentences until *. Count palindrome words (ignore case).
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
            if (palindrome(word))
                ans++;
        return ans;
    }

    // word → characters (i vs n-1-i, ignore case)
    public static boolean palindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++)
            if (ord(word.charAt(i)) != ord(word.charAt(word.length() - 1 - i)))
                return false;
        return true;
    }

    private static int ord(char c) {
        if (c >= 'a' && c <= 'z')
            c = (char)((int)c - 32);
        return c - 'A';
    }
}