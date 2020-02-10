package com.techpro.api.hotelreservation.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by manoj on 1/12/2020.
 */
@Configuration
public class DynamoDBConfiguration {

    @Value("${aws.dynamo.region}")
    String region;

    /**
     * This bean contains the necessary information to access AWS resources.
     * @return
     */
    @Bean
    public AWSCredentialsProvider awsCredentialsProvider() {

        return new DefaultAWSCredentialsProviderChain();
    }

    /**
     * This bean is the AWS Dynamo DB client using which Dynamo DB will be accessed.
     * @return
     */
    @Bean
    public AmazonDynamoDB getAmazonDynamoDBClient() {

        return AmazonDynamoDBClientBuilder.standard().withCredentials(awsCredentialsProvider()).withRegion(region)
                .build();
    }

    /**
     *
     * @return
     */
    @Bean
    public DynamoDB getDynamoDBClient() {

        return new DynamoDB(getAmazonDynamoDBClient());
    }

    /**
     * This bean is a mapper class which is used to perform CRUD operations directly on the model object.
     * @return
     */
    @Bean
    public DynamoDBMapper getDynamoDBMapper() {

        return new DynamoDBMapper(getAmazonDynamoDBClient());
    }

}
