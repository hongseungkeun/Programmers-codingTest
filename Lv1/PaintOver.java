package Lv1;

/**
 *  프로그래머스 : 덧칠하기
 *
 *  n : 페인트가 칠해진 길이
 *  m : 페인트를 칠하는 롤러의 길이
 *  section : 페인트를 칠하기로 정한 구역들의 번호가 담긴 정수 배열
 *
 *  롤러의 좌우측 끝을 구역의 경계선 혹은 벽의 좌우측 끝부분에 맞춘 후 롤러를 위아래로 움직이면서
 *  벽을 칠합니다. 현재 페인트를 칠하는 구역들을 완전히 칠한 후 벽에서 롤러를 떼며, 이를 벽을 한 번 칠했다고
 *  정의합니다.
 *
 *  한 구역에 페인트를 여러 번 칠해도 되고 다시 칠해야 할 구역이 아닌 곳에 페인트를 칠해도 되지만 다시 칠하기로
 *  정한 구역은 적어도 한 번 페인트칠을 해야 합니다. 예산을 아끼기 위해 다시 칠할 구역을 정했듯 마찬가지로 롤러로
 *  페인트칠을 하는 횟수를 최소화하려고 합니다
 *
 *  풀이 과정
 *  - n은 길이 이므로 사용할 필요를 못 느낌
 *  - checkPlace : 최대로 페인트가 칠해진 구역
 *  - checkPlace와 현재 구역을 비교 후 칠하지 않았다면 칠해줌
 *
 */

public class PaintOver {
    public int solution(int n, int m, int[] section) {
        int answer = 0; // 칠해진 횟수
        int checkPlace = 0; // 최대로 페인트가 칠해진 구역
        for (int sec : section) {
            if (checkPlace < sec) {   // checkPlace를 최대로 갱신해주고 횟수를 늘려줌
                checkPlace = sec + m - 1;
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 1;
        int[] section = {1, 2, 3, 4};
        PaintOver paintOver = new PaintOver();
        System.out.println(paintOver.solution(n,m,section));
    }
}
