package Lv1;

import java.util.Arrays;

/**
 *  프로그래머스 : 없는 숫자 더하기
 *
 *  문제 설명
 *
 *  0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
 *  numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록
 *  solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *
 *  - 0 ~ 9의 총합인 45와 numbers의 총합을 뺀 값을 return
 *
 */

public class AddNumberNotExist {
    public int solution(int[] numbers) {
        final int MAX_NUM = 45;

        return MAX_NUM - Arrays.stream(numbers).sum();
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        AddNumberNotExist addNumberNotExist = new AddNumberNotExist();
        System.out.println(addNumberNotExist.solution(numbers));
    }
}