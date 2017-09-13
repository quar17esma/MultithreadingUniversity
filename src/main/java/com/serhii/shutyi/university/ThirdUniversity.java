package com.serhii.shutyi.university;

import com.serhii.shutyi.processing.ProcessingQueue;
import com.serhii.shutyi.docs.DocumentType;

public class ThirdUniversity extends University {

    public ThirdUniversity(ProcessingQueue processingQueue) {
        super(processingQueue);
    }

    @Override
    void processDocs() {
        while (!getProcessingQueue().isEmpty()
                && getProcessingQueue().peek().equals(DocumentType.MATH)) {
            getUniversity().add(getProcessingQueue().poll());
        }
    }
}
