package com.sample;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

@Configuration
@EnableDynamoDBRepositories
public class DynamoDbConfiguration {
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());
		amazonDynamoDB.setRegion(Region.getRegion(Regions.US_WEST_2));

		return amazonDynamoDB;
	}

	@Bean
	public AWSCredentials amazonAWSCredentials() {

		return new ProfileCredentialsProvider().getCredentials();
	}
}
