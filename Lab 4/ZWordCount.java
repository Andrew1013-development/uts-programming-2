public class ZWordCount {
    public static void main(String[] args) {
        String[] sentences = {
                "green ideas Zleep furiously",
                "a zebra graZed",
                "zorro WAZ zore",
                "I feel snoozy"
        };
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
        System.out.println("Words containing a 'z' = " + zWords(sentences));
    }

    public static int zWords(String[] sentences) {
        int res = 0;
        for (String s : sentences)
            res += zWords(s);
        return res;
    }

    public static int zWords(String sentence) {
        int res = 0;
        String[] words;

        words = sentence.split(" ");
        for (String s : words)
            if (containsZ(s))
                res++;
        return res;
    }

    public static boolean containsZ(String word) {
        for (int i = 0; i < word.length(); i++)
            if (word.charAt(i) == 'z' || word.charAt(i) == 'Z')
                return true;
        return false;
    }
}