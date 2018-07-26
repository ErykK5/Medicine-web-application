package com.company.vaadindb.dao;

import com.company.vaadindb.model.Med;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MedDAO extends JpaRepository<Med, Long> {

    public Med findByName(String name);

}
