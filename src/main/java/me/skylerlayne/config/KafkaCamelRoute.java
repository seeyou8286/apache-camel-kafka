package me.skylerlayne.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//https://github.com/Talend/apache-camel/blob/master/components/camel-kafka/src/main/docs/kafka-component.adoc

@Configuration
public class KafkaCamelRoute {
	String ssl = "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"seeyou8286\" password=\"Happy2013\";";
	String kafkavalue =
			"kafka:mytopic?brokers=47.106.174.94:9093, 47.106.160.212:9093, 47.106.172.117:9093"
					+ "&securityProtocol=SASL_SSL"
					+ "&saslMechanism=PLAIN"
					+ "&keyDeserializer=org.apache.kafka.common.serialization.StringSerializer"
					+ "&sslEndpointAlgorithm="
					+ "&groupId=myconsumer"
					+ "&sslTruststoreLocation=/Users/chachen/workplace/apache-camel-kafka/src/main/resources/kafka.client.truststore.jks"
					+ "&sslTruststorePassword=KafkaOnsClient"
					+ "&saslJaasConfig="+ssl;


	@Bean(name = "KafkaRouteProducer")
	public RouteBuilder kafkaRouteProducer() {
		return new KafkaRouteProducer(kafkavalue);
	}

//	@Bean(name = "KafkaRouteConsumer")
//	public RouteBuilder kafkaRouteConsumer() {
//		return new RouteBuilder() {
//			public void configure() {
//				from(kafkavalue)
//						.bean(KafkaOutputBean.class, "doWork");
//			}
//		};
//	}
}