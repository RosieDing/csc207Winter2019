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

[In this method, we use the object”mylittefishies” from fishTank too much times.]


### Solution:

[In fishTank class, change “mylittlefishies” into a private data field.
Then, creating accessor and mutator(getter and setter methods) in fishTank.
Finally, in FishFrame class, each time using getter and setter method to call and modify.]


### Explanation
[Since we add the getter and setter method, in each time to access the data.]

============================================================

## Code Smell 2: [object-orientation Abuser]

### Code Smell Category: [switch statement]

### List of classes and line numbers involved:

* [class fish
   reverseAppearance line 66-81] 

###Description:

[In this method, we state all the possible character of appearance in complex cases. 
But many of the cases are useless.]


### Solution:

[In this class, we can use if method to apply the transformation between “<” and ”>”.]

### Explanation

[In this class, for the appearance of fish(“><>”),  we only use “<”,”>” . 
So in this method, the if statement to transfer from these two sting will makes the methods efficient.]

============================================================

## Code Smell 3: [dispensable]

### Code Smell Category: [duplicate code]

### List of classes and line numbers involved:

* [class fish and class hungry fish
 all the methods]

### Description:

[In class hungry fish, except the appearance, many of the methods are identical with fish.]


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
 So defining distinct method and string for hungry fish.]


============================================================

## Code Smell 4: [bloaters]

### Code Smell Category: [primitive obsession]

### List of classes and line numbers involved:

* [class bubble
 line 82-134]

### Description:

[in these lines, each time we need to change the appearance of bubble,
 the appearance need to be assign to a new string.]

### Solution:

[In this method assign “.”,”o”,”O” into three objects.
 In the three method “floatStraingtUp”,”floatLeft”,”floatRightUp” 
 we need to change appearance between different objects.]

### Explanation

[By assigning the new objects, for each time we need to change appearance, 
we do not need to create a new string, just use the object we have already create.
]

============================================================

## Code Smell 5: [Write the code smell name]

### Code Smell Category: [Write the code smell category name]

### List of classes and line numbers involved:

* [Write a class and list of line numbers, one class per asterisk, that describe the smell]

### Description:

[In your own words, explain how the description of the code smell applies to this particular code.]

### Solution:

[In your own words, explain how you might solve this code smell:
how would you refactor the code?]

### Explanation

[How does your solution get rid of the code smell? Write your explanation here.]

============================================================
