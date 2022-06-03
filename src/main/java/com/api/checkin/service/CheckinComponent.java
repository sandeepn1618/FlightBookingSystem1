package com.api.checkin.service;

import com.api.checkin.entity.CheckInRecord;
import com.api.checkin.repository.CheckinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CheckinComponent {
    private static final Logger logger = LoggerFactory.getLogger(CheckinComponent.class);

    CheckinRepository checkinRepository;


    public long checkIn(CheckInRecord checkIn) {
        checkIn.setCheckInTime(new Date());
        logger.info("Saving checkin ");
        //save
        long id = checkinRepository.save(checkIn).getId();
        logger.info("Successfully saved checkin ");
        //send a message back to booking to update status
        logger.info("Sending booking id " + id);
        return id;

    }

    public CheckInRecord getCheckInRecord(long id) {
        return checkinRepository.findById(id).get();
    }

}	
