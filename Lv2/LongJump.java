package Lv2;

/**
 *  프로그래머스 : 멀리 뛰기
 *
 *  문제 설명
 *
 *  효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다.
 *  칸이 총 4개 있을 때, 효진이는
 *  (1칸, 1칸, 1칸, 1칸)
 *  (1칸, 2칸, 1칸)
 *  (1칸, 1칸, 2칸)
 *  (2칸, 1칸, 1칸)
 *  (2칸, 2칸)
 *  의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다.
 *  멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내,
 *  여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요.
 *  예를 들어 4가 입력된다면, 5를 return하면 됩니다.
 *
 *  풀이 과정
 *
 *  - 결과를 보면 피보나치 수와 동일하게 이루어진다
 *      - 1칸이라면 가능한 수는 1번, 2칸이라면 가능한 수는 (1, 1), (2)로 2번, 3칸이라면 (1, 1, 1), (1, 2), (2, 1)로 3번
 *  - 반복을 통해 앞의 두 수의 합을 반복을 통해 모두 더한다
 *      - 만약 1일 경우 반복에 돌지 않고 1을 리턴한다
 *      - 2부터 정상적으로 반복을 돌며 더해준다
 *
 */

public class LongJump {
    private static long answer = 0;

    public long solution(int n) {
        long answer = 1L;
        long f1 = 1L;
        long f2 = 1L;

        for (int i = 1; i < n; i++) {
            answer = f1 + f2;
            f1 = f2;
            f2 = answer;
        }

       return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        LongJump longJump = new LongJump();
        System.out.println(longJump.solution(n));
    }
}
