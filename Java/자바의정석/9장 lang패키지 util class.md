### 9-1

```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class Study2 {
    public static void main(String[] args) {
        SutdaCard c1 = new SutdaCard(3,true);
        SutdaCard c2 = new SutdaCard(3,true);
        System.out.println("c1="+c1);
        System.out.println("c2="+c2);
        System.out.println("c1.equals(c2):"+c1.equals(c2));

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
        if(obj instanceof SutdaCard){
            if(this.num==((SutdaCard) obj).num&&this.isKwang==((SutdaCard) obj).isKwang){
                return true;
            }
            else return false;
        }
        else return false;
    }
    public String toString() {
        return num + ( isKwang ? "K":"");
    }
}
```

