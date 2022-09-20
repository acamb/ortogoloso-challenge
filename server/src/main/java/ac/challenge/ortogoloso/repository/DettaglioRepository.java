package ac.challenge.ortogoloso.repository;

import ac.challenge.ortogoloso.model.Dettaglio;
import ac.challenge.ortogoloso.model.Fattura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DettaglioRepository extends CrudRepository<Dettaglio,Long> {
    public List<Dettaglio> findAllByFatturaId(Long id);
}
