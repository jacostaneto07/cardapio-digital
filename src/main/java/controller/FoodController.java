package controller;

import dtos.FoodRequestDto;
import dtos.FoodResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FoodService;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    public ResponseEntity<List<FoodResponseDto>> getAll() {
        List<FoodResponseDto> foodList = foodService.getAll().stream().map(FoodResponseDto::new).toList();
        return ResponseEntity.ok().body(foodList);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/save")
    public void save(@RequestBody FoodRequestDto data) {
        foodService.save(data);
    }
}
