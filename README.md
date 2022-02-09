### My learning note about SOLID principle

![pyramidofcleancode](https://github.com/bluething/solid/blob/master/images/pyramidofcleancode.png?raw=true)

### Problem that we face in daily activity

#### Code Fragility

Fragility is the tendency of the software to break in many places every time is changed.

##### Code Rigidity

Rigidity is the tendency for software to be difficult to change even in simple way.  
Every change causes a cascade of subsequent changes in dependent modules.

### Technical debt

Both of the problems are a symptom of technical debt. Technical debt is a cost of prioritizing fast delivery over code quality for long period of time.

We have 2 choices when develop a software

###### Fast delivery

1. The easiest thing that we can do to implement a change or fix the bug.  
2. Fast
3. Poor written code.

###### Code quality

1. Takes more time to understand the system, write a good unit test or to make our component loose coupled.  
2. Adds a bit of complexity.  
3. Maintainable code.

Technical debt is costly, lower technical debt have a lower cost. The cost must manageable.  
Technical debt effect customer responsiveness, lower technical debt means we adapt quickly with user requirement.

The fact is:  
1. No matter how good the team is, technical debt will accumulate over time.  
2. If technical debt left uncontrolled, it will kill our project.  
3. Controlling technical debt is a must.

##### How to control technical debt?

1. Write code.  
2. Pay debt, refactoring. Applying SOLID, design pattern, decouple components, write more test (specially unit test).  
3. Write more code.  
4. Pay (new) debt, refactoring.

### What the benefit if we implement SOLID principle?

1. Code is easy to understand and reason about.  
2. Changes are faster and have a minimal risk.  
3. Highly maintainable over long periods of time.  
4. Cost-effective.

### How about architectural level, how can we achieve same result like implement SOLID?

1. Constant refactoring.  
2. Implement design pattern.  
3. Implement TDD.