package Lv1;

import java.util.*;

/**
 *  프로그래머스 : 성격 유형 검사하기
 *
 *  지표 번호	성격 유형
 *  1번 지표	라이언형(R), 튜브형(T)
 *  2번 지표	콘형(C), 프로도형(F)
 *  3번 지표	제이지형(J), 무지형(M)
 *  4번 지표	어피치형(A), 네오형(N)
 *
 *  검사 결과는 모든 질문의 성격 유형 점수를 더하여 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격 유형이라고
 *  판단합니다. 단, 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의
 *  성격 유형이라고 판단합니다.
 *
 *  survey : 질문마다 판단하는 지표를 담은 1차원 문자열 배열
 *  choices : 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열
 *  검사자의 성격 유형 검사 결과를 지표 번호 순서대로 return 하도록 하는 solution 함수 완성
 *
 */

public class PersonalityType {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        List<String> surveys = new ArrayList<>(List.of("RT","CF","JM","AN")); // 나중에 검사 결과 반환 비교를 위한 리스트
        Map<String, Integer> map = new HashMap<>(); // 선택지와 선택지 숫자를 넣어줄 map

        for (int i = 0; i < survey.length; i++) {   // survey 반복을 통해 map을 채움
            String[] surveySplit = survey[i].split("");
            int choice = choices[i];

            scoringByChoice(map, surveySplit, choice);
        }

        for (String s : surveys) {  //  surveys 리스트 반복을 통해 answer 추출
            String[] surveysSplit = s.split("");
            // 이미 리스트를 반복했을 때 사전 순이므로 왼쪽값이 크거나 같다면 answer와 합침, 왼쪽값이 작다면 오른쪽값을 answer와 합침
            answer.append(map.getOrDefault(surveysSplit[0], 0) >= map.getOrDefault(surveysSplit[1], 0) ? surveysSplit[0] : surveysSplit[1]);
        }

        return answer.toString();
    }

    private static void scoringByChoice(Map<String, Integer> map, String[] surveySplit, int choice) {
        switch (choice){
            case 1:
                map.put(surveySplit[0], map.getOrDefault(surveySplit[0], 0) + 3);
                break;
            case 2:
                map.put(surveySplit[0], map.getOrDefault(surveySplit[0], 0) + 2);
                break;
            case 3:
                map.put(surveySplit[0], map.getOrDefault(surveySplit[0], 0) + 1);
                break;
            case 4:
                break;
            case 5:
                map.put(surveySplit[1], map.getOrDefault(surveySplit[1], 0) + 1);
                break;
            case 6:
                map.put(surveySplit[1], map.getOrDefault(surveySplit[1], 0) + 2);
                break;
            case 7:
                map.put(surveySplit[1], map.getOrDefault(surveySplit[1], 0) + 3);
                break;
        }
    }

    public static void main(String[] args) {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};
        PersonalityType personalityType = new PersonalityType();
        System.out.println(personalityType.solution(survey, choices));
    }
}
