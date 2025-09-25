package com.pikcurchu.pikcur.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Tag(name="테스트 api", description = "안녕나는테스트")
@Controller
@RequestMapping("/test")
public class testController {

    @Operation(summary = "첫번째메소드", description = "안농하세오")
    @GetMapping("/hi")
    public void test() {

    }

}
