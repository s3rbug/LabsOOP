package lab5;

public class Main {

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("word3 word2. word1 word2 word3! word1 word2. word123 word123 word123 word123. word3");
        Text text = new Text(s);
        System.out.println("Початковий текст:");
        System.out.println(text.toString());
        text.printMaxCountWithSameWords();
    }
}