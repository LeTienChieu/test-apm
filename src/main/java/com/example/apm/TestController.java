package com.example.apm;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/super-fast")
    public String getSuperFastApi() {

        return "Api này chạy nhanh lắm";
    }

    @GetMapping("/fast")
    public String getFastApi() throws InterruptedException {

        Thread.sleep(20);
        return "Api này bị delay 20 mini giây";
    }

    @GetMapping("/slow")
    public String getSlowApi() throws InterruptedException {

        Thread.sleep(3000);
        return "Api này bị delay 3 giây :(";
    }

    @GetMapping("/super-slow")
    @Profile({"predev", "dev", "staging"})
    public String getSuperSlowApi() throws InterruptedException {

        Thread.sleep(10000);
        return "Api này siêu chậm delay tận 10 giây. Hãy xem sự khác biệt khi trace bằng apm nhé";
    }
}
