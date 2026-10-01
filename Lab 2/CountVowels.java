public class CountVowels {
    public static void main(String[] args) {
        char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};
        char val = '?';
        int cnt = 0;

        while (true) {
            System.out.print("Character: ");
            val = In.nextChar();
            if (val == '.')
                break;
            for (int i = 0; i < 5; i++)
                if (val == VOWELS[i]) {
                    cnt++;
                    break;
                }
        }
        System.out.printf("Vowel count = %d\n", cnt);
    }
}