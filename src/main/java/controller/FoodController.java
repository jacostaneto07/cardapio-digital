package controller;

import dtos.FoodResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.FoodService;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/list")
    public ResponseEntity<List<FoodResponseDto>> getAll() {
        List<FoodResponseDto> foodList = foodService.getAll().stream().map(FoodResponseDto::new).toList();
        return ResponseEntity.ok().body(foodList);
    }
}
