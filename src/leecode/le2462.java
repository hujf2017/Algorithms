package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/11/8 11:47
 * @Description TODO
 */
public class le2462 {

    public long totalCost(int[] costs, int k, int candidates) {
        if (costs.length == 1) {
            return costs[0];
        }
        long count = 0;
        TreeMap<Integer, Set<Integer>> map = new TreeMap();
        TreeMap<Integer, Set<Integer>> map2 = new TreeMap();
        //前K个 和  后K个

        int left = 0;
        int right = costs.length - 1;
        int num = 0;
        while (left < right && num < candidates) {
            Set<Integer> orDefault = map.getOrDefault(costs[left], new LinkedHashSet<>());
            orDefault.add(left);
            map.put(costs[left], orDefault);
            left++;

            Set<Integer> orDefaul2 = map2.getOrDefault(costs[right], new LinkedHashSet<>());
            orDefaul2.add(right);
            map2.put(costs[right], orDefaul2);
            right--;

            num++;
        }
        //k 轮
        for (int i = 0; i < k; i++) {
            //找到第一个
            Iterator<Map.Entry<Integer, Set<Integer>>> iterator = map.entrySet().iterator();
            Iterator<Map.Entry<Integer, Set<Integer>>> iterator1 = map2.entrySet().iterator();
            Integer key;
            Integer key1;
            Map.Entry<Integer, Set<Integer>> next2 = null;
            Map.Entry<Integer, Set<Integer>> next = null;
            if (!iterator.hasNext()) {
                next2 = iterator1.next();
                key1 = next2.getKey();
                key = Integer.MAX_VALUE;
            } else if (!iterator1.hasNext()) {
                next = iterator.next();
                key = next.getKey();
                key1 = Integer.MAX_VALUE;
            } else {
                next = iterator.next();
                next2 = iterator1.next();
                key = next.getKey();
                key1 = next2.getKey();
            }


            if (key < key1) {
                Set<Integer> value = next.getValue();
                Integer next1 = value.iterator().next();
                count += key;
                value.remove(next1);
                if (value.size() == 0) {
                    map.remove(key);
                }
                if (left <= right) {
                    Set<Integer> orDefault = map.getOrDefault(costs[left], new LinkedHashSet<>());
                    orDefault.add(left);
                    map.put(costs[left], orDefault);
                    left++;
                }
            } else if (key.equals(key1)) {
                Set<Integer> value = next.getValue();
                Set<Integer> value2 = next2.getValue();
                count += key;
                Integer index1 = value.iterator().next();
                Integer index2 = value2.iterator().next();
                if (index1 < index2) {
                    value.remove(index1);
                    if (value.size() == 0) {
                        map.remove(key1);
                    }
                    if (left <= right) {
                        Set<Integer> orDefault = map.getOrDefault(costs[left], new LinkedHashSet<>());
                        orDefault.add(left);
                        map.put(costs[left], orDefault);
                        left++;
                    }
                } else if (index1.equals(index2)) {
                    value.remove(index1);
                    if (value.size() == 0) {
                        map.remove(key1);
                    }
                    value2.remove(index2);
                    if (value2.size() == 0) {
                        map2.remove(key1);
                    }
                } else {

                    value2.remove(index2);
                    if (value2.size() == 0) {
                        map2.remove(key1);
                    }
                    if (left <= right) {
                        Set<Integer> orDefault = map2.getOrDefault(costs[right], new LinkedHashSet<>());
                        orDefault.add(right);
                        map2.put(costs[right], orDefault);
                        right--;
                    }
                }

            } else {
                Set<Integer> value = next2.getValue();
                Integer next1 = value.iterator().next();
                count += key1;
                value.remove(next1);
                if (value.size() == 0) {
                    map2.remove(key1);
                }

                if (left <= right) {
                    Set<Integer> orDefault = map2.getOrDefault(costs[right], new LinkedHashSet<>());
                    orDefault.add(right);
                    map2.put(costs[right], orDefault);
                    right--;
                }
            }

        }

        return count;

    }


//        //第i轮开始
//        for(int i=0;i<k;i++){
//            //找前面的candidates 个
//            int mii = Integer.MAX_VALUE;
//            int index = -1;
//            for(int j=0;j<candidates&&j<list.size();j++){
//                if(mii>list.get(j)){
//                    index = j;
//                    mii = list.get(j);
//                }
//            }
//
//            for(int j=0;j<candidates&&j<list.size();j++){
//                int num =list.size()-1;
//                if(mii>list.get(num-j)){
//                    index = num-j;
//                    mii = list.get(num-j);
//                }
//            }
//            count+=mii;
//            list.remove(index);
//        }

    @Test
    public void t() {
        totalCost(new int[]{57}, 1, 1);
    }

    public long totalCost2(int[] costs, int k, int candidates) {

        PriorityQueue<Worker> queue = new PriorityQueue<Worker>(new Comparator<Worker>() {

            @Override
            public int compare(Worker o1, Worker o2) {
                if (o1.cost == o2.cost) {
                    return o1.index - o2.index;
                }
                return o1.cost - o2.cost;
            }
        });
        int left = 0;
        int right = costs.length - 1;
        int num = 0;
        while (left <= right && num < candidates) {
            if (left == right) {
                Worker worker = new Worker(costs[left], left);
                queue.add(worker);
            } else {
                Worker worker = new Worker(costs[left], left);
                Worker worker2 = new Worker(costs[right], right);
                queue.add(worker);
                queue.add(worker2);
                left++;
                right++;
            }
        }

        int count = 0;
        for (int i = 0; i < k; i++) {
            Worker poll = queue.poll();
            int index = poll.index;
            count += poll.cost;
            //
            if (left <= right) {
                if (index < left) {
                    Worker worker = new Worker(costs[left], left);
                    queue.add(worker);
                    left++;
                } else {
                    Worker worker = new Worker(costs[right], right);
                    queue.add(worker);
                    right--;
                }
            }
        }
        return count;
    }

    class Worker {
        public int cost;
        public int index;

        public Worker(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }
    }
}

