
// 每个学生有两个属性 id 和 scores。找到每个学生最高的5个分数的平均值。
public class Solution {
    
    public Map<Integer, Double> highFive(Record[] results) {
        
        Map<Integer, Double> ans = new HashMap<Integer, Double>();
        
        if(results == null || results.length == 0) {
            return ans;
        }
        
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        
        for(Record result : results) {
            int id = result.id;
            int score = result.score;
            if(!map.containsKey(id)) {
                map.put(id, new PriorityQueue<Integer>(5, (a, b) -> a - b));
            }
            
            PriorityQueue<Integer> pq = map.get(id);
            if(pq.size() < 5) {
                pq.offer(score);
            } else {
                if(pq.peek() < score) {
                    pq.poll();
                    pq.offer(score);
                }
            }
        }
        
        for(int id : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(id);
            double avg = 0;
            for(int score : pq) {
                avg += (double)score;
            }
            avg /=  pq.size();
            ans.put(id, avg);
        }
            
        return ans;
    }
}