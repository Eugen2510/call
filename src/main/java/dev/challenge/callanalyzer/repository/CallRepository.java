package dev.challenge.callanalyzer.repository;

import dev.challenge.callanalyzer.model.entity.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepository extends JpaRepository<Call, Long> {
}
