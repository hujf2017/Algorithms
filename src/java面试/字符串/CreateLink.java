package java面试.字符串;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Hujf
 * @title: CreateLink
 * @date 2021-06-08 15:57
 * @description: TODO
 */
public class CreateLink {

    LinkedList linkedList ;
    public CreateLink(){
        linkedList= new LinkedList();
    }

    public void addElement(Object num){
        linkedList.addFirst(num);
    }

    public void reversion(){
        LinkedList tmpList =new LinkedList();

        Iterator iterator = linkedList.iterator();
        while(iterator.hasNext()){
            tmpList.addFirst(iterator.next());
        }
        linkedList = tmpList;
    }

    public void print(){
        Iterator iterator = linkedList.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
    }
    @Test
    public void t(){
        int []tes = {1,2,3,4,5};

        CreateLink link = new CreateLink();
        for(int k:tes){
            link.addElement(k);
        }
        link.print();
        link.reversion();
        link.print();
    }
}
