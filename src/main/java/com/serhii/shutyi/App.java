package com.serhii.shutyi;

import com.serhii.shutyi.docs.DocumentType;
import com.serhii.shutyi.docs.DocumentsQueue;
import com.serhii.shutyi.processing.ProcessingQueue;
import com.serhii.shutyi.university.FirstUniversity;
import com.serhii.shutyi.university.SecondUniversity;
import com.serhii.shutyi.university.ThirdUniversity;

public class App {
    public static void main(String[] args) {
        DocumentsQueue biology = new DocumentsQueue(DocumentType.BIOLOGY, 200);
        DocumentsQueue math = new DocumentsQueue(DocumentType.MATH, 250);

        ProcessingQueue processingQueue = new ProcessingQueue(biology, math);
        processingQueue.checkAndFillProcessingQueue();

        FirstUniversity firstUniversity = new FirstUniversity(processingQueue);
        SecondUniversity secondUniversity = new SecondUniversity(processingQueue);
        ThirdUniversity thirdUniversity = new ThirdUniversity(processingQueue);

        Thread threadFirst = new Thread(firstUniversity);
        Thread threadSecond = new Thread(secondUniversity);
        Thread threadThird = new Thread(thirdUniversity);

        threadFirst.start();
        threadSecond.start();
        threadThird.start();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("1 univ size = " + firstUniversity.getUniversity().size());
        System.out.println(firstUniversity.toString());
        System.out.println("2 univ size = " + secondUniversity.getUniversity().size());
        System.out.println(secondUniversity.toString());
        System.out.println("3 univ size = " + thirdUniversity.getUniversity().size());
        System.out.println(thirdUniversity.toString());




    }
}
