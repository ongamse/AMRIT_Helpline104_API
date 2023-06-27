package com.iemr.helpline104.repository.hihl;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.hihl.T_hihlcocasesheet;

@Repository
public interface T_hihlcocasesheetRepo extends CrudRepository<T_hihlcocasesheet, Long> {

	@Query(value = "SELECT * from T_hihlcocasesheet WHERE BeneficiaryRegID = :benRegId ORDER BY ID DESC LIMIT 5", nativeQuery = true)
	List<T_hihlcocasesheet> getHihlCasesheets(@Param("benRegId") Long benRegId);

	T_hihlcocasesheet findById(Long id);
}
