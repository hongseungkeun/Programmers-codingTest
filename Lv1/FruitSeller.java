package Lv1;

import java.util.Arrays;
import java.util.Collections;

/**
 *  프로그래머스 : 과일 장수
 *
 *  문제 설명
 *
 *  상태에 따라 1점부터 k점까지의 점수로 분류하며, k점이 최상품의 사과이고 1점이 최하품의 사과입니다.
 *  사과 한 상자의 가격은 다음과 같이 결정됩니다.
 *  - 한 상자에 사과를 m개씩 담아 포장합니다.
 *  - 상자에 담긴 사과 중 가장 낮은 점수가 p (1 ≤ p ≤ k)점인 경우, 사과 한 상자의 가격은 p * m 입니다.
 *  - 최대 이익 : (최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수)
 *
 *  사과의 최대 점수 k, 한 상자에 들어가는 사과의 수 m, 사과들의 점수 score가 주어졌을 때,
 *  과일 장수가 얻을 수 있는 최대 이익을 return하는 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *  - 사과 점수가 담긴 score 배열을 내림차순으로 정렬한다
 *  - 반복을 통해 사과 점수의 현재 최솟값을 구하고 m개 만큼 반복이 돌았을 때 최대 이익을 구해 answer에 담아준다
 */

public class FruitSeller {
    public int solution(int k, int m, int[] score) {
        score = Arrays.stream(score).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int answer = 0;
        int min = 9;

        for (int i = 0; i < score.length; i++) {
            min = Math.min(min,score[i]);

            if((i + 1) % m == 0){
                answer += min * m;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        FruitSeller fruitSeller = new FruitSeller();
        System.out.println(fruitSeller.solution(k, m, score));
    }
}
