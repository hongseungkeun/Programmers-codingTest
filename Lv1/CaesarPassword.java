package Lv1;

import java.util.ArrayList;
import java.util.List;

/**
 *  프로그래머스 : 시저 암호
 *
 *  문제 설명
 *
 *  어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
 *  예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
 *  문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
 *
 *  제한 조건
 *  - 공백은 아무리 밀어도 공백입니다.
 *  - s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
 *  - s의 길이는 8000이하입니다.
 *  - n은 1 이상, 25이하인 자연수입니다.
 *
 *  풀이 과정
 *  - 소문자, 대문자가 들어있는 배열을 각각 준비한다
 *  - 대문자, 소문자 배열에서 현재 문자열 알파벳의 위치를 찾고 그 위치를 반복을 통해 배열의 끝이 아니라면 계속 ++, 아니라면 0으로 바꿔준다
 */

public class CaesarPassword {
    public String solution(String s, int n) {
        String[] sArr = s.split("");
        List<Character> upper = new ArrayList<>();
        List<Character> lower = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            upper.add(i);
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            lower.add(i);
        }

        for (int i = 0; i < sArr.length; i++) {
            if(upper.contains(s.charAt(i))){
                pushString(s, n, sArr, upper, i);
            } else if (lower.contains(s.charAt(i))){
                pushString(s, n, sArr, lower, i);
            }
        }

        return String.join("", sArr);
    }

    private static void pushString(String s, int n, String[] sArr, List<Character> charArr, int i) {
        int position = charArr.indexOf(s.charAt(i));
        for (int j = 0; j < n; j++) {
            if(position == charArr.size() - 1){
                position = 0;
            }else{
                position++;
            }
        }
        sArr[i] = String.valueOf(charArr.get(position));
    }

    public static void main(String[] args) {
        String s = "a B z";
        int n = 4;
        CaesarPassword caesarPassword = new CaesarPassword();
        System.out.println(caesarPassword.solution(s, n));
    }
}
