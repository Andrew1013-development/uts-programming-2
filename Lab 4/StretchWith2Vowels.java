import java.util.Arrays;

public class StretchWith2Vowels {
    private static final char[] VOWELS = {
            'a', 'e', 'u', 'i', 'o',
            'A', 'E', 'U', 'I', 'O'
    };

    private static int solve(String s) {
        String[] words, segments;
        int vowels, res = 0;
        boolean stretch;

        words = s.split(" ");
        for (String w : words) {
            stretch = false;
            segments = w.split("[zZ]");
            for (String seg : segments) {
                vowels = 0;
                for (int i = 0; i < seg.length(); i++)
                    for (int j = 0; j < 10; j++)
                        if (seg.charAt(i) == VOWELS[j]) {
                            vowels++;
                            break;
                        }
                if (vowels == 2) {
                    stretch = true;
                    break;
                }
            }
            if (stretch)
                res++;
            //System.out.println(Arrays.toString(segments));
        }
        return res;
    }

    public static void main(String[] args) {
        String sentence;
        while (true) {
            System.out.print("Sentence: ");
            sentence = In.nextLine();
            if (sentence.equals("*"))
                break;
            System.out.printf("Matching words = %d\n", solve(sentence));
        }
        System.out.println("Done");
    }
}