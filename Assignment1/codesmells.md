# Markdown

Markdown is a plain-text file format. There are lots of programming tools that use Markdown, and it's useful and
easy to learn. Hash marks (the number sign) indicate headers. Asterisks indicate lists.

# List of code smells

## Code Smell 1: 
[couplers]

### Code Smell Category: 
[feature envy]


### List of classes and line numbers involved:

[* class fishFrame
  line 31-39]


### Description:

[In Class fishFrame, we use the object”mylittefishies” from fishTank too much times.]


### Solution:

[In fishTank class, change “mylittlefishies” to a private data field.
Then, creating accessor and mutator(getter and setter methods) in fishTank.
Finally, in FishFrame class, each time using getter and setter method to call and modify.]


### Explanation
[Since we add the getter and setter method, each time when we need to access the data, 
we can use the method to access and modify the data we need.]

============================================================

## Code Smell 2: [object-orientation Abuser]

### Code Smell Category: [switch statement]

### List of classes and line numbers involved:

* [class fish
   reverseAppearance line 66-81] 

### Description:

[In this method, we state all the possible character of appearance in complex cases by switching statement. 
But many of the cases are useless and annoying.]


### Solution:

[In this class, we can use if statement to apply the transformation between “<” and ”>”.]

### Explanation

[In this class, for the appearance of fish(“><>”),  we only use “<”,”>” . 
So in this method, using if statement to transfer from these two sting will makes the methods efficient.]

============================================================

## Code Smell 3: [dispensable]

### Code Smell Category: [duplicate code]

### List of classes and line numbers involved:

* [class fish and class hungry fish
 all the methods]

### Description:

[In class hungry fish, except the appearance, most of the methods are identical with fish.]


### Solution:
[Change hungry fish as an extension of Fish class. And adding new reverseAppearance method 
in Class hungry fish with the feature of hungry fish to override the method in fish class. 
And also for the data field appearance, we need to assign another appearance for hungry fish.
]


### Explanation

[Since hungry fish class and fish class almost have the same methods and data fields, 
changing fish class as a superclass could reduce the duplicate code in hungry fish.
 Hungry fish could directly use the same code. 
 And also the only difference from this two class is the appearance field and its method reverseAppearance. 
 So defining distinct method and strings for hungry fish.]


============================================================

## Code Smell 4: [bloaters]

### Code Smell Category: [primitive obsession]

### List of classes and line numbers involved:

* [class bubble line 82-134]

### Description:

[In these lines, each time we need to change the appearance of bubble,
 the appearance need to be assign as a new string.]

### Solution:

[In this method assign “.”,”o”,”O” into three different objects.
 In the methods “floatStraingtUp”,”floatLeft”,”floatRightUp” 
 we need to change appearance between different objects.]

### Explanation

[By assigning the new objects, for each time we need to change appearance, 
instead of creating a new string, just using the objects we have already create.
]

============================================================

## Code Smell 5: [bloaters]

### Code Smell Category: 
[Large Class]

### List of classes and line numbers involved:

* [Class fishTank line 31-58]

### Description:

[In this class we need to assign different instance in the array. 
But some objects have been assign to the same location.
]

### Solution:

[Under this situation, we need to check all the locations and delete out the objects in the same locations.
]

### Explanation

[Since if we assign two object in the same location,
 the first one will be covered to be useless code. 
 So deleting the conflict code will reduce the workload and simplify the method. ]

============================================================
