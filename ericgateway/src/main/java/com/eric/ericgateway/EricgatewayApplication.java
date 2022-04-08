package com.eric.ericgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.jaegertracing.Configuration;
import io.jaegertracing.internal.JaegerTracer;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class EricgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EricgatewayApplication.class, args);
	}
    @Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
    



    @Bean
    public static JaegerTracer getTracer() {
        Configuration.SamplerConfiguration samplerConfig = Configuration.SamplerConfiguration.fromEnv().withType("const").withParam(1);
        Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
        Configuration config = new Configuration("gatewayservice").withSampler(samplerConfig).withReporter(reporterConfig);
        return config.getTracer();
    }

}
