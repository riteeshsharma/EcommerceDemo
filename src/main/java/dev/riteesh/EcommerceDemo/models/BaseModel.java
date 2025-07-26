package dev.riteesh.EcommerceDemo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseModel {
    private long id;
    private DateTimeFormat createdAt;
    private DateTimeFormat updatedAt;

}
