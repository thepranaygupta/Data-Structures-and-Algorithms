class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            public int compare(int[] property1, int[] property2) {
                if (property1[0] != property2[0])
                    return property1[0] - property2[0];
                else
                    return property1[1] - property2[1];
            }
        });
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int[] property : properties) {
            int attack = property[0], defense = property[1];
            if (defense > map.getOrDefault(attack, 0))
                map.put(attack, defense);
        }
        int count = 0;
        int length = properties.length;
        int index = length - 2;
        while (index >= 0 && properties[index][0] == properties[index + 1][0])
            index--;
        if (index < 0)
            return 0;
        int maxDefense = properties[length - 1][1];
        for (int i = index; i >= 0; i--) {
            int attack = properties[i][0], defense = properties[i][1];
            if (defense < maxDefense)
                count++;
            if (i > 0 && attack > properties[i - 1][0]) {
                int curMaxDefense = map.get(attack);
                maxDefense = Math.max(maxDefense, curMaxDefense);
            }
        }
        return count;
    }
}