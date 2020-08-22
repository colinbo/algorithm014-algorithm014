import java.util.*;

public class TopK {

    public int[] topKFrequent(int[] nums, int k) {
        int[] topK = new int[k];
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums){
            if (!count.containsKey(num)){
                count.put(num, 1);
            }
            else {
                count.put(num, count.get(num) + 1);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer t2, Integer t1) {
                return count.get(t2) - count.get(t1);
            }
        });

        for (Map.Entry<Integer, Integer> keySet : count.entrySet()){
            if (queue.size() < k){
                queue.add(keySet.getKey());
            }
            else {
                if (keySet.getValue() > count.get(queue.peek())){
                    queue.poll();
                    queue.add(keySet.getKey());
                }
            }
        }
        for (int i = k - 1; i >= 0; i--){
            topK[i] = queue.poll();
        }

        System.out.println(Arrays.toString(topK));
        return topK;
    }

    public static void main(String[] args) {
        int[] list = {1,2,1,1,1,2,2,3,4,4,4,4,4,4,4,5};
        new TopK().topKFrequent(list, 3);
    }
}
