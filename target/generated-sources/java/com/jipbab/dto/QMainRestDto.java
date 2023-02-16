package com.jipbab.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.jipbab.dto.QMainRestDto is a Querydsl Projection type for MainRestDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMainRestDto extends ConstructorExpression<MainRestDto> {

    private static final long serialVersionUID = 758791220L;

    public QMainRestDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> resName, com.querydsl.core.types.Expression<String> information, com.querydsl.core.types.Expression<String> resImgUrl) {
        super(MainRestDto.class, new Class<?>[]{long.class, String.class, String.class, String.class}, id, resName, information, resImgUrl);
    }

}

