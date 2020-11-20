package com.jetbrains;

import java.util.Collection;
import java.util.HashMap;

public class CircledQueue <T> {
    private int startLock = -1, endLock = -1;
    private HashMap<Integer, T> queue = new HashMap<>();
    private int size;

    CircledQueue(int size) {
        this.size = size;
    }
    CircledQueue(){ this.size = 0;}
    void put(T temp)
    {
        if(startLock == -1)
        {
            startLock = endLock = 0;
            queue.put(0,temp);
        }
        else if (startLock == 0 && endLock == size -1) {
            System.out.println("Queue overflow");
        }
        else if(endLock == size - 1 && queue.get(0) != null)
        {
            System.out.println("Queue overflow");
        }
        else if(endLock < size - 1 && queue.get(endLock + 1) != null)
        {
            System.out.println("Queue overflow");
        }
        else if (endLock + 1 == size) // size=5 endlock=4 -> endlock=0
        {
            if(startLock != 0)
            {
                endLock = 0;
                queue.put(0, temp);
            }
            else
                System.out.println("Queue overflow");
        }
        else if(startLock >= 0 && endLock < size - 1)
        {
            queue.put(endLock+1,temp);
            endLock++;
        }
    }
    void delete()
    {
        if(startLock < size - 1 && startLock != endLock) {
            queue.put(startLock, null);
            startLock++;
        }
        else if (startLock == endLock)
        {
            queue.put(startLock, null);
            System.out.println("Queue is empty.");
        }
        else if(startLock + 1 == size)
        {
                queue.put(startLock, null);
                startLock = 0;
        }
    }
    CircledQueue add(CircledQueue<T> firstObj, Collection<T> secondObj){
        int tempSize = firstObj.size + secondObj.size();
        CircledQueue<T> tempQ = new CircledQueue<>(tempSize);


        while(firstObj.queue.get(firstObj.startLock) != null) {
            tempQ.put(firstObj.queue.get(firstObj.startLock));
            firstObj.delete();
        }
        for(var temp: secondObj){
            tempQ.put(temp);
        }

        return tempQ;
    }

    CircledQueue group(CircledQueue<T> firstObj, CircledQueue<T> secondObj) {
        int tempSize = firstObj.size + secondObj.size;
        CircledQueue<T> tempQ = new CircledQueue<>(tempSize);
        while(firstObj.queue.get(firstObj.startLock) != null) {
            tempQ.put(firstObj.queue.get(firstObj.startLock));
            firstObj.delete();
        }
        while(secondObj.queue.get(secondObj.startLock) != null) {
            tempQ.put(secondObj.queue.get(secondObj.startLock));
            secondObj.delete();
        }
        return tempQ;
    }

}
