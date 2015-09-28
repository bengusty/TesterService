package demo;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTester is a Querydsl query type for Tester
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTester extends EntityPathBase<Tester> {

    private static final long serialVersionUID = -862964918L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTester tester = new QTester("tester");

    public final ListPath<Bug, QBug> bugs = this.<Bug, QBug>createList("bugs", Bug.class, QBug.class, PathInits.DIRECT2);

    public final QCountry country;

    public final ListPath<Device, QDevice> devices = this.<Device, QDevice>createList("devices", Device.class, QDevice.class, PathInits.DIRECT2);

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath lastName = createString("lastName");

    public QTester(String variable) {
        this(Tester.class, forVariable(variable), INITS);
    }

    public QTester(Path<? extends Tester> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTester(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTester(PathMetadata<?> metadata, PathInits inits) {
        this(Tester.class, metadata, inits);
    }

    public QTester(Class<? extends Tester> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.country = inits.isInitialized("country") ? new QCountry(forProperty("country")) : null;
    }

}

