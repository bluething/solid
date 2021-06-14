### Interface Segregation Principle (ISP)

We use ISP to find right granularity level for our abstraction.

_**Clients should not be forced to depend on methods that they don't use.**_

Code dependency will force recompilation and redeployment.

The "interface" term is not only a Java interface, but also abstract classes and a public methods.

ISP is a problem in static typed language like Java and in architectural level.

![ISP at architectural level](https://github.com/bluething/solid/blob/master/images/ispatarchitecturallevel.jpg?raw=true)

What if D contains features that F does not use and, therefore, that S does not care about?  
Changes to those features within D may well force the redeployment of F and, therefore, the redeployment of S.  
Even worse, a failure of one of the features within D may cause failures in F and S.

#### The effect if we use ISP

1. If our interface is small, the class that implement them have a higher chance to fully substitute the interface (LSP). If the interface is fat, there are possibility the class that implement them not use all methods.  
2. If we depend on small interface we can more focused and tend to have a single purpose (SRP). Depending on fat interface make cohesion in our class low.

#### The benefit of ISP

1. Reduce code coupling.  
2. Our class more cohesive and focused.  
3. It reinforces teh use of SRP and LSP.

#### What is a fat interface?

##### Too many methods

![too many methods](https://github.com/bluething/solid/blob/master/images/toomanymethods.jpg?raw=true)

What if User1 only use op1()?  
Usually the class that don't use the method will throw an UnsupportedOperationException in the body.

##### Interface with low cohesion

```java
interface ShoppingCart {
    void addItem(Item item);
    void removeItem(Item item);
    void proceesPayment();
    boolean checkItemInStock(Item item);
}
```

proceesPayment() and checkItemInStock() doesn't have relation with shopping cart feature. It will violate SRP, make the class low cohesion.  
Also, its increase code coupling. The implementation will have many dependencies because they need them to do all the tasks.

#### How to refactor a fat interface?

##### If we own the interface

Break the interface then add multiple interface implementation in our class.

##### If the interface is external

Use adapter pattern.