package Lv1;

import java.util.Arrays;

/**
 *  프로그래머스 : 최대공약수와 최소공배수
 *
 *  문제 설명
 *
 *  두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
 *  배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
 *  예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
 *
 *  풀이 과정
 *  - 최대공약수 : 유클리드 호제법을 이용해 구한다
 *  - 최소공배수 : n * m / 최대공약수임을 이용해 구한다
 *
 *  - 어떻게 깔끔하게 코드를 짜야할 지 감이 안와서 검색해보니 유클리드 호제법이라는 방식이 많이 나와 사용해 풀이했다
 *    (코딩테스트 연습을 하려다 졸지에 수학 공부를 하게된..)
 *  - 유클리드 호제법은 대충 a, b (a > b)가 있다면 b와 a % b를 a % b가 0이 될 때까지 계속 비교하고
 *    a % b가 0이면 b의 값이 최대 공약수가 된다. (더 자세한 증명식은 이해하기에도 너무 복잡해서 제대로 써 놓질 못하겠다)
 */

public class MaximumDivisorAndMinimumDivisor {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(Math.max(n, m), Math.min(n, m));
        answer[1] = (n * m)/answer[0];
        return answer;
    }

    public static int gcd(int max, int min) {
        if (min == 0) {
            return max;
        }
        return gcd(min, max % min);
    }

    public static void main(String[] args) {
        int n = 11;
        int m = 12;
        MaximumDivisorAndMinimumDivisor maximumDivisorAndMinimumDivisor = new MaximumDivisorAndMinimumDivisor();
        System.out.println(Arrays.toString(maximumDivisorAndMinimumDivisor.solution(n,m)));
    }
}
