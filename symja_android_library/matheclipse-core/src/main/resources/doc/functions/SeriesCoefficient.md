## SeriesCoefficient

```
SeriesCoefficient(expr, {x, x0, n})
```

> get the coefficient of `(x- x0)^n` at the point `x = x0`

See:
* [Wikipedia - Taylor series](https://en.wikipedia.org/wiki/Taylor_series)
* [Wikipedia - Big O notation](https://en.wikipedia.org/wiki/Big_O_notation)
* [Wikipedia - Formal power series](https://en.wikipedia.org/wiki/Formal_power_series)

### Examples

```
>> SeriesCoefficient(Sin(x),{x,f+g,n}) 
Piecewise({{Sin(f+g+1/2*n*Pi)/n!,n>=0}},0)
```

### Related terms
[ComposeSeries](ComposeSeries.md), [InverseSeries](InverseSeries.md), [Series](Series.md), [SeriesData](SeriesData.md)