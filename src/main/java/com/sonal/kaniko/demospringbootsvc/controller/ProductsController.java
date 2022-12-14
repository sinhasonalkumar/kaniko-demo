package com.sonal.kaniko.demospringbootsvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/v1/products")
@Api(tags = "products")
public class ProductsController {

    @ApiOperation(value = "This web method is used to get the products.")
    @GetMapping
    public ResponseEntity<List<String>> getProducts() {
        return ResponseEntity.ok(Arrays.asList("Bats", "Balls", "Stumps"));
    }

}
