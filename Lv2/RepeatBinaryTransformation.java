package Lv2;

import java.util.Arrays;

/**
 *  프로그래머스 : 이진 변환 반복하기
 *
 *  문제 설명
 *
 *  0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
 *  - x의 모든 0을 제거합니다.
 *  - x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
 *  예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.
 *
 *  0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때,
 *  이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 *
 *  제한사항
 *  - s의 길이는 1 이상 150,000 이하입니다.
 *  - s에는 '1'이 최소 하나 이상 포함되어 있습니다.
 *
 *  풀이 과정
 *  - 해당 내용을 문자열 s의 길이가 1이 될 때까지 반복한다
 *      - 문자열 s에 들어있는 0의 개수를 더한다
 *      - 문자열 s의 들어있는 0을 모두 제거한다
 *      - 0을 제거한 문자열 s의 길이를 2진수로 변환한다
 *      - 반복한 횟수를 증가해준다
 *  - 문자열 s의 길이가 1이 되었다면 반복을 종료하고 {반복한 횟수, 0의 총 개수}를 리턴한다
 */

public class RepeatBinaryTransformation {
    private static int count = 0;
    private static int countZero = 0;
    private static String string;

    public int[] solution(String s) {
        string = s;

        while (string.length() != 1) {
            calCountOfZero();
            calculation();
            count++;
        }

        return new int[] {count, countZero};
    }

    private static void calCountOfZero(){
        countZero += (int) string.chars().filter(c -> c == '0').count();
    }

    private static void calculation() {
        replaceZeroToEmpty();
        convertToBinary();
    }

    private static void replaceZeroToEmpty() {
        string = string.replaceAll("0", "");
    }

    private static void convertToBinary() {
        string = Integer.toBinaryString(string.length());
    }

    public static void main(String[] args) {
        String s = "110010101001";
        RepeatBinaryTransformation repeatBinaryTransformation = new RepeatBinaryTransformation();
        System.out.println(Arrays.toString(repeatBinaryTransformation.solution(s)));
    }
}
