package Lv1;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 *  프로그래머스 : 두 개 뽑아서 더하기
 *
 *  문제 설명
 *  정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서
 *  만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
 *
 *  제한사항
 *  - numbers의 길이는 2 이상 100 이하입니다.
 *  - numbers의 모든 수는 0 이상 100 이하입니다.
 *
 *  풀이 과정
 *  - 겹치는 숫자를 제거하기 위해, 그리고 자동으로 오름차순 정렬을 위해 TreeSet 자료구조에 더한 값들을 넣어주고 return
 *
 *  - TreeSet을 사용한 이유 : 첫 구현 당시 numbers를 먼저 정렬해주고 반복문을 통해 HashSet에 넣어주면
 *    낮은 값부터 더해지기 때문에 밑에서 따로 정렬을 하지 않아도 될거라고 생각했으나 HashSet이 순서가 없어서
 *    그런지 제대로 정렬이 된 상태에서 나오지 않았다. 그래서 자동으로 오름차순 정렬을 하는 TreeSet을 사용했다
 *
 */

public class PickTwoAndAdd {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        PickTwoAndAdd pickTwoAndAdd = new PickTwoAndAdd();
        System.out.println(Arrays.toString(pickTwoAndAdd.solution(numbers)));
    }
}
