package Lv2;

import java.util.*;

/**
 *  프로그래머스 : 기능개발
 *
 *  문제 설명
 *
 *  프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 *  또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
 *  먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
 *  각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 *
 *  제한 사항
 *  - 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
 *  - 작업 진도는 100 미만의 자연수입니다.
 *  - 작업 속도는 100 이하의 자연수입니다.
 *  - 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 *
 *  풀이 과정
 *  - 큐에 기능 개발이 끝나는 날을 구해 차례로 넣어준다
 *  - 반복을 통해 배포마다 몇 개의 기능이 배포되는지를 구한다
 *      - 먼저 큐에서 비교할 날짜(day)를 뽑는다
 *      - day와 다음에 뽑은 날짜를 비교한다
 *          - day가 뽑은 날짜보다 크거나 같다면 함께 배포가 되야 하므로 count++
 *          - day가 뽑은 날짜보다 작다면 배포 진행
 *              - day를 뽑은 날짜로 바꿔준다
 *              - 배포를 담을 리스트에 지금까지의 count를 넣어준다
 *              - count는 다시 1로 초기화 해준다
 *  - 모든 반복이 끝났다면 배포 리스트에 남은 count를 넣어준다
 */

public class FunctionalDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        int count = 1;

        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }

        int day = queue.poll();

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (day < poll) {
                day = poll;
                answer.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        FunctionalDevelopment functionalDevelopment = new FunctionalDevelopment();
        System.out.println(Arrays.toString(functionalDevelopment.solution(progresses, speeds)));
    }
}
