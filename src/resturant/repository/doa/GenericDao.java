package resturant.repository.doa;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
    void create(T t);

    T read(PK id);

    void update(T t);

    void delete(T t);

    List<T> selectAll();
}
