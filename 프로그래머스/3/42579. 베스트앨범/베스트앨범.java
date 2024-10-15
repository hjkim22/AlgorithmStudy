import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {   
        Map<String, List<Song>> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            if(map.get(genres[i]) == null) {
                map.put(genres[i], new ArrayList<>());
            }            
            map.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        List<Genre> list = new ArrayList<>();
        for(String s : map.keySet()) {
            int sum = 0;
            for(int i = 0; i < map.get(s).size(); i++) {
                sum += map.get(s).get(i).play;
            }
            list.add(new Genre(s, sum));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            String key = list.get(i).name;
            int size = map.get(key).size();
            Collections.sort(map.get(key), Collections.reverseOrder());
            for(int j = 0; j < size; j++) {
                if(j == 2) {
                    break;
                }
                result.add(map.get(key).get(j).id); // 결과에 노래 고유 번호 저장
            }
        }        
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}

class Genre implements Comparable<Genre> {
    String name;
    int totalPlay;
    public Genre(String name, int totalPlay) {
        this.name = name;
        this.totalPlay = totalPlay;
    }
    
    @Override
    public int compareTo(Genre other) {
        return totalPlay - other.totalPlay;
    }
}

class Song implements Comparable<Song> {
    int id, play;
    public Song(int id, int play) {
        this.id = id;
        this.play = play;
    }
    
    @Override
    public int compareTo(Song other) {
        return play - other.play;
    }
}