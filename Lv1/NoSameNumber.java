package Lv1;

import java.util.*;

/**
 *  프로그래머스 : 같은 숫자는 싫어
 *
 *  문제 설명
 *
 *  배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로
 *  나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의
 *  순서를 유지해야 합니다.
 *  배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.
 *
 *  풀이 과정
 *  - 원소 크기는 0 ~ 9까지의 숫자이므로 이전 숫자를 10으로 지정
 *  - 반복을 통해 현재 숫자와 이전 숫자가 같지 않으면 리스트에 추가하고 이전 숫자를 현재 숫자로 바꿔준다
 */

public class NoSameNumber {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        int previousNumber = 10;

        for (int a : arr){
            if(a != previousNumber){
                answer.add(a);
                previousNumber = a;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        NoSameNumber noSameNumber = new NoSameNumber();
        System.out.println(Arrays.toString(noSameNumber.solution(arr)));
    }
}
