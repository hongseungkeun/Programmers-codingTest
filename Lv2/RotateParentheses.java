package Lv2;

import java.util.Stack;

/**
 *  프로그래머스 : 괄호 회전하기
 *
 *  문제 설명
 *
 *  다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
 *  - (), [], {} 는 모두 올바른 괄호 문자열입니다.
 *  - 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다. 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
 *  - 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다. 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
 *  대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다. 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때
 *  s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *  - 반복을 통해 스택에 '[','{','(' 셋 중 하나라면 push, 아니라면 현재 괄호 문자열과 올바른 괄호가 될 수 있는 지 스택에서 꺼내고 맞다면 없애준다.
 *  - 올바른 괄호가 된다면 스택은 비어있게 됨
 *      - 올바른 괄호라면 answer++
 *  - s를 한 칸씩 이동시키며 s의 길이 만큼 반복한 뒤 answer를 리턴한다
 */

public class RotateParentheses {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isCorrect(s)) {
                answer++;
            }
            s = s.substring(1) + s.charAt(0);
        }

        return answer;
    }

    private static boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    switch (s.charAt(i)) {
                        case ']' -> isErasableParentheses(stack, '[');
                        case ')' -> isErasableParentheses(stack, '(');
                        case '}' -> isErasableParentheses(stack, '{');
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static void isErasableParentheses(Stack<Character> stack, char parentheses) {
        if (stack.peek() == parentheses) {
            stack.pop();
        }
    }

    public static void main(String[] args) {
        String s = "}]()[{";
        RotateParentheses rotateParentheses = new RotateParentheses();
        System.out.println(rotateParentheses.solution(s));
    }
}
