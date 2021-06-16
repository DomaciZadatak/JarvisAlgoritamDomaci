package com.company;

import java.util.Arrays;

public class Main {

    static class Point {
        int x;
        int y;
    }

    public static class Jarvis {

        private boolean orijentacija(Point p, Point q, Point r) {
            int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

            if (val >= 0)
                return false;
            return true;
        }

        public void ispisi(Point[] points, int[] next) {
            System.out.println("\nTacke : ");
            for (int i = 0; i < next.length; i++)
                if (next[i] != -1)
                    System.out.println("(" + points[i].x + ", " + points[i].y + ")");
        }

        public void Jarvis(Point[] points)
        {
            int k = points.length;
            if (k < 3)
                return;
            int[] next = new int[k];
            Arrays.fill(next, -1);

            int leftest = 0;
            for (int i = 1; i < k; i++)
                if (points[i].x < points[leftest].x)
                    leftest = i;
            int x = leftest, c;
            do
            {
                c = (x + 1) % k;
                for (int i = 0; i < k; i++)
                    if (orijentacija(points[x], points[i], points[c]))
                        c = i;

                next[x] = c;
                x = c;
            } while (x != leftest);


            ispisi(points, next);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Jarvis jarvis = new Jarvis();

        System.out.println("Unesite broj tacaka: ");
        int n = scan.nextInt();
        Point[] points = new Point[n];
        System.out.println("Unesite "+ n +" x, y koordinata");
        for (int i = 0; i < n; i++)
        {
            points[i] = new Point();
            points[i].x = scan.nextInt();
            points[i].y = scan.nextInt();
        }
        jarvis.Jarvis(points);

    }
}
