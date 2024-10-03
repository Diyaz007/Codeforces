import java.util.Scanner;

public class TaskHomeWork {
    public static void main(String[] args) {

        //FirstTask
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите цифру: ");
        int n = sc.nextInt();
        String[] name = {"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int cycle = 0;
        int roundTotal = 0;

        while (roundTotal < n) {
            cycle++;
            roundTotal = 5 * (int) (Math.pow(2, cycle) - 1);
        }

        int Round1 = 5 * (int) (Math.pow(2, cycle - 1) - 1);
        int Round2 = n - Round1;
        int index = (Round2 - 1) / (int) (Math.pow(2, cycle - 1));

        System.out.println(name[index]);

        //Second Task
        System.out.println("Second Task");
        Hanoi(3, 'A', 'B', 'C');

        //Third Task
        System.out.println("Third Task");
        System.out.print("Введите число: ");
        int inputNumber = sc.nextInt();
        int number = inputNumber;
        String binaryString = "";
        if (number == 0) {
            binaryString = "0";
        }else {
            while (number > 0) {
                binaryString = (number % 2) + binaryString;
                number = number / 2;
            }
        }
        System.out.println("Двоичное представление числа " + inputNumber + ": " + binaryString);

    }

    public static void Hanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            System.out.println("Переместить диск 1 с " + fromRod + " на " + toRod);
            return;
        }
        Hanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Переместить диск " + n + " с " + fromRod + " на " + toRod);
        Hanoi(n - 1, auxRod, toRod, fromRod);
    }




}
