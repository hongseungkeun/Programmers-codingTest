package Lv2;

import java.util.Stack;

/**
 *  프로그래머스 : 짝지어 제거하기
 *
 *  문제 설명
 *
 *  짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다.
 *  먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다.
 *  이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다. 문자열 S가 주어졌을 때,
 *  짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요. 성공적으로 수행할 수 있으면 1을,
 *  아닐 경우 0을 리턴해주면 됩니다.
 *
 *  예를 들어, 문자열 S = baabaa 라면 b aa baa → bb aa → aa →
 *  의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.
 *
 *  풀이 과정
 *  - 편리하게 문자를 비교하기 위해 stack을 사용
 *  - 만약 스택이 비어있지 않고 스택에서 가져온 문자와 반복을 돌리는 문자가 같다면 짝이 지어진 것이므로 스택에서 pop해준다
 *  - 그게 아니라면 스택에 해당 문자를 push해준다
 */

public class RemovingThePair {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("");

        for (String str : arr) {
            if (!stack.isEmpty() && stack.peek().equals(str)) {
                stack.pop();
            } else {
                stack.push(str);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        String s = "baabaa";
        RemovingThePair removingThePair = new RemovingThePair();
        System.out.println(removingThePair.solution(s));
    }
}
