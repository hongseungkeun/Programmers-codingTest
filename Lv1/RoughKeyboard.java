package Lv1;

import java.util.*;

/**
 *  프로그래머스 : 대충 만든 자판
 *
 *  문제 설명
 *
 *  이 휴대폰 자판을 이용해 특정 문자열을 작성할 때, 키를 최소 몇 번 눌러야 그 문자열을 작성할 수 있는지 알아보고자 합니다.
 *  1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap과 입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때,
 *  각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지 순서대로 배열에 담아 return 하는 solution 함수를 완성해 주세요.
 *  단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다.
 *
 *  풀이 과정
 *
 *  - 몇 번키를 눌렀는지는 알 필요 없으므로 keymap에 담긴 문자열과 문자열의 현재 위치만 Map에 저장한다
 *      - 문자열의 현재 위치가 몇 번 눌러야 하는 값이 된다
 *  - 만약 입력하려는 문자열이 존재하면 문자열의 현재 위치값을, 아니라면 -1을 가져온다
 *  - -1이라면 그 문자열은 작성할 수 없으므로 answer에 넣고 반복을 종료한다
 *  - 아니라면 계속 반복을 통해 몇 번 눌러야 하는지 모두 더하고 배열에 넣어준다
 */

public class RoughKeyboard {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> locationOfKey = new HashMap<>();

        for (String key : keymap) {
            String[] split = key.split("");
            for (int j = 0; j < split.length; j++) {
                if (!locationOfKey.containsKey(split[j])) {
                    locationOfKey.put(split[j], j + 1);
                } else {
                    if (j < locationOfKey.get(split[j])) {
                        locationOfKey.put(split[j], j + 1);
                    }
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            int answers = 0;
            String[] split = targets[i].split("");

            for (String targetSplit : split){
                int isUnableWrite = locationOfKey.getOrDefault(targetSplit, -1);

                if(isUnableWrite == -1){
                    answers = isUnableWrite;
                    break;
                }
                answers += isUnableWrite;
            }

            answer[i] = answers;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        RoughKeyboard roughKeyboard = new RoughKeyboard();
        System.out.println(Arrays.toString(roughKeyboard.solution(keymap,targets)));
    }
}