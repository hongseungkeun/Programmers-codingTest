package Lv1;

import java.util.Arrays;

/**
 *  프로그래머스 : 평균 구하기
 *
 *  문제 설명
 *
 *  정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.
 *
 *  제한사항
 *  - arr은 길이 1 이상, 100 이하인 배열입니다.
 *  - arr의 원소는 -10,000 이상 10,000 이하인 정수입니다.
 *
 *  풀이 과정
 *  - Stream의 average()를 통해 평균값을 리턴
 *      - 길이가 0일 때의 조건 처리는 제한 사항에서 길이가 1 이상이기 때문에 해주지 않았다
 */

public class AverageAcquisition {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        AverageAcquisition averageAcquisition = new AverageAcquisition();
        System.out.println(averageAcquisition.solution(arr));
    }
}
