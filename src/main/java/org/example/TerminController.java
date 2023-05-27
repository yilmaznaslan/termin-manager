package org.example;

import org.example.exceptions.FormValidationFailed;
import org.example.model.FormTO;
import org.example.model.PersonalInfoFormTO;
import org.example.model.VisaFormTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;


@RestController
public class TerminController {

    private final TerminService terminService;

    private final Logger logger = LoggerFactory.getLogger(TerminController.class);

    public TerminController(TerminService terminService) {
        this.terminService = terminService;
    }

    @GetMapping("/terminRequest")
    public void createTerminSearchRequest() {
        logger.info("Receives a GEt request to termin search request");
    }

    @PostMapping(value = "/terminRequest", consumes = "application/json")
    public void createTerminSearchRequest(@RequestBody FormTO formTO) {
        PersonalInfoFormTO personalInfoFormTO = formTO.getPersonalInfoFormTO();
        VisaFormTO visaFormTO = formTO.getVisaFormTO();
        logger.info("Receives a POST request to termin search request. PersonalInfo: {}, VisaForm: {}", personalInfoFormTO, visaFormTO);

        CompletableFuture<Void> future = terminService.startScanningAsync(personalInfoFormTO, visaFormTO);
        future.exceptionally(ex -> {
            // Handle the exception...
            return null;
        });
    }

}
