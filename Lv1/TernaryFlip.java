package Lv1;

/**
 *  프로그래머스 : 3진법 뒤집기
 *
 *  문제 설명
 *
 *  자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후,
 *  이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *  - Integer.toString()를 이용해 10진수를 3진수로 변경한다
 *  - 3진수로 변경된 문자열을 StringBuffer의 reverse()를 이용해서 문자열을 반전시키고 다시 10진수로 변경한다
 *
 *  - 진수를 변경해주는 메소드가 있는건 알았지만 StringBuffer를 이용해 문자열을 반전시킬 수 있는 메소드가 있는 건 몰랐고
 *    반복문을 돌리려다 혹시 몰라 검색해보니 있었고 해보니 코드가 엄청 간결하게 완성됐다. 검색해보길 정말 잘한 거 같다
 */

public class TernaryFlip {
    public int solution(int n) {
        StringBuffer sb = new StringBuffer(Integer.toString(n, 3));

        return Integer.parseInt(sb.reverse().toString(), 3);
    }

    public static void main(String[] args) {
        int n = 45;
        TernaryFlip ternaryFlip = new TernaryFlip();
        System.out.println(ternaryFlip.solution(n));
    }
}
