package com.iemr.helpline104.repository.drugGroup;

import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.drugGroup.M_DrugGroup;

@Repository
@RestResource(exported = false)
public interface DrugGroupRepository extends CrudRepository<M_DrugGroup, Long>{
	
		@Query("select d.drugGroupID,d.drugGroup,d.drugGroupDesc,d.serviceProviderID from M_DrugGroup d"
				+ " where d.deleted=false and d.serviceProviderID=:serviceProviderID")
		public List<Objects[]> getDrugGroups(@Param("serviceProviderID") Integer serviceProviderID) throws Exception;
		
		/*
		@Query("select d from M_DrugGroup d"
				+ " INNER JOIN d.m_drugMaster m where d.deleted=false and m.deleted=false")
		public M_DrugGroup getDrugsList() throws Exception;*/
		
		/*@Query("select d from M_DrugGroup d"
				+ " INNER JOIN d.m_drugMaster m where d.deleted=false and m.deleted=false and d.providerServiceMapID=:providerServiceMapID group by d.drugGroupID")
		public List<Objects[]> getDrugsList(@Param("providerServiceMapID") Integer providerServiceMapID) throws Exception;*/
		

		
		
		@Query("select d.drugMapID,d.drugId,d.drugName,d.drugGroupID,d.drugGroupName,m.remarks,d.providerServiceMapID "
				+ "from M_104drugmapping d  "
				+ " INNER JOIN d.m_drugMaster m "
				+ "where d.deleted=false and m.deleted= false and d.providerServiceMapID=:providerServiceMapID and d.drugGroupID=:drugGroupID")
		public List<Objects[]>  getDrugList(@Param("providerServiceMapID") Integer providerServiceMapID, @Param("drugGroupID") Integer drugGroupID) throws Exception;
		
		
		@Query("select d.drugMapID,d.drugId,d.drugName,d.drugGroupID,d.drugGroupName,m.remarks,d.providerServiceMapID "
				+ "from M_104drugmapping d  "
				+ " INNER JOIN d.m_drugMaster m "
				+ "where d.deleted=false and m.deleted= false and d.providerServiceMapID=:providerServiceMapID order by d.drugName ")
		public List<Objects[]>  getDrugDetailList(@Param("providerServiceMapID") Integer providerServiceMapID) throws Exception;
		
}
