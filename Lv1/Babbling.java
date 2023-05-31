package Lv1;

/**
 *  프로그래머스 : 옹알이
 *
 *  문제 설명
 *
 *  머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과
 *  네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다.
 *  문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록
 *  solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *  - 발음할 수 있는 문자열을 각각의 인덱스 위치로 바꿔준다
 *  - 바꿔진 문자열이 숫자로 되어있고, 현재 문자와 다음 문자가 같지 않다면 answer++
 *      - 현재 문자와 다음 문자 비교 : 연속해서 같은 발음을 못하기 때문
 *
 *  - 처음에는 replaceFirst를 사용했으나 연속하지만 않으면 가능하다는 걸 놓쳐 통과하지 못했다
 *  - 그래서 문자열 자체를 숫자(인덱스)로 바꿔 연속된 문자인지 비교하고 정규식으로 숫자로 이루어져있는지 비교하는 것이
 *    가장 나은 방법같았다
 */

public class Babbling {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possibleBabbling = {"aya", "ye", "woo", "ma"};

        for (String s : babbling) {
            for (int i = 0; i < possibleBabbling.length; i++) {
                s = s.replace(possibleBabbling[i], String.valueOf(i));
            }

            if (s.matches("^[0-9]*$") && isPossible(s)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPossible(String s){
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] babbling = {"ayayeayayeaya"};
        Babbling babbling1 = new Babbling();
        System.out.println(babbling1.solution(babbling));
    }
}
