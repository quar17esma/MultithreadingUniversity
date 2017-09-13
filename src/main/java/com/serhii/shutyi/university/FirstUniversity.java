package com.serhii.shutyi.university;

import com.serhii.shutyi.processing.ProcessingQueue;
import com.serhii.shutyi.docs.DocumentType;

public class FirstUniversity extends University {

    public FirstUniversity(ProcessingQueue processingQueue) {
        super(processingQueue);
    }

    @Override
    void processDocs() {
        if (getProcessingQueue() != null) {
            while (!getProcessingQueue().isEmpty() && isBiology()) {
                getUniversity().add(getProcessingQueue().poll());
            }
        }
    }

    private boolean isBiology() {
        return getProcessingQueue().peek().equals(DocumentType.BIOLOGY);
    }

}
