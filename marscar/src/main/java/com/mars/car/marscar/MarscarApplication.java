package com.mars.car.marscar;

import com.mars.car.marscar.domain.Angle;
import com.mars.car.marscar.domain.MarsCar;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarscarApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(MarscarApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    MarsCar marsCar=new MarsCar(1,1, Angle.N);
    //接收指令进行操作
    marsCar.displayEndLocation();
  }
}
