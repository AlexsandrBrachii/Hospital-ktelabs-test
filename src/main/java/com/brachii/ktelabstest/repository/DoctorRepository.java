package com.brachii.ktelabstest.repository;

import com.brachii.ktelabstest.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>  {
}
