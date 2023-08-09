package Lv2;

import java.util.HashMap;
import java.util.Map;

/**
 *  프로그래머스 : 전화번호 목록
 *
 *  문제 설명
 *
 *  전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
 *  어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 *
 *  풀이 과정
 *  - 전화번호부들을 Map의 키값으로 넣음
 *  - 전화번호부들을 반복문으로 돌려서 찾기
 *  - 전화번호부를 substring으로 자른 값들을 Map의 containsKey 메소드를 통해 있다면 false 리턴
 * */

public class Phone {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> phoneList = new HashMap<>();
        for (String phone : phone_book){
            phoneList.put(phone, 0);
        }
        for (String phone : phone_book) {
            for (int i = 0; i < phone.length(); i++) {
                if(phoneList.containsKey(phone.substring(0,i))){
                    return false;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        Phone phone = new Phone();
        System.out.println(phone.solution(phone_book));
    }
}