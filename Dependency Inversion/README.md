### Dependency Inversion Principle (DIP)

We use DIP to effectively decouple components.

_**High level modules should not depend on low level modules, both should depend on abstractions.**_  
_**Abstractions should not depend on details. Details should depend upon abstractions.**_

##### What does it mean by "high level" modules?

Modules that define _what_ the software should do, written to solve real problem and use cases. Its abstract and map to the business domain.

##### What does it mean by "low level" modules?

Modules that define _how_ the software do, contain implementation details that are required to execute the business policies. For example logging, data access, I/O, network communication.

##### Abstraction

Every change to an abstraction corresponds to a change to its concrete implementations. Conversely, changes to concrete implementations do not always, or even usually, require changes to the interfaces that they implement.  
Therefore, abstraction are less volatile than implementations.

Good software design is reducing volatility of abstraction.

##### Bad DIP

```java
class MovieLister {
    public Movie[] moviesDirectedBy(String arg) {
        // depend on finder low level module
        List allMovies = finder.findAll();
        for (Iterator it = allMovies.iterator(); it.hasNext(); ) {
            Movie movie = (Movie) it.next();
            if (!movie.getDirector().equals(arg)) it.remove();
        }
        return (Movie[]) allMovies.toArray(new Movie[allMovies.size()]);
    }
}
```

##### Good DIP

```java
public interface MovieFinder {
    List findAll();
}
class MovieLister {
    // depend on low level abstraction
    private MovieFinder finder;
    public MovieLister(MovieFinder finder) {
        this.finder = finder;
    }
}
```

![dip image](https://github.com/bluething/solid/blob/master/images/dip.png?raw=true)

##### When to violate DIP?

We can ignore or violate DIP if and only if we depend on very stable concrete implementation. For example String class in Java.  
What the meaning of stable? The changes are very rare and tightly controlled.

#### Dependency Injection (DI)

Not same as dependency inversion!

The basic idea of the Dependency Injection is to have a separate object, an _assembler_, that populates a field in the class with an appropriate implementation for the interface.  
There are three types of injection:  
1. Constructor Injection.  
2. Setter Injection.  
3. Interface Injection.

#### Inversion of Control (IoC)

Inversion of control is a design principle in which the control of object creation, configuration and lifecycle passed to a container or framework.  
No "new" in our code. IoC container will create the object for us (in Spring we called bean). It makes sense to use it for some objects in an application (service, data access, controllers), but not for value objects or entities.

##### What the benefit of IoC?

1. It's easy to switch between implementations at runtime.  
2. Increased program modularity.  
3. Manages the lifecycles of objects and their configuration.

_**The DIP, DI, and IoC are the most effective ways to eliminate code coupling and keep systems easy to maintain and evolve.**_

### Additional reading

[Inversion of Control Containers and the Dependency Injection pattern](https://martinfowler.com/articles/injection.html)  
[Spring IoC Container](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans)