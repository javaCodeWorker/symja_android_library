package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.patternmatching.Matcher;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface StruveHRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 0, 3 };

  final public static IAST RULES = List(
    IInit(StruveH, SIZES),
    // StruveH(-1/2,z_):=Sqrt(2/(Pi*z))*Sin(z)
    ISetDelayed(StruveH(CN1D2,z_),
      Times(Sqrt(Times(C2,Power(Times(Pi,z),CN1))),Sin(z))),
    // StruveH(1/2,z_):=Sqrt(2/(Pi*z))*(1-Cos(z))
    ISetDelayed(StruveH(C1D2,z_),
      Times(Sqrt(Times(C2,Power(Times(Pi,z),CN1))),Subtract(C1,Cos(z)))),
    // StruveH(Undefined,y_):=Undefined
    ISetDelayed(StruveH(Undefined,y_),
      Undefined),
    // StruveH(x_,Undefined):=Undefined
    ISetDelayed(StruveH(x_,Undefined),
      Undefined)
  );
}
