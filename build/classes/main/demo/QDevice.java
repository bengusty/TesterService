package demo;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDevice is a Querydsl query type for Device
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDevice extends EntityPathBase<Device> {

    private static final long serialVersionUID = -1320952607L;

    public static final QDevice device = new QDevice("device");

    public final StringPath description = createString("description");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QDevice(String variable) {
        super(Device.class, forVariable(variable));
    }

    public QDevice(Path<? extends Device> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDevice(PathMetadata<?> metadata) {
        super(Device.class, metadata);
    }

}

