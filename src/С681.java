import java.util.*;

public class С681 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<String> operations = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            operations.add(scanner.nextLine());
        }

        List<String> result = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (String op : operations) {
            if (op.startsWith("insert")) {
                int x = Integer.parseInt(op.split(" ")[1]);
                heap.offer(x);
                result.add(op);
            } else if (op.startsWith("getMin")) {
                int x = Integer.parseInt(op.split(" ")[1]);
                while (!heap.isEmpty() && heap.peek() < x) {
                    heap.poll();
                    result.add("removeMin");
                }
                if (heap.isEmpty() || heap.peek() != x) {
                    heap.offer(x);
                    result.add("insert " + x);
                }
                result.add(op);
            } else if (op.equals("removeMin")) {
                if (heap.isEmpty()) {
                    result.add("insert 0");
                    heap.offer(0);
                }
                heap.poll();
                result.add(op);
            }
        }

        System.out.println(result.size());
        for (String res : result) {
            System.out.println(res);
        }
    }
}