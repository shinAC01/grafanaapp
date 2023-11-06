package cu.uci.grafanapp.repos;

import cu.uci.grafanapp.entity.Registro;
import org.springframework.data.repository.CrudRepository;

public interface IRegistroRepo extends CrudRepository<Registro,Long> {

}
