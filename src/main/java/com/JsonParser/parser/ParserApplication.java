package com.JsonParser.parser;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SpringBootApplication
public class ParserApplication {

	public static void main(String[] args) throws JAXBException {

		SpringApplication.run(ParserApplication.class, args);
		String json = "{\n" +
				"\"usages\":[\n" +
				"    {\n" +
				"        \"meterSampleId\": 1,\n" +
				"        \"sequenceNumber\": 11722,\n" +
				"        \"deviceId\": \"022176991002\",\n" +
				"        \"nodeId\": \"00-1b-c5-0c-60-06-74-0b\",\n" +
				"        \"profileObisCode\": \"AQBjAQD/\",\n" +
				"        \"formattedProfileObisCode\": \"1.0.99.1.0.255\",\n" +
				"        \"registerValues\": [\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AAABAAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"0.0.1.0.0.255\",\n" +
				"                \"formattedValue\": \"2020-03-25T18:00:00Z\",\n" +
				"                \"attributeId\": 2,\n" +
				"                \"unit\": 0,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"CQwH5AMZAxIAAACAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQABBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.1.4.0.255\",\n" +
				"                \"formattedValue\": \"2 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAI=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQACBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.2.4.0.255\",\n" +
				"                \"formattedValue\": \"0 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQADBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.3.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQAEBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.4.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"sampleTime\": \"2020-03-25T17:00:00Z\",\n" +
				"        \"createTime\": \"2020-03-25T17:15:38Z\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"meterSampleId\": 2,\n" +
				"        \"sequenceNumber\": 11723,\n" +
				"        \"deviceId\": \"022176991002\",\n" +
				"        \"nodeId\": \"00-1b-c5-0c-60-06-74-0b\",\n" +
				"        \"profileObisCode\": \"AQBjAQD/\",\n" +
				"        \"formattedProfileObisCode\": \"1.0.99.1.0.255\",\n" +
				"        \"registerValues\": [\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AAABAAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"0.0.1.0.0.255\",\n" +
				"                \"formattedValue\": \"2020-03-25T18:15:00Z\",\n" +
				"                \"attributeId\": 2,\n" +
				"                \"unit\": 0,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"CQwH5AMZAxIPAACAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQABBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.1.4.0.255\",\n" +
				"                \"formattedValue\": \"3 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAM=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQACBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.2.4.0.255\",\n" +
				"                \"formattedValue\": \"0 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQADBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.3.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQAEBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.4.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"sampleTime\": \"2020-03-25T17:15:00Z\",\n" +
				"        \"createTime\": \"2020-03-25T17:15:39Z\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"meterSampleId\": 3,\n" +
				"        \"sequenceNumber\": 11724,\n" +
				"        \"deviceId\": \"022176991002\",\n" +
				"        \"nodeId\": \"00-1b-c5-0c-60-06-74-0b\",\n" +
				"        \"profileObisCode\": \"AQBjAQD/\",\n" +
				"        \"formattedProfileObisCode\": \"1.0.99.1.0.255\",\n" +
				"        \"registerValues\": [\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AAABAAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"0.0.1.0.0.255\",\n" +
				"                \"formattedValue\": \"2020-03-25T18:30:00Z\",\n" +
				"                \"attributeId\": 2,\n" +
				"                \"unit\": 0,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"CQwH5AMZAxIeAACAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQABBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.1.4.0.255\",\n" +
				"                \"formattedValue\": \"3 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAM=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQACBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.2.4.0.255\",\n" +
				"                \"formattedValue\": \"0 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQADBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.3.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQAEBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.4.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"sampleTime\": \"2020-03-25T17:30:00Z\",\n" +
				"        \"createTime\": \"2020-03-25T17:30:38Z\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"meterSampleId\": 4,\n" +
				"        \"sequenceNumber\": 11725,\n" +
				"        \"deviceId\": \"022176991002\",\n" +
				"        \"nodeId\": \"00-1b-c5-0c-60-06-74-0b\",\n" +
				"        \"profileObisCode\": \"AQBjAQD/\",\n" +
				"        \"formattedProfileObisCode\": \"1.0.99.1.0.255\",\n" +
				"        \"registerValues\": [\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AAABAAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"0.0.1.0.0.255\",\n" +
				"                \"formattedValue\": \"2020-03-25T18:45:00Z\",\n" +
				"                \"attributeId\": 2,\n" +
				"                \"unit\": 0,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"CQwH5AMZAxItAACAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQABBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.1.4.0.255\",\n" +
				"                \"formattedValue\": \"3 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAM=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQACBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.2.4.0.255\",\n" +
				"                \"formattedValue\": \"0 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQADBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.3.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQAEBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.4.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"sampleTime\": \"2020-03-25T17:45:00Z\",\n" +
				"        \"createTime\": \"2020-03-25T17:45:38Z\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"meterSampleId\": 5,\n" +
				"        \"sequenceNumber\": 11726,\n" +
				"        \"deviceId\": \"022176991002\",\n" +
				"        \"nodeId\": \"00-1b-c5-0c-60-06-74-0b\",\n" +
				"        \"profileObisCode\": \"AQBjAQD/\",\n" +
				"        \"formattedProfileObisCode\": \"1.0.99.1.0.255\",\n" +
				"        \"registerValues\": [\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AAABAAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"0.0.1.0.0.255\",\n" +
				"                \"formattedValue\": \"2020-03-25T19:00:00Z\",\n" +
				"                \"attributeId\": 2,\n" +
				"                \"unit\": 0,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"CQwH5AMZAxMAAACAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQABBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.1.4.0.255\",\n" +
				"                \"formattedValue\": \"3 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAM=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQACBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.2.4.0.255\",\n" +
				"                \"formattedValue\": \"0 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQADBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.3.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQAEBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.4.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"sampleTime\": \"2020-03-25T18:00:00Z\",\n" +
				"        \"createTime\": \"2020-03-25T18:00:38Z\"\n" +
				"    },\n" +
				"  {\n" +
				"        \"meterSampleId\": 1,\n" +
				"        \"sequenceNumber\": 11722,\n" +
				"        \"deviceId\": \"022176991001\",\n" +
				"        \"nodeId\": \"00-1b-c5-0c-60-06-74-0b\",\n" +
				"        \"profileObisCode\": \"AQBjAQD/\",\n" +
				"        \"formattedProfileObisCode\": \"1.0.99.1.0.255\",\n" +
				"        \"registerValues\": [\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AAABAAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"0.0.1.0.0.255\",\n" +
				"                \"formattedValue\": \"2020-03-25T18:00:00Z\",\n" +
				"                \"attributeId\": 2,\n" +
				"                \"unit\": 0,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"CQwH5AMZAxIAAACAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQABBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.1.4.0.255\",\n" +
				"                \"formattedValue\": \"2 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAI=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQACBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.2.4.0.255\",\n" +
				"                \"formattedValue\": \"0 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQADBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.3.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQAEBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.4.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"sampleTime\": \"2020-03-25T17:00:00Z\",\n" +
				"        \"createTime\": \"2020-03-25T17:15:38Z\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"meterSampleId\": 2,\n" +
				"        \"sequenceNumber\": 11723,\n" +
				"        \"deviceId\": \"022176991001\",\n" +
				"        \"nodeId\": \"00-1b-c5-0c-60-06-74-0b\",\n" +
				"        \"profileObisCode\": \"AQBjAQD/\",\n" +
				"        \"formattedProfileObisCode\": \"1.0.99.1.0.255\",\n" +
				"        \"registerValues\": [\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AAABAAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"0.0.1.0.0.255\",\n" +
				"                \"formattedValue\": \"2020-03-25T18:15:00Z\",\n" +
				"                \"attributeId\": 2,\n" +
				"                \"unit\": 0,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"CQwH5AMZAxIPAACAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQABBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.1.4.0.255\",\n" +
				"                \"formattedValue\": \"3 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAM=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQACBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.2.4.0.255\",\n" +
				"                \"formattedValue\": \"0 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQADBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.3.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQAEBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.4.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"sampleTime\": \"2020-03-25T17:15:00Z\",\n" +
				"        \"createTime\": \"2020-03-25T17:15:39Z\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"meterSampleId\": 3,\n" +
				"        \"sequenceNumber\": 11724,\n" +
				"        \"deviceId\": \"022176991001\",\n" +
				"        \"nodeId\": \"00-1b-c5-0c-60-06-74-0b\",\n" +
				"        \"profileObisCode\": \"AQBjAQD/\",\n" +
				"        \"formattedProfileObisCode\": \"1.0.99.1.0.255\",\n" +
				"        \"registerValues\": [\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AAABAAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"0.0.1.0.0.255\",\n" +
				"                \"formattedValue\": \"2020-03-25T18:30:00Z\",\n" +
				"                \"attributeId\": 2,\n" +
				"                \"unit\": 0,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"CQwH5AMZAxIeAACAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQABBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.1.4.0.255\",\n" +
				"                \"formattedValue\": \"3 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAM=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQACBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.2.4.0.255\",\n" +
				"                \"formattedValue\": \"0 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQADBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.3.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQAEBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.4.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"sampleTime\": \"2020-03-25T17:30:00Z\",\n" +
				"        \"createTime\": \"2020-03-25T17:30:38Z\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"meterSampleId\": 4,\n" +
				"        \"sequenceNumber\": 11725,\n" +
				"        \"deviceId\": \"022176991001\",\n" +
				"        \"nodeId\": \"00-1b-c5-0c-60-06-74-0b\",\n" +
				"        \"profileObisCode\": \"AQBjAQD/\",\n" +
				"        \"formattedProfileObisCode\": \"1.0.99.1.0.255\",\n" +
				"        \"registerValues\": [\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AAABAAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"0.0.1.0.0.255\",\n" +
				"                \"formattedValue\": \"2020-03-25T18:45:00Z\",\n" +
				"                \"attributeId\": 2,\n" +
				"                \"unit\": 0,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"CQwH5AMZAxItAACAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQABBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.1.4.0.255\",\n" +
				"                \"formattedValue\": \"3 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAM=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQACBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.2.4.0.255\",\n" +
				"                \"formattedValue\": \"0 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQADBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.3.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQAEBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.4.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"sampleTime\": \"2020-03-25T17:45:00Z\",\n" +
				"        \"createTime\": \"2020-03-25T17:45:38Z\"\n" +
				"    },\n" +
				"    {\n" +
				"        \"meterSampleId\": 5,\n" +
				"        \"sequenceNumber\": 11726,\n" +
				"        \"deviceId\": \"022176991001\",\n" +
				"        \"nodeId\": \"00-1b-c5-0c-60-06-74-0b\",\n" +
				"        \"profileObisCode\": \"AQBjAQD/\",\n" +
				"        \"formattedProfileObisCode\": \"1.0.99.1.0.255\",\n" +
				"        \"registerValues\": [\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AAABAAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"0.0.1.0.0.255\",\n" +
				"                \"formattedValue\": \"2020-03-25T19:00:00Z\",\n" +
				"                \"attributeId\": 2,\n" +
				"                \"unit\": 0,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"CQwH5AMZAxMAAACAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQABBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.1.4.0.255\",\n" +
				"                \"formattedValue\": \"3 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAM=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQACBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.2.4.0.255\",\n" +
				"                \"formattedValue\": \"0 W\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 27,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQADBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.3.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            },\n" +
				"            {\n" +
				"                \"registerObisCode\": \"AQAEBAD/\",\n" +
				"                \"formattedRegisterObisCode\": \"1.0.4.4.0.255\",\n" +
				"                \"formattedValue\": \"0 var\",\n" +
				"                \"attributeId\": 3,\n" +
				"                \"unit\": 29,\n" +
				"                \"scalar\": 0,\n" +
				"                \"registerValue\": \"BgAAAAA=\"\n" +
				"            }\n" +
				"        ],\n" +
				"        \"sampleTime\": \"2020-03-25T18:00:00Z\",\n" +
				"        \"createTime\": \"2020-03-25T18:00:38Z\"\n" +
				"    }\n" +
				"\n" +
				"]\n" +
				"}";


		Gson gson = new Gson(); // Or use new GsonBuilder().create();
		ListUsage target2 = gson.fromJson(json, ListUsage.class);

		//new Work
		Devices devices = new Devices();
		Device device = new Device();
		mL ml = new mL();
		preVEE preVee = new preVEE();
		InitialMeasurementData initialMeasurementData = new InitialMeasurementData();
		LocalDateTime startDate = null;
		LocalDateTime endDate = null;
		int count=1;

		ArrayList<String> devicesIds = new ArrayList<String>();

		System.out.println(target2.usages);

		for(Usage usage :target2.usages){

			if(devicesIds.contains(usage.getDeviceId()))
				continue;

			device = new Device();

			device.setHeadEnd("Value 1 from Properties");
			device.setHeadEndExternalId("value 2 from properties");
			device.setDeviceIdentifierNumber(usage.getDeviceId());

			List<Usage> sameDevices = target2.usages.stream().filter(i -> i.getDeviceId().equals(usage.getDeviceId())).collect(Collectors.toList());

			for(Intervals interval :usage.registerValues){

				count =1;

				preVee = new preVEE();

				if(interval.getFormattedRegisterObisCode().equals("0.0.1.0.0.255") && startDate == null)
				{
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
					startDate = LocalDateTime.parse(interval.getFormattedValue(), formatter);

					startDate = startDate.minusMinutes(15);

					Usage lastUsage = sameDevices.get(sameDevices.size() - 1);
					Intervals sameObisCode = lastUsage.registerValues.get(0);

					endDate = LocalDateTime.parse(sameObisCode.getFormattedValue(), formatter);
				}
				else
				{
					for(Usage same :sameDevices)
					{
						for(Intervals inter :same.registerValues)
						{
							ml = new mL();

							if(inter.getFormattedRegisterObisCode().equals(interval.getFormattedRegisterObisCode()))
							{
								ml.setS(count);
								ml.setQ(inter.getFormattedValue());

								preVee.msrs.add(ml);
								count++;
							}
						}
					}

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

					preVee.setUom(interval.getFormattedRegisterObisCode());
					preVee.setStDt(startDate.format(formatter));
					preVee.setEnDt(endDate.format(formatter));
					preVee.setSpi("Value 3 from properties");

					initialMeasurementData = new InitialMeasurementData();
					initialMeasurementData.preVEES.add(preVee);

				}

				device.InitialMeasurementDataList.add(initialMeasurementData);
			}

			devices.devices.add(device);
			devicesIds.add(usage.getDeviceId());

			//target2.usages.removeIf(i->i.getDeviceId().equals(usage.getDeviceId()));
		}

		devices.devices.forEach(u->u.InitialMeasurementDataList.forEach(i->i.preVEES.forEach(p->p.msrs.forEach(m->  System.out.println(m.getQ())))));

		JAXBContext context = JAXBContext.newInstance(Devices.class);

		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		m.marshal(devices, System.out);
		//target2.usages.forEach(usage -> usage.registerValues.forEach(interval -> System.out.println(interval.getAttributeId())));
		
	}

}


