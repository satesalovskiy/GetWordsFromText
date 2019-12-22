package words;

import java.util.HashMap;
import java.util.Map;

public class HashMapWithWords {
    private String[] dividedText;
    private HashMap<String, Integer> hashMap;

    HashMapWithWords() {
        hashMap = new HashMap<>();
    }

    //Метод доступный пользователю. Разделяет текст на слова, где разделитель - пробел.
    public void divideText(String text) {
        if(text.length()==0) {
            System.out.print("Строка с текстом пустая!");
            return;
        }
        dividedText = text.split(" ");
        correctMistakes();
        print();
    }

    //Метод, в котором в цикле проверяется каждое слово. Если длина слова 1 и это буква - добавляем ее в хэшмап.
    //Иначе, если на конце слова нет символа, который не буква, проверяем чтобы слово состояло только из букв и кладем его в хэшмап.
    //Если на конце слова символ, который не буква, то кладем в хэшмап слово, в котором этот символ удален
    private void correctMistakes() {
        for (int i = 0; i < dividedText.length; i++) {
            if (dividedText[i].length() == 1) {
                if (isWordInASCII(toChar(dividedText[i])))
                    putInHashMap(dividedText[i]);
            } else {
                if (isLastSymbolChar(dividedText[i]))
                    if (!areNumbersInWord(dividedText[i]))
                        putInHashMap(dividedText[i]);
                else
                    if (!areNumbersInWord(dividedText[i]))
                        putInHashMap(withoutLastSymbol(dividedText[i]));
            }
        }
    }

    //Проверяет, есть ли в слове, что то кроме букв
    private boolean areNumbersInWord(String string) {
        int count = 0;
        char[] charString = string.toCharArray();

        for (int i = 0; i < charString.length; i++) {
            if (!isWordInASCII(charString[i]))
                count++;
        }
        return (count == 0) ? false : true;
    }

    //Возвращает подстроку короче исходной на 1 символ
    private String withoutLastSymbol(String string) {
        return string.substring(0, string.length() - 1);
    }

    //Возвращает true, если последний символ - буква и false, если что то кроме буквы
    private boolean isLastSymbolChar(String string) {
        return isWordInASCII(string.toCharArray()[string.length() - 1]);
    }

    //Если в хэшмапе нет элемента, то добавляет его как ключ, а значение ставит в 1
    //Иначе так же кладет как ключ, но значение увеличивает на 1 от исходного
    //Таким образом подсчитываем количество вхождений каждого слова
    private void putInHashMap(String string) {
        if (!hashMap.containsKey(string)) {
            hashMap.put(string, 1);
        } else {
            hashMap.put(string, hashMap.get(string).intValue() + 1);
        }
    }

    //Берет из строки только первый символ и переделывает его в тип char
    private char toChar(String string) {
        return string.toCharArray()[0];
    }

    //Проверят границы, в которых лежат буквы в таблице ASCII
    //Возвращает true, если символ - буква по таблице и false, если что то другое
    //С учетом регистра
    private boolean isWordInASCII(char character) {
        return ((character > 64 && character < 91) || (character > 96 && character < 123)) ? true : false;
    }

    //Форматированный вывод хэшмапы: ключ - значение
    public void print() {
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.format("Key: %-20s" + "Number: %-20s" + "\n", entry.getKey(), entry.getValue());
        }
    }
}
