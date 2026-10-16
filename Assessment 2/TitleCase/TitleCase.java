public class TitleCase {
    public static void main(String[] args) {
        String s;
        // Read one line. First letter of each word upper case; the rest lower case.
        // Prompt: print. Result: println.
        s = readString();
        System.out.println(titleSentence(s));
    }

    public static String readString() {
        System.out.print("String: ");
        return In.nextLine();
    }

    // sentence → words
    public static String titleSentence(String sentence) {
        String ans = "";
        String[] words;

        words = sentence.split(" +");
        for (int i = 0; i < words.length; i++) {
            if (words[i].isEmpty())
                continue;
            if (!ans.isEmpty())
                ans += ' ';
            ans += titleWord(words[i]);
        }
        return ans;
    }

    // word → characters (index 0 upper; the rest lower)
    public static String titleWord(String word) {
        String ans = "";

        ans += upper_char(word.charAt(0));
        for (int i = 1; i < word.length(); i++)
            ans += lower_char(word.charAt(i));
        return ans;
    }

    private static char upper_char(char c) {
        if ((int)c >= 97 && (int)c <= 122)
            return (char)((int)c - 32);
        return c;
    }
    private static char lower_char(char c) {
        if ((int)c >= 65 && (int)c <= 90)
            return (char)((int)c + 32);
        return c;
    }
}