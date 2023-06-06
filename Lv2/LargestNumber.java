package Lv2;

import java.util.Arrays;

/**
 *  프로그래머스 : 가장 큰 수
 *
 *  문제 설명
 *  0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 *  예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
 *  0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *
 *  제한 사항
 *  - numbers의 길이는 1 이상 100,000 이하입니다.
 *  - numbers의 원소는 0 이상 1,000 이하입니다.
 *  - 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 *
 *  풀이 과정
 *  - 모든 값이 0이라면 가장 큰 수는 0이 되므로 0을 리턴해준다
 *  - int 배열을 String 배열로 변환한 뒤 두 개의 값을 더해서 내림차순으로 정렬한다
 */

public class LargestNumber {
    public String solution(int[] numbers) {
        if(Arrays.stream(numbers).allMatch(n -> n == 0)){
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        String[] array = Arrays.stream(numbers).mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(array, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (String arr : array){
            answer.append(arr);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {0, 0, 0};
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.solution(numbers));
    }
}
