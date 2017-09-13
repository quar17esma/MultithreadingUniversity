package com.serhii.shutyi.processing;

import com.serhii.shutyi.docs.DocumentType;
import com.serhii.shutyi.docs.DocumentsQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProcessingQueue {
    private Queue<DocumentType> processingQueue;
    private DocumentsQueue biology;
    private DocumentsQueue math;

    public ProcessingQueue(DocumentsQueue biology, DocumentsQueue math) {
        this.processingQueue = new LinkedList<>();
        this.biology = biology;
        this.math = math;
    }

    public DocumentType poll() {
        return processingQueue.poll();
    }

    public DocumentType peek() {
        return processingQueue.peek();
    }

    public boolean isEmpty() {
        return processingQueue.isEmpty();
    }

    public synchronized void checkAndFillProcessingQueue() {
        if (processingQueue.size() < 25) {
            while (processingQueue.size() != 50) {
                boolean isTypeBiology;   //if true poll from biology
                if (biology.isEmpty() && math.isEmpty()) {
                    break;
                } else if (biology.isEmpty() && !math.isEmpty()) {
                    isTypeBiology = false;
                } else if (math.isEmpty() && !biology.isEmpty()) {
                    isTypeBiology = true;
                } else {
                    Random random = new Random();
                    isTypeBiology = random.nextBoolean();
                }
                moveToProcessingQueue(isTypeBiology);
            }
        }
    }

    private void moveToProcessingQueue(boolean isTypeBiology) {
        DocumentType doc;
        if (isTypeBiology) {
            doc = biology.poll();
        } else {
            doc = math.poll();
        }
        processingQueue.add(doc);
    }

    public Queue<DocumentType> getProcessingQueue() {
        return processingQueue;
    }

    public void setProcessingQueue(Queue<DocumentType> processingQueue) {
        this.processingQueue = processingQueue;
    }
}
