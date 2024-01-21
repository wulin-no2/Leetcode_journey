class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        // BFS. Use Map<String, List<String>> to represent the graph;
        // key is pattern; value is the neighborWords;
        Map<String, List<String>> adjList = buildAdjacencyList(wordList, beginWord);
        // store adjacent nodes;
        Queue<String> queue = new LinkedList<>();
        // memoization;
        Set<String> visited = new HashSet<>();
        
        queue.offer(beginWord);
        visited.add(beginWord);
        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String currentWord = queue.poll();
                for (int i = 0; i < currentWord.length(); i++) {
                    String newWord = currentWord.substring(0, i) + '*' + currentWord.substring(i + 1);
                    for (String adjacentWord : adjList.getOrDefault(newWord, new ArrayList<>())) {
                        if (adjacentWord.equals(endWord)) {
                            return step + 1;
                        }
                        if (!visited.contains(adjacentWord)) {
                            queue.offer(adjacentWord);
                            visited.add(adjacentWord);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private Map<String, List<String>> buildAdjacencyList(List<String> wordList, String beginWord) {
        // why the patterns are key? cause different patterns may match multiple words; these multiple words are both neighbors;
        Map<String, List<String>> adjList = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1);
                List<String> adjacentWords = adjList.getOrDefault(newWord, new ArrayList<>());
                adjacentWords.add(word);
                adjList.put(newWord, adjacentWords);
            }
        }
        return adjList;
    }
}
