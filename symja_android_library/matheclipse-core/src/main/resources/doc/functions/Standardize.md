## Standardize

```
Standardize(list-of-values)
```

> shifts the `list-of-values` by `Mean(list-of-values)`and scales by `StandardDeviation(list-of-values)`

```
Standardize(list-of-values, function1, function2)
```

> shifts the `list-of-values` by `function1(list-of-values)`and scales by `function2(list-of-values)`

See
* [Wikipedia - Standard score](https://en.wikipedia.org/wiki/Standard_score)

### Examples

```
>> Standardize(N(Range(5)), Mean, 1 &)
{-2.0,-1.0,0.0,1.0,2.0}");

>> Standardize(N(Range(5)), Median, InterquartileRange)
{-0.8,-0.4,0.0,0.4,0.8}
```

### Related terms 
[PrincipleComponents](PrincipleComponents.md)