package Lv3;

import java.util.*;

/**
 * 프로그래머스 : 베스트앨범
 *
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 *
 * 요구사항
 * - 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * - 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * - 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 *
 * 제한사항
 * - genres[i]는 고유번호가 i인 노래의 장르입니다.
 * - plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * - genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * - 장르 종류는 100개 미만입니다.
 * - 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * - 모든 장르는 재생된 횟수가 다릅니다.
 *
 */
public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        Map<String, Integer> maxForGenres = new HashMap<>();
        Map<String, Map<Integer, Integer>> maxForPlays = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();

        for(int i = 0; i < plays.length; i++) {
            if(!maxForGenres.containsKey(genres[i])) {
                Map<Integer,Integer> playList = new HashMap<>();
                playList.put(i, plays[i]);
                maxForPlays.put(genres[i], playList);
                maxForGenres.put(genres[i], plays[i]);
            } else {
                maxForPlays.get(genres[i]).put(i, plays[i]);
                maxForGenres.put(genres[i], maxForGenres.get(genres[i]) + plays[i]);
            }
        }

        List<Map.Entry<String, Integer>> genresRank = new ArrayList<>(maxForGenres.entrySet());
        genresRank.sort((o1, o2) -> o2.getValue() - o1.getValue());

        for(Map.Entry<String, Integer> rank : genresRank){
            List<Map.Entry<Integer, Integer>> play = new ArrayList<>(maxForPlays.get(rank.getKey()).entrySet());
            play.sort(((o1, o2) -> o2.getValue() - o1.getValue()));
            int count = 0;

            for (Map.Entry<Integer,Integer> playListRank : play){
                answerList.add(playListRank.getKey());
                count++;
                if(count == 2){
                    break;
                }
            }
        }
        answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        BestAlbum bestAlbum = new BestAlbum();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(bestAlbum.solution(genres, plays)));
    }
}
