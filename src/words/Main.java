package words;

public class Main {
    public static void main(String[] args) {
//        //Не выведет ничего, тк в этой строке нет слов
//        String text = "//// / + = ' , , , 1 4545";

        String text = "It is an accepted fact that cultures are not stagnant – they are constantly evolving;" +
                " however the normal pace of change is usually extremely slow. When I look back over three generations," +
                " I see a difference in my grandmother’s life, my mother’s life and my own. I see changes at many levels" +
                "– social norms, accepted ways of thought, communication and behaviour, and the role of family and community." +
                " However these changes have slowly been woven into the fabric of Indian society, gradually being absorbed as the new norms," +
                " without shaking the core.";
        HashMapWithWords hashMapWithWords = new HashMapWithWords();
        hashMapWithWords.divideText(text);
    }
}
