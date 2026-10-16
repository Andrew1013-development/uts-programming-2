public class ReverseWords {
    public static void main(String[] args) {
        String s;

        // Read one line. Reverse the letters in each word. Keep word order.
        s = readString();
        System.out.println(flipSentence(s));
    }

    public static String readString() {
        System.out.print("String: ");
        return In.nextLine();
    }

    // sentence → words
    public static String flipSentence(String sentence) {
        String ans = "";
        String[] words;

        words = sentence.split(" +");
        ans = flipWord(words[0]);
        for (int i = 1; i < words.length; i++) {
            ans += ' ';
            ans = ans.concat(flipWord(words[i]));
        }
        return ans;
    }

    // word → characters (last to first)
    public static String flipWord(String word) {
        String ans = "";

        for (int i = word.length() - 1; i >= 0; i--)
            ans += word.charAt(i);
        return ans;
    }
}
