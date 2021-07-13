/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionManagement.ADT;

/**
 *
 * @author Loo Zi Kang
 * @param <T> type of the node
 */
public class Node<T> {

    public T data;
    public Node next;
    
    public Node() {
        this.data = null;
    }

    public Node(T data) {
        this.data = data;
    }    
}
