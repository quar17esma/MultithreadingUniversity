package com.serhii.shutyi.university;

import com.serhii.shutyi.processing.ProcessingQueue;
import com.serhii.shutyi.docs.DocumentType;

import java.util.LinkedList;
import java.util.Queue;

public abstract class University implements Runnable {

    private ProcessingQueue processingQueue;

    private Queue<DocumentType> university;

    public University(ProcessingQueue processingQueue) {
        this.processingQueue = processingQueue;
        this.university = new LinkedList<>();
    }

    @Override
    public void run() {
        while (!processingQueue.isEmpty()) {
            synchronized (processingQueue) {
                processDocs();
                processingQueue.checkAndFillProcessingQueue();
                processingQueue.notify();
                try {
                    processingQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    abstract void processDocs();

    public int size() {
        return university.size();
    }

    public ProcessingQueue getProcessingQueue() {
        return processingQueue;
    }

    public void setProcessingQueue(ProcessingQueue queue) {
        this.processingQueue = queue;
    }

    public Queue<DocumentType> getUniversity() {
        return university;
    }

    public void setUniversity(Queue<DocumentType> university) {
        this.university = university;
    }

    @Override
    public String toString() {
        StringBuilder result  = new StringBuilder("");
        for (DocumentType doc:university) {
            result.append(" ");
            result.append(doc.name());
        }
        result.append("\n");

        return result.toString();
    }
}
