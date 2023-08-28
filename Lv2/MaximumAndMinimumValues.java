package Lv2;

import static java.util.Arrays.stream;

/**
 *  프로그래머스 : 최댓값과 최솟값
 *
 *  문제 설명
 *
 *  문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
 *  예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
 *
 *  제한 조건
 *  - s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
 *
 *  풀이 과정
 *  - 문자열 s의 공백으로 구분된 숫자를 int 배열에 넣는다
 *  - int 배열의 최댓값, 최솟값을 StringBuilder에 (최솟값) (최댓값) 형태로 넣어준다
 */

public class MaximumAndMinimumValues {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int[] arr = stream(s.split("\\s")).mapToInt(Integer::parseInt).toArray();

        sb.append(stream(arr).min().getAsInt());
        sb.append(" ");
        sb.append(stream(arr).max().getAsInt());

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        MaximumAndMinimumValues maximumAndMinimumValues = new MaximumAndMinimumValues();
        System.out.println(maximumAndMinimumValues.solution(s));
    }
}
