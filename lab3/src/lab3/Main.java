package lab3;

/*
* C3 = 0 => StringBuilder
* C17 = 0 => Знайти найбільшу кількість речень заданого тексту, в яких є однакові слова.
* */

import java.util.Arrays;

public class Main {
    static StringBuilder[] toStringBuilder(String[] arr){
        StringBuilder[] res = new StringBuilder[arr.length];
        for(int i = 0; i < arr.length; ++i){
            res[i] = new StringBuilder(arr[i]);
        }
        return res;
    }
    static StringBuilder[][] splitByWords(StringBuilder str){
        StringBuilder[] sentences = toStringBuilder(str.toString().replaceAll("[,:-]+", "")
                .trim().replaceAll(" +", " ").split("[!?.]+"));

        StringBuilder[][] words = new StringBuilder[sentences.length][];
        for(int i = 0; i < sentences.length; ++i){
            words[i] = toStringBuilder(sentences[i].toString().split(" "));
        }

        return words;
    }
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("слово1 слово3: слово3, слово2. слово1, слово1, слово1 - слово3! слово1 слово2 слово2?");
        StringBuilder[][] words = splitByWords(str);
        for (StringBuilder[] sentence : words) {
            Arrays.sort(sentence);
        }
        for (int i = 0; i < words.length; ++i) {
            int count = 1, countBest = 1;
            StringBuilder bestWord = new StringBuilder();
            for(int j = 1; j < words[i].length; ++j) {
                if(words[i][j].isEmpty())
                    continue;
                if(words[i][j].equals(words[i][j - 1])){
                    ++count;
                }
                else{
                    count = 1;
                }
                if(count > countBest){
                    countBest = count;
                    bestWord = words[i][j];
                }
            }
            System.out.println("У реченні номер " + (i + 1) + " найчастіше слово - " + bestWord + ", що зустрічається " + countBest + " раз(-и)");
        }

    }
}
