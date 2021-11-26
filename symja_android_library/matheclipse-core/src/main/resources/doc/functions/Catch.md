## Catch

```
Catch(expr)
```

> returns the value argument of the first `Throw(value)` generated in the evaluation of `expr`.

```
Catch(expr, form)
```

> returns value from the first `Throw(value, tag)` for which `form` matches `tag`. 

```
Catch(expr, form, f)
```

> returns `f(value, tag)`. 

### Examples

Exit to the enclosing `Catch` as soon as `Throw` is evaluated:

```
>> Catch(r; s; Throw(t); u; v)
t
```

Define a function that can "throw an exception":

```
>> f(x_) := If(x > 12, Throw(overflow), x!)
```

The result of `Catch` is just what is thrown by `Throw`:

```
>> Catch(f(1) + f(15))
overflow
     
>> Catch(f(1) + f(4))
25
```