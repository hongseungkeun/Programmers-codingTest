package Lv2;

import java.util.*;

/**
 *  프로그래머스 : 과제 진행하기
 *
 *  문제 설명
 *
 *  과제를 받은 루는 다음과 같은 순서대로 과제를 하려고 계획을 세웠습니다.
 *
 *  - 과제는 시작하기로 한 시각이 되면 시작합니다.
 *  - 새로운 과제를 시작할 시각이 되었을 때, 기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 새로운 과제를 시작합니다.
 *  - 진행중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 이어서 진행합니다.
 *  - 만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행합니다.
 *  - 멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다.
 *
 *  과제 계획을 담은 이차원 문자열 배열 plans가 매개변수로 주어질 때, 과제를 끝낸 순서대로 이름을 배열에
 *  담아 return 하는 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *
 *  - List answer : 끝난 과제들을 담을 리스트
 *  - List times : 과제의 시작 시간들을 담을 리스트
 *  - Map language : 과제의 시작 시간과 과제의 이름을 담을 맵
 *  - Map playtime : 과제의 시작 시간과 과제의 걸리는 시간을 담을 맵
 *  - Stack inProgress : 현재 진행중에 있었던 과제를 담을 스택
 *
 *  - 반복을 통해 과제의 시작 시간들을 리스트에 담고 오름차순으로 정렬
 *  - 과제의 개수만큼 반복
 *      - 만약 과제의 개수와 i가 같다면 밑의 과정이 필요없으므로 answer에 담고 break
 *      - 현재 과제의 플레이 타임이 다음 과제의 시작 시간 - 현재 과제의 시작 시간보다 작다면
 *          - 현재 과제는 끝낼 수 있기 때문에 answer에 담고 남아 있는 시간을 구한다
 *          - 남아 있는 시간이 0이 아니고, 현재 진행중인 과제들이 있다면 남아 있는 시간으로 현재 진행중인 과제들을 차례로 끝낸다
 *          - 남아 있는 시간이 0이거나, 현재 진행중인 과제들이 없다면 진행한 만큼 playtime에 업데이트 해준다
 *      - 현재 과제의 플레이 타임이 다음 과제의 시작 시간 - 현재 과제의 시작 시간과 같다면
 *          - 딱 알맞게 끝났으므로 answer에 담아준다
 *      - 현재 과제의 플레이 타임이 다음 과제의 시작 시간 - 현재 과제의 시작 시간보다 크다면
 *          - 다 끝낼 수 없기 때문에 진행한 만큼을 playtime에 업데이트 해주고 진행중으로 넣어주기 위해 inProgress에 담아준다
 *  - 반복이 끝났다면 inProgress에 남아 있는 과제들을 순서대로 answer에 담아준다
 *
 */

public class ProceedingAssignment {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        List<Integer> times = new ArrayList<>();
        Map<Integer, String> language = new HashMap<>();
        Map<Integer, Integer> playtime = new HashMap<>();
        Stack<Integer> inProgress = new Stack<>();

        for (String[] plan : plans) {
            String[] time = plan[1].split(":");
            int timeToCompare = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

            times.add(timeToCompare);
            language.put(timeToCompare, plan[0]);
            playtime.put(timeToCompare, Integer.parseInt(plan[2]));
        }

        times.sort(Comparator.naturalOrder());

        for (int i = 0; i < plans.length; i++) {
            if(i == plans.length-1){
                answer.add(language.get(times.get(i)));
                break;
            }

            if(playtime.get(times.get(i)) < times.get(i + 1) - times.get(i)){
                answer.add(language.get(times.get(i)));
                int remainTime = (times.get(i + 1) - times.get(i)) - playtime.get(times.get(i));

                while(!(remainTime == 0) && !inProgress.empty()){
                    if(playtime.get(inProgress.peek()) <= remainTime){
                        remainTime -= playtime.get(inProgress.peek());
                        answer.add(language.get(inProgress.peek()));
                        inProgress.pop();
                    }else{
                        playtime.put(inProgress.peek(), playtime.get(inProgress.peek()) - remainTime);
                        remainTime = 0;
                    }
                }
            }else if(playtime.get(times.get(i)) == times.get(i + 1) - times.get(i)){
                answer.add(language.get(times.get(i)));
            }else{
                playtime.put(times.get(i),playtime.get(times.get(i)) - (times.get(i + 1) - times.get(i)));
                inProgress.push(times.get(i));
            }
        }

        while(!inProgress.empty()){
            answer.add(language.get(inProgress.pop()));
        }

        return answer.toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[][] plans = {{"science", "12:40", "50"},{"music", "12:20", "40"},{"history", "14:00", "30"},{"computer", "12:30", "100"}};
        ProceedingAssignment proceedingAssignment = new ProceedingAssignment();
        System.out.println(Arrays.toString(proceedingAssignment.solution(plans)));
    }
}