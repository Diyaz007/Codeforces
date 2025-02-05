import java.util.*;

public class ShortPath {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        HashMap<String,Integer> roads = new HashMap<>();
        String[] strings = {"A","B","C","D","E","F","G","H","Z"};
        for (int i = 0; i < strings.length; i++) {
            if(i == 8){
                for (int j = 1; j < 8; j+=2) {
                    System.out.printf("Input length of road (%s,%s): ",strings[i],strings[j]);
                    Integer length = sc.nextInt();
                    roads.put(strings[i] + strings[j], length);

                    roads.put(strings[j] + strings[i], length); // Двусторонняя дорога

                }
            }
            else if(i == 7){
                System.out.printf("Input length of road (%s,%s): ",strings[i],strings[0]);
                Integer length = sc.nextInt();
                roads.put(strings[i] + strings[0], length);
                roads.put(strings[0] + strings[i], length);
            }else {
                System.out.printf("Input length of road (%s,%s): ", strings[i], strings[i + 1]);
                Integer length = sc.nextInt();
                roads.put(strings[i] + strings[i + 1], length);
                roads.put(strings[i + 1] + strings[i], length);
            }
        }
        System.out.println(roads);
        // Чтение начальной и конечной точки
        System.out.print("Enter start point: ");
        String start = sc.next();
        System.out.print("Enter end point: ");
        String end = sc.next();

        // Поиск кратчайшего пути
        findShortestPath(strings, roads, start, end);
    }
    public static void findShortestPath(String[] nodes, HashMap<String, Integer> roads, String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        // Инициализация
        for (String node : nodes) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        queue.add(start);

        // Алгоритм Дейкстры
        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (String neighbor : nodes) {
                if (roads.containsKey(current + neighbor)) {
                    int newDist = distances.get(current) + roads.get(current + neighbor);
                    if (newDist < distances.get(neighbor)) {
                        distances.put(neighbor, newDist);
                        previous.put(neighbor, current);
                        queue.add(neighbor);
                    }
                }
            }
        }

        // Восстановление пути
        List<String> path = new ArrayList<>();
        String step = end;
        while (step != null) {
            path.add(step);
            step = previous.get(step);
        }
        Collections.reverse(path);

        // Вывод результата
        if (distances.get(end) == Integer.MAX_VALUE) {
            System.out.println("No path found.");
        } else {
            System.out.println("Shortest path: " + String.join(" -> ", path));
            System.out.println("Total distance: " + distances.get(end));
        }
    }
}
