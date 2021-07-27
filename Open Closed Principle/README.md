### Open Closed Principle (OCP)

**_"Classes, functions and modules should be closed for modification, but open for extension."_**

##### What the meaning of "closed for modification"?

Each new feature should not modify existing source code.

##### What the meaning of "open for extension"?

A component should be extendable to make it behave in new ways.

##### Why modify an existing source code is a bad idea?

There are a chance to cascading changes in dependent class or module.

#### Why we need OCP?

1. New features can be added easily and with minimal cost.  
2. Minimize the risk of regression bugs.  
3. Enforce decoupling by isolating changes in specific components, works along with SRP.

#### How to implement OCP?

There are 2 strategy:

1. Doing inheritance. Produce coupling between child and parent, specially if the parent is a concrete class.  
2. Implement strategy pattern. I prefer this.

Applying OCP progressively:

1. Start small. Make changes inline. Bug fixes can be implemented this way.  
2. More changes. Consider inheritance.  
3. If need more flexible solution, implement strategy pattern.

#### How to implement OCP in API?

API is a contract for customer, we need to aware about backward compatibility.

1. Don't change existing public contracts: data classes, signatures.  
2. Expose abstractions to your customers and let them add new features on top of your framework.  
3. If a breaking changes is inevitable, give your clients time to adapt.