### Single Responsibility Principle (SRP)

_**"Every function, class or module should have one and only one reason to change."**_

#### What the meaning of reason to change?

It's all about responsibility.

Examples of responsibility:  
1. Business logic.  
2. UI.  
3. Persistence.  
4. Logging.  
5. Orchestration.  
6. Users.

#### The benefit of SRP

1. It makes code easier to understand, fix and maintain. Most of the time we read the code instead of write.  
2. Classes are less coupled and more resilient to change. Our code will have less fragility and rigidity.  
3. More testable design.

#### How to identify multiple responsibility?

1. Have _if_ or _switch_ statements.  
2. Have a monster method, method that [do more than one thing](https://github.com/bluething/cleancode/tree/main/03%20Functions#function-should-do-one-thing).  
3. Have a god class. [Low coupling and high cohesion](https://github.com/bluething/cleancode/tree/main/10%20Classes#low-coupling-high-cohesion) is a key.  
4. Method used by multiple users.

#### What if our code have multiple responsibility?

1. Code is more difficult to read and reason about.  
2. Decreased quality due to testing difficulty.  
3. Have a side effect.  
4. High coupling. Pay attention to dependencies, abstract it as much as possible.