@XmlRootElement(name = "DeviceList")
@XmlAccessorType(XmlAccessType.FIELD)
class Devices{
	@XmlElement(name = "device")
	ArrayList<Device> devices = new ArrayList<Device>();
}
class Device{
	private String headEnd;
	private String headEndExternalId;
	private String deviceId;
	private String deviceIdentifierNumber;
	@XmlElement(name = "initialMeasurementDataList")
	ArrayList<InitialMeasurementData> InitialMeasurementDataList = new ArrayList<InitialMeasurementData>();

// Getter Methods

	public String getHeadEnd() { return headEnd; }
	public String getHeadEndExternalId() { return headEndExternalId; }
	public String getDeviceId() { return deviceId; }
	public String getDeviceIdentifierNumber() { return deviceIdentifierNumber; }


	// Setter Methods

	public void setHeadEnd(String headEnd) {
		this.headEnd = headEnd;
	}
	public void setHeadEndExternalId(String headEndExternalId) { this.headEndExternalId = headEndExternalId; }
	public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
	public void setDeviceIdentifierNumber(String deviceIdentifierNumber) { this.deviceIdentifierNumber = deviceIdentifierNumber; }

}
class InitialMeasurementData{
	@XmlElement(name = "preVEE")
	ArrayList<preVEE> preVEES = new ArrayList<preVEE>();
}
class preVEE{
	private String uom;
	private String stDt;
	private String enDt;
	private String spi;

