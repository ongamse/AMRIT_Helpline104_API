package com.iemr.helpline104.service.directory;

import java.util.List;

import com.iemr.helpline104.data.directory.SubDirectory;

public interface SubDirectoryService {	
	public List<SubDirectory> getSubDirectories(int directoryID);
}
