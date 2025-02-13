import java.util.*;

public class task1 {
    private static final Random RANDOM = new Random();
    private static final Map<Integer, Set<Integer>> graph = new HashMap<>();
    private static int nextVertex = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество новых вершин: ");
        int newNodes = scanner.nextInt();
        scanner.close();

        initializeBaseGraph();
        boolean success = addNewNodes(newNodes);

        if (success) {
            printGraph();
        } else {
            System.out.println("Невозможно добавить все вершины с 3+ соединениями.");
        }
    }

    // Инициализация 4 базовых вершин
    private static void initializeBaseGraph() {
        for (int i = 1; i <= 4; i++) {
            graph.put(i, new HashSet<>());
        }

        // Соединяем стартовые вершины (каждая строго с 2 другими)
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(3, 4);
        addEdge(4, 1);
    }

    // Добавление новых вершин
    private static boolean addNewNodes(int count) {
        for (int i = 0; i < count; i++) {
            int newNode = nextVertex++;
            graph.put(newNode, new HashSet<>());

            List<Integer> existingNodes = new ArrayList<>(graph.keySet());
            existingNodes.remove(Integer.valueOf(newNode)); // Исключаем саму новую вершину
            existingNodes.removeIf(node -> graph.get(node).size() == 2 && node <= 4); // Убираем базовые вершины (1-4), если у них уже 2 соединения

            if (existingNodes.size() < 3) {
                return false; // Если нет 3+ доступных вершин, невозможно добавить новую
            }

            Collections.shuffle(existingNodes); // Перемешиваем вершины для случайного соединения

            // Соединяем новую вершину ровно с 3 случайными
            for (int j = 0; j < 3; j++) {
                addEdge(newNode, existingNodes.get(j));
            }
        }
        return true;
    }

    // Добавление связи между вершинами
    private static void addEdge(int a, int b) {
        if (!graph.get(a).contains(b)) {
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
    }

    // Вывод списка смежности графа
    private static void printGraph() {
        System.out.println("Граф (список смежности):");
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
