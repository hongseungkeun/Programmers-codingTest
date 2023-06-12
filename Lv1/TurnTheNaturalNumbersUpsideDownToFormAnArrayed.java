package Lv1;

import java.util.*;

/**
 *  프로그래머스 : 자연수 뒤집어 배열로 만들기
 *
 *  문제 설명
 *
 *  자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
 *  예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
 *
 *  풀이 과정
 *  - n을 역순으로 answer에 넣어준다
 *
 *  - 조금의 성능을 위해 스트링을 이어 붙히는게 아닌 StringBuilder를 사용하자
 *  - 찾아보니 단 한 줄로 만든 분이 계셔서 코드를 가져와 보았다
 *      - new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray()
 *      - 속도는 기존 코드가 0.2초, 위 코드는 5초 이내로 좋지 않다
 */

public class TurnTheNaturalNumbersUpsideDownToFormAnArrayed {
    public int[] solution(long n) {
        String[] s = String.valueOf(n).split("");
        int length = s.length;
        int[] answer = new int[length];

        for (int i = 0; i < length; i++) {
            answer[i] = Integer.parseInt(s[length - (i + 1)]);
        }

        return answer;
    }

    public static void main(String[] args) {
        long n = 12345;
        TurnTheNaturalNumbersUpsideDownToFormAnArrayed turnTheNaturalNumbersUpsideDownToFormAnArrayed = new TurnTheNaturalNumbersUpsideDownToFormAnArrayed();
        System.out.println(Arrays.toString(turnTheNaturalNumbersUpsideDownToFormAnArrayed.solution(n)));
    }
}
