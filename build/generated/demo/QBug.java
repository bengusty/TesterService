package demo;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QBug is a Querydsl query type for Bug
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBug extends EntityPathBase<Bug> {

    private static final long serialVersionUID = 855458761L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBug bug = new QBug("bug");

    public final QDevice device;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final QTester tester;

    public QBug(String variable) {
        this(Bug.class, forVariable(variable), INITS);
    }

    public QBug(Path<? extends Bug> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBug(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBug(PathMetadata<?> metadata, PathInits inits) {
        this(Bug.class, metadata, inits);
    }

    public QBug(Class<? extends Bug> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.device = inits.isInitialized("device") ? new QDevice(forProperty("device")) : null;
        this.tester = inits.isInitialized("tester") ? new QTester(forProperty("tester"), inits.get("tester")) : null;
    }

}

