package Lv1;

import java.util.Scanner;

/**
 *  프로그래머스 : 직사각형 별찍기
 *
 *  문제 설명
 *
 *  이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
 *  별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
 *
 *  풀이 과정
 *  - 문제에 주어진 대로 단순 연산
 */

public class MakeRectangularStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        sb.append("*".repeat(Math.max(0, n)));

        for (int i = 0; i < m; i++) {
            System.out.println(sb);
        }
    }
}
