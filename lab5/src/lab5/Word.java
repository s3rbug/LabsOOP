package lab5;

public class Word {
    private final Letter[] word;
    private final boolean hasPunctuation;
    private final Punctuation.PunctuationType punctuation;

    Word(String str) {
        String filtered = str.replaceAll(" ", "");
        char lastElement = filtered.charAt(filtered.length() - 1);
        if (Punctuation.isEndOfTheSentence(lastElement)) {
            hasPunctuation = true;
            punctuation = Punctuation.getTypeOfChar(lastElement);
            filtered = filtered.substring(0, filtered.length() - 1);
        } else {
            hasPunctuation = false;
            punctuation = Punctuation.PunctuationType.WRONG;
        }
        word = new Letter[filtered.length()];
        for (int i = 0; i < filtered.length(); ++i) {
            word[i] = new Letter(filtered.charAt(i));
        }
    }

    String getWithoutPunctuation() {
        StringBuilder result = new StringBuilder();
        for (Letter l : word) {
            result.append(l.get());
        }
        return result.toString();
    }

    @Override
    public String toString() {
        String result = getWithoutPunctuation();
        if (hasPunctuation) {
            result += Punctuation.getCharByType(punctuation);
        }
        return result + " ";
    }
}
