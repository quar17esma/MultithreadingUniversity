package com.serhii.shutyi.university;

import com.serhii.shutyi.processing.ProcessingQueue;
import com.serhii.shutyi.docs.DocumentType;

public class FirstUniversity extends University {

    public FirstUniversity(ProcessingQueue processingQueue) {
        super(processingQueue);
    }

    @Override
    void processDocs() {
        while (!getProcessingQueue().isEmpty()
                && getProcessingQueue().peek().equals(DocumentType.BIOLOGY)) {
            getUniversity().add(getProcessingQueue().poll());
        }
    }


}
