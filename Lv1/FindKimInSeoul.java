package Lv1;

import java.util.Arrays;

/**
 *  프로그래머스 : 서울에서 김서방 찾기
 *
 *  문제 설명
 *
 *  String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수,
 *  solution을 완성하세요. seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
 *
 *  제한 사항
 *  - seoul은 길이 1 이상, 1000 이하인 배열입니다.
 *  - seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
 *  - "Kim"은 반드시 seoul 안에 포함되어 있습니다.
 *
 *  풀이 과정
 *  - indexOf 메소드를 이용해 "Kim"의 위치를 찾고 만들어야 하는 텍스트 문자열에 연결해 리턴한다
 */
public class FindKimInSeoul {
    public String solution(String[] seoul) {
        final String name = "Kim";
        return "김서방은 " + Arrays.asList(seoul).indexOf(name) + "에 있다";
    }

    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};
        FindKimInSeoul findKimInSeoul = new FindKimInSeoul();
        System.out.println(findKimInSeoul.solution(seoul));
    }
}
