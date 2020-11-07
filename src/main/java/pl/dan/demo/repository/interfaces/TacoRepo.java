package pl.dan.demo.repository.interfaces;

import org.springframework.data.repository.CrudRepository;
import pl.dan.demo.model.Taco;

public interface TacoRepo extends CrudRepository<Taco, Long> {
}
