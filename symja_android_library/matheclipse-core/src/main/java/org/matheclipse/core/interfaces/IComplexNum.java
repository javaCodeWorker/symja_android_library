package org.matheclipse.core.interfaces;

/** */
public interface IComplexNum extends INumber {
  public IComplexNum add(IComplexNum val);

  @Override
  public IComplexNum conjugate();

  /**
   * Return the absolute value of this complex number.
   *
   * <p>
   * Returns <code>NaN</code> if either real or imaginary part is <code>NaN</code> and <code>
   * Double.POSITIVE_INFINITY</code> if neither part is <code>NaN</code>, but at least one part
   * takes an infinite value.
   *
   * @return the absolute value
   */
  public double dabs();

  public IComplexNum divide(IComplexNum val);

  public double getImaginaryPart();

  public double getRealPart();

  @Override
  default long leafCount() {
    return 3;
  }

  public IComplexNum multiply(IComplexNum val);

  public IComplexNum subtract(IComplexNum subtrahend);

  public IComplexNum pow(IComplexNum val);

  public long precision();
}
