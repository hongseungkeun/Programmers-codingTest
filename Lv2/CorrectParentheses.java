package Lv2;

import java.util.Stack;

/**
 *  프로그래머스 : 올바른 괄호
 *
 *  문제 설명
 *
 *  괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
 *  - "()()" 또는 "(())()" 는 올바른 괄호입니다.
 *  - ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 *
 *  '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고,
 *  올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 *
 *  풀이 과정
 *  - 스택을 사용하여 괄호가 '('라면 넣어주고 ')'라면 들어있는 값을 없애는 방식으로 풀이
 *      - 만약 올바른 괄호라면 스택의 사이즈가 0
 *  - 첫 시작이 ')'라면 절대 올바른 괄호가 될 수 없으므로 시작부분에서 검사
 */

public class CorrectParentheses {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char c;

        if(s.charAt(0) == ')'){
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }

        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String s = "()()";
        CorrectParentheses correctParentheses = new CorrectParentheses();
        System.out.println(correctParentheses.solution(s));
    }
}
