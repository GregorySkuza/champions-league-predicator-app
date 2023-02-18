package pl.gskuza.championsleaguepredictorapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gskuza.championsleaguepredictorapp.model.Competitor;


@Repository
public interface CompetitorRepository extends JpaRepository<Competitor,Long> {
}
