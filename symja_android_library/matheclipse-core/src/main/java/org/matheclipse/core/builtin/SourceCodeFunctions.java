package org.matheclipse.core.builtin;

import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.interfaces.AbstractEvaluator;
import org.matheclipse.core.expression.BuiltInSymbol;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.expression.S;
import org.matheclipse.core.interfaces.IAST;
import org.matheclipse.core.interfaces.IBuiltInSymbol;
import org.matheclipse.core.interfaces.IEvaluator;
import org.matheclipse.core.interfaces.IExpr;

public class SourceCodeFunctions {

	final static String GITHUB = "https://github.com/";
	final static String POM_PATH = "axkr/symja_android_library/blob/master/symja_android_library/matheclipse-core/";
	final static String SRC_PATH = "src/main/java/";

	/**
	 * Generated by class: <code>org.matheclipse.core.preprocessor.GithubSymjaFunctionLineNumber</code>
	 */
	public final static int[] LINE_NUMBER_OF_JAVA_CLASS = new int[] { //
			0, 0, 0, 128, 137, 146, 0, 0, 0, 155, //
			0, 0, 168, 178, 0, 0, 0, 0, 0, 0, 0, //
			187, 200, 136, 226, 363, 203, 0, 153, 500, 404, 694, //
			47, 92, 137, 181, 0, 0, 0, 474, 0, 558, 145, //
			31, 44, 0, 98, 130, 719, 380, 0, 562, 647, 177, //
			200, 282, 358, 454, 551, 609, 694, 657, 740, 832, 907, //
			1050, 501, 80, 128, 333, 795, 569, 925, 188, 82, 29, //
			35, 72, 123, 0, 0, 198, 0, 0, 52, 0, 0, //
			0, 0, 0, 0, 1801, 0, 0, 65, 111, 141, 117, //
			1619, 250, 564, 466, 251, 400, 568, 663, 735, 109, 680, //
			244, 873, 80, 76, 32, 347, 1060, 98, 0, 0, 0, //
			0, 272, 326, 299, 225, 0, 793, 879, 918, 0, 971, //
			1060, 0, 0, 1809, 121, 190, 0, 0, 47, 0, 255, //
			0, 452, 92, 0, 161, 533, 0, 489, 64, 1043, 231, //
			538, 247, 1232, 170, 0, 1186, 0, 623, 1459, 1528, 322, //
			200, 1209, 580, 671, 644, 0, 1131, 381, 414, 117, 752, //
			144, 248, 268, 893, 0, 0, 0, 0, 1307, 0, 26, //
			497, 1399, 950, 63, 277, 1816, 0, 0, 1518, 1010, 1468, //
			368, 430, 1018, 1075, 726, 0, 0, 1569, 117, 49, 103, //
			165, 141, 473, 477, 876, 1823, 791, 23, 1037, 1370, 1172, //
			68, 1598, 165, 240, 1705, 1337, 1671, 1746, 236, 2775, 19, //
			770, 1442, 1861, 1069, 52, 0, 439, 165, 52, 16, 78, //
			127, 1218, 541, 0, 538, 621, 327, 0, 0, 1769, 1914, //
			2021, 2062, 1128, 1841, 1832, 309, 82, 843, 914, 939, 1005, //
			0, 0, 0, 241, 1265, 265, 298, 1097, 1122, 0, 1410, //
			0, 0, 385, 0, 1181, 2887, 536, 31, 2115, 0, 0, //
			1232, 0, 105, 1352, 1393, 1271, 1447, 1378, 1357, 654, 1197, //
			2224, 2144, 0, 381, 13, 51, 88, 0, 747, 802, 0, //
			57, 1401, 1502, 78, 93, 55, 0, 75, 218, 333, 428, //
			555, 210, 257, 0, 1168, 1402, 438, 511, 581, 3055, 279, //
			1534, 410, 1644, 842, 670, 346, 0, 0, 1471, 1962, 260, //
			324, 22, 1362, 1873, 3193, 714, 3275, 36, 33, 0, 1733, //
			0, 2354, 1488, 1929, 2203, 2176, 2229, 2322, 1922, 2087, 1966, //
			0, 2273, 296, 0, 964, 92, 0, 1029, 0, 0, 36, //
			156, 1149, 480, 635, 1093, 2495, 299, 0, 1454, 775, 901, //
			0, 0, 481, 557, 0, 546, 2533, 2575, 1013, 1522, 14, //
			1596, 655, 1663, 410, 427, 497, 2405, 53, 67, 2448, 726, //
			1659, 0, 138, 1387, 606, 63, 151, 138, 1752, 1556, 1820, //
			632, 2669, 2751, 0, 0, 0, 567, 0, 29, 69, 0, //
			2099, 2056, 692, 447, 467, 525, 2188, 125, 0, 217, 61, //
			267, 314, 384, 425, 0, 0, 0, 0, 1605, 1980, 0, //
			1712, 2806, 2351, 901, 0, 775, 821, 0, 2517, 1834, 1980, //
			725, 0, 15, 1829, 502, 1718, 1848, 893, 0, 0, 0, //
			0, 248, 973, 0, 21, 299, 0, 790, 681, 739, 0, //
			845, 2573, 987, 770, 1044, 585, 1049, 1771, 1128, 2049, 2072, //
			0, 2202, 0, 2121, 0, 648, 0, 1067, 1825, 0, 0, //
			338, 0, 2941, 0, 369, 447, 860, 357, 918, 297, 0, //
			0, 76, 14, 46, 15, 1186, 37, 2860, 77, 230, 132, //
			334, 1967, 1011, 223, 900, 956, 19, 30, 1071, 2004, 39, //
			1050, 0, 558, 0, 607, 675, 0, 722, 0, 762, 2021, //
			0, 0, 0, 0, 802, 2513, 842, 510, 3037, 658, 769, //
			0, 267, 351, 484, 305, 712, 890, 0, 3478, 2556, 3580, //
			2234, 2479, 1869, 36, 3119, 743, 2072, 0, 1978, 2027, 3194, //
			2273, 2358, 374, 155, 3310, 3388, 0, 0, 0, 0, 0, //
			0, 0, 0, 0, 0, 0, 0, 71, 0, 330, 71, //
			2607, 2183, 2717, 0, 0, 176, 223, 33, 33, 32, 0, //
			0, 1007, 2030, 2181, 2203, 1110, 1138, 3625, 2419, 2149, 0, //
			405, 193, 2417, 2767, 0, 0, 2893, 459, 1884, 2275, 942, //
			991, 1008, 1077, 1188, 545, 977, 606, 2525, 0, 2566, 1856, //
			2636, 611, 2742, 2515, 69, 0, 0, 328, 3846, 3881, 75, //
			3987, 81, 1183, 676, 2951, 2999, 0, 131, 1146, 0, 0, //
			2654, 28, 2745, 0, 382, 2337, 0, 0, 1003, 1279, 0, //
			3062, 2071, 0, 3441, 3125, 3210, 2395, 57, 29, 19, 0, //
			0, 0, 71, 451, 539, 1103, 24, 4136, 190, 2805, 3459, //
			2881, 0, 0, 0, 1326, 1385, 1471, 1531, 3279, 10, 3031, //
			3085, 0, 2961, 0, 3136, 2858, 943, 4363, 2952, 3206, 0, //
			0, 167, 0, 0, 661, 0, 3024, 0, 0, 0, 0, //
			2485, 0, 0, 0, 0, 752, 1626, 1745, 0, 1432, 58, //
			1303, 1203, 1257, 1460, 3280, 0, 1293, 1339, 323, 0, 812, //
			3074, 19, 77, 0, 0, 4689, 0, 3576, 3804, 16, 1983, //
			1028, 3346, 3496, 0, 1485, 1493, 0, 0, 3639, 3669, 1083, //
			749, 1865, 2513, 2631, 0, 32, 27, 0, 0, 2771, 3012, //
			0, 4751, 16, 1368, 1412, 0, 2604, 2752, 2927, 3083, 3153, //
			3240, 3393, 4009, 3405, 885, 0, 3222, 3488, 1109, 4303, 4347, //
			4258, 0, 0, 4217, 4329, 3736, 3857, 3770, 3928, 1010, 0, //
			3950, 4006, 209, 4567, 93, 1489, 3139, 244, 0, 3249, 0, //
			1547, 3298, 4885, 236, 0, 299, 793, 5023, 2124, 1534, 1174, //
			1298, 20, 12, 59, 92, 170, 255, 306, 449, 5054, 4417, //
			4394, 4059, 0, 4481, 0, 0, 0, 1091, 0, 2165, 0, //
			0, 0, 221, 0, 0, 1602, 0, 4538, 4765, 4826, 4970, //
			5076, 5172, 5156, 888, 2275, 5195, 3351, 5241, 0, 1389, 155, //
			3889, 1279, 0, 1380, 5335, 5408, 149, 1419, 0, 3432, 1657, //
			1701, 1449, 3473, 0, 3515, 3600, 3677, 0, 1592, 2230, 2381, //
			0, 5484, 5527, 0, 0, 0, 0, 1083, 1425, 1701, 1832, //
			323, 1967, 32, 165, 0, 4609, 4755, 1504, 133, 2487, 1246, //
			2657, 3526, 2760, 1356, 5242, 0, 0, 1537, 80, 1680, 1760, //
			2325, 0, 66, 892, 978, 0, 0, 5626, 5695, 4820, 4211, //
			1144, 493, 2375, 2423, 5333, 0, 5367, 1620, 4348, 4454, 0, //
			0, 228, 325, 364, 401, 422, 457, 478, 513, 0, 551, //
			600, 678, 735, 467, 1651, 1731, 5396, 0, 178, 5755, 4534, //
			0, 43, 1600, 0, 5049, 5004, 138, 547, 0, 4861, 0, //
			5556, 2496, 1843, 1877, 0, 0, 1181, 772, 1239, 0, 5874, //
			198, 0, 2131, 2205, 6233, 6418, 6464, 6074, 2883, 3026, 3803, //
			15, 645, 407, 539, 573, 428, 0, 795, 1933, 2031, 2700, //
			2527, 177, 100, 5163, 6131, 2682, 826, 866, 3633, 3633, 912, //
			928, 674, 3561, 3942, 0, 0, 6556, 3701, 2755, 2790, 0, //
			3771, 667, 0, 45, 51, 32, 0, 3918, 0, 1777, 0, //
			0, 0, 0, 4007, 2870, 5639, 6649, 2293, 360, 1548, 3943, //
			0, 4615, 0, 268, 4067, 2378, 2445, 2518, 997, 3992, 1272, //
			564, 4048, 0, 4296, 5860, 4112, 1322, 1199, 1264, 1326, 0, //
			5955, 954, 988, 1022, 1066, 0, 0, 2932, 3000, 0, 0, //
			1434, 1496, 3054, 0, 4139, 0, 1888, 0, 1811 };

