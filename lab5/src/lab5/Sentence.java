package lab5;

public class Sentence {
    private final Word[] sentence;
    Sentence(String str){
        String[] split = str.replaceAll("\\s{2,}", " ").trim().split(" ");
        sentence = new Word[split.length];
        for(int i = 0; i < split.length; ++i){
            sentence[i] = new Word(split[i]);
        }
    }

    boolean contains(String stringToCheck){
        for(Word word: sentence){
            if(word.getWithoutPunctuation().equals(stringToCheck)){
                return true;
            }
        }
        return false;
    }

    String getWord(int index){
        return sentence[index].getWithoutPunctuation();
    }

    int length(){
        return sentence.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Word word: sentence){
            result.append(word.toString());
        }
        return result.toString();
    }
}
