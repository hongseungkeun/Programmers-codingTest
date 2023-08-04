package Lv2;

import java.util.*;

/**
 *  프로그래머스 : 요격 시스템
 *
 *  문제 설명
 *  A 나라와 B 나라가 싸우고 있는 이 세계는 2 차원 공간으로 이루어져 있습니다.
 *  A 나라가 발사한 폭격 미사일은 x 축에 평행한 직선 형태의 모양이며 개구간을 나타내는 정수
 *  쌍 (s, e) 형태로 표현됩니다. B 나라는 특정 x 좌표에서 y 축에 수평이 되도록 미사일을 발사하며,
 *  발사된 미사일은 해당 x 좌표에 걸쳐있는 모든 폭격 미사일을 관통하여 한 번에 요격할 수 있습니다.
 *  단, 개구간 (s, e)로 표현되는 폭격 미사일은 s와 e에서 발사하는 요격 미사일로는 요격할 수 없습니다.
 *  요격 미사일은 실수인 x 좌표에서도 발사할 수 있습니다.
 *  각 폭격 미사일의 x 좌표 범위 목록 targets이 매개변수로 주어질 때, 모든 폭격 미사일을
 *  요격하기 위해 필요한 요격 미사일 수의 최솟값을 return 하도록 solution 함수를 완성해 주세요.
 *
 *  풀이 과정
 *  - 좌표 e를 기준으로 오름차순 정렬
 *  - 맨 첫번 째 좌표의 e를 끝으로 잡고 반복 실행
 *  - 반복에서는 target의 s와 아까 끝으로 잡은 e와 비교 후 s가 크거나 같다면 끝을
 *  그 target의 e와 교체하고 answer++,
 *
 */

public class InterceptionSystem {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        int end = targets[0][1];
        answer++;

        for(int[] target : targets){
            if(target[0] >= end){
                end = target[1];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12},{3, 7},{1, 4}};
        InterceptionSystem interceptionSystem = new InterceptionSystem();
        System.out.println(interceptionSystem.solution(targets));
    }
}
