package com.company;

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
    }

    public static void main(String[] args) {
	    
        
    }
}
