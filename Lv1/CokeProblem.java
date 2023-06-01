package Lv1;

/**
 *  프로그래머스 : 콜라 문제
 *
 *  문제 설명
 *  빈 병 a개를 가져다주면 콜라 b병을 주는 마트가 있을 때, 빈 병 n개를 가져다주면 몇 병을 받을 수 있는지 계산하는 문제입니다.
 *  기존 콜라 문제와 마찬가지로, 보유 중인 빈 병이 a개 미만이면, 추가적으로 빈 병을 받을 순 없습니다.
 *
 *  콜라를 받기 위해 마트에 주어야 하는 병 수 a, 빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b,
 *  상빈이가 가지고 있는 빈 병의 개수 n이 매개변수로 주어집니다. 상빈이가 받을 수 있는 콜라의
 *  병 수를 return 하도록 solution 함수를 작성해주세요.
 *
 *  풀이 과정
 *  - 전체 콜라 개수에서 빈 병을 가져다 주면 받을 수 있는 콜라 개수가 총 몇 개인지 구한다
 *  - 남은 병들과 다시 돌려받은 콜라를 더하고 돌려 받은 콜라를 answer에 계속 담아준다
 */

public class CokeProblem {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int receiveCoke;

        while(a <= n){
            receiveCoke = n / a * b;
            n = n % a + receiveCoke;
            answer += receiveCoke;
        }

        return answer;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        int n = 20;
        CokeProblem cokeProblem = new CokeProblem();
        System.out.println(cokeProblem.solution(a, b, n));
    }
}
