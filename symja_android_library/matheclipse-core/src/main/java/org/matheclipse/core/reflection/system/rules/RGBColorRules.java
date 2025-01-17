package org.matheclipse.core.reflection.system.rules;

import static org.matheclipse.core.expression.F.*;
import org.matheclipse.core.interfaces.ISymbol;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.patternmatching.Matcher;

/**
 * <p>Generated by <code>org.matheclipse.core.preprocessor.RulePreprocessor</code>.</p>
 * <p>See GIT repository at: <a href="https://github.com/axkr/symja_android_library">github.com/axkr/symja_android_library under the tools directory</a>.</p>
 */
public interface RGBColorRules {
  /**
   * <ul>
   * <li>index 0 - number of equal rules in <code>RULES</code></li>
	 * </ul>
	 */
  final public static int[] SIZES = { 24, 0 };

  final public static IAST RULES = List(
    IInit(RGBColor, SIZES),
    // Black=RGBColor(0.0,0.0,0.0)
    ISet(Black,
      RGBColor(CD0,CD0,CD0)),
    // Brown=RGBColor(0.6,0.4,0.2)
    ISet(Brown,
      RGBColor(num(0.6),num(0.4),num(0.2))),
    // Blue=RGBColor(0.0,0.0,1.0)
    ISet(Blue,
      RGBColor(CD0,CD0,CD1)),
    // Cyan=RGBColor(0.0,1.0,1.0)
    ISet(Cyan,
      RGBColor(CD0,CD1,CD1)),
    // Gray=RGBColor(0.5,0.5,0.5)
    ISet(Gray,
      RGBColor(num(0.5),num(0.5),num(0.5))),
    // Green=RGBColor(0.0,1.0,0.0)
    ISet(Green,
      RGBColor(CD0,CD1,CD0)),
    // Magenta=RGBColor(1.0,0.0,1.0)
    ISet(Magenta,
      RGBColor(CD1,CD0,CD1)),
    // Orange=RGBColor(1.0,0.5,0.0)
    ISet(Orange,
      RGBColor(CD1,num(0.5),CD0)),
    // Pink=RGBColor(1.0,0.5,0.5)
    ISet(Pink,
      RGBColor(CD1,num(0.5),num(0.5))),
    // Purple=RGBColor(0.5,0.0,0.5)
    ISet(Purple,
      RGBColor(num(0.5),CD0,num(0.5))),
    // Red=RGBColor(1.0,0.0,0.0)
    ISet(Red,
      RGBColor(CD1,CD0,CD0)),
    // White=RGBColor(1.0,1.0,1.0)
    ISet(White,
      RGBColor(CD1,CD1,CD1)),
    // Yellow=RGBColor(1.0,1.0,0.0)
    ISet(Yellow,
      RGBColor(CD1,CD1,CD0)),
    // LightBrown=RGBColor(0.94,0.91,0.88)
    ISet(LightBrown,
      RGBColor(num(0.94),num(0.91),num(0.88))),
    // LightBlue=RGBColor(0.87,0.94,1.0)
    ISet(LightBlue,
      RGBColor(num(0.87),num(0.94),CD1)),
    // LightCyan=RGBColor(0.9,1.0,1.0)
    ISet(LightCyan,
      RGBColor(num(0.9),CD1,CD1)),
    // LightGray=RGBColor(0.85,0.85,0.85)
    ISet(LightGray,
      RGBColor(num(0.85),num(0.85),num(0.85))),
    // LightGreen=RGBColor(0.0,1.0,0.0)
    ISet(LightGreen,
      RGBColor(CD0,CD1,CD0)),
    // LightMagenta=RGBColor(1.0,0.9,1.0)
    ISet(LightMagenta,
      RGBColor(CD1,num(0.9),CD1)),
    // LightOrange=RGBColor(1.0,0.9,0.8)
    ISet(LightOrange,
      RGBColor(CD1,num(0.9),num(0.8))),
    // LightPink=RGBColor(1.0,0.925,0.925)
    ISet(LightPink,
      RGBColor(CD1,num(0.925),num(0.925))),
    // LightPurple=RGBColor(0.94,0.88,0.94)
    ISet(LightPurple,
      RGBColor(num(0.94),num(0.88),num(0.94))),
    // LightRed=RGBColor(1.0,0.85,0.85)
    ISet(LightRed,
      RGBColor(CD1,num(0.85),num(0.85))),
    // LightYellow=RGBColor(1.0,1.0,0.85)
    ISet(LightYellow,
      RGBColor(CD1,CD1,num(0.85)))
  );
}
