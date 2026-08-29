class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Bucket: index = frequency
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : count.keySet()) {
            int frequency = count.get(num);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }

            bucket[frequency].add(num);
        }

        // Get k most frequent
        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[index] = num;
                    index++;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}