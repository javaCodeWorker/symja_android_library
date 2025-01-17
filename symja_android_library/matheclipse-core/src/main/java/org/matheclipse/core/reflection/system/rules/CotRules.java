package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.patternmatching.Matcher;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface CotRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 29, 8 };

  final public static IAST RULES = List(
    IInit(Cot, SIZES),
    // Cot(Undefined)=Undefined
    ISet(Cot(Undefined),
      Undefined),
    // Cot(0)=ComplexInfinity
    ISet(Cot(C0),
      CComplexInfinity),
    // Cot(Pi/12)=2+Sqrt(3)
    ISet(Cot(Times(QQ(1L,12L),Pi)),
      Plus(C2,CSqrt3)),
    // Cot(Pi/10)=Sqrt(5+2*Sqrt(5))
    ISet(Cot(Times(QQ(1L,10L),Pi)),
      Sqrt(Plus(C5,Times(C2,CSqrt5)))),
    // Cot(Pi/8)=Sqrt(2)+1
    ISet(Cot(Times(QQ(1L,8L),Pi)),
      Plus(C1,CSqrt2)),
    // Cot(Pi/6)=Sqrt(3)
    ISet(Cot(Times(QQ(1L,6L),Pi)),
      CSqrt3),
    // Cot(Pi/5)=Sqrt(1+2/Sqrt(5))
    ISet(Cot(Times(QQ(1L,5L),Pi)),
      Sqrt(Plus(C1,Times(C2,C1DSqrt5)))),
    // Cot(Pi/4)=1
    ISet(Cot(CPiQuarter),
      C1),
    // Cot(3/10*Pi)=Sqrt(5-2*Sqrt(5))
    ISet(Cot(Times(QQ(3L,10L),Pi)),
      Sqrt(Plus(C5,Times(CN2,CSqrt5)))),
    // Cot(Pi/3)=1/Sqrt(3)
    ISet(Cot(CPiThird),
      C1DSqrt3),
    // Cot(3/8*Pi)=-1+Sqrt(2)
    ISet(Cot(Times(QQ(3L,8L),Pi)),
      Plus(CN1,CSqrt2)),
    // Cot(2/5*Pi)=Sqrt(1-2/Sqrt(5))
    ISet(Cot(Times(QQ(2L,5L),Pi)),
      Sqrt(Plus(C1,Times(CN2,C1DSqrt5)))),
    // Cot(5/12*Pi)=2-Sqrt(3)
    ISet(Cot(Times(QQ(5L,12L),Pi)),
      Subtract(C2,CSqrt3)),
    // Cot(Pi/2)=0
    ISet(Cot(CPiHalf),
      C0),
    // Cot(7/12*Pi)=-2+Sqrt(3)
    ISet(Cot(Times(QQ(7L,12L),Pi)),
      Plus(CN2,CSqrt3)),
    // Cot(3/5*Pi)=-Sqrt(1-2/Sqrt(5))
    ISet(Cot(Times(QQ(3L,5L),Pi)),
      Negate(Sqrt(Plus(C1,Times(CN2,C1DSqrt5))))),
    // Cot(5/8*Pi)=1-Sqrt(2)
    ISet(Cot(Times(QQ(5L,8L),Pi)),
      Subtract(C1,CSqrt2)),
    // Cot(2/3*Pi)=-1/Sqrt(3)
    ISet(Cot(Times(QQ(2L,3L),Pi)),
      Negate(C1DSqrt3)),
    // Cot(7/10*Pi)=-Sqrt(5-2*Sqrt(5))
    ISet(Cot(Times(QQ(7L,10L),Pi)),
      Negate(Sqrt(Plus(C5,Times(CN2,CSqrt5))))),
    // Cot(3/4*Pi)=-1
    ISet(Cot(Times(QQ(3L,4L),Pi)),
      CN1),
    // Cot(4/5*Pi)=-Sqrt(1+2/Sqrt(5))
    ISet(Cot(Times(QQ(4L,5L),Pi)),
      Negate(Sqrt(Plus(C1,Times(C2,C1DSqrt5))))),
    // Cot(5/6*Pi)=-Sqrt(3)
    ISet(Cot(Times(QQ(5L,6L),Pi)),
      Negate(CSqrt3)),
    // Cot(7/8*Pi)=-1-Sqrt(2)
    ISet(Cot(Times(QQ(7L,8L),Pi)),
      Subtract(CN1,CSqrt2)),
    // Cot(9/10*Pi)=-Sqrt(5+2*Sqrt(5))
    ISet(Cot(Times(QQ(9L,10L),Pi)),
      Negate(Sqrt(Plus(C5,Times(C2,CSqrt5))))),
    // Cot(11/12*Pi)=-2-Sqrt(3)
    ISet(Cot(Times(QQ(11L,12L),Pi)),
      Subtract(CN2,CSqrt3)),
    // Cot(Pi)=ComplexInfinity
    ISet(Cot(Pi),
      CComplexInfinity),
    // Cot(ArcSin(x_)):=Sqrt(1-x^2)/x
    ISetDelayed(Cot(ArcSin(x_)),
      Times(Power(x,CN1),Sqrt(Subtract(C1,Sqr(x))))),
    // Cot(ArcCos(x_)):=x/Sqrt(1-x^2)
    ISetDelayed(Cot(ArcCos(x_)),
      Times(x,Power(Subtract(C1,Sqr(x)),CN1D2))),
    // Cot(ArcTan(x_)):=1/x
    ISetDelayed(Cot(ArcTan(x_)),
      Power(x,CN1)),
    // Cot(2*ArcTan(x_)):=(1-x^2)/(2*x)
    ISetDelayed(Cot(Times(C2,ArcTan(x_))),
      Times(Subtract(C1,Sqr(x)),Power(Times(C2,x),CN1))),
    // Cot(ArcCot(x_)):=x
    ISetDelayed(Cot(ArcCot(x_)),
      x),
    // Cot(2*ArcCot(x_)):=(-1+x^2)/(2*x)
    ISetDelayed(Cot(Times(C2,ArcCot(x_))),
      Times(Plus(CN1,Sqr(x)),Power(Times(C2,x),CN1))),
    // Cot(ArcCsc(x_)):=Sqrt(1-1/x^2)*x
    ISetDelayed(Cot(ArcCsc(x_)),
      Times(Sqrt(Subtract(C1,Power(x,CN2))),x)),
    // Cot(ArcSec(x_)):=1/(Sqrt(1-1/x^2)*x)
    ISetDelayed(Cot(ArcSec(x_)),
      Times(Power(Subtract(C1,Power(x,CN2)),CN1D2),Power(x,CN1))),
    // Cot(I*Infinity)=-I
    ISet(Cot(DirectedInfinity(CI)),
      CNI),
    // Cot(-I*Infinity)=I
    ISet(Cot(DirectedInfinity(CNI)),
      CI),
    // Cot(ComplexInfinity)=Indeterminate
    ISet(Cot(CComplexInfinity),
      Indeterminate)
  );
}
