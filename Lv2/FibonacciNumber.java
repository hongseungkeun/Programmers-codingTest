package Lv2;

/**
 *  프로그래머스 : 피보나치 수
 *
 *  문제 설명
 *
 *  피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
 *  2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
 *
 *  풀이 과정
 *
 *  - 피보나치 수는 앞의 두 수의 합이 뒤의 수가 되는 배열이다
 *      - F(2) = F(0) + F(1) = 0 + 1 = 1
 *  - 숫자의 크기의 범위가 커질 수 있으니 long으로 타입을 변환한다
 *  - 반복을 통해 앞의 두 수의 합을 반복을 통해 모두 더한다
 *      - 1일 경우를 위해 f1은 1로 설정한다
 *  - 1234567로 나누는 이유
 *      - n이 커질수록 리턴해야하는 값이 커지기 때문
 *      - 임의의 수이지만 오버플로를 방지할 수 있을 만큼 크지만 계산 효율성이 있을 만큼 작은 소수라고 한다
 */

public class FibonacciNumber {
    public long solution(int n) {
        long answer = 0;
        long f1 = 1;
        long f2 = 0;

        for (int i = 0; i < n; i++) {
            answer = (f1 + f2) % 1234567;
            f1 = f2;
            f2 = answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println(fibonacciNumber.solution(n));
    }
}
