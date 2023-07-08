package Lv1;

/**
 *  프로그래머스 : 가운데 글자 가져오기
 *
 *  문제 설명
 *
 *  단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
 *  단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
 *
 *  풀이 과정
 *  - 짝수라면 가운데 두글자를, 홀수라면 가운데 글자를 substring을 이용하여 잘라낸다
 */
public class GetMiddleLetter {
    public String solution(String s) {
        int sLength = s.length();
        int sMiddle = sLength / 2;

        return sLength % 2 == 0 ? s.substring(sMiddle - 1, sMiddle + 1) : s.substring(sMiddle, sMiddle + 1);
    }

    public static void main(String[] args) {
        String s = "abcde";
        GetMiddleLetter getMiddleLetter = new GetMiddleLetter();
        System.out.println(getMiddleLetter.solution(s));
    }
}
