package com.company.vaadindb.dao;

import com.company.vaadindb.model.Med;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MedDAO extends JpaRepository<Med, Long> {

    //List<Med> findByLastNameStartsWithIgnoreCase(String lastName );

    public Med findByName(String name);

}
