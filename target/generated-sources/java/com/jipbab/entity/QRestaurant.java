package com.jipbab.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRestaurant is a Querydsl query type for Restaurant
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurant extends EntityPathBase<Restaurant> {

    private static final long serialVersionUID = 1790012025L;

    public static final QRestaurant restaurant = new QRestaurant("restaurant");

    public final NumberPath<Integer> heart = createNumber("heart", Integer.class);

    public final StringPath information = createString("information");

    public final StringPath location = createString("location");

    public final NumberPath<Long> res_id = createNumber("res_id", Long.class);

    public final StringPath res_name = createString("res_name");

    public final StringPath time1 = createString("time1");

    public final StringPath time2 = createString("time2");

    public QRestaurant(String variable) {
        super(Restaurant.class, forVariable(variable));
    }

    public QRestaurant(Path<? extends Restaurant> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRestaurant(PathMetadata metadata) {
        super(Restaurant.class, metadata);
    }

}

