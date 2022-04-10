package jeronimo.teste.brasilprev.dao.api.postgres;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jeronimo.teste.brasilprev.entities.Address;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddresRepository implements PanacheRepository<Address> {
}
