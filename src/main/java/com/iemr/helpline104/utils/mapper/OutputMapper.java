package com.iemr.helpline104.utils.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

public class OutputMapper {
	static GsonBuilder builder;

	public OutputMapper() {
		if (builder == null) {
			builder = new GsonBuilder();
			builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			builder.excludeFieldsWithoutExposeAnnotation();
			builder.setLongSerializationPolicy(LongSerializationPolicy.STRING);
			builder.serializeNulls();
		}
	}

	public static Gson gson() {
		return builder.create();
	}
}