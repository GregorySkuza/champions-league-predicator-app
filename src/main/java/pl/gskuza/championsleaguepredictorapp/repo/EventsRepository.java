package pl.gskuza.championsleaguepredictorapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gskuza.championsleaguepredictorapp.model.Events;
import pl.gskuza.championsleaguepredictorapp.model.EventsContainer;

import java.util.List;


@Repository
public interface EventsRepository extends JpaRepository<Events,Long> {

}
