package com.serhii.shutyi.university;

import com.serhii.shutyi.processing.ProcessingQueue;

import java.util.Random;

public class SecondUniversity extends University {

    public SecondUniversity(ProcessingQueue processingQueue) {
        super(processingQueue);
    }

    @Override
    void processDocs() {
        Random random = new Random();
        int quantity = random.nextInt(5) + 1;
        for (int i = 0; i < quantity; i++) {
            if (!getProcessingQueue().isEmpty()) {
                getUniversity().add(getProcessingQueue().poll());
            }
        }
    }
}
