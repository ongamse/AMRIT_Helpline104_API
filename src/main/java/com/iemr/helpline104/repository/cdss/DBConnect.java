package com.iemr.helpline104.repository.cdss;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.cdss.Symptoms;

@Repository
@RestResource(exported = false)
public interface DBConnect extends CrudRepository<Symptoms, Integer> {
	
	@Query("SELECT Symptom FROM Symptoms s group by Symptom")
	List<String> getSymptoms();

	@Query(value="SELECT * FROM m_cdssdata s where LOWER(s.Symptom) = LOWER(:symptom) and :age>=s.AgeFrom and :age<=s.AgeTo and s.Gender like %:gender% order by(s.AgeTo-s.AgeFrom) Limit 1",nativeQuery=true)
	Symptoms getQuestions(@Param("symptom") String symptom,@Param("age")int age,@Param("gender") String gender);

	@Query("SELECT Data FROM Symptoms s where LOWER(s.SymptomId) = LOWER(:id) ")
	String getResultsById(@Param("id") int id);

	@Query("SELECT Symptom FROM Symptoms s where :age>=s.AgeFrom and :age<=s.AgeTo and s.Gender like %:gender%  group by Symptom")
	List<String> getSymptoms(@Param("gender")String gender, @Param("age")int age);


	
}
