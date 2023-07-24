package Lv1;

import java.util.*;

/**
 * 프로그래머스 : 개인정보 수집 유효기간
 *
 * 고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다. 약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다.
 * 당신은 각 개인정보가 어떤 약관으로 수집됐는지 알고 있습니다. 수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.
 *
 * 오늘 날짜를 의미하는 문자열 today, 약관의 유효기간을 담은 1차원 문자열 배열 terms와 수집된 개인정보의 정보를 담은 1차원 문자열 배열 privacies가
 * 매개변수로 주어집니다. 이때 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
 */
public class Validity {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer=new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();
        String[] todaySplit = today.split("\\.");
        int count = 1;
        int todayCnt=Integer.parseInt(todaySplit[0])*12*28+Integer.parseInt(todaySplit[1])*28+Integer.parseInt(todaySplit[2]);
        for(String term : terms){
            String[] termSplit = term.split("\\s");
            termsMap.put(termSplit[0],Integer.parseInt(termSplit[1]));
        }
        for(String privacy : privacies){
            String[] privacySplit = privacy.split("\\s");
            int[] intPrivacy = Arrays.stream(privacySplit[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
            Integer termInteger = termsMap.get(privacySplit[1]);
            int i = intPrivacy[1] + termInteger;
            int temp=intPrivacy[0]*12*28+i*28+intPrivacy[2]-1;

            if(todayCnt>temp){
                answer.add(count);
            }
            count++;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        Validity validity = new Validity();
        System.out.println(Arrays.toString(validity.solution(today, terms, privacies)));
    }
}
