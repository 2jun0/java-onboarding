package onboarding;

import java.util.*;

public class Problem7 {

    public static int getRecommendScore(int cntOfSameFriendsWithMe, int cntOfVisit) {
        return cntOfSameFriendsWithMe * 10 + cntOfVisit;
    }

    public static Set<String> getAllCrews(List<List<String>> friendRelations, List<String> visitors) {
        HashSet<String> allCrews = new HashSet<>();

        // 관계에 있는 모든 크루들 저장
        friendRelations.forEach(friendRelation -> allCrews.addAll(friendRelation));
        // 관계가 없는 크루도 있으니 방문한 크루들도 저장
        visitors.forEach(visitor -> allCrews.add(visitor));

        return allCrews;
    }

    public static Map<String, Set<String>> createFriendGraph(Set<String> crews, List<List<String>> friendRelations) {
        HashMap<String, Set<String>> friendGraph = new HashMap<>();

        // init graph
        crews.forEach(crew -> friendGraph.put(crew, new HashSet<>()));

        // add line in graph
        friendRelations.forEach(friendRelation -> {
            String crew1 = friendRelation.get(0);
            String crew2 = friendRelation.get(1);

            friendGraph.get(crew1).add(crew2);
            friendGraph.get(crew2).add(crew1);
        });

        return friendGraph;
    }

    public static <T> HashMap<T, Integer> getCntOfTravelCaseBfs(Map<T, Set<T>> graph, T srtNode, int targetDist) {
        // init cnfOfTravelCase
        HashMap<T, Integer> cntOfTravelCase = new HashMap<>();
        graph.keySet().forEach(node -> cntOfTravelCase.put(node, 0));

        // 시작 노드부터의 거리
        HashMap<T, Integer> dists = new HashMap<>();
        graph.keySet().forEach(node -> dists.put(node, -1));
        // node, visitedBitmask, depth
        ArrayDeque<T> queue = new ArrayDeque<>();

        // 최초 방문 노드
        cntOfTravelCase.replace(srtNode, 1);
        dists.put(srtNode, 0);
        queue.addLast(srtNode);

        while (!queue.isEmpty()) {
            T node = queue.poll();
            int dist = dists.get(node);
            int curCntOfTravelCase = cntOfTravelCase.get(node);

            if (dist >= targetDist)
                continue;

            for (T nxtNode: graph.get(node)) {
                int nxtCntOfTravelCase = cntOfTravelCase.get(nxtNode) + curCntOfTravelCase;
                cntOfTravelCase.replace(nxtNode, nxtCntOfTravelCase);

                if (dists.get(nxtNode).equals(-1)) {
                    dists.replace(nxtNode, dist+1);
                    queue.addLast(nxtNode);
                }
            }
        }

        // target
        HashMap<T, Integer> cntOfTravelCaseToTargetDist = new HashMap<>();
        cntOfTravelCase.forEach((node, cnt) -> {
            if (dists.get(node) == targetDist)
                cntOfTravelCaseToTargetDist.put(node, cnt);
        });

        return cntOfTravelCaseToTargetDist;
    }

    public static Map<String, Integer> getCntOfSameFriendsWithMeByCrew(Map<String, Set<String>> friendGraph, String me) {
        // 아래는 크루별 방문 회수
        Map<String, Integer> cntOfSameFriendsWithMeByCrew = getCntOfTravelCaseBfs(friendGraph, me, 2);
        return cntOfSameFriendsWithMeByCrew;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
