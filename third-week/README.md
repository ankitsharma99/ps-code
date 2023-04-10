# Type Parameters:

i. T - type
ii. E - Element
iii. K - key
iv. N - Number
v. V - Value


## Wildcard Element: 

? - any thing
<? extends Number>: Any child class of Number (Integer, Float, Double)
<? super Integer>: All parent classes of Integer (Number, Object)


## Wildcard can be used as:

> Type of parameter 
> Field
> Return Type
> Local Variable


# Upper Bounded Wildcards: <? extends Number>       // accepts below hierarchy
# Lower Bounded Wildcards: <? super Number>     // accepts above hierarchy
# Unbounded Wildcards: <?>          // accepts anything