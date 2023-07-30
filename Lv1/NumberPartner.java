package Lv1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *  프로그래머스 : 숫자 짝꿍
 *
 *  문제 설명
 *
 *  두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를
 *  두 수의 짝꿍이라 합니다(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).
 *  X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
 *
 *  예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는
 *  가장 큰 정수인 330입니다. 다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는
 *  2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수
 *  없습니다.) 두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *  - Map의 Key와 value를 각각 Y의 숫자, 개수로 설정하고 값을 넣어준다
 *  - 반복을 통해 X의 숫자들을 Map에서 찾은 뒤 있다면 StringBuilder에 넣고 개수를 줄인다
 *      - 만약 개수가 0개가 된다면 Map에서 삭제한다
 *  - StringBuilder의 사이즈가 0이라면 -1를, 첫 번째 숫자가 0이라면 0을 리턴한다
 *  - 두 조건을 통과했다면 내림차순 정렬을 한 뒤 리턴한다
 */

public class NumberPartner {
    public String solution(String X, String Y) {
        String answer;
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> yMap = new HashMap<>();

        for (int i = 0; i < Y.length(); i++) {
            char y = Y.charAt(i);
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }

        for (int i = 0; i < X.length(); i++) {
            char x = X.charAt(i);
            if(yMap.containsKey(x)){
                sb.append(x);
                yMap.put(x, yMap.getOrDefault(x, 0) - 1);
                if(yMap.get(x) == 0){
                    yMap.remove(x);
                }
            }
        }

        if(sb.length() == 0){
            return "-1";
        }else if (sb.charAt(0) == '0'){
            return "0";
        }

        answer = sb.toString();
        String[] array = answer.split("");
        Arrays.sort(array, Collections.reverseOrder());
        return String.join("", array);
    }

    public static void main(String[] args) {
        String X = "100";
        String Y = "123450";
        NumberPartner numberPartner = new NumberPartner();
        System.out.println(numberPartner.solution(X,Y));
    }
}
