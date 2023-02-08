package com.jipbab.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestHashTag is a Querydsl query type for RestHashTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestHashTag extends EntityPathBase<RestHashTag> {

    private static final long serialVersionUID = -1628434052L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRestHashTag restHashTag = new QRestHashTag("restHashTag");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QRestaurant restaurant;

    public final StringPath tag = createString("tag");

    public QRestHashTag(String variable) {
        this(RestHashTag.class, forVariable(variable), INITS);
    }

    public QRestHashTag(Path<? extends RestHashTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRestHashTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRestHashTag(PathMetadata metadata, PathInits inits) {
        this(RestHashTag.class, metadata, inits);
    }

    public QRestHashTag(Class<? extends RestHashTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant")) : null;
    }

}

