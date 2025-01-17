package com.example.esarest.dto;

import com.example.esarest.dto.base.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class BookDto implements BaseDto {

    private String title;

    private String description;

    private Long libraryId;

}
