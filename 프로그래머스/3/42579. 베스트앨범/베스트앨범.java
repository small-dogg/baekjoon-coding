import java.util.*;

class Solution {
     private class Song {
        int idx;
        int play;

        public Song(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        //장르별 총 재생수
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        //장르를 총 재생 수 기준으로 정렬
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        //장르별 노래 목록
        Map<String, List<Song>> map2 = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            List<Song> genreList = map2.getOrDefault(genres[i], new ArrayList<>());
            genreList.add(new Song(i, plays[i]));
            map2.put(genres[i], genreList);
        }

        //장르별로 노래정렬 후 최대 2곡 선택
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : list) {
            String genre = entry.getKey();
            List<Song> songs = map2.get(genre);

            // 많이 재생된 순으로 정렬, 같으면 idx 낮은 순
            songs.sort((a1, a2) -> {
                if (a1.play != a2.play) {
                    return a2.play - a1.play;
                } else {
                    return a1.idx - a2.idx;
                }
            });

            answer.add(songs.get(0).idx);
            if (songs.size() > 1) {
                answer.add(songs.get(1).idx);
            }
        }

        return answer.stream().mapToInt(a -> a).toArray();
    }
}