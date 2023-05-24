package Lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  프로그래머스 : 제일 작은 수 제거하기
 *
 *  문제 설명
 *
 *  정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
 *  단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
 *
 */

public class RemoveMinNum {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }
        List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Integer[] newArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(newArr);
        collect.remove(newArr[0]);

        return collect.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {10};
        RemoveMinNum removeMinNum = new RemoveMinNum();
        System.out.println(Arrays.toString(removeMinNum.solution(arr)));
    }
}