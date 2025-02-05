package chapter09.readFiveTimes;

public class Practice9_2_R5 {
    public static void main(String[] args) {
        Point3D_9_2_R5 p1 = new Point3D_9_2_R5(1, 2, 3);
        Point3D_9_2_R5 p2 = new Point3D_9_2_R5(1, 2, 3);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println("p1==p2?" + (p1 == p2));
        System.out.println("p1.equals(p2) = " + (p1.equals(p2)));
    }
}

class Point3D_9_2_R5 {
    int x, y, z;

    public Point3D_9_2_R5(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Point3D_9_2_R5() {
        this(0, 0, 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point3D_9_2_R5) {
            Point3D_9_2_R5 point = (Point3D_9_2_R5) obj;
            return x == point.x && y == point.y && z == point.z;
        }

        return false;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "," + z + "]";
    }
}