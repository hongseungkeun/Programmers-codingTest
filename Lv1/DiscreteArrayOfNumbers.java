package Lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *  프로그래머스 : 나누어 떨어지는 숫자 배열
 *
 *  문제 설명
 *  array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
 *  divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
 *
 *  풀이 과정
 *  - 문제 설명대로 divisor로 나누어 떨어진 값을 오름차순으로 정렬하여 리턴한다
 *
 *  - 스트림 연산, for문 연산 속도 비교
 *      - 스트림 연산 : 대개 비슷하게 약 3 ~ 4초
 *      - for문 : 대개 비슷하게 약 2 ~ 3초, 빠른건 1초 이내
 *  - 번갈아가며 확인해보려하니 속도가 점점 느리게 측정되서 처음 제출 당시 기준으로 작성
 */

public class DiscreteArrayOfNumbers {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();

        for (int num : arr) {
            if (num % divisor == 0) {
                answer.add(num);
            }
        }

        if (answer.size() == 0) {
            return new int[]{-1};
        }

        answer.sort(Comparator.comparingInt(o -> o));

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

//    public int[] solution(int[] arr, int divisor) {
//        int[] answer = Arrays.stream(arr).filter(num -> num % divisor == 0).toArray();
//
//        if (answer.length == 0) {
//            return new int[]{-1};
//        }
//
//        Arrays.sort(answer);
//
//        return answer;
//    }

    public static void main(String[] args) {
        int[] arr = {2, 36, 1, 3};
        int divisor = 1;
        DiscreteArrayOfNumbers discreteArrayOfNumbers = new DiscreteArrayOfNumbers();
        System.out.println(Arrays.toString(discreteArrayOfNumbers.solution(arr, divisor)));
    }
}
