package com.hack.backend.survey.repository;

import com.hack.backend.survey.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SurveyRepository extends JpaRepository<Survey,Long> {
}
