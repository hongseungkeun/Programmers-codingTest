package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  프로그래머스 : 영어 끝말잇기
 *
 *  문제 설명
 *
 *  사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때, 가장 먼저 탈락하는 사람의
 *  번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 하도록 solution 함수를 완성해주세요.
 *
 *  제한 사항
 *
 *  - 끝말잇기에 참여하는 사람의 수 n은 2 이상 10 이하의 자연수입니다.
 *  - words는 끝말잇기에 사용한 단어들이 순서대로 들어있는 배열이며, 길이는 n 이상 100 이하입니다.
 *  - 단어의 길이는 2 이상 50 이하입니다.
 *  - 모든 단어는 알파벳 소문자로만 이루어져 있습니다.
 *  - 끝말잇기에 사용되는 단어의 뜻(의미)은 신경 쓰지 않으셔도 됩니다.
 *  - 정답은 [ 번호, 차례 ] 형태로 return 해주세요.
 *  - 만약 주어진 단어들로 탈락자가 생기지 않는다면, [0, 0]을 return 해주세요.
 *
 *  풀이 과정
 *
 *  - 반복을 통해 바로 전 끝말과 현재 시작 말을 비교
 *  - 인덱스 + 1(0으로 시작했기 때문)과 n을 나눈 몫이 차례과 되고 나머지가 번호가 되는 점을 이용
 */

public class EnglishShiritori {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int answer0 = 0;
        int answer1 = 0;
        String end = "";
        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String[] word = words[i].split("");

            if(i == 0){
                end = word[word.length - 1];
                list.add(words[i]);
                continue;
            }

            if(end.equals(word[0]) && !list.contains(words[i])){
                end = word[word.length - 1];
                list.add(words[i]);
            }else{
                answer0 = i % n + 1;
                answer1 = i / n + 1;
                break;
            }
        }

        answer[0] = answer0;
        answer[1] = answer1;

        return answer;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        EnglishShiritori englishShiritori = new EnglishShiritori();
        System.out.println(Arrays.toString(englishShiritori.solution(n,words)));
    }
}