{  
  (* fungrim "dec042" *)
  Hypergeometric1F1(a_Integer,b_,z_) := Module({n=(-a)}, Sum(FactorialPower(-n,k,-1)/FunctionExpand(FactorialPower(b,k,-1)) * (z^k / Factorial(k)), {k, 0, n}) 
     /; a<0 && !(TrueQ(Element(b, Integers) && b<=0 && b>a)) ) 
  
}