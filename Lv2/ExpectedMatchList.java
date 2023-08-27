package Lv2;

/**
 *  프로그래머스 : 예상 대진표
 *
 *  문제 설명
 *  △△ 게임대회가 개최되었습니다. 이 대회는 N명이 참가하고, 토너먼트 형식으로 진행됩니다.
 *  N명의 참가자는 각각 1부터 N번을 차례대로 배정받습니다. 그리고, 1번 ↔ 2번, 3번 ↔ 4번, ... , N-1번 ↔ N번의 참가자끼리 게임을 진행합니다.
 *  각 게임에서 이긴 사람은 다음 라운드에 진출할 수 있습니다. 이때, 다음 라운드에 진출할 참가자의 번호는 다시 1번부터 N/2번을 차례대로 배정받습니다.
 *  만약 1번 ↔ 2번 끼리 겨루는 게임에서 2번이 승리했다면 다음 라운드에서 1번을 부여받고, 3번 ↔ 4번에서 겨루는 게임에서 3번이 승리했다면 다음 라운드에서 2번을 부여받게 됩니다.
 *  게임은 최종 한 명이 남을 때까지 진행됩니다.
 *
 *  이때, 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와 몇 번째 라운드에서 만나는지 궁금해졌습니다.
 *  게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B가 함수 solution의 매개변수로 주어질 때, 처음 라운드에서 A번을 가진 참가자는 경쟁자로 생각하는 B번 참가자와
 *  몇 번째 라운드에서 만나는지 return 하는 solution 함수를 완성해 주세요. 단, A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정합니다.
 *
 *  풀이 과정
 *  - 만약 3번 ↔ 4번의 대결이라면 3번이 N-1, 4번이 N 즉, 짝수가 N이 되므로 a와 b가 만약 홀수라면 +1을 통해 짝수로 만들어준다
 *  - 라운드가 지나갈때마다 answer++를 해준다
 *  - 끝나는 조건은 a와 b를 뺀 값이 1이 아니거나 a와 b를 2로 나눈 값이 같으면 반복 진행
 *      - a와 b를 뺀 값이 1이면 같은 라운드에서 만난 것
 *      - 만약 예를 들어 a가 4, b가 5라면 둘을 뺀 값은 1이지만 같은 라운드가 아니기 때문에 a와 b를 2로 나눈 값이 같으면 true라는 조건을 넣어 반복을 계속 진행한다
 */

public class ExpectedMatchList {
    public int solution(int n, int a, int b) {
        int answer = 1;

        while (Math.abs(a - b) != 1 || a / 2 == b / 2) {
            a = allocationNum(a);
            b = allocationNum(b);
            answer++;
        }

        return answer;
    }

    private int allocationNum(int num) {
        if (num % 2 != 0) {
            num += 1;
        }

        return num / 2;
    }

    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        ExpectedMatchList expectedMatchList = new ExpectedMatchList();
        System.out.println(expectedMatchList.solution(n, a, b));
    }
}
