package Lv1;

import java.util.Arrays;

/**
 *  프로그래머스 : 예산
 *
 *  문제 설명
 *
 *  물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 합니다. 예를 들어 1,000원을
 *  신청한 부서에는 정확히 1,000원을 지원해야 하며, 1,000원보다 적은 금액을 지원해 줄 수는 없습니다.
 *  부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때, 최대 몇 개의 부서에
 *  물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *
 *  - d를 오름차순으로 정렬
 *  - 반복을 통해 총 예산(budget)이 현재 신청 금액(amount)보다 작다면 반복 탈출
 *  - 그렇지 않다면 총 예산에서 현재 신청 금액을 빼주고 answer++
 */

public class Budget {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        for(int amount : d){
            if(budget < amount){
                break;
            }
            budget -= amount;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] d = {1,3,2,5,4};
        int b = 9;
        Budget budget = new Budget();
        System.out.println(budget.solution(d,b));
    }
}