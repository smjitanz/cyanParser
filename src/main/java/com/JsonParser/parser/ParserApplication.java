package com.JsonParser.parser;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Iterator;

@SpringBootApplication
public class ParserApplication {

	public static void main(String[] args) {

		SpringApplication.run(ParserApplication.class, args);
		String json = "{\n" +
				"\"usages\":[\n" +
				"{\n" +
				"   \"createTime\":\"2017-12-15T11:11:23+0000\",\n" +
				"   \"deviceId\":\"METER 123\",\n" +
				"   \"formattedProfileObisCode\":\"1.0.94.91.0.255\",\n" +
				"   \"meterSampleId\":1,\n" +
				"   \"registerValues\":[\n" +
				"      {\n" +
				"         \"attributeId\":1,\n" +
				"         \"formattedRegisterObisCode\":\"0.0.1.0.0.255\",\n" +
				"         \"formattedValue\":\"2017-12-15T11:03:03\"\n" +
				"      },\n" +
				"      {\n" +
				"         \"attributeId\":2,\n" +
				"         \"formattedRegisterObisCode\":\"1.0.31.7.0.255\",\n" +
				"         \"formattedValue\":\"0 A\"\n" +
				"      }\n" +
				"   ]\n" +
				"},\n" +
				"{\n" +
				"   \"createTime\":\"2017-12-15T11:16:23+0000\",\n" +
				"   \"deviceId\":\"METER 123\",\n" +
				"   \"formattedProfileObisCode\":\"1.0.94.91.0.255\",\n" +
				"   \"meterSampleId\":2,\n" +
				"   \"registerValues\":[\n" +
				"      {\n" +
				"         \"attributeId\":3,\n" +
				"         \"formattedRegisterObisCode\":\"0.0.1.0.0.255\",\n" +
				"         \"formattedValue\":\"2017-12-15T11:08:03\"\n" +
				"      },\n" +
				"      {\n" +
				"         \"attributeId\":4,\n" +
				"         \"formattedRegisterObisCode\":\"1.0.31.7.0.255\",\n" +
				"         \"formattedValue\":\"0 A\"\n" +
				"      }\n" +
				"   ]\n" +
				"}\n" +
				"]}";


		Gson gson = new Gson(); // Or use new GsonBuilder().create();
		ListUsage target2 = gson.fromJson(json, ListUsage.class);

		target2.usages.forEach(usage -> usage.registerValues.forEach(interval -> System.out.println(interval.getAttributeId())));
		
	}

}

class ListUsage{
	ArrayList<Usage> usages = new ArrayList<Usage>();
}
class Usage {
	private String createTime;
	private String deviceId;
	private String formattedProfileObisCode;
	private float meterSampleId;
	ArrayList<Intervals> registerValues = new ArrayList <Intervals> ();


	// Getter Methods

	public String getCreateTime() {
		return createTime;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public String getFormattedProfileObisCode() {
		return formattedProfileObisCode;
	}

	public float getMeterSampleId() {
		return meterSampleId;
	}

	// Setter Methods

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public void setFormattedProfileObisCode(String formattedProfileObisCode) {
		this.formattedProfileObisCode = formattedProfileObisCode;
	}

	public void setMeterSampleId(float meterSampleId) {
		this.meterSampleId = meterSampleId;
	}
}
class Intervals {
	private String attributeId;
	private String formattedRegisterObisCode;
	private String formattedValue;


	// Getter Methods

	public String getAttributeId() {
		return attributeId;
	}


	public String getFormattedProfileObisCode() {
		return formattedRegisterObisCode;
	}

	public String getFormattedValue() {
		return formattedValue;
	}

	// Setter Methods

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public void setFormattedProfileObisCode(String formattedRegisterObisCode) {
		this.formattedRegisterObisCode = formattedRegisterObisCode;
	}

	public void setFormattedValue(String formattedValue) {
		this.formattedValue = formattedValue;
	}
}