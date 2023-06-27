package com.iemr.helpline104.service.report;

import java.util.List;

import com.iemr.helpline104.data.report.BeneficiaryReport;
import com.iemr.helpline104.data.report.BenmedhistoryReport;
import com.iemr.helpline104.data.report.BloodrequestReport;
import com.iemr.helpline104.data.report.COReport;
import com.iemr.helpline104.data.report.DirectoryserviceReport;
import com.iemr.helpline104.data.report.EpidemicoutbreakReport;
import com.iemr.helpline104.data.report.FeedbackReport;
import com.iemr.helpline104.data.report.FoodsafetyReport;
import com.iemr.helpline104.data.report.MOReport;
import com.iemr.helpline104.data.report.MedicalHistory;
import com.iemr.helpline104.data.report.OrgandonationReport;
import com.iemr.helpline104.data.report.PrescriptionReport;
import com.iemr.helpline104.data.report.SchemeserviceReport;

public interface CRMReportsService {	

	List<EpidemicoutbreakReport> getEpidemicoutbreakReport(String jsonRequest) throws Exception;
	List<BeneficiaryReport> getRegistrationReport(String jsonRequest) throws Exception;
	List<MedicalHistory> getHAOSummaryReport(String jsonRequest) throws Exception;
	List<MOReport> getMOSummaryReport(String jsonRequest) throws Exception;
	List<COReport> getCOSummaryReport(String jsonRequest) throws Exception;
	List<BenmedhistoryReport> getPDSummaryReport(String jsonRequest) throws Exception;
	List<BloodrequestReport> getBloodRequestReport(String jsonRequest) throws Exception;
	List<DirectoryserviceReport> getDirectoryserviceReport(String jsonRequest) throws Exception;
	List<OrgandonationReport> getOrgandonationReport(String jsonRequest) throws Exception;
	List<SchemeserviceReport> getSchemeServiceReport(String jsonRequest) throws Exception;
	List<FeedbackReport> getFeedbackReport(String jsonRequest) throws Exception;
	List<FoodsafetyReport> getFoodsafetyReport(String jsonRequest) throws Exception;
	List<PrescriptionReport> getPrescriptionReport(String jsonRequest) throws Exception;
	String getBloodOnCallCountReportByDate(String request) throws Exception;
	String getMentalHealthReport(String request) throws Exception;
	String getMedicalAdviseReport(String request) throws Exception;
	String getCDIResponseReport(String request) throws Exception;
}
