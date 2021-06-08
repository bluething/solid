### Liskov Substitution Principle (LSP)

_**If S is a subtype of T, then objects of type T in a program may be replaced with objects of type S without modifying the functionality of the program.**_

_**Any object of a type must be substitutable by objects of a derived typed without altering the correctness of that program.**_

Is all about relationship between types.  
I agree in OOP, "is a" relationship is not correct. A more suitable relationship is "is substitutable by".  
"square is a rectangle" vs "is the class rectangle fully substitutable by the class square"

If it looks like a duck, quacks like a duck, but need batteries you probably have the wrong abstraction.

What happen if we have incorrect relationships between type? Side effects and unexpected bugs.

#### LSP violation

##### Empty method / functions

```java
abstract class Bird {
    abstract void fly();
}
public class Pigeon extends Bird {
    public void fly() {
        // logic to fly
    }
}
public class Ostrich extends Bird {
    public void fly() {
        // usually either:
        // empty body method
        // or
        // throw NotImplementedException
    }
}
```

Is Bird fully substitutable by Ostrich?  
Same thing happened if the parent is concrete class or interface.

##### Harden precondition

```java
class Rectangle {
    private int width;
    private int height;
    
    public int area() {
        return wdith * height;
    }
    
    public int setWidth(int width) {
        this.width = width;
    }
    public int setHeight(int height) {
        this.height = height;
    }
}
class Square extends Rectangle {
    @Override
    public int area() {
        return wdith * wdth;
    }
}
```

What happen if we use like this  
```java
Rectangle r = new Square();
r.setWidth(10);
r.setHeight(20);
assertEquals(200, r.area()); // -> failed
```

[Setter](https://github.com/bluething/cleancode/tree/main/06%20Object%20and%20Data%20Structure#never-use-getter-and-setter) provoke violation to the next level.

##### Partial implemented interfaces

```java
interface Account {
    void processLocalTransfer(double amount);
    void processInternationalTransfer(double amount);
}
class SchoolAccount implements Account {
    public void processLocalTransfer(double amount) {
        // some logic
    }
    public void processInternationalTransfer(double amount) {
        // usually either:
        // empty body method
        // or
        // throw NotImplementedException
    }
}
```

What if we use like this  
```java
Account account = new SchoolAccount();
account.processInternationalTransfer(5000); // either throw an exception or broken because empty body method
```

##### Type checking

```java
for (Task task : tasks) {
    if(t instanceOf BugFix) {
        BugFix bf = (BugFix) task;
        bf.initializeBugDescription();
        }
    task.setInprogress();
}
```

1. Preconditions cannot be strengthened in a subtype.  
2. Postconditions cannot be weakened in a subtype.  
3. Invariants of the supertype must be preserved in a subtype.  
4. History constraint (the "history rule"). Objects are regarded as being modifiable only through their methods (encapsulation). Since subtypes may introduce methods that are not present in the supertype, the introduction of these methods may allow state changes in the subtype that are not permissible in the supertype. The history constraint prohibits this.

#### How to refactor code to follow LSP

##### Eliminate incorrect relations between objects

```java
public class Pigeon {
    public void fly() {
        // logic to fly
    }
}
public class Ostrich {
    // other methods belong to ostrich
}
```

```java
interface LocalAccount {
    void processLocalTransfer(double amount);
}
interface InternationalAccount {
    void processInternationalTransfer(double amount);
}
class SchoolAccount implements LocalAccount {
    public void processLocalTransfer(double amount) {
        // some logic
    }
}
```

##### Use "Tell, don't ask!" principle to eliminate type checking and casting

```java
class BugFix extends Task {
    @Override
    public void setInprogress() {
        this.initializeBugDescription();
        super.setInprogress();
    }
}
for (Task task : tasks) {
    task.setInprogress();
}
```

##### Apply the LSP proactively

1. Make sure that a derived type can substitute its base type completely. Always ask "if this type fully substitutable by those type"  
2. Keep base class small and focused.  
3. Keep interface lean.

### Additional reading

[Tell don't ask](https://martinfowler.com/bliki/TellDontAsk.html)