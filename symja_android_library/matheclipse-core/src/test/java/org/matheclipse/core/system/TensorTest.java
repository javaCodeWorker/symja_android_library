package org.matheclipse.core.system;

import org.matheclipse.core.basic.Config;
import org.matheclipse.core.eval.EvalEngine;

/** Tests for tensor functions */
public class TensorTest extends ExprEvaluatorTestCase {

  public TensorTest(String name) {
    super(name);
  }

  public void testHodgeDual() {
    // check(
    // "Normal@HodgeDual({{a, b},{ c,d}})", //
    // "(b-c)/2");
    check("Normal@HodgeDual({a, b, c})", //
        "{{0,c,-b},{-c,0,a},{b,-a,0}}");
    check("Normal@HodgeDual({a, b, c, d})", //
        "{{{0,0,0,0},{0,0,-d,c},{0,d,0,-b},{0,-c,b,0}},{{0,0,d,-c},{0,0,0,0},{-d,0,0,a},{c,\n"
            + "0,-a,0}},{{0,-d,0,b},{d,0,0,-a},{0,0,0,0},{-b,a,0,0}},{{0,c,-b,0},{-c,0,a,0},{b,-a,\n"
            + "0,0},{0,0,0,0}}}");
    check("Normal@HodgeDual({a, b, c, d, e})", //
        "{{{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}},{{0,0,0,0,0},{0,\n"
            + "0,0,0,0},{0,0,0,e,-d},{0,0,-e,0,c},{0,0,d,-c,0}},{{0,0,0,0,0},{0,0,0,-e,d},{0,0,\n"
            + "0,0,0},{0,e,0,0,-b},{0,-d,0,b,0}},{{0,0,0,0,0},{0,0,e,0,-c},{0,-e,0,0,b},{0,0,0,\n"
            + "0,0},{0,c,-b,0,0}},{{0,0,0,0,0},{0,0,-d,c,0},{0,d,0,-b,0},{0,-c,b,0,0},{0,0,0,0,\n"
            + "0}}},{{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,-e,d},{0,0,e,0,-c},{0,0,-d,c,0}},{{0,0,0,0,\n"
            + "0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}},{{0,0,0,e,-d},{0,0,0,0,0},{0,\n"
            + "0,0,0,0},{-e,0,0,0,a},{d,0,0,-a,0}},{{0,0,-e,0,c},{0,0,0,0,0},{e,0,0,0,-a},{0,0,\n"
            + "0,0,0},{-c,0,a,0,0}},{{0,0,d,-c,0},{0,0,0,0,0},{-d,0,0,a,0},{c,0,-a,0,0},{0,0,0,\n"
            + "0,0}}},{{{0,0,0,0,0},{0,0,0,e,-d},{0,0,0,0,0},{0,-e,0,0,b},{0,d,0,-b,0}},{{0,0,0,-e,d},{\n"
            + "0,0,0,0,0},{0,0,0,0,0},{e,0,0,0,-a},{-d,0,0,a,0}},{{0,0,0,0,0},{0,0,0,0,0},{0,0,\n"
            + "0,0,0},{0,0,0,0,0},{0,0,0,0,0}},{{0,e,0,0,-b},{-e,0,0,0,a},{0,0,0,0,0},{0,0,0,0,\n"
            + "0},{b,-a,0,0,0}},{{0,-d,0,b,0},{d,0,0,-a,0},{0,0,0,0,0},{-b,a,0,0,0},{0,0,0,0,0}}},{{{\n"
            + "0,0,0,0,0},{0,0,-e,0,c},{0,e,0,0,-b},{0,0,0,0,0},{0,-c,b,0,0}},{{0,0,e,0,-c},{0,\n"
            + "0,0,0,0},{-e,0,0,0,a},{0,0,0,0,0},{c,0,-a,0,0}},{{0,-e,0,0,b},{e,0,0,0,-a},{0,0,\n"
            + "0,0,0},{0,0,0,0,0},{-b,a,0,0,0}},{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{\n"
            + "0,0,0,0,0}},{{0,c,-b,0,0},{-c,0,a,0,0},{b,-a,0,0,0},{0,0,0,0,0},{0,0,0,0,0}}},{{{\n"
            + "0,0,0,0,0},{0,0,d,-c,0},{0,-d,0,b,0},{0,c,-b,0,0},{0,0,0,0,0}},{{0,0,-d,c,0},{0,\n"
            + "0,0,0,0},{d,0,0,-a,0},{-c,0,a,0,0},{0,0,0,0,0}},{{0,d,0,-b,0},{-d,0,0,a,0},{0,0,\n"
            + "0,0,0},{b,-a,0,0,0},{0,0,0,0,0}},{{0,-c,b,0,0},{c,0,-a,0,0},{-b,a,0,0,0},{0,0,0,\n"
            + "0,0},{0,0,0,0,0}},{{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}}}}");
  }

  public void testLeviCivitaTensor() {
    if (Config.EXPENSIVE_JUNIT_TESTS) {
      check("LeviCivitaTensor(7);", //
          "");
    }
    check("LeviCivitaTensor(1)//Normal", //
        "{1}");
    check("{x,y,z}.Normal(LeviCivitaTensor(3))  ", //
        "{{0,z,-y},{-z,0,x},{y,-x,0}}");
    check("Array(Signature({##})&,{3,3,3})", //
        "{{{0,0,0},{0,0,1},{0,-1,0}},{{0,0,-1},{0,0,0},{1,0,0}},{{0,1,0},{-1,0,0},{0,0,0}}}");
    check("LeviCivitaTensor(3)", //
        "SparseArray(Number of elements: 6 Dimensions: {3,3,3} Default value: 0)");
    check("LeviCivitaTensor(4) // Normal", //
        "{{{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},{{0,0,0,0},{0,0,0,0},{0,0,0,1},{0,0,-\n"
            + "1,0}},{{0,0,0,0},{0,0,0,-1},{0,0,0,0},{0,1,0,0}},{{0,0,0,0},{0,0,1,0},{0,-1,0,0},{\n"
            + "0,0,0,0}}},{{{0,0,0,0},{0,0,0,0},{0,0,0,-1},{0,0,1,0}},{{0,0,0,0},{0,0,0,0},{0,0,\n"
            + "0,0},{0,0,0,0}},{{0,0,0,1},{0,0,0,0},{0,0,0,0},{-1,0,0,0}},{{0,0,-1,0},{0,0,0,0},{\n"
            + "1,0,0,0},{0,0,0,0}}},{{{0,0,0,0},{0,0,0,1},{0,0,0,0},{0,-1,0,0}},{{0,0,0,-1},{0,\n"
            + "0,0,0},{0,0,0,0},{1,0,0,0}},{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}},{{0,1,0,0},{-\n"
            + "1,0,0,0},{0,0,0,0},{0,0,0,0}}},{{{0,0,0,0},{0,0,-1,0},{0,1,0,0},{0,0,0,0}},{{0,0,\n"
            + "1,0},{0,0,0,0},{-1,0,0,0},{0,0,0,0}},{{0,-1,0,0},{1,0,0,0},{0,0,0,0},{0,0,0,0}},{{\n"
            + "0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}}}}");
  }

  public void testTensorDimensions() {
    check("A=Array(a, {2, 3, 4});TensorDimensions(A)", //
        "{2,3,4}");
    check("TensorDimensions({{1,2},{3,4},{a,b},{c,d}})", //
        "{4,2}");
    check("m = SparseArray({{1, 2, 3} -> a}, {2, 3, 4});TensorDimensions(m)", //
        "{2,3,4}");
  }

  public void testTensorRank() {
    check("TensorRank(3.14)", //
        "0");
    check("TensorRank(Pi+E)", //
        "0");
    check("TensorRank({})", //
        "1");
    check("TensorRank({{}})", //
        "2");
    check("A=Array(a, {2, 3, 4});TensorRank(A)", //
        "3");
    check("TensorRank({{1,2},{3,4},{a,b},{c,d}})", //
        "2");
    check("m = SparseArray({{1, 2, 3} -> a}, {2, 3, 4});TensorRank(m)", //
        "3");
  }

