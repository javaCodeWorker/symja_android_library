## Depth
```
Depth(expr)
```
> gives the depth of `expr`.

The depth of an expression is defined as one plus the maximum number of `Part` indices required to reach any part of `expr`, except for heads.

### Examples
```
>> Depth(x)
1
 
>> Depth(x + y)
2
 
>> Depth({{{{x}}}})
5
```
 
Complex numbers are atomic, and hence have depth 1:
```
>> Depth(1 + 2*I)
1
```
 
`Depth` ignores heads:
```
>> Depth(f(a, b)[c])
2
```

### Github

* [Implementation of Depth](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/matheclipse-core/src/main/java/org/matheclipse/core/builtin/StructureFunctions.java#L316) 
