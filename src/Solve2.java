import java.util.Scanner;

public class Solve2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] chessBoard = new int[8][8];
        printBoard(chessBoard);
        Task(chessBoard);
    }
    public static void Task(int[][] chessBoard){
        System.out.println("Введите расположение коня");
        System.out.print("Горизонтально: ");
        int horizontal = sc.nextInt();
        System.out.print("Вертикально: ");
        int vertical = sc.nextInt();
        if(horizontal >= 1 && horizontal <= 8 && vertical >= 1 && vertical <= 8 ){
            System.out.printf("Ваше распалажение: [%s,%s]\n", horizontal, vertical);
            chessBoard[vertical-1][horizontal-1] = 1;
            printBoard(chessBoard);
            System.out.println("Введите ход коня");
            System.out.print("Горизонтально: ");
            int horizontalMove = sc.nextInt();
            System.out.print("Вертикально: ");
            int verticalMove = sc.nextInt();
            if(horizontalMove >= 1 && horizontalMove <= 8 && verticalMove >= 1 && verticalMove <= 8 ){
                if (((horizontalMove - horizontal == 2 || horizontal - horizontalMove == 2) && (verticalMove - vertical == 1 || vertical - verticalMove == 1))
                        || ((verticalMove - vertical == 2 || vertical - verticalMove == 2 )&& (horizontalMove - horizontal == 1 || horizontal - horizontalMove == 1))) {
                    System.out.println("Ход возможен");
                    chessBoard[verticalMove-1][horizontalMove-1] = 1;
                    chessBoard[vertical-1][horizontal-1] = 0;
                    printBoard(chessBoard);
                    Continue(chessBoard,horizontalMove,verticalMove);
                }
                else {
                    System.out.println("Ход не возможен");
                }
            }else {
                System.out.println("Нет данной клетки!");
                Task(chessBoard);
            }
        }
        else {
            System.out.println("Нет данной клетки!");
            Task(chessBoard);
        }
    }
    public static void printBoard(int[][] chessBoard){
        for (int i = -1; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(i == -1){
                    System.out.print("    "+(j+1));
                }
                else if(j == 0){
                    System.out.print((i+1)+" | "+chessBoard[i][j]);
                }
                else {
                    System.out.print("    "+chessBoard[i][j]);
                }
            }
            System.out.println();
        }
    }
    public static void Continue(int[][] chessBoard,int horizontal,int vertical){
        System.out.println("Введите ход коня");
        System.out.print("Горизонтально: ");
        int horizontalMove = sc.nextInt();
        System.out.print("Вертикально: ");
        int verticalMove = sc.nextInt();
        if(horizontalMove >= 1 && horizontalMove <= 8 && verticalMove >= 1 && verticalMove <= 8 ){
            if (((horizontalMove - horizontal == 2 || horizontal - horizontalMove == 2) && (verticalMove - vertical == 1 || vertical - verticalMove == 1))
                    || ((verticalMove - vertical == 2 || vertical - verticalMove == 2 )&& (horizontalMove - horizontal == 1 || horizontal - horizontalMove == 1))) {
                System.out.println("Ход возможен");
                chessBoard[verticalMove-1][horizontalMove-1] = 1;
                chessBoard[vertical-1][horizontal-1] = 0;
                printBoard(chessBoard);
                Continue(chessBoard,horizontalMove,verticalMove);
            }
            else {
                System.out.println("Ход не возможен");
            }
        }else {
            System.out.println("Нет данной клетки!");
            Continue(chessBoard,horizontal,vertical);
        }
    }
}