  public void testTensorSymmetry() {
    check("TensorSymmetry({{a,b,c,d}, {b,e,f,g}, {c,f,h,i},{d,g,i,j}})", //
        "Symmetric({1,2})");
    check("TensorSymmetry({{0, a, b}, {-a, 0, c}, {-b, -c, 0}})", //
        "AntiSymmetric({1,2})");
    check("TensorSymmetry({{a}})", //
        "Symmetric({1,2})");
    check("TensorSymmetry({{0}})", //
        "ZeroSymmetric({})");
    check("TensorSymmetry({{0,0}, {0,0}})", //
        "ZeroSymmetric({})");
    check("TensorSymmetry({{a,b}, {b,c}})", //
        "Symmetric({1,2})");
  }

  public void testKroneckerProduct() {

    check("av = {1, 2, 3}; bv = {4, 5};", //
        "");
    check("KroneckerProduct(av,bv)", //
        "{{4,5},{8,10},{12,15}}");

    check("am = {{1, 2}, {3, 4}}; bm = {{5, 6}, {7, 8}, {9, 10}};", //
        "");
    check("KroneckerProduct(am,bm)", //
        "{{5,6,10,12},{7,8,14,16},{9,10,18,20},{15,18,20,24},{21,24,28,32},{27,30,36,40}}");

    // TODO improve FlattenArray / message ArrayFlatten: Function (rank != 2) not implemented.
    check("am = {{{1, 2}, {3, 4}}}; bm = {{{5, 6}, {7, 8}, {9, 10}}};", //
        "");
    check("KroneckerProduct(am,bm)", //
        "KroneckerProduct({{{{{{5,6},{7,8},{9,10}}},{{{10,12},{14,16},{18,20}}}},{{{{15,\n" //
            + "18},{21,24},{27,30}}},{{{20,24},{28,32},{36,40}}}}}})");
    // check("KroneckerProduct(am,bm)", //
    // "{{5,6,10,12},{7,8,14,16},{9,10,18,20},{15,18,20,24},{21,24,28,32},{27,30,36,40}}");

    check("ta = {{0, 1}, {-1, 0}}; tb = {{1, 2}, {3, 4}};", //
        "");
    check("KroneckerProduct(ta, tb)", //
        "{{0,0,1,2},{0,0,3,4},{-1,-2,0,0},{-3,-4,0,0}}");

    check("ta = {{1, 2}, {3, 4}, {5, 6}}; tb = {{7, 8}, {9, 0}};", //
        "");
    check("KroneckerProduct(ta, tb) // MatrixForm", //
        "{{7,8,14,16},\n" //
            + " {9,0,18,0},\n" //
            + " {21,24,28,32},\n" //
            + " {27,0,36,0},\n" //
            + " {35,40,42,48},\n" //
            + " {45,0,54,0}}");

    check("ta = {{1,4,-7}, {-2,3,3}}; tb = {{8,-9,-6,5},{1,-3,-4,7},{2,8,-8,-3},{1,2,-5,-1}};", //
        "");
    check("KroneckerProduct(ta, tb) // MatrixForm", //
        "{{8,-9,-6,5,32,-36,-24,20,-56,63,42,-35},\n" //
            + " {1,-3,-4,7,4,-12,-16,28,-7,21,28,-49},\n" //
            + " {2,8,-8,-3,8,32,-32,-12,-14,-56,56,21},\n" //
            + " {1,2,-5,-1,4,8,-20,-4,-7,-14,35,7},\n" //
            + " {-16,18,12,-10,24,-27,-18,15,24,-27,-18,15},\n" //
            + " {-2,6,8,-14,3,-9,-12,21,3,-9,-12,21},\n" //
            + " {-4,-16,16,6,6,24,-24,-9,6,24,-24,-9},\n" //
            + " {-2,-4,10,2,3,6,-15,-3,3,6,-15,-3}}");

    check("ta = {{1,2}, {3,4}}; tb = {{0,5}, {6,7}};", //
        "");
    check("KroneckerProduct(ta, tb)", //
        "{{0,5,0,10},{6,7,12,14},{0,15,0,20},{18,21,24,28}}");
  }

