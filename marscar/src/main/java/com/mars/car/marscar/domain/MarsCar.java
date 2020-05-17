package com.mars.car.marscar.domain;

import lombok.Data;

/**
 * 火星车的实现v1
 */
@Data
public class MarsCar {

      /**
       * x轴的位置
       */
      public int x;
      /**
       * y轴的位置
       */
      public int y;
      /**
       * 角度
       */
      public Angle angle;

      public MarsCar(int x,int y,Angle angle)
      {
            this();
            this.setX(x);
            this.setY(y);
            this.setAngle(angle);
      }

      public void move(MoveType type)
      {
            if (type.equals(MoveType.R))
                  this.angle=Angle.valueOf(angle.getRightStatus());
            else if(type.equals(MoveType.L))
                  this.angle=Angle.valueOf(angle.getLeftStatus());
            else if(type.equals(MoveType.M))
            {
                  if(angle.equals(Angle.E))
                        x=x+1;
                  else if(angle.equals(Angle.W))
                        x=x-1;
                  else if(angle.equals(Angle.N))
                        y=y+1;
                  else
                        y=y-1;
            }
      }


      public void displayEndLocation()
      {
            System.out.println(this.x+"\t"+this.y+"\t"+this.angle);
      }
}