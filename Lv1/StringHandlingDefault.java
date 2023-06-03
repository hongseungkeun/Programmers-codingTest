package Lv1;

/**
 *  프로그래머스 : 문자열 다루기 기본
 *
 *  문제 설명
 *
 *  문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
 *  예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
 *
 *  풀이 과정
 *  - 정규식으로 숫자인지 검사
 *  - 문자열 s의 길이가 4 혹은 6인지 검사
 *
 */

public class StringHandlingDefault {
    public boolean solution(String s) {
        return s.matches("^[0-9]*$") && isPossibleLength(s);
    }

    private boolean isPossibleLength(String s){
        return 4 == s.length() || s.length() == 6;
    }

    public static void main(String[] args) {
        String s = "a234";
        StringHandlingDefault stringHandlingDefault = new StringHandlingDefault();
        System.out.println(stringHandlingDefault.solution(s));
    }
}
