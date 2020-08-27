package com.techpro.api.hotelreservation.db;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import com.techpro.api.hotelreservation.domain.Reservation;
import org.codehaus.jackson.map.util.ISO8601Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by manoj on 1/12/2020.
 */
@Component
public class DynamoDBUtil {
    private final static Logger log = LoggerFactory.getLogger(DynamoDBUtil.class);

    @Autowired
    DynamoDBMapper dynamoDBMapper;

    @Autowired
    AmazonDynamoDB amazonDynamoDBClient;

    public Reservation saveReservation(Reservation reservation) {
        dynamoDBMapper.save(reservation);
        return dynamoDBMapper.load(reservation);

    }

    public List<Reservation> getReservationByEmail(String email) {
        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
        eav.put(":val1", new AttributeValue().withS(email));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("guestDetails.email = :val1").withExpressionAttributeValues(eav);

        List<Reservation> scanResult = dynamoDBMapper.scan(Reservation.class, scanExpression);

        /*for (Reservation book : scanResult) {
            System.out.println(book);
        }*/
        return scanResult;
    }

    public Reservation getReservation(String bookingNumber) {
        return dynamoDBMapper.load(Reservation.class, bookingNumber);
    }

    public void deleteReservation(Reservation reservation) {
        dynamoDBMapper.delete(reservation);
    }

    public List<Reservation> getReservations() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();

        List<Reservation> scanResult = dynamoDBMapper.scan(Reservation.class, scanExpression);

        /*for (Reservation book : scanResult) {
            System.out.println(book);
        }*/
        return scanResult;
    }

}
