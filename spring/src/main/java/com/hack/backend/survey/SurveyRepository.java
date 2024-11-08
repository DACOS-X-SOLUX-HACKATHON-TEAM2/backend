package com.hack.backend.survey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface SurveyRepository extends JpaRepository<Survey,Long> {
}
