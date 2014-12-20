package org.matheclipse.core.reflection.system;

import static org.matheclipse.core.expression.F.And;
import static org.matheclipse.core.expression.F.ArcCos;
import static org.matheclipse.core.expression.F.ArcCot;
import static org.matheclipse.core.expression.F.ArcSin;
import static org.matheclipse.core.expression.F.ArcTan;
import static org.matheclipse.core.expression.F.C1;
import static org.matheclipse.core.expression.F.C1D2;
import static org.matheclipse.core.expression.F.C2;
import static org.matheclipse.core.expression.F.CN1;
import static org.matheclipse.core.expression.F.CN1D2;
import static org.matheclipse.core.expression.F.Cos;
import static org.matheclipse.core.expression.F.Cosh;
import static org.matheclipse.core.expression.F.Equal;
import static org.matheclipse.core.expression.F.Pi;
import static org.matheclipse.core.expression.F.Positive;
import static org.matheclipse.core.expression.F.Power;
import static org.matheclipse.core.expression.F.Sin;
import static org.matheclipse.core.expression.F.Sinh;
import static org.matheclipse.core.expression.F.Times;
import static org.matheclipse.core.expression.F.a;
import static org.matheclipse.core.expression.F.a_;
import static org.matheclipse.core.expression.F.x;
import static org.matheclipse.core.expression.F.x_;
import static org.matheclipse.core.expression.F.y;
import static org.matheclipse.core.expression.F.y_;

import java.util.HashMap;
import java.util.Map;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractArgMultiple;
import org.matheclipse.core.eval.interfaces.INumeric;
import org.matheclipse.core.expression.AST;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IComplex;
import org.matheclipse.core.interfaces.IComplexNum;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.IFraction;
import org.matheclipse.core.interfaces.IInteger;
import org.matheclipse.core.interfaces.INum;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.patternmatching.HashedOrderlessMatcher;

public class Plus extends AbstractArgMultiple implements INumeric {
	/**
	 * Constructor for the singleton
	 */
	public final static Plus CONST = new Plus();

	private static HashedOrderlessMatcher ORDERLESS_MATCHER = new HashedOrderlessMatcher();

	@Override
	public HashedOrderlessMatcher getHashRuleMap() {
		return ORDERLESS_MATCHER;
	}

	public Plus() {

	}

