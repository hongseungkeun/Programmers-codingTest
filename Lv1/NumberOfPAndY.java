package Lv1;

/**
 *  프로그래머스 : 문자열 내 p와 y의 개수
 *
 *  문제 설명
 *  대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True,
 *  다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.
 *  단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
 *
 *  풀이 과정
 *  - 문자열 s를 모두 소문자로 바꾼 후 반복을 통해 p라면 count++, y라면 count--를 해준다
 *  - count가 0이라면 true, 아니라면 false를 리턴해준다
 *
 *  - char와 string 비교는 잘 되지 않기 때문에 ''에 넣어서 비교해주자
 */

public class NumberOfPAndY {
    boolean solution(String s) {
        int count = 0;
        s = s.toLowerCase();

        for (int i = 0; i < s.length(); i++) {
            if('p' == s.charAt(i)){
                count++;
            } else if ('y' == s.charAt(i)){
                count--;
            }
        }

        return count == 0 ? true : false;
    }

    public static void main(String[] args) {
        String s = "Pyy";
        NumberOfPAndY numberOfPAndY = new NumberOfPAndY();
        System.out.println(numberOfPAndY.solution(s));
    }
}
