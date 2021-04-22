package lab5;
import java.util.ArrayList;

public class Text {
    private final Sentence[] text;
    Text(StringBuilder string){
        String str = string.toString().replaceAll("\\s{2,}", " ").trim();
        String[] split = str.split("(?<=\\.)|(?<=!)|(?<=\\?)");
        text = new Sentence[split.length];
        for(int i = 0; i < split.length; ++i){
            text[i] = new Sentence(split[i]);
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Sentence sentence: text){
            result.append(sentence.toString());
        }
        return result.toString();
    }
    void printMaxCountWithSameWords(){
        int maxCount = 0;
        String maxString = "";
        ArrayList<Integer> maxListOfOccurring = new ArrayList<>();
        for (Sentence allSentences : text) {
            for (int i = 0; i < allSentences.length(); ++i) {
                int count = 0;
                String wordToCheck = allSentences.getWord(i);
                ArrayList<Integer> listOfOccurring = new ArrayList<>();
                for (int j = 0; j < text.length; ++j) {
                    if (text[j].contains(wordToCheck)) {
                        ++count;
                        listOfOccurring.add(j);
                    }
                }
                if(count > maxCount){
                    maxCount = count;
                    maxString = wordToCheck;
                    maxListOfOccurring = listOfOccurring;
                }
            }
        }
        System.out.print("Найбільша кількість речень тексту, в яких є однакові слова: " + maxCount +
                "\nСлово, що зустрічається у найбільшій кількості речень: " + maxString +
                "\nНомери речень, у яких воно зустрічається: ");
        for(int i = 0; i < maxListOfOccurring.size(); ++i){
            System.out.print(maxListOfOccurring.get(i) + 1);
            if(i != maxListOfOccurring.size() - 1){
                System.out.print(", ");
            }
        }
    }
}
