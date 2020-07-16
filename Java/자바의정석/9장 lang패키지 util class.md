### 9-1

```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class Study2 {
    public static void main(String[] args) {
        SutdaCard c1 = new SutdaCard(3, true);
        SutdaCard c2 = new SutdaCard(3, true);
        System.out.println("c1=" + c1);
        System.out.println("c2=" + c2);
        System.out.println("c1.equals(c2):" + c1.equals(c2));

    }
}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public boolean equals(Object obj) {
        if (obj instanceof SutdaCard) {
            if (this.num == ((SutdaCard) obj).num && this.isKwang == ((SutdaCard) obj).isKwang) {
                return true;
            } else return false;
        } else return false;
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}
```

### 9-2

```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class Study2 {
    public static void main(String[] args) {
        Point3D p1 = new Point3D(1, 2, 3);
        Point3D p2 = new Point3D(1, 2, 3);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("p1==p2?" + (p1 == p2));
        System.out.println("p1.equals(p2)?" + (p1.equals(p2)));
    }
}

class Point3D {
    int x, y, z;

    Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Point3D() {
        this(0, 0, 0);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Point3D) {
            if (this.x == ((Point3D) obj).x && this.y == ((Point3D) obj).y && this.z == ((Point3D) obj).z) {
                return true;
            } else return false;
        } else return false;

    }

    public String toString() {
        return "[" + this.x + "," + this.y + "," + this.z + "]";
    }
}
```

### 9-3

```java
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Study2 {
    public static void main(String[] args) {
        String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java";
        String path = "";
        String fileName = "";

        path = fullPath.substring(0,14);
        fileName = fullPath.substring(15);
        System.out.println("fullPath:"+fullPath);
        System.out.println("path:"+path);
        System.out.println("fileName:"+fileName);
    }
}
```

### 9-4

```java
public class Study2 {
    static void printGraph(int[] arr, char ch) {
        for (int a : arr) {
            for (int i = 0; i < a; i++) {
                System.out.print(ch);
            }
            System.out.print(a);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printGraph(new int[]{3, 7, 1, 4}, '*');
    }
}
```

