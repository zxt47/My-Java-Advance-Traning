package com.mars.car.marscar.domain;

import lombok.Data;

/**
 * 需要探测的地图，看看是否可以直接使用JDK原生的Map
 */
@Data
public class Map {
  int x;
  int y;
}