	@XmlElement(name = "msrs")
	ArrayList<mL> msrs = new ArrayList<mL>();

	// Getter Methods

	public String getUom() { return uom; }
	public String getStDt() { return stDt; }
	public String getEnDt() { return enDt; }
	public String getSpi() { return spi; }


	// Setter Methods

	public void setUom(String uom) {
		this.uom = uom;
	}
	public void setStDt(String stDt) { this.stDt = stDt; }
	public void setEnDt(String enDt) { this.enDt = enDt; }
	public void setSpi(String spi) { this.spi = spi; }

}

class mL{
	private int s;
	private String q;

	// Getter Methods

	public int getS() { return s; }
	public String getQ() { return q; }

	// Setter Methods

	public void setS(int s) {
		this.s = s;
	}
	public void setQ(String q) { this.q = q; }


}

class ListUsage{
	//ArrayList<Usage> usages = new ArrayList<Usage>();
	List<Usage> usages = new CopyOnWriteArrayList<Usage>();
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


	public String getFormattedRegisterObisCode() {
		return formattedRegisterObisCode;
	}

	public String getFormattedValue() {
		return formattedValue;
	}

	// Setter Methods

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	public void setFormattedRegisterObisCode(String formattedRegisterObisCode) {
		this.formattedRegisterObisCode = formattedRegisterObisCode;
	}

	public void setFormattedValue(String formattedValue) {
		this.formattedValue = formattedValue;
	}
}