	/**
	 * 
	 * See <a href="https://pangin.pro/posts/computation-in-static-initializer">Beware of computation in static
	 * initializer</a>
	 */
	private static class Initializer {

		private static void init() {
			S.FunctionURL.setEvaluator(new FunctionURL());
		}
	}

	private static class FunctionURL extends AbstractEvaluator {

		@Override
		public IExpr evaluate(final IAST ast, EvalEngine engine) {
			if (ast.arg1().isBuiltInSymbol()) {
				IBuiltInSymbol builtin = (IBuiltInSymbol) ast.arg1();
				String url = functionURL(builtin);
				if (url != null) {
					return F.stringx(url);
				}
			}
			return F.NIL;
		}

		@Override
		public int[] expectedArgSize(IAST ast) {
			return IOFunctions.ARGS_1_1;
		}
	}

	private static String buildURL(final Class<?> clazz, int line) {
		StringBuilder buf = new StringBuilder(512);
		buf.append(GITHUB);
		buf.append(POM_PATH);
		buf.append(SRC_PATH);
		String canonicalName = clazz.getCanonicalName();
		String packageName = clazz.getPackage().getName();
		String parentClass = canonicalName.substring(packageName.length() + 1);
		int index = parentClass.indexOf('.');
		if (index > 0) {
			parentClass = parentClass.substring(0, index);
		}
		String packagePath = packageName.replace('.', '/');
		buf.append(packagePath);
		buf.append('/');
		buf.append(parentClass);
		buf.append(".java#L");
		buf.append(line);
		return buf.toString();
	}

	public static String functionURL(IBuiltInSymbol builtin) {
		int ordinal = builtin.ordinal();
		if (ordinal > 0 && ordinal < LINE_NUMBER_OF_JAVA_CLASS.length) {
			int line = LINE_NUMBER_OF_JAVA_CLASS[ordinal];
			if (line > 0) {
				IEvaluator evaluator = builtin.getEvaluator();
				if (evaluator != null && evaluator != BuiltInSymbol.DUMMY_EVALUATOR) {
					Class<? extends IEvaluator> clazz = evaluator.getClass();
					return buildURL(clazz, line);
				}
			}
		}
		return null;
	}

	public static void initialize() {
		Initializer.init();
	}

	private SourceCodeFunctions() {

	}

}
