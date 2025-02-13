import java.util.*;

public class GraphTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(4);
        graph.get(4).add(1);
        System.out.print("Введите количество дополнительных вершин: ");
        int extraVertices = scanner.nextInt();
        for (int i = 1; i <= extraVertices; i++) {
            int extraVertex = N + i;
            graph.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                int constantVertex = (i + j) % N + 1;
                graph.get(constantVertex).add(extraVertex);
                graph.get(extraVertex).add(constantVertex);
            }
        }
        boolean isValid = true;
        for (int i = 1; i <= N; i++) {
            if (graph.get(i).size() != 2) {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            System.out.println("Граф построен корректно.");
        } else {
            System.out.println("Граф построен некорректно.");
        }
        boolean hasValidExtraVertices = true;
        for (int i = N + 1; i <= N + extraVertices; i++) {
            if (graph.get(i).size() < 3) {
                hasValidExtraVertices = false;
                break;
            }
        }

        if (hasValidExtraVertices) {
            System.out.println("Все дополнительные вершины имеют три и более соединений.");
        } else {
            System.out.println("Некоторые дополнительные вершины имеют менее трех соединений.");
        }
        System.out.println("Граф:");
        for (int i = 1; i < graph.size(); i++) {
            System.out.print(i + ": (");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j));
                if (j < graph.get(i).size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
    }
}
