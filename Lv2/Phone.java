package Lv2;

import java.util.HashMap;
import java.util.Map;

/**
 * 프로그래머스 : 전화번호 목록
 *
 * - 전화번호부에 적힌 전화번호에 다른 전화번호의 접두사인 경우 false, 아니면 true
 *
 * 풀이
 * - 전화번호부들을 Map의 키값으로 넣음
 * - 전화번호부들을 반복문으로 돌려서 찾기
 * - 전화번호부를 substring으로 자른 값들을 Map의 containsKey 메소드를 통해 있다면 false 리턴
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
                    phone.substring(0,i);
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