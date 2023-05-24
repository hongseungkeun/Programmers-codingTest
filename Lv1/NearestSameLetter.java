package Lv1;

import java.util.*;

/**
 *  프로그래머스 : 가장 가까운 같은 글자
 *
 *  문제 설명
 *
 *  문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에
 *  있는 같은 글자가 어디 있는지 알고 싶습니다.
 *  예를 들어, s="banana"라고 할 때, a로 예를 들면
 *  - a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
 *  - a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
 *  - a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고,
 *  이는 2로 표현합니다.
 *
 *  풀이 과정
 *
 *  - 문자열을 나누고 그 나눈 배열로 반복 실행
 *  - 만약 map에 그 문자열이 존재하지 않다면 리스트에 -1을 넣어주고 map을 그 문자열과 현재 인덱스로 채움
 *  - 존재한다면 현재 인덱스와 map에 담겨있는 그 문자열의 인덱스를 뺀 값을 리스트에 넣어줌
 *  - 답으로 리스트를 리턴
 *
 *  - Map의 containsKey를 사용하여 찾아주었지만 찾을 필요없이 getOrDefault를 사용하여 문제를 풀 수
 *  있을 것 같아 풀어 봤으나 기존 방식보다 코드는 많이 줄었지만 시간 소모가 조금 더 걸려 기존 방식을 택했다.
 */

public class NearestSameLetter {
    public int[] solution(String s) {
        String[] splitLetter = s.split("");
        List<Integer> answers = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < splitLetter.length; i++) {
            if(!map.containsKey(splitLetter[i])){
                answers.add(-1);
                map.put(splitLetter[i],i);
                continue;
            }
            answers.add(i - map.get(splitLetter[i]));
            map.put(splitLetter[i],i);
//            answers.add(i - map.getOrDefault(splitLetter[i], i+1));
//            map.put(splitLetter[i],i);
        }

        return answers.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        String s = "banana";
        NearestSameLetter nearestSameLetter = new NearestSameLetter();
        System.out.println(Arrays.toString(nearestSameLetter.solution(s)));
    }
}
