package uz.pdp.warehouseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WarehouseAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehouseAppApplication.class, args);

        System.out.println("Dastur ishga tushdi !!!");
    }

}
