package domain;

import dtos.FoodRequestDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_food")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Food {

    public Food(FoodRequestDto data) {
        this.title = data.title();
        this.image = data.image();
        this.price = data.price();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String image;

    private Integer price;
}
