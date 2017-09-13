package com.serhii.shutyi.processing;

import com.serhii.shutyi.docs.DocumentType;
import com.serhii.shutyi.docs.DocumentsQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProcessingQueue {
    private Queue<DocumentType> documentQueue;
    private DocumentsQueue biology;
    private DocumentsQueue math;

    public ProcessingQueue(DocumentsQueue biology, DocumentsQueue math) {
        this.documentQueue = new LinkedList<>();
        this.biology = biology;
        this.math = math;
    }

    public DocumentType poll() {
        return documentQueue.poll();
    }

    public DocumentType peek() {
        return documentQueue.peek();
    }

    public boolean isEmpty() {
        return documentQueue.isEmpty();
    }

    public void checkAndFillProcessingQueue() {
        if (documentQueue.size() < 25) {
            while (documentQueue.size() != 50) {

                boolean type;   //if true poll from biology
                if (biology.getDocumentsQueue().isEmpty()) {
                    type = false;
                } else if (math.getDocumentsQueue().isEmpty()) {
                    type = true;
                } else {
                    Random random = new Random();
                    type = random.nextBoolean();
                }
                DocumentType doc;
                if (type) {
                    doc = biology.poll();
                } else {
                    doc = math.poll();
                }
                documentQueue.add(doc);
            }
        }
    }

    public Queue<DocumentType> getDocumentQueue() {
        return documentQueue;
    }

    public void setDocumentQueue(Queue<DocumentType> documentQueue) {
        this.documentQueue = documentQueue;
    }
}
