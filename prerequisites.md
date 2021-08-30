## **Prerequisites :-**

### 0. [**PROGRAMMING LANGUAGE.**](https://youtu.be/Nckx9qMy_kw)
### 1. [**CLASS AND OBJECTS.**](https://youtu.be/a199KZGMNxk?t=244)
### 2. [**CONSTRUCTOR.**](https://youtu.be/a199KZGMNxk?t=981)
### 3. [**this KEYWORD.**](https://youtu.be/a199KZGMNxk?t=1424)
### 4. [**ACCESS MODIFIERS IN JAVA.**](https://youtu.be/ZunFumWa-ZU)

- ### **Public-** The access level of the public modifier is everywhere. Methods, variables declared public can be accessed from anywhere after importing that class.
- ### **Default-** The access level of the default modifier is within the package. Methods, variables declared default can be accessed from other classes of the same package.
- ### **Private-** The access level of the private modifier is within the class. Methods, variables declared private cannot be accessed from outside the class.

### 5. [**ENCAPSULATION.**](https://youtu.be/a199KZGMNxk?t=2019)
### 6. [**STATIC KEYWORD IN JAVA.**](https://youtu.be/3LtIk7wFGi0)
### 7. [**INNER CLASS IN JAVA.**](https://youtu.be/zg1pijw6AM4)
### 8. [**Pass by value.**](https://youtu.be/H71vRa86AGg)
### 9. [**Pass by refrence.**](https://youtu.be/q_q-6KuP91c)

```java
import java.util.*;

public class Hi {

    // here value is copied in localVariable 'a'.
    public static void incrementPrimitiveDT(int a) {
        a++;
    }

    // here reference is copied, means 'input' is also pointing to 'arr'.
    public static void incrementReferenceDT(int input[]) {
        for(int i=0;i<input.length;i++) {
            input[i]++;
        }
    }


    public static void main(String[] args) {
        int i=10;
        incrementPrimitiveDT(i); // passByValue
        System.out.println(i); // 10


        int arr[]= {1,2,3,4,5};
        incrementReferenceDT(arr); // passByReference
        System.out.println(Arrays.toString(arr)); // [2, 3, 4, 5, 6]
    }
}
```

### 10. [**Strings are immutable.**](https://youtu.be/4cEsJtuW4YY)
### 11. [**== & .equals in String.**](https://youtu.be/i7vYjvJOIiw)
### 12. [**Wrapper class in java.**](https://youtu.be/nYE_P9FG1g0)
- Object creation and memory allocation in Integer class.

```JAVA
public static void main(String[] args) {
    // case 1:
    Integer i= new Integer(1);
    Integer j=new Integer(1);
    System.out.println(i==j); // false,  coz == check reference address of i and j, and here 'i' is pointing to 1 (i---> 1) and 'j' is pointing to different 1 (j---> 1)
    System.out.println(i.equals(j)); // true

    // case 2:
    Integer a=new Integer(2);
    Integer b=2;

    System.out.println(a==b); // false
    System.out.println(a.equals(b)); // true

    // case 3:
    Integer x=new Integer(3);
    Integer y=x;

    System.out.println(x==y); // true
    System.out.println(x.equals(y)); // true

    // case 4
    Integer p=128;
    Integer q=128;
    System.out.println(p==q); // false
    System.out.println(p.equals(q)); // true

    // case 5 -128 to 127 is in cached memory so they point to the same object without creating its instances.
    Integer s=50;
    Integer t=50;
    System.out.println(s==t); // true
    System.out.println(s.equals(t)); // true
}
```

### 13. [**Generics in Java.**](https://youtu.be/XMvznsY02Mk)
### 14. [**isequals and hashcode in java by codingSimplified.**](https://youtu.be/X2AjBFZfFCY)
- [**isequals and hashcode in java by AnujBhaiya.**](https://youtu.be/HRHMkQ9fWsM)
### 15. **% operator in JAVA :** **dividend % divisor** - Here two conditions are needed to be taken care of :
- **When Divedend < Divisor then answer is dividend.**
- **When Divedend > Divisor then answer lie in between [0 to divisor-1].**
### 16. **Store 2 numbers in a number.**
- To Inject B in A we ADD(+) **B\*INF** in A and store it in A, where INF is any number greater than A and B.
- to extract old number i.e., A from modified A we do (A % INF).
- to extract new number(Injected number) i.e., B from modified A we do (A / INF).
```java
int a=5;
int b=4;// number to be injected
int INF=9999;
a=a+(b*INF);
System.out.println(a%INF); // 5
System.out.println(a/INF); //4
```
<hr>
<hr>

# **Some Important basic concepts of Java by Kunal Kushwaha's Bootcamp**
## 1. Memory Allocation when you initialize a variable.
![kunalKushwaha1 1](https://user-images.githubusercontent.com/71629248/128210358-dff0df32-a25b-4c84-9bfb-9d9161127aca.png)

**Note:** When there is no reference variable pointing to the actual object then it is deleted automatically when garbage collection hits.
## 2. Objects & Reference Variable.
![kunalKushwaha1 0](https://user-images.githubusercontent.com/71629248/128210454-7d5523f3-3f0d-4046-9511-b222ffd8f17d.png)

```java
public class Demo{ 
    public static void main(String[] args) {
        Human obj=new Human();
        Human son=obj; // this is his mom who calls obj as hisSon.
        Human bro=obj; // this is his sister who calls obj as hisBro.
        son.hairCut="done"; // here his mom told him to get a haircut.
        // here his sister is also able to see his haircut.
        System.out.println(bro.hairCut); // done
    }
}
class Human{
    String name="Vikash";
    String hairCut="notDone";
}
```  
