package Lv1;

import java.util.*;

/**
 *  프로그래머스 : 실패율
 *
 *  문제 설명
 *
 *  전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
 *  실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
 *  실패율은 다음과 같이 정의한다.
 *  - 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 *
 *  제한사항
 *  - 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
 *  - stages의 길이는 1 이상 200,000 이하이다.
 *  - stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
 *  - 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
 *  - 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
 *  - 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
 *  - 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
 *
 *  풀이 과정
 *  - HashMap > userFailureOfStage : key - 스테이지 숫자, value - 스테이지의 실패한 유저 숫자 합
 *  - HashMap > failureRate : key - 스테이지 숫자, 스테이지의 실패율
 *  - userFailureCount : 스테이지를 도전한 플레이어 수
 *  - 스테이지 별로 실패한 플레이어의 총합을 구한다
 *      - 마지막 스테이지를 성공한 사람은 N + 1에 해당하는 스테이지를 배열에서 가지고 있음
 *  - 위에서 구한 userFailureOfStage에서 만약 스테이지가 없거나 스테이지에 도달한 플레이어 수가 더 없다면 그 스테이지에는 failureRate에 0.0을 넣어준다
 *      - 위 조건을 만족하지 않는다면 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수를 구해 넣어주고
 *        userFailureCount를 클리어하지 못한 플레이어의 수만큼 빼준다
 *  - 모든 반복이 끝나고 실패율이 높은 스테이지부터 내림차순으로 정렬한 뒤 리턴한다
 */

public class FailureRate {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> userFailureOfStage = new HashMap<>();
        Map<Integer, Double> failureRate = new HashMap<>();
        int userFailureCount = stages.length;

        for (int stage : stages) {
            userFailureOfStage.put(stage, userFailureOfStage.getOrDefault(stage, 0) + 1);
        }

        for (int i = 1; i <= N; i++) {
            if(!userFailureOfStage.containsKey(i) || userFailureCount == 0){
                failureRate.put(i, 0.0);
                continue;
            }
            failureRate.put(i, (double) userFailureOfStage.get(i) / userFailureCount);
            userFailureCount -= userFailureOfStage.get(i);
        }

        List<Integer> answer = new ArrayList<>(failureRate.keySet());
        answer.sort((o1, o2) -> Double.compare(failureRate.get(o2), failureRate.get(o1)));

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        FailureRate failureRate = new FailureRate();
        System.out.println(Arrays.toString(failureRate.solution(N, stages)));
    }
}
