package org.example;

import org.example.exceptions.FormValidationFailed;
import org.example.model.FormTO;
import org.example.model.PersonalInfoFormTO;
import org.example.model.VisaFormTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TerminController {

    Logger logger = LoggerFactory.getLogger(TerminController.class);

    @GetMapping("/terminSearchRequest")
    public void createTerminSearchRequest() {
        logger.info("Receives a GEt request to termin search request");
    }

    @PostMapping("/terminSearchRequest")
    public void createTerminSearchRequest(@RequestBody FormTO formTO) {
        PersonalInfoFormTO personalInfoFormTO = formTO.getPersonalInfoFormTO();
        VisaFormTO visaFormTO = formTO.getVisaFormTO();
        logger.info("Receives a POST request to termin search request. PersonalInfo: {}, VisaForm: {}", personalInfoFormTO, visaFormTO);

        TerminFinder terminFinder = new TerminFinder(personalInfoFormTO, visaFormTO);
        try {
            terminFinder.startScanning();

        } catch (FormValidationFailed e) {

        }
    }
}
