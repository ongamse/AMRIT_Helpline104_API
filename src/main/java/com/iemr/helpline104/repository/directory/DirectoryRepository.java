package com.iemr.helpline104.repository.directory;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.helpline104.data.directory.Directory;

@Repository
@RestResource(exported = false)
public interface DirectoryRepository extends CrudRepository<Directory, Long> {
	@Query("select instituteDirectoryID, instituteDirectoryName from Directory where Deleted = false")
	public Set<Objects[]> findAciveDirectories();
}
