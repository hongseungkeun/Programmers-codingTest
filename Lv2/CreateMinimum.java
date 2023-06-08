package Lv2;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *  프로그래머스 : 최솟값 만들기
 *
 *  문제 설명
 *  길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
 *  배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 이러한 과정을 배열의 길이만큼 반복하며,
 *  두 수를 곱한 값을 누적하여 더합니다. 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다.
 *  (단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)
 *  배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.
 *
 *  풀이 과정
 *  - 배열의 최댓값과 다른 배열의 최솟값을 곱한 값을 answer에 더해주는 연산 문제
 *
 *  - Array의 sort사용할 시 효율성 테스트를 통과하지 못함
 *      - PriorityQueue 사용으로 변경
 *  - PriorityQueue를 사용했음에도 효율성이 많이 좋아졌지만 하나가 통과하지 못함
 *      - import java.util.*을 혹시 몰라 각각 Collections와 PriorityQueue로 변경
 *  - PriorityQueue가 효율성면으로 훨씬 뛰어났다는 점과 import도 조금의 시간차이를 줄 것 같다는 생각이 드는 문제
 */

public class CreateMinimum {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> queueA = new PriorityQueue<>();
        PriorityQueue<Integer> queueB = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            queueA.add(A[i]);
            queueB.add(B[i]);
        }

        while(!queueA.isEmpty()){
            answer += queueA.poll() * queueB.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        CreateMinimum createMinimum = new CreateMinimum();
        System.out.println(createMinimum.solution(A, B));
    }
}
