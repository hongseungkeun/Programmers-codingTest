package Lv1;

import java.util.Arrays;

/**
 *  프로그래머스 : x만큼 간격이 있는 n개의 숫자
 *
 *  문제 설명
 *
 *  함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
 *  조건을 만족하는 함수, solution을 완성해주세요.
 *
 *  풀이 과정
 *  - 배열을 크기를 n개 만큼 선언하고, 반복을 통해 x씩 증가하는 숫자에 대한 연산을 진행 한다
 */

public class NumbersSpacedByX {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        int x = -4;
        int n = 2;
        NumbersSpacedByX numbersSpacedByX = new NumbersSpacedByX();
        System.out.println(Arrays.toString(numbersSpacedByX.solution(x, n)));
    }
}
