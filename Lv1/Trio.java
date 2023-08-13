package Lv1;

import java.util.Arrays;

/**
 *  프로그래머스 : 삼총사
 *
 *  문제 설명
 *
 *  한국중학교에 다니는 학생들은 각자 정수 번호를 갖고 있습니다. 이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면
 *  3명의 학생은 삼총사라고 합니다. 예를 들어, 5명의 학생이 있고, 각각의 정수 번호가 순서대로 -2, 3, 0, 2, -5일 때,
 *  첫 번째, 세 번째, 네 번째 학생의 정수 번호를 더하면 0이므로 세 학생은 삼총사입니다. 또한, 두 번째, 네 번째, 다섯 번째
 *  학생의 정수 번호를 더해도 0이므로 세 학생도 삼총사입니다. 따라서 이 경우 한국중학교에서는 두 가지 방법으로 삼총사를 만들 수 있습니다.
 *
 *  한국중학교 학생들의 번호를 나타내는 정수 배열 number가 매개변수로 주어질 때, 학생들 중 삼총사를 만들 수 있는 방법의 수를
 *  return 하도록 solution 함수를 완성하세요.
 *
 */

public class Trio {
    private static final int[] arr = new int[3];
    private static int[] numArr;
    private static int N;
    private static int resultCount = 0;

    public int solution(int[] number) {
        N = number.length;
        numArr = number;

        DFS(0, 0);
        return resultCount;
    }

    private static void DFS(int idx, int depth) {
        if(depth == 3) {
            if(Arrays.stream(arr).sum() == 0) {
                resultCount++;
            }
            return;
        }

        for(int i = idx; i < N; i++) {
            arr[depth] = numArr[i];
            DFS(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) {
        int[] number = {-1, 1, -1 ,1};
        Trio trio = new Trio();
        System.out.println(trio.solution(number));
    }
}