	/**
	 * 
	 * See: <a href="http://www.cs.berkeley.edu/~fateman/papers/newsimp.pdf">Experiments in Hash-coded Algebraic Simplification</a>
	 * 
	 * @param ast
	 *            the abstract syntax tree (AST) of the form <code>Plus(...)</code> which should be evaluated
	 * @return the evaluated object or <code>null</code>, if evaluation isn't possible
	 */
	@Override
	public IExpr evaluate(final IAST ast) {
		int size = ast.size();
		if (ast.isEvalFlagOff(IAST.IS_EVALED)) {
			if (size > 2) {
				boolean evaled = false;

				Map<IExpr, IExpr> plusMap = new HashMap<IExpr, IExpr>(size + 5 + size / 10);
				IExpr numberValue = null;
				for (int i = 1; i < size; i++) {
					final IExpr arg = ast.get(i);
					if (arg.isIndeterminate()) {
						return F.Indeterminate;
					} else if (arg.isDirectedInfinity()) {
						if (arg.isInfinity()) {
							if (numberValue == null) {
								numberValue = arg;
								continue;
							}
							numberValue = infinityPlus(numberValue);
							if (numberValue.isIndeterminate()) {
								return F.Indeterminate;
							}
							evaled = true;
							continue;
						} else if (arg.isNegativeInfinity()) {
							if (numberValue == null) {
								numberValue = arg;
								continue;
							}
							numberValue = negativeInfinityPlus(numberValue);
							if (numberValue.isIndeterminate()) {
								return F.Indeterminate;
							}
							evaled = true;
							continue;
						} else if (arg.isComplexInfinity()) {
							if (numberValue == null) {
								numberValue = arg;
								continue;
							}
							if (numberValue.isNumber()) {
								numberValue=F.CComplexInfinity;
								evaled = true;
								continue;
							}
							return F.Indeterminate;
						}
					} else if (arg.isNumber()) {
						if (ast.get(i).isZero()) {
							evaled = true;
							continue;
						}
						if (numberValue == null) {
							numberValue = ast.get(i);
							continue;
						}
						if (numberValue.isNumber()) {
							numberValue = numberValue.plus(ast.get(i));
							evaled = true;
							continue;
						}
						if (numberValue.isInfinity()) {
							numberValue = infinityPlus(ast.get(i));
							if (numberValue.isIndeterminate()) {
								return F.Indeterminate;
							}
							evaled = true;
							continue;
						}
						if (numberValue.isNegativeInfinity()) {
							numberValue = negativeInfinityPlus(ast.get(i));
							if (numberValue.isIndeterminate()) {
								return F.Indeterminate;
							}
							evaled = true;
							continue;
						}
						continue;
					} else if (arg.isTimes()) {
						IAST timesAST = (IAST) ast.get(i);
						if (timesAST.arg1().isNumber()) {
							if (addMerge(plusMap, timesAST.removeAtClone(1).getOneIdentity(F.C1), timesAST.arg1())) {
								evaled = true;
							}
							continue;
						}
						if (addMerge(plusMap, timesAST, F.C1)) {
							evaled = true;
						}
						continue;
					}
					if (addMerge(plusMap, arg, F.C1)) {
						evaled = true;
					}
				}
				if (evaled) {
					IExpr temp;
					IAST result = F.Plus();
					if (numberValue != null) {
						result.add(numberValue);
					}
					for (Map.Entry<IExpr, IExpr> element : plusMap.entrySet()) {
						if (element.getValue().isOne()) {
							temp = element.getKey();
							if (temp.isPlus()) {
								result.addAll((IAST) temp);
							} else {
								result.add(temp);
							}
							continue;
						}
						result.add(F.Times(element.getValue(), element.getKey()));
					}
					result.addEvalFlags(IAST.IS_EVALED);
					return result.getOneIdentity(F.C0);
				}
			}
			ast.addEvalFlags(IAST.IS_EVALED);
		}

		if (size > 2) {
			IAST temp = evaluateHashs(ast);
			if (temp != null) {
				return temp;
			}
		}
		return null;
	}

	/**
	 * Add or merge the <code>key, value</code> pair into the given <code>plusMap</code>.
	 * 
	 * @param plusMap
	 *            the map where the <code>key, value</code> pair should be addd to
	 * @param key
	 *            the key expression
	 * @param value
	 *            the value expression
	 */
	public boolean addMerge(Map<IExpr, IExpr> plusMap, IExpr key, IExpr value) {
		IExpr temp = plusMap.get(key);
		if (temp == null) {
			plusMap.put(key, value);
			return false;
		}
		// merge both values
		if (temp.isNumber() && value.isNumber()) {
			temp = temp.plus(value);
			if (temp.isZero()) {
				plusMap.remove(key);
			}
		} else if (temp.head().equals(F.Plus)) {
			((IAST) temp).add(value);
		} else {
			temp = F.Plus(temp, value);
		}
		plusMap.put(key, temp);
		return true;
	}

	@Override
	public IExpr e2ComArg(final IComplex c0, final IComplex c1) {
		return c0.add(c1);
	}

	@Override
	public IExpr e2DblArg(final INum d0, final INum d1) {
		return d0.add(d1);
	}

	@Override
	public IExpr e2DblComArg(final IComplexNum d0, final IComplexNum d1) {
		return d0.add(d1);
	}

	@Override
	public IExpr e2FraArg(final IFraction f0, final IFraction f1) {
		return f0.add(f1);
	}

	@Override
	public IExpr e2IntArg(final IInteger i0, final IInteger i1) {
		return i0.add(i1);
	}

