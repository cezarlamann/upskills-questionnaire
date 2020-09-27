package br.com.cezarlamann.upskills.questionnaire.repository;

import br.com.cezarlamann.upskills.questionnaire.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
