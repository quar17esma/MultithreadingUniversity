package com.serhii.shutyi.docs;

import java.util.LinkedList;
import java.util.Queue;

public class DocumentsQueue {
    private Queue<DocumentType> documentsQueue;

    public DocumentsQueue(DocumentType documentType, int quantity) {
        documentsQueue = new LinkedList<>();
        for (int i = 0; i < quantity; i++) {
            getDocumentsQueue().add(documentType);
        }
    }

    public DocumentType poll(){
        return documentsQueue.poll();
    }

    public Queue<DocumentType> getDocumentsQueue() {
        return documentsQueue;
    }

    public void setDocumentsQueue(Queue<DocumentType> documentsQueue) {
        this.documentsQueue = documentsQueue;
    }
}