  public void testTensorProduct() {

    check("ta = {{1,4,-7}, {-2,3,3}}; tb = {{8,-9,-6,5},{1,-3,-4,7},{2,8,-8,-3},{1,2,-5,-1}};", //
        "");
    check("TensorProduct(ta, tb)  ", //
        "{{{{8,-9,-6,5},{1,-3,-4,7},{2,8,-8,-3},{1,2,-5,-1}},{{32,-36,-24,20},{4,-12,-16,\n" //
            + "28},{8,32,-32,-12},{4,8,-20,-4}},{{-56,63,42,-35},{-7,21,28,-49},{-14,-56,56,21},{-\n" //
            + "7,-14,35,7}}},{{{-16,18,12,-10},{-2,6,8,-14},{-4,-16,16,6},{-2,-4,10,2}},{{24,-\n" //
            + "27,-18,15},{3,-9,-12,21},{6,24,-24,-9},{3,6,-15,-3}},{{24,-27,-18,15},{3,-9,-12,\n" //
            + "21},{6,24,-24,-9},{3,6,-15,-3}}}}");

    check(
        "TensorProduct({{{1,2,3},{4,5,6},{7,8,9}},{{2,0,0},{0,3,0},{0,0,1}}},{{2,1,4},{0,3,0},{0,0,1}})", //
        "{{{{{2,1,4},{0,3,0},{0,0,1}},{{4,2,8},{0,6,0},{0,0,2}},{{6,3,12},{0,9,0},{0,0,3}}},{{{\n"
            + "8,4,16},{0,12,0},{0,0,4}},{{10,5,20},{0,15,0},{0,0,5}},{{12,6,24},{0,18,0},{0,0,\n"
            + "6}}},{{{14,7,28},{0,21,0},{0,0,7}},{{16,8,32},{0,24,0},{0,0,8}},{{18,9,36},{0,27,\n"
            + "0},{0,0,9}}}},{{{{4,2,8},{0,6,0},{0,0,2}},{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,\n"
            + "0,0},{0,0,0}}},{{{0,0,0},{0,0,0},{0,0,0}},{{6,3,12},{0,9,0},{0,0,3}},{{0,0,0},{0,\n"
            + "0,0},{0,0,0}}},{{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}},{{2,1,4},{0,\n"
            + "3,0},{0,0,1}}}}}");

    // Unicode symbol \[TensorProduct] - \uF3DA looks nearly the same as \[CircleTimes] - \u2997
    check("TensorProduct(a + 2*b, c)", //
        "(a+2*b)\uF3DAc");

    check("TensorProduct({2, 3}, {{a, b}, {c, d}} )", //
        "{{{2*a,2*b},{2*c,2*d}},{{3*a,3*b},{3*c,3*d}}}");
    check("TensorProduct({{{2*a,2*b},{2*c,2*d}},{{3*a,3*b},{3*c,3*d}}}, {x, y})", //
        "{{{{2*a*x,2*a*y},{2*b*x,2*b*y}},{{2*c*x,2*c*y},{2*d*x,2*d*y}}},{{{3*a*x,3*a*y},{\n"
            + "3*b*x,3*b*y}},{{3*c*x,3*c*y},{3*d*x,3*d*y}}}}");
    check("TensorProduct({2, 3}, {{a, b}, {c, d}}, {x, y})", //
        "{{{{2*a*x,2*a*y},{2*b*x,2*b*y}},{{2*c*x,2*c*y},{2*d*x,2*d*y}}},{{{3*a*x,3*a*y},{\n"
            + "3*b*x,3*b*y}},{{3*c*x,3*c*y},{3*d*x,3*d*y}}}}");
    check("TensorProduct({a, b}, {x, y})", //
        "{{a*x,a*y},{b*x,b*y}}");
    check("TensorProduct({x,y}, {a,b})", //
        "{{a*x,b*x},{a*y,b*y}}");

    check(
        "TensorProduct({{3, 8, 2, 7, 7}, {0, 3, 9, 9, 8}}, {{8, 10, 4, 9}, {5, 6, 7, 4}, {2, 3, 2, 9}})", //
        "{{{{24,30,12,27},{15,18,21,12},{6,9,6,27}},{{64,80,32,72},{40,48,56,32},{16,24,\n"
            + "16,72}},{{16,20,8,18},{10,12,14,8},{4,6,4,18}},{{56,70,28,63},{35,42,49,28},{14,\n"
            + "21,14,63}},{{56,70,28,63},{35,42,49,28},{14,21,14,63}}},{{{0,0,0,0},{0,0,0,0},{0,\n"
            + "0,0,0}},{{24,30,12,27},{15,18,21,12},{6,9,6,27}},{{72,90,36,81},{45,54,63,36},{\n"
            + "18,27,18,81}},{{72,90,36,81},{45,54,63,36},{18,27,18,81}},{{64,80,32,72},{40,48,\n"
            + "56,32},{16,24,16,72}}}}");
  }



