package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.patternmatching.Matcher;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface BesselKRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 0, 3 };

  final public static IAST RULES = List(
    IInit(BesselK, SIZES),
    // BesselK(Undefined,y_):=Undefined
    ISetDelayed(BesselK(Undefined,y_),
      Undefined),
    // BesselK(x_,Undefined):=Undefined
    ISetDelayed(BesselK(x_,Undefined),
      Undefined),
    // BesselK(-1/2,z_):=Sqrt(Pi/2)/(E^z*Sqrt(z))
    ISetDelayed(BesselK(CN1D2,z_),
      Times(Sqrt(CPiHalf),Power(Times(Exp(z),Sqrt(z)),CN1))),
    // BesselK(1/2,z_):=Sqrt(Pi/2)/(E^z*Sqrt(z))
    ISetDelayed(BesselK(C1D2,z_),
      Times(Sqrt(CPiHalf),Power(Times(Exp(z),Sqrt(z)),CN1))),
    // BesselK(x_/;x>0&&FractionalPart(x)==0.5&&!IntegerQ(x),z_/;!PossibleZeroQ(z)&&FreeQ(z,DirectedInfinity)):=Module({u,f,k=-1/2+x},f=1/(E^u*u);While(k>0,k=-1+k;f=D(f,u)/u);Sqrt(Pi/2*z)*f/(-u)^(1/2-x)/.u->z)
    ISetDelayed(BesselK(Condition(x_,And(Greater(x,C0),Equal(FractionalPart(x),num(0.5)),Not(IntegerQ(x)))),Condition(z_,And(Not(PossibleZeroQ(z)),FreeQ(z,DirectedInfinity)))),
      Module(list(u,f,Set(k,Plus(CN1D2,x))),CompoundExpression(Set(f,Times(Exp(Negate(u)),Power(u,CN1))),While(Greater(k,C0),CompoundExpression(Set(k,Plus(CN1,k)),Set(f,Times(Power(u,CN1),D(f,u))))),ReplaceAll(Times(Sqrt(Times(C1D2,Pi,z)),Power(Negate(u),Plus(CN1D2,x)),f),Rule(u,z))))),
    // BesselK(x_/;x<0&&FractionalPart(x)==-0.5&&!IntegerQ(x),z_/;!PossibleZeroQ(z)&&FreeQ(z,DirectedInfinity)):=Module({u,f,k=-1/2-x},f=1/(E^u*u);While(k>0,k=-1+k;f=D(f,u)/u);Sqrt(Pi/2*z)*f/(-u)^(1/2+x)/.u->z)
    ISetDelayed(BesselK(Condition(x_,And(Less(x,C0),Equal(FractionalPart(x),num(-0.5)),Not(IntegerQ(x)))),Condition(z_,And(Not(PossibleZeroQ(z)),FreeQ(z,DirectedInfinity)))),
      Module(list(u,f,Set(k,Subtract(CN1D2,x))),CompoundExpression(Set(f,Times(Exp(Negate(u)),Power(u,CN1))),While(Greater(k,C0),CompoundExpression(Set(k,Plus(CN1,k)),Set(f,Times(Power(u,CN1),D(f,u))))),ReplaceAll(Times(Sqrt(Times(C1D2,Pi,z)),Power(Negate(u),Subtract(CN1D2,x)),f),Rule(u,z)))))
  );
}
