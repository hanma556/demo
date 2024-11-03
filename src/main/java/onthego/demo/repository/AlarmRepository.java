package onthego.demo.repository;

import onthego.demo.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long> {
    Alarm findFirstByOrderByIdAsc();
} 