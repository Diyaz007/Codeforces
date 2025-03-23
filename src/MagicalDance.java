import java.util.*;

public class MagicalDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.next();

        char[] directions = {'N', 'E', 'S', 'W'};
        int maxMatches = 0;

        for (char startDirection : directions) {
            int matches = 0;
            char currentDirection = startDirection;

            for (int i = 0; i < n; i++) {
                char leftTurn = turnLeft(currentDirection);
                char rightTurn = turnRight(currentDirection);
                if (leftTurn == s.charAt(i)) {
                    currentDirection = leftTurn;
                } else if (rightTurn == s.charAt(i)) {
                    currentDirection = rightTurn;
                }
                if (currentDirection == s.charAt(i)) {
                    matches++;
                }
            }

            maxMatches = Math.max(maxMatches, matches);
        }

        System.out.println(maxMatches);
    }

    private static char turnLeft(char dir) {
        switch (dir) {
            case 'N': return 'W';
            case 'W': return 'S';
            case 'S': return 'E';
            case 'E': return 'N';
        }
        return dir;
    }
    private static char turnRight(char dir) {
        switch (dir) {
            case 'N': return 'E';
            case 'E': return 'S';
            case 'S': return 'W';
            case 'W': return 'N';
        }
        return dir;
    }
}
