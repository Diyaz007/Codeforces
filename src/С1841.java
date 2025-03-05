import java.util.Scanner;

public class С1841 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            StringBuilder s = new StringBuilder(sc.next());
            int a = -1, b = -1, c = -1, d = -1, e = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'A' && a == -1) {
                    a = i;
                } else if (s.charAt(i) == 'B' && b == -1) {
                    b = i;
                } else if (s.charAt(i) == 'C' && c == -1) {
                    c = i;
                } else if (s.charAt(i) == 'D' && d == -1) {
                    d = i;
                } else if (s.charAt(i) == 'E' && e == -1) {
                    e = i;
                }
            }
            int res = calculate(s);
            if (a != -1) {
                s.setCharAt(a, 'B');
                res = Math.max(res, calculate(s));
                s.setCharAt(a, 'C');
                res = Math.max(res, calculate(s));
                s.setCharAt(a, 'D');
                res = Math.max(res, calculate(s));
                s.setCharAt(a, 'E');
                res = Math.max(res, calculate(s));
                s.setCharAt(a, 'A');
            }
            if (b != -1) {
                s.setCharAt(b, 'C');
                res = Math.max(res, calculate(s));
                s.setCharAt(b, 'D');
                res = Math.max(res, calculate(s));
                s.setCharAt(b, 'E');
                res = Math.max(res, calculate(s));
                s.setCharAt(b, 'B');
            }
            if (c != -1) {
                s.setCharAt(c, 'D');
                res = Math.max(res, calculate(s));
                s.setCharAt(c, 'E');
                res = Math.max(res, calculate(s));
                s.setCharAt(c, 'C');
            }
            if (d != -1) {
                s.setCharAt(d, 'E');
                res = Math.max(res, calculate(s));
                s.setCharAt(d, 'D');
            }
            a = -1;
            b = -1;
            c = -1;
            d = -1;
            e = -1;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == 'A' && a == -1) {
                    a = i;
                } else if (s.charAt(i) == 'B' && b == -1) {
                    b = i;
                } else if (s.charAt(i) == 'C' && c == -1) {
                    c = i;
                } else if (s.charAt(i) == 'D' && d == -1) {
                    d = i;
                } else if (s.charAt(i) == 'E' && e == -1) {
                    e = i;
                }
            }

            if (e != -1) {
                s.setCharAt(e, 'A');
                res = Math.max(res, calculate(s));
                s.setCharAt(e, 'B');
                res = Math.max(res, calculate(s));
                s.setCharAt(e, 'C');
                res = Math.max(res, calculate(s));
                s.setCharAt(e, 'D');
                res = Math.max(res, calculate(s));
                s.setCharAt(e, 'E');
            }
            if (d != -1) {
                s.setCharAt(d, 'B');
                res = Math.max(res, calculate(s));
                s.setCharAt(d, 'C');
                res = Math.max(res, calculate(s));
                s.setCharAt(d, 'A');
                res = Math.max(res, calculate(s));
                s.setCharAt(d, 'D');
            }
            if (c != -1) {
                s.setCharAt(c, 'A');
                res = Math.max(res, calculate(s));
                s.setCharAt(c, 'B');
                res = Math.max(res, calculate(s));
                s.setCharAt(c, 'C');
            }
            if (b != -1) {
                s.setCharAt(b, 'A');
                res = Math.max(res, calculate(s));
                s.setCharAt(b, 'B');
            }
            System.out.println(res);
        }
    }

    public static int calculate(StringBuilder s) {
        boolean a = false, b = false, c = false, d = false, e = false;
        int total = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'A':
                    a = true;
                    if (b || c || d || e) {
                        total -= 1;
                    } else {
                        total += 1;
                    }
                    break;


                case 'B':
                    b = true;
                    if (c || d || e) {
                        total -= 10;
                    } else {
                        total += 10;
                    }
                    break;

                case 'C':
                    c = true;
                    if (d || e) {
                        total -= 100;
                    } else {
                        total += 100;
                    }
                    break;

                case 'D':
                    d = true;
                    if (e) {
                        total -= 1000;
                    } else {
                        total += 1000;
                    }
                    break;

                case 'E':
                    e = true;
                    total += 10000;
                    break;
            }
        }
        return total;
    }
}