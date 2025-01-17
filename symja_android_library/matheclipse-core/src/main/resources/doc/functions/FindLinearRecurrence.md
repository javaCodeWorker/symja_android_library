## FindLinearRecurrence

```
FindLinearRecurrence(list)
```

> compute a minimal linear recurrence which returns list.

See
* [Wikipedia - Recurrence relation](https://en.wikipedia.org/wiki/Recurrence_relation)
* [OEIS - Recurrence - Linear recurrences with constant coefficients](http://oeis.org/wiki/Recurrence#Linear_recurrences_with_constant_coefficients)

### Examples
 
```
>> FindLinearRecurrence({1, 2, 4, 7, 28, 128, 582, 2745, 13021, 61699, 292521, 1387138}) 
{5,-2,6,-11}
```
