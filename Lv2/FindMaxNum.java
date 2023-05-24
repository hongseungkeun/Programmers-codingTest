package Lv2;

import java.util.Arrays;
import java.util.Stack;

/**
 *  프로그래머스 : 뒤에 있는 큰 수 찾기
 *
 *  정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서
 *  가장 가까이 있는 수를 뒷 큰수라고 합니다.
 *  정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution
 *  함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.
 *
 *  풀이 과정
 *  - Stack에 지나간 번호들의 인덱스를 담는다
 *  - Stack에 담긴 번호들과 현재 번호를 비교해 현재 번호가 크다면 Stack에 담긴 인덱스를 이용해 answer를 갱신
 *
 */

public class FindMaxNum {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Arrays.fill(answer, -1);    // 기본으로 int[]을 -1로 채움

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            // stack에 무언가 담겨있고, 현재 숫자가 stack에 차례대로 담긴 숫자보다 큰지 반복적으로 검사
            while(!stack.empty() && numbers[i] > numbers[stack.peek()]){
                // stack의 가장 첫 인덱스를 answer 배열의 인덱스로 놓고 현재 숫자를 넣어줌
                answer[stack.pop()] = numbers[i];
            }
            // stack에 현재 인덱스를 넣어줌
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
//        int[] numbers = {2, 3, 3, 5};
        int[] numbers = {9, 1, 5, 3, 6, 2};
        FindMaxNum findMaxNum = new FindMaxNum();
        System.out.println(Arrays.toString(findMaxNum.solution(numbers)));
    }
}
