package Lv2;

import java.util.Arrays;

/**
 *  프로그래머스 : 광물 캐기
 *
 *  문제 설명
 *
 *  마인은 다이아몬드 곡괭이, 철 곡괭이, 돌 곡괭이를 각각 0개에서 5개까지 가지고 있으며, 곡괭이로 광물을 캘 때는 피로도가 소모됩니다.
 *  각 곡괭이는 종류에 상관없이 광물 5개를 캔 후에는 더 이상 사용할 수 없습니다.
 *  마인은 다음과 같은 규칙을 지키면서 최소한의 피로도로 광물을 캐려고 합니다.
 *  - 사용할 수 있는 곡괭이중 아무거나 하나를 선택해 광물을 캡니다.
 *  - 한 번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용합니다.
 *  - 광물은 주어진 순서대로만 캘 수 있습니다.
 *  - 광산에 있는 모든 광물을 캐거나, 더 사용할 곡괭이가 없을 때까지 광물을 캡니다.
 *
 *  마인이 갖고 있는 곡괭이의 개수를 나타내는 정수 배열 picks와 광물들의 순서를 나타내는 문자열 배열 minerals가 매개변수로 주어질 때,
 *  마인이 작업을 끝내기까지 필요한 최소한의 피로도를 return 하는 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *
 *  - 2차원 배열 (fatigues)에 다이아, 철, 돌 곡괭이로 minerals를 순서대로 5개를 각각 캤을 때의 총 피로도를 구해 넣어준다
 *  - 돌 곡괭이로 캔 피로도를 기준으로 내림차순으로 fatigues를 정렬한다. (피로도가 가장 많을 수록 다이아로 캘 수 있게 하기 위해)
 *  - fatigues로 반복을 통해 다이아, 철, 돌 곡괭이 순서로 피로도를 꺼내준다
 *      - 만약 곡괭이가 있다면 그 곡괭이의 피로도를 꺼내 answer에 더해준다
 *      - 없다면 다음 곡괭이를 확인하고 다음 곡괭이 마저 없다면 break
 *
 *  주의
 *
 *  - 2차원 배열에서 5개씩 피로도를 구하면서 캘 수 있는 곡괭이 개수가 없을 때 반복을 종료하지 않으면 광물을 캐는 순서는 변경할 수 없기 때문에
 *    나중에 정렬을 할 때 캘 수 없는 광물들까지 포함해서 정렬을 하게 된다
 *  - 다이아, 철, 돌 곡괭이를 선택하는 과정에서 세 개의 곡괭이의 개수를 넘어가는지, 안에 각각의 곡괭이 개수가 0이라면에 따라 반복을 계속 해야한다
 */

public class MiningMineral {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[][] fatigues = new int[minerals.length / 5 + 1][3];
        int pickCount = Arrays.stream(picks).sum();
        int pick = 0;

        for (int i = 0; i < minerals.length && 0 < pickCount; i++) {
            switch(minerals[i])
            {
                case "diamond":
                    fatigues[i / 5][0] += 1;
                    fatigues[i / 5][1] += 5;
                    fatigues[i / 5][2] += 25;
                    break;
                case "iron":
                    fatigues[i / 5][0] += 1;
                    fatigues[i / 5][1] += 1;
                    fatigues[i / 5][2] += 5;
                    break;
                case "stone":
                    fatigues[i / 5][0] += 1;
                    fatigues[i / 5][1] += 1;
                    fatigues[i / 5][2] += 1;
            }

            if(i % 5 == 4) {
                pickCount--;
            }
        }

        Arrays.sort(fatigues, (o1, o2) -> o2[2] - o1[2]);

        for (int[] fatigue : fatigues) {
            while (pick < 3 && picks[pick] == 0) {
                pick++;
            }

            if (pick == 3) {
                break;
            }

            picks[pick]--;
            answer += fatigue[pick];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] picks = {0,0,1};
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        MiningMineral miningMineral = new MiningMineral();
        System.out.println(miningMineral.solution(picks, minerals));
    }
}