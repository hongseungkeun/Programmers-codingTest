package Lv1;

/**
 *  프로그래머스 : 숫자 문자열과 영단어
 *
 *  문제 설명
 *
 *  숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
 *  - 1478 → "one4seveneight"
 *  - 234567 → "23four5six7"
 *  - 10203 → "1zerotwozero3"
 *  이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
 *  s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *  - 배열에 0~9까지 숫자의 영단어를 넣어준다
 *  - replace를 통해 해당 배열에서 영단어들을 숫자로 변경해준다
 */

public class NumericStringsAndEnglishWords {
    public int solution(String s) {
        String[] englishWords = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        for (int i = 0; i < englishWords.length; i++) {
            s = s.replace(englishWords[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        String s = "one4seveneight";
        NumericStringsAndEnglishWords numericStringsAndEnglishWords = new NumericStringsAndEnglishWords();
        System.out.println(numericStringsAndEnglishWords.solution(s));
    }
}