  public void testRotationTransform() {
    check("RotationTransform(Pi).TranslationTransform({1, -1})", //
        "TransformationFunction(\n" //
            + "{{-1,0,-1},\n" //
            + " {0,-1,1},\n" //
            + " {0,0,1}})"); //

    check("TranslationTransform({1, -1}).RotationTransform(Pi)", //
        "TransformationFunction(\n" //
            + "{{-1,0,1},\n" //
            + " {0,-1,-1},\n" //
            + " {0,0,1}})"); //

    check("RotationTransform(alpha)", //
        "TransformationFunction({{Cos(alpha),-Sin(alpha),0},{Sin(alpha),Cos(alpha),0},{0,\n" //
            + "0,1}})");
  }

  public void testScalingTransform() {
    check("ScalingTransform({a, b, c})", //
        "TransformationFunction(\n" //
            + "{{a,0,0,0},\n" //
            + " {0,b,0,0},\n" //
            + " {0,0,c,0},\n" //
            + " {0,0,0,1}})");

    check("ScalingTransform(s,{1,1})", //
        "TransformationFunction({{1/2*(1+s),1/2*(-1+s),0},{1/2*(-1+s),1/2*(1+s),0},{0,0,1}})");
  }

  public void testShearingTransform() {
    check("ShearingTransform(\\[Theta], {1, 0}, {0, 1})", //
        "TransformationFunction({{1,Tan(θ),0},{0,1,0},{0,0,1}})");
  }

  public void testTransformationFunction() {
    check("r = RotationTransform(\\[Theta]);", //
        "");
    check("r({x, y})", //
        "{x*Cos(θ)-y*Sin(θ),y*Cos(θ)+x*Sin(θ)}");
  }

  public void testTranslationTransform() {

    check("t = TranslationTransform({x0, y0})", //
        "TransformationFunction(\n" //
            + "{{1,0,x0},\n" //
            + " {0,1,y0},\n" //
            + " {0,0,1}})");
    check("t({x, y})", //
        "{x+x0,y+y0}");


    check("TranslationTransform({a,b,c,d})", //
        "TransformationFunction(\n" //
            + "{{1,0,0,0,a},\n" //
            + " {0,1,0,0,b},\n" //
            + " {0,0,1,0,c},\n" //
            + " {0,0,0,1,d},\n" //
            + " {0,0,0,0,1}})");

    check("TranslationTransform({1, 2})", //
        "TransformationFunction(\n" //
            + "{{1,0,1},\n" //
            + " {0,1,2},\n" //
            + " {0,0,1}})"); //
  }

  /** The JUnit setup method */
  @Override
  protected void setUp() {
    super.setUp();
    Config.SHORTEN_STRING_LENGTH = 1024;
    Config.MAX_AST_SIZE = 1000000;
    EvalEngine.get().setIterationLimit(50000);
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
    Config.SHORTEN_STRING_LENGTH = 80;
  }
}
