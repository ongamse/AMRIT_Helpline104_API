package com.iemr.helpline104.service.secondaryCrmReports;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public interface CRMSecondaryReportService {
	ByteArrayInputStream getRegistrationReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getHAOReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getMOReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getMODetailsReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getCOReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getMentalHealthReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getGrievanceReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getPrescriptionReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getCDIResponseReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getSchemeServiceReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getDirectoryserviceReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getBloodRequestReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getBloodOnCallCountReportByDate(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getEpidemicoutbreakReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getOrgandonationReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getFoodSafetyReport(String jsonRequest, String filename) throws Exception;
	ByteArrayInputStream getPDSummaryReport(String jsonRequest, String filename) throws Exception;
}
