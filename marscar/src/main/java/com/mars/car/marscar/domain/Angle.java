package com.mars.car.marscar.domain;


/**
 * 角度
 * 应该有一个状态转移的过程
 */
public enum Angle {
  N("W","E"),S("W","E"),W("S","N"),E("N","S");

  private String leftStatus;

  private String rightStatus;


  private Angle(String leftStatus,String rightStatus)
  {
      this.leftStatus=leftStatus;
      this.rightStatus=rightStatus;
  }

  public String getLeftStatus() {
    return leftStatus;
  }

  public String getRightStatus() {
    return rightStatus;
  }
}
