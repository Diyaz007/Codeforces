import java.util.ArrayList;
import java.util.Scanner;

public class Bob {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minutes = scanner.nextInt();
        final int steps = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < minutes; i++) {
            list.add(scanner.nextInt());
        }

        int lenght = 0;
        int person = 0;
        int time = 0;
        for (int i = 0; i < minutes; i++) {
            lenght = lenght + list.get(i);
            if(lenght - person >= steps) {
                person = person + steps;
                time = time + 1;
            }else {
                person = person + (lenght - person);
                time = time + 1;
            }
        }
        if(lenght > person){
            time = time + divideRoundUp(lenght - person,steps);
        }

        System.out.println(time);
    }
    private static int divideRoundUp(int denominator, int divisor) {
        return (denominator + divisor - 1) / divisor;
    }
}
