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

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgName = createString("imgName");

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final StringPath oriImgName = createString("oriImgName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regTime = _super.regTime;

    public final StringPath resImgUrl = createString("resImgUrl");

    public final StringPath resRepimgYn = createString("resRepimgYn");

    public final QRestaurant restaurant;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> upDateTime = _super.upDateTime;

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

