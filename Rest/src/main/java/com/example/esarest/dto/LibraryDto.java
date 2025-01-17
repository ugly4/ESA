package com.example.esarest.dto;

import com.example.esarest.dto.base.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LibraryDto implements BaseDto {

    private String name;

    private String address;

}
