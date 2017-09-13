package com.serhii.shutyi.university;

import com.serhii.shutyi.processing.ProcessingQueue;

import java.util.Random;

public class SecondUniversity extends University {

    public SecondUniversity(ProcessingQueue processingQueue) {
        super(processingQueue);
    }

    @Override
    void processDocs() {
        if (getProcessingQueue() != null) {
            for (int i = 0; i < getRandomQuantity(); i++) {
                if (!getProcessingQueue().isEmpty()) {
                    getUniversity().add(getProcessingQueue().poll());
                }
            }
        }
    }

    private int getRandomQuantity() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }
}
