package com.iemr.helpline104.service.directory;

import java.util.List;

import com.iemr.helpline104.data.directory.Directory;
import com.iemr.helpline104.data.directory.Directoryservice;

public interface DirectoryServiceService {
	public List<Directory> getDirectories();

	List<Directoryservice> getDirectorySearchHistory(Long beneficiaryId, Long benCallID);

	String saveDirectorySearchHistory(Directoryservice[] directoryservice);

}
