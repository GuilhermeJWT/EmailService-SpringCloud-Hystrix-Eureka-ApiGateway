package br.com.systemgs.emailservice.repository;

import br.com.systemgs.emailservice.model.ModelEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<ModelEmail, Long> {

}
