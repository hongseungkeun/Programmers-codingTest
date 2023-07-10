package Lv1;

/**
 *  프로그래머스 : 수박수박수박수박수박수?
 *
 *  문제 설명
 *  길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수,
 *  solution을 완성하세요. 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
 *
 *  제한 조건
 *  - n은 길이 10,000이하인 자연수입니다.
 *
 *  풀이 과정
 *  - 반복문을 통해 i를 2로 나눴을 때의 나머지가 0이라면 "수"를, 아니라면 "박"을 StringBuilder를
 *    이용해 이어붙힌 후 리턴한다
 */

public class Watermelons {
    public String solution(int n) {
        final String text1 = "수";
        final String text2 = "박";
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0){
                sb.append(text1);
            } else{
                sb.append(text2);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 3;
        Watermelons watermelons = new Watermelons();
        System.out.println(watermelons.solution(n));
    }
}
