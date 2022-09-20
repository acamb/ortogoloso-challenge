package ac.challenge.ortogoloso.repository;

import ac.challenge.ortogoloso.model.Fattura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatturaRepository extends CrudRepository<Fattura,Long> {

}
