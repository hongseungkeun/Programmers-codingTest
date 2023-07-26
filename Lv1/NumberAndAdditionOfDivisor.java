package Lv1;

import java.util.ArrayList;
import java.util.List;

/**
 *  프로그래머스 : 약수의 개수와 덧셈
 *
 *  문제 설명
 *
 *  두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
 *  약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *  - left부터 right까지의 숫자를 구하고 그 숫자들을 answer에 약수가 홀수면 -, 짝수면 +를 해 리턴한다
 *
 *  - 그래도 이정도면 깔끔하다고 생각했는데 문제를 풀고 다른 사람의 답을 보고 벙찌게 됐다. (살짝 또 수학공부를 하게 된 느낌..)
 *      - i % Math.sqrt(i) == 0 라는 조건 하나로 약수가 홀수인지 짝수인지 판별하는 걸 보고 이렇게도 할 수 있구나 생각하게 됐다.
 */

public class NumberAndAdditionOfDivisor {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            List<Integer> numArr = new ArrayList<>();

            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    numArr.add(j);
                    if (i / j != j) {
                        numArr.add(i / j);
                    }
                }
            }

            if(numArr.size() % 2 == 0){
                answer += i;
            }else{
                answer -= i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        NumberAndAdditionOfDivisor numberAndAdditionOfDivisor = new NumberAndAdditionOfDivisor();
        System.out.println(numberAndAdditionOfDivisor.solution(left, right));
    }
}
