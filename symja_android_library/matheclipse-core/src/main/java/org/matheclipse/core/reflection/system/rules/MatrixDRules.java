package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.IAST;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface MatrixDRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 0, 10 };

  final public static IAST RULES = List(
    IInit(MatrixD, SIZES),
    // MatrixD(Inverse(x_),x_?(TensorRank(x)==2)):=(-Inverse(x)).MatrixD(a,x).Inverse(x)
    ISetDelayed(MatrixD(Inverse(x_),PatternTest(x_,Equal(TensorRank(x),C2))),
      Dot(Negate(Inverse(x)),MatrixD(a,x),Inverse(x))),
    // MatrixD(Transpose(x_),x_?(TensorRank(x)==2)):=Transpose(MatrixD(x,x))
    ISetDelayed(MatrixD(Transpose(x_),PatternTest(x_,Equal(TensorRank(x),C2))),
      Transpose(MatrixD(x,x))),
    // MatrixD(Det(x_),x_?(TensorRank(x)==2)):=Det(x)*Transpose(Inverse(x))
    ISetDelayed(MatrixD(Det(x_),PatternTest(x_,Equal(TensorRank(x),C2))),
      Times(Det(x),Transpose(Inverse(x)))),
    // MatrixD(Det(a_?(TensorRank(x)==2).x_.b_?(TensorRank(x)==2)),x_?(TensorRank(x)==2)):=Det(a.x.b)*Transpose(Inverse(x))
    ISetDelayed(MatrixD(Det(Dot(PatternTest(a_,Equal(TensorRank(x),C2)),x_,PatternTest(b_,Equal(TensorRank(x),C2)))),PatternTest(x_,Equal(TensorRank(x),C2))),
      Times(Det(Dot(a,x,b)),Transpose(Inverse(x)))),
    // MatrixD(Det(Transpose(x_).a_?(TensorRank(x)==2).x_),x_?(TensorRank(x)==2)):=2*Det(Transpose(x).a.x)*Inverse(Transpose(x))
    ISetDelayed(MatrixD(Det(Dot(Transpose(x_),PatternTest(a_,Equal(TensorRank(x),C2)),x_)),PatternTest(x_,Equal(TensorRank(x),C2))),
      Times(C2,Det(Dot(Transpose(x),a,x)),Inverse(Transpose(x)))),
    // MatrixD(Log(Det(Transpose(x_).x_)),x_?(TensorRank(x)==2)):=2*Inverse(Transpose(x))
    ISetDelayed(MatrixD(Log(Det(Dot(Transpose(x_),x_))),PatternTest(x_,Equal(TensorRank(x),C2))),
      Times(C2,Inverse(Transpose(x)))),
    // MatrixD(Log(Det(x_)),x_?(TensorRank(x)==2)):=Inverse(Transpose(x))
    ISetDelayed(MatrixD(Log(Det(x_)),PatternTest(x_,Equal(TensorRank(x),C2))),
      Inverse(Transpose(x))),
    // MatrixD(Det(MatrixPower(x_,k_)),x_?(TensorRank(x)==2)):=k*Det(MatrixPower(x,k))*Inverse(Transpose(x))
    ISetDelayed(MatrixD(Det(MatrixPower(x_,k_)),PatternTest(x_,Equal(TensorRank(x),C2))),
      Times(k,Det(MatrixPower(x,k)),Inverse(Transpose(x)))),
    // MatrixD(Inverse(x_),x_?(TensorRank(x)==2)):=(-Inverse(x)).$SingleEntryMatrix.Inverse(x)
    ISetDelayed(MatrixD(Inverse(x_),PatternTest(x_,Equal(TensorRank(x),C2))),
      Dot(Negate(Inverse(x)),$SingleEntryMatrix,Inverse(x))),
    // MatrixD(Det(Inverse(x_)),x_?(TensorRank(x)==2)):=-Det(Inverse(x))*Transpose(Inverse(x))
    ISetDelayed(MatrixD(Det(Inverse(x_)),PatternTest(x_,Equal(TensorRank(x),C2))),
      Times(CN1,Det(Inverse(x)),Transpose(Inverse(x))))
  );
}