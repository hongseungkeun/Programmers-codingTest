package Lv1;

/**
 *  프로그래머스 : 정수 제곱근 판별
 *
 *  문제 설명
 *
 *  임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
 *  n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 *
 *  풀이 과정
 *  - n의 제곱근을 구하고 그 제곱근을 제곱한 값이 n과 일치한다면 x+1의 제곱 리턴, 아니라면 -1 리턴
 *      - Math 클래스의 sqrt()를 이용해 제곱근을 구한다
 *      - Math 클래스의 pow()를 이용해 위에서 구한 제곱근을 제곱한다
 *      - 그 값이 n과 일치한다면 x+1의 제곱 리턴, 아니라면 -1 리턴
 *
 *  - Math 클래스의 다양한 메소드를 사용해볼 수 있어서 좋았다
 *  - 삼항연산자를 이용해 간단하게 한 줄로 만들었지만 역시 가독성에 있어선 if문을 사용하는 게 더 좋아보인다
 */

public class DeterminingTheSquareRootOfAnInteger {
    public long solution(long n) {
        return Math.pow((int) Math.sqrt(n), 2) == n ? (long) Math.pow(Math.sqrt(n) + 1, 2) : -1;
    }

    public static void main(String[] args) {
        long n = 121;
        DeterminingTheSquareRootOfAnInteger determiningTheSquareRootOfAnInteger = new DeterminingTheSquareRootOfAnInteger();
        System.out.println(determiningTheSquareRootOfAnInteger.solution(n));
    }
}
