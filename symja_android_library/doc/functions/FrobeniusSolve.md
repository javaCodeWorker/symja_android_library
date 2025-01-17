## FrobeniusSolve

```
FrobeniusSolve({a1, ... ,aN}, M)
```

> get a list of solutions for the Frobenius equation given by the list of integers `{a1, ... ,aN}` and the non-negative integer `M`.

The Frobenius problem, also known as the postage-stamp problem or the money-changing problem, is an integer programming problem that seeks nonnegative integer solutions to `x1*a1 + ... + xN*aN = M` where `ai` and `M` are positive integers.
In particular, the Frobenius number `FrobeniusNumber({a1, ... ,aN})`, is the largest `M` so that this equation fails to have a solution.

See: 
* [Wikipedia - Coin problem](https://en.wikipedia.org/wiki/Coin_problem)
* [Wikipedia - Partition (number theory)](https://en.wikipedia.org/wiki/Partition_(number_theory))
* [Wikipedia - Diophantine equation](https://en.wikipedia.org/wiki/Diophantine_equation)

### Examples

Solve the diophantine equation `2*x + 3*y + 4*z == 29`:

```
>> FrobeniusSolve({2, 3, 4}, 29)
{{0,3,5},{0,7,2},{1,1,6},{1,5,3},{1,9,0},{2,3,4},{2,7,1},{3,1,5},{3,5,2},{4,3,3},{
4,7,0},{5,1,4},{5,5,1},{6,3,2},{7,1,3},{7,5,0},{8,3,1},{9,1,2},{10,3,0},{11,1,1},{
13,1,0}}
```

### Related terms 
[FrobeniusNumber](FrobeniusNumber.md), [IntegerPartitions](IntegerPartitions.md) 

### Github

* [Implementation of FrobeniusSolve](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/matheclipse-core/src/main/java/org/matheclipse/core/reflection/system/FrobeniusSolve.java#L58) 
