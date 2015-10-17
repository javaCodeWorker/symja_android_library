package org.matheclipse.core.builtin.function;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.exception.Validate;
import org.matheclipse.core.eval.interfaces.AbstractCoreFunctionEvaluator;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.interfaces.ISymbol;

import com.google.common.base.Function;

/**
 * 
 * <p>
 * See the online Symja function reference: <a href="https://bitbucket.org/axelclk/symja_android_library/wiki/Symbols/AppendTo">AppendTo</a>
 * </p>
 *
 */
public class AppendTo extends AbstractCoreFunctionEvaluator {

	static class AppendToFunction implements Function<IExpr, IExpr> {
		private final IExpr value;

		public AppendToFunction(final IExpr value) {
			this.value = value;
		}

		@Override
		public IExpr apply(final IExpr symbolValue) {
			if (!symbolValue.isAST()) {
				return null;
			}
			return ((IAST) symbolValue).appendClone(value);
		}

	}

	public AppendTo() {
		super();
	}

	@Override
	public IExpr evaluate(final IAST ast, EvalEngine engine) {
		Validate.checkSize(ast, 3);
		ISymbol sym = Validate.checkSymbolType(ast, 1);
		IExpr arg2 = F.eval(ast.arg2());
		Function<IExpr, IExpr> function = new AppendToFunction(arg2);
		IExpr[] results = sym.reassignSymbolValue(function, F.AppendTo);
		if (results != null) {
			return results[1];
		}
		return null;
	}

	@Override
	public void setUp(final ISymbol symbol) {
		symbol.setAttributes(ISymbol.HOLDFIRST);
	}
}