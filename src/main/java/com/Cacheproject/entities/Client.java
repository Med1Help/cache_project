package com.Cacheproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "clients")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Client extends BaseEntity{

    private String name;
    private String phone;
    private String adr;
}
