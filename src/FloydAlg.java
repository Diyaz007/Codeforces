public class FloydAlg {
    static final int INF = 99999;

    public static void floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        int[][] next = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        printSolution(dist, next);
    }
    private static void printSolution(int[][] dist, int[][] next) {
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    System.out.print("Кратчайший путь от " + i + " к " + j + " (длина: " + dist[i][j] + "): ");
                    printPath(i, j, next);
                    System.out.println();
                }
            }
        }
    }
    private static void printPath(int u, int v, int[][] next) {
        if (next[u][v] == -1) {
            System.out.print("Нет пути");
            return;
        }
        System.out.print(u);
        while (u != v) {
            u = next[u][v];
            System.out.print(" -> " + u);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 3, INF, INF, INF, INF},
                {INF, 0, 1, INF, INF, INF},
                {INF, INF, 0, 7, INF, 2},
                {INF, INF, INF, 0, INF, INF},
                {INF, INF, INF, 2, 0, 3},
                {INF, INF, INF, INF, INF, 0}
        };

        floydWarshall(graph);
    }
}
