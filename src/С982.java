import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class С982 {
    static Scanner sc = new Scanner(System.in);
    static List<Integer>[] tree;
    static int maxEdges = 0;

    public static void main(String[] args) {
        int n = sc.nextInt();
        if (n % 2 != 0) {
            System.out.println(-1);
            return;
        }
        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }
        search(1, -1);
        System.out.println(maxEdges);
    }

    static int search(int node, int parent) {
        int size = 1;
        for (int neighbor : tree[node]) {
            if (neighbor != parent) {
                int subSize = search(neighbor, node);
                if (subSize % 2 == 0) {
                    maxEdges++;
                } else {
                    size += subSize;
                }
            }
        }
        return size;
    }
}
