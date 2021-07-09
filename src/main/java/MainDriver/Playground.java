/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainDriver;

import SessionManagement.ADT.LinkedQueue;

/**
 *
 * @author zkang
 */
public class Playground {

    public static void linkedQueuePG() {
        LinkedQueue<String> myqueue = new LinkedQueue<>();
        myqueue.enqueue("Item 1");
        myqueue.enqueue("Item 2");
        myqueue.enqueue("Item 3");
        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
        System.out.println(myqueue.dequeue());
    }
}
