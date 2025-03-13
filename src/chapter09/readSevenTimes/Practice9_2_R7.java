package chapter09.readSevenTimes;

public class Practice9_2_R7 {
    public static void main(String[] args) {
        Point3D9_2_R7 p1 = new Point3D9_2_R7(1, 2, 3);
        Point3D9_2_R7 p2 = new Point3D9_2_R7(1, 2, 3);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println("p1==p2?" + (p1 == p2));
        System.out.println("p1.equals(p2)?" + (p1.equals(p2)));
    }
}

class Point3D9_2_R7 {
    int x, y, z;

    public Point3D9_2_R7(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D9_2_R7() {
        this(0, 0, 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point3D9_2_R7 point) {
            return this.x == point.x && this.y == point.y && this.z == point.z;
        }

        return false;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "," + z + "]";
    }
}