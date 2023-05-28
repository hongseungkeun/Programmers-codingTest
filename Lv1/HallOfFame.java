package Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *  프로그래머스 : 명예의 전당
 *
 *  문제 설명
 *
 *  이 프로그램에서는 매일 "명예의 전당"의 최하위 점수를 발표합니다. 예를 들어, k = 3이고,
 *  7일 동안 진행된 가수의 점수가 [10, 100, 20, 150, 1, 100, 200]이라면,
 *  명예의 전당에서 발표된 점수는 아래의 그림과 같이 [10, 10, 10, 20, 20, 100, 100]입니다.
 *  명예의 전당 목록의 점수의 개수 k, 1일부터 마지막 날까지 출연한 가수들의 점수인 score가 주어졌을 때,
 *  매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.
 *
 *  제한 사항
 *  - 3 ≤ k ≤ 100
 *  - 7 ≤ score의 길이 ≤ 1,000
 *      - 0 ≤ score[i] ≤ 2,000
 *
 *  풀이 과정
 *  - 리스트에 score를 하나씩 넣어가며 k만큼 자르고 그때마다의 가장 낮은 숫자를 answer에 넣어준다
 */

public class HallOfFame {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            scores.add(score[i]);
            scores.sort(((o1, o2) -> o2 - o1));
            answer[i] = Collections.min(scores.stream().limit(k).toList());
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        HallOfFame hallOfFame = new HallOfFame();
        System.out.println(Arrays.toString(hallOfFame.solution(k, score)));
    }
}