	private IExpr infinityPlus(IExpr o1) {
		if (o1.isInfinity()) {
			return F.CInfinity;
		} else if (o1.isNegativeInfinity()) {
			EvalEngine.get().printMessage("Indeterminate expression Infinity-Infinity");
			return F.Indeterminate;
		}
		return F.CInfinity;
	}

	private IExpr negativeInfinityPlus(IExpr o1) {
		if (o1.isInfinity()) {
			EvalEngine.get().printMessage("Indeterminate expression Infinity-Infinity");
			return F.Indeterminate;
		} else if (o1.isNegativeInfinity()) {
			return F.CNInfinity;
		}
		return F.CNInfinity;
	}

	@Override
	public IExpr eComIntArg(final IComplex c0, final IInteger i1) {
		return c0.add(F.complex(i1, F.C0));
	}

	public static IExpr evalPlusNumbers(IAST ast) {
		IAST result = F.Plus();
		IExpr num;
		if (!ast.arg1().isNumber()) {
			return null;
		}
		if (!ast.arg2().isNumber()) {
			return null;
		}
		num = ast.arg1().plus(ast.arg2());
		result.add(num);
		for (int i = 3; i < ast.size(); i++) {
			if (num.isNumber() && ast.get(i).isNumber()) {
				num = num.plus(ast.get(i));
			} else {
				result.addAll(ast, i, ast.size());
				result.set(1, num);
				return result;
			}
		}
		return num;
	}

	public double evalReal(final double[] stack, final int top, final int size) {
		double result = 0;
		for (int i = top - size + 1; i < top + 1; i++) {
			result += stack[i];
		}
		return result;
	}

	@Override
	public void setUp(final ISymbol symbol) {
		symbol.setAttributes(ISymbol.ONEIDENTITY | ISymbol.ORDERLESS | ISymbol.FLAT | ISymbol.LISTABLE | ISymbol.NUMERICFUNCTION);

		// ORDERLESS_MATCHER.setUpHashRule("Sin[x_]^2", "Cos[x_]^2", "a");
		ORDERLESS_MATCHER.definePatternHashRule(Power(Sin(x_), C2), Power(Cos(x_), C2), C1);
		// ORDERLESS_MATCHER.setUpHashRule("a_*Sin[x_]^2", "a_*Cos[x_]^2", "a");
		ORDERLESS_MATCHER.defineHashRule(Times(a_, Power(Sin(x_), C2)), Times(a_, Power(Cos(x_), C2)), a);
		// ORDERLESS_MATCHER.setUpHashRule("ArcSin[x_]", "ArcCos[x_]", "Pi/2");
		ORDERLESS_MATCHER.defineHashRule(ArcSin(x_), ArcCos(x_), Times(C1D2, Pi));
		// ORDERLESS_MATCHER.setUpHashRule("ArcTan[x_]", "ArcCot[x_]", "Pi/2");
		ORDERLESS_MATCHER.defineHashRule(ArcTan(x_), ArcCot(x_), Times(C1D2, Pi));
		// ORDERLESS_MATCHER.setUpHashRule("ArcTan[x_]", "ArcTan[y_]", "Pi/2", "Positive[x]&&(y==1/x)");
		ORDERLESS_MATCHER.defineHashRule(ArcTan(x_), ArcTan(y_), Times(C1D2, Pi), And(Positive(x), Equal(y, Power(x, CN1))));
		// ORDERLESS_MATCHER.setUpHashRule("-ArcTan[x_]", "-ArcTan[y_]", "-Pi/2", "Positive[x]&&(y==1/x)");
		ORDERLESS_MATCHER.definePatternHashRule(Times(CN1, ArcTan(x_)), Times(CN1, ArcTan(y_)), Times(CN1D2, Pi),
				And(Positive(x), Equal(y, Power(x, CN1))));
		// ORDERLESS_MATCHER.setUpHashRule("Cosh[x_]^2", "-Sinh[x_]^2", "1");
		ORDERLESS_MATCHER.definePatternHashRule(Power(Cosh(x_), C2), Times(CN1, Power(Sinh(x_), C2)), C1);
		super.setUp(symbol);
	}

}
