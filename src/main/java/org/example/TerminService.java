package org.example;

import org.example.exceptions.FormValidationFailed;
import org.example.model.PersonalInfoFormTO;
import org.example.model.VisaFormTO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class TerminService {

    @Async
    public CompletableFuture<Void> startScanningAsync(PersonalInfoFormTO personalInfoFormTO, VisaFormTO visaFormTO) {
        UUID id = UUID.randomUUID();
        TerminFinder terminFinder = new TerminFinder(id, personalInfoFormTO, visaFormTO);
        try {
            terminFinder.startScanning();
        } catch (FormValidationFailed e) {
            // Handle the exception...
        }
        return CompletableFuture.completedFuture(null);
    }
}
