package Lv1;

import java.util.Stack;

/**
 *  프로그래머스 : 햄버거 만들기
 *
 *  문제 설명
 *
 *  햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고,
 *  상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다.
 *  상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
 *
 *  제한사항
 *  - 1 ≤ ingredient의 길이 ≤ 1,000,000
 *  - ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다
 *
 *  풀이 과정
 *  - ingredient의 값들을 하나씩 Stack에 저장한다
 *  - 햄버거는 1, 2, 3, 1(빵 – 야채 – 고기 - 빵)의 순서대로 쌓였는 지 Stack의 사이즈가 4일 때부터 검사를 진행한다
 */

public class MakeHamburgers {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int in : ingredient){
            stack.push(in);

            if(4 <= stack.size()){
                if(stack.get(stack.size() - 4) == 1
                        && stack.get(stack.size() - 3) == 2
                        && stack.get(stack.size() - 2) == 3
                        && stack.get(stack.size() - 1) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        MakeHamburgers makeHamburgers = new MakeHamburgers();
        System.out.println(makeHamburgers.solution(ingredient));
    }
}
