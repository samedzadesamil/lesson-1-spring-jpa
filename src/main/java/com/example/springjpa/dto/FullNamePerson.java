package com.example.springjpa.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FullNamePerson {
    private String name;
    private String surname;
}
