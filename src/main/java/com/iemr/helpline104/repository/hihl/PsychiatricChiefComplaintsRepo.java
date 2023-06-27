package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.PsychiatricChiefComplaints;

@Repository
public interface PsychiatricChiefComplaintsRepo extends CrudRepository<PsychiatricChiefComplaints, Integer> {
	List<PsychiatricChiefComplaints> findByDeleted(Boolean deleted);
}
