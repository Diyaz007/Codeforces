import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1327 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<String> ans = new ArrayList<>();
        while (t > 0){
            int n = sc.nextInt();
            int marriedgirl = 0, mboy = 0;
            List<Integer> daughter = new ArrayList<>();
            boolean[] taken = new boolean[n + 1];

            for (int i = 0; i < n; i++) {
                int j = sc.nextInt();
                boolean check = false;
                for (int k = 0; k < j; k++) {
                    int temp = sc.nextInt();
                    if (!taken[temp] && !check) {
                        taken[temp] = true;
                        check = true;
                        marriedgirl++;
                        mboy++;
                    }
                }
                if (!check) daughter.add(i + 1);
            }

            if (daughter.size() > 0) {
                for (int i = 1; i <= n; i++) {
                    if (!taken[i]) {
                        ans.add("IMPROVE");
                        ans.add(daughter.get(0) + " " + i);
                        break;
                    }
                };
            }else {
                ans.add("OPTIMAL");
            }
            t--;
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}


