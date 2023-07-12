package Lv1;

/**
 *  프로그래머스 : 이상한 문자 만들기
 *
 *  문제 설명
 *
 *  문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
 *  각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 *
 *  제한 사항
 *  - 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
 *  - 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
 *
 *  풀이 과정
 *  - 한 글자씩 짝수라면 대문자로, 홀수라면 소문자로 변경해준다
 *  - 이 때 밑의 검사를 반복해서 진행한다
 *      - 한 글자가 끝나면 checkSpace 변수를 하나씩 올려주며 짝수인지 홀수인지 검사한다
 *      - 만약 띄어쓰기를 만난다면 checkSpace 변수를 0으로 초기화해준다
 */

public class CreateStrangeCharacters {
    public String solution(String s) {
        int checkSpace = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                sb.append("\s");
                checkSpace = 0;
                continue;
            }

            if(checkSpace % 2 == 0){
                sb.append(String.valueOf(s.charAt(i)).toUpperCase());
            }else{
                sb.append(String.valueOf(s.charAt(i)).toLowerCase());
            }

            checkSpace++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "try hello world";
        CreateStrangeCharacters createStrangeCharacters = new CreateStrangeCharacters();
        System.out.println(createStrangeCharacters.solution(s));
    }
}
