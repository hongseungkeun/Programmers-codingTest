package Lv1;

import java.util.stream.LongStream;

/**
 *  프로그래머스 : 두 정수 사이의 합
 *
 *  문제 설명
 *
 *  두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, solution을 완성하세요.
 *  예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
 *
 *  제한 조건
 *  - a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
 *  - a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
 *  - a와 b의 대소관계는 정해져있지 않습니다.
 *
 *  풀이 과정
 *  - a와 b가 같지 않다면 LongStream.rangeClosed()를 이용해 a와 b의 최솟값, 최댓값의 합을 리턴한다
 *  - 같다면 a or b를 리턴한다
 */
public class TheSumOfTwoIntegers {
    public long solution(int a, int b) {
        return a != b ? LongStream.rangeClosed(Math.min(a,b),Math.max(a,b)).sum() : a;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        TheSumOfTwoIntegers theSumOfTwoIntegers = new TheSumOfTwoIntegers();
        System.out.println(theSumOfTwoIntegers.solution(a,b));
    }
}
