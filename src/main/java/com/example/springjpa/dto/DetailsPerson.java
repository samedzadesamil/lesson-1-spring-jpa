package com.example.springjpa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DetailsPerson {
   private String name;
   private String surname;
   private String email;
   private String location;

}
