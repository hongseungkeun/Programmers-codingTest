package Lv1;

import java.util.Arrays;

/**
 *  프로그래머스 : 문자열 내 마음대로 정렬하기
 *
 *  문제 설명
 *
 *  문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
 *  예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
 *
 *  제한 조건
 *  - strings는 길이 1 이상, 50이하인 배열입니다.
 *  - strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
 *  - strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
 *  - 모든 strings의 원소의 길이는 n보다 큽니다.
 *  - 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
 *
 *  풀이 과정
 *  - Comparator를 람다식을 이용해 조건 정렬
 *      - 인덱스 위치의 문자가 같다면 사전순으로 정렬
 *      - 아니라면 인덱스 위치 기준으로 정렬
 */

public class SortTheStringAsIWant {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if (o1.split("")[n].equals(o2.split("")[n])) {
                return o1.compareTo(o2);
            }
            return o1.split("")[n].compareTo(o2.split("")[n]);
        });
        return strings;
    }

    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 1;
        SortTheStringAsIWant sortTheStringAsIWant = new SortTheStringAsIWant();
        System.out.println(Arrays.toString(sortTheStringAsIWant.solution(strings, n)));
    }
}
