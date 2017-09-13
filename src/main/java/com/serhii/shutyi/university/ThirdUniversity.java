package com.serhii.shutyi.university;

import com.serhii.shutyi.processing.ProcessingQueue;
import com.serhii.shutyi.docs.DocumentType;

public class ThirdUniversity extends University {

    public ThirdUniversity(ProcessingQueue processingQueue) {
        super(processingQueue);
    }

    @Override
    void processDocs() {
        if (getProcessingQueue() != null) {
            while (!getProcessingQueue().isEmpty() && isMath()) {
                getUniversity().add(getProcessingQueue().poll());
            }
        }
    }

    private boolean isMath() {
        return getProcessingQueue().peek().equals(DocumentType.MATH);
    }
}
