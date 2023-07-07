package Lv1;

import java.time.LocalDate;

/**
 *  프로그래머스 : 2016년
 *
 *  문제 설명
 *
 *  2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
 *  두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
 *  요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다.
 *  예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
 *
 *  제한 조건
 *  - 2016년은 윤년입니다.
 *  - 2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
 *
 *  풀이 과정
 *  - LocalDate.of()를 이용해 2016년 날짜를 가져온다
 *  - 날짜의 요일을 substring을 이용해 3글자로 잘라낸 뒤 리턴
 */

public class YearOf2016 {
    private final int YEAR = 2016;
    private final int BEGIN_INDEX = 0;
    private final int END_INDEX = 3;

    public String solution(int a, int b) {
        LocalDate date = LocalDate.of(YEAR, a, b);
        return date.getDayOfWeek().name().substring(BEGIN_INDEX, END_INDEX);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 22;
        YearOf2016 yearOf2016 = new YearOf2016();
        System.out.println(yearOf2016.solution(a,b));
    }
}
