package com.jipbab.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResImg is a Querydsl query type for ResImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResImg extends EntityPathBase<ResImg> {

    private static final long serialVersionUID = 816660543L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResImg resImg = new QResImg("resImg");

    public final StringPath img_name = createString("img_name");

    public final NumberPath<Long> res_img_id = createNumber("res_img_id", Long.class);

    public final StringPath res_imgUrl = createString("res_imgUrl");

    public final StringPath res_oriImgName = createString("res_oriImgName");

    public final StringPath res_repimgYn = createString("res_repimgYn");

    public final QRestaurant restaurant;

    public QResImg(String variable) {
        this(ResImg.class, forVariable(variable), INITS);
    }

    public QResImg(Path<? extends ResImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResImg(PathMetadata metadata, PathInits inits) {
        this(ResImg.class, metadata, inits);
    }

    public QResImg(Class<? extends ResImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant")) : null;
    }

}

