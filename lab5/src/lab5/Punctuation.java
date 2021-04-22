package lab5;

public class Punctuation {
    enum PunctuationType {
        COMMA,
        POINT,
        EXCLAMATION,
        QUESTION,
        WRONG
    }

    public static PunctuationType getTypeOfChar(char c){
        if(c == ','){
            return PunctuationType.COMMA;
        }
        else if (c == '.'){
            return PunctuationType.POINT;
        }
        else if (c == '!'){
            return PunctuationType.EXCLAMATION;
        }
        else if (c == '?'){
            return PunctuationType.QUESTION;
        }
        return PunctuationType.WRONG;
    }

    public static char getCharByType(PunctuationType type){
        if(type == PunctuationType.COMMA){
            return ',';
        }
        else if(type == PunctuationType.POINT){
            return '.';
        }
        else if(type == PunctuationType.EXCLAMATION){
            return '!';
        }
        else if(type == PunctuationType.QUESTION){
            return '?';
        }
        return '\0';
    }

    public static boolean isEndOfTheSentence(char c){
        return c == '.' || c == '!' || c == '?';
    }
}
