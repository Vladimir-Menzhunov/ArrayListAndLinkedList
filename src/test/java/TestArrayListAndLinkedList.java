import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TestArrayListAndLinkedList {

    /**
     * get(int index) - (LinkedList) - Время выполнения операции линейно O(n) (во всех случаях кроме
     * добавления в начало или конец там оно константно O(1)
     *
     * get(int index) - (ArrayList) - Время выполнения операции константно O(1)
     */

    @Test
    public void checkGetMethodArrayListAndLinkedList() {
        long startTime;
        long finishTime;

        long timeArrayList;
        long timeLinkedList;

        ArrayList<Double> arrayList = new ArrayList<Double>();
        LinkedList<Double> linkedList = new LinkedList<Double>();

        int range = 100000000;

        for(int i = 0; i < 20000000; i++) {
            arrayList.add(Math.random() * range);
            linkedList.add(Math.random() * range);
        }

        startTime = System.currentTimeMillis();
        arrayList.get(10000000);
        finishTime = System.currentTimeMillis();
        timeArrayList = finishTime - startTime;

        startTime = System.currentTimeMillis();
        linkedList.get(10000000);
        finishTime = System.currentTimeMillis();
        timeLinkedList = finishTime - startTime;

        System.out.println("TimeArrayList get middle = " + timeArrayList);
        System.out.println("TimeLinkedList get middle = " + timeLinkedList);

        assertTrue(timeArrayList < timeLinkedList);

        startTime = System.currentTimeMillis();
        arrayList.get(0);
        finishTime = System.currentTimeMillis();
        timeArrayList = finishTime - startTime;

        startTime = System.currentTimeMillis();
        linkedList.getFirst();
        finishTime = System.currentTimeMillis();
        timeLinkedList = finishTime - startTime;

        System.out.println("TimeArrayList get first = " + timeArrayList);
        System.out.println("TimeLinkedList get first = " + timeLinkedList);

        assertEquals(timeArrayList, timeLinkedList);

        startTime = System.currentTimeMillis();
        arrayList.get(arrayList.size() - 1);
        finishTime = System.currentTimeMillis();
        timeArrayList = finishTime - startTime;

        startTime = System.currentTimeMillis();
        linkedList.getLast();
        finishTime = System.currentTimeMillis();
        timeLinkedList = finishTime - startTime;

        System.out.println("TimeArrayList get last = " + timeArrayList);
        System.out.println("TimeLinkedList get last = " + timeLinkedList);

        assertEquals(timeArrayList, timeLinkedList);

    }

    /**
     * add(int index) - (LinkedList) - Время выполнения операции линейно O(n) (во всех случаях кроме
     * добавления в начало или конец там оно константно O(1)
     *
     * add(int index) - (ArrayList) - Время выполнения операции в среднем константно O(1)
     * в плохих случаях может понадобится копирование массива(напимер удаление элемента с позиции n/2 и ниже) и время выполнения увеличится до O(n)
     */

    @Test
    public void checkAddMethodArrayListAndLinkedList() {
        long startTime;
        long finishTime;

        long timeArrayList;
        long timeLinkedList;

        ArrayList<Double> arrayList = new ArrayList<Double>();
        LinkedList<Double> linkedList = new LinkedList<Double>();

        int range = 10000000;

        for(int i = 0; i < 20000000; i++) {
            arrayList.add(Math.random() * range);
            linkedList.add(Math.random() * range);
        }

        startTime = System.currentTimeMillis();
        arrayList.add(10000000, 5000.);
        finishTime = System.currentTimeMillis();
        timeArrayList = finishTime - startTime;

        startTime = System.currentTimeMillis();
        linkedList.add(10000000, 5000.);
        finishTime = System.currentTimeMillis();
        timeLinkedList = finishTime - startTime;

        System.out.println("TimeArrayList add middle = " + timeArrayList);
        System.out.println("TimeLinkedList add middle = " + timeLinkedList);

        assertTrue(timeArrayList < timeLinkedList);

        startTime = System.currentTimeMillis();
        arrayList.add(0, 5000.);
        finishTime = System.currentTimeMillis();
        timeArrayList = finishTime - startTime;

        startTime = System.currentTimeMillis();
        linkedList.add(0, 5000.);
        finishTime = System.currentTimeMillis();
        timeLinkedList = finishTime - startTime;

        System.out.println("TimeArrayList add first = " + timeArrayList);
        System.out.println("TimeLinkedList add first = " + timeLinkedList);

        assertTrue(timeArrayList > timeLinkedList);

        startTime = System.currentTimeMillis();
        arrayList.add(arrayList.size() - 1, 5000.);
        finishTime = System.currentTimeMillis();
        timeArrayList = finishTime - startTime;

        startTime = System.currentTimeMillis();
        linkedList.add(linkedList.size() - 1, 5000.);
        finishTime = System.currentTimeMillis();
        timeLinkedList = finishTime - startTime;

        System.out.println("TimeArrayList add last = " + timeArrayList);
        System.out.println("TimeLinkedList add last = " + timeLinkedList);

        assertEquals(timeArrayList, timeLinkedList);

    }


    /**
     * remove(int index) - (LinkedList) - Время выполнения операции линейно O(n) (во всех случаях кроме
     * удалиния из начала или конеца - там оно константно O(1)
     *
     * remove(int index) - (ArrayList) - В среднем время выполнения операции константно O(1)
     * в плохих случаях может понадобится копирование массива(напимер удаление элемента с позиции n/2 и ниже) и время выполнения увеличится до O(n)
     */

    @Test
    public void checkRemoveMethodArrayListAndLinkedList() {
        long startTime;
        long finishTime;

        long timeArrayList;
        long timeLinkedList;

        ArrayList<Double> arrayList = new ArrayList<Double>();
        LinkedList<Double> linkedList = new LinkedList<Double>();

        int range = 10000000;

        for(int i = 0; i < 20000000; i++) {
            arrayList.add(Math.random() * range);
            linkedList.add(Math.random() * range);
        }

        startTime = System.currentTimeMillis();
        arrayList.remove(10000000);
        finishTime = System.currentTimeMillis();
        timeArrayList = finishTime - startTime;

        startTime = System.currentTimeMillis();
        linkedList.remove(10000000);
        finishTime = System.currentTimeMillis();
        timeLinkedList = finishTime - startTime;

        System.out.println("TimeArrayList remove middle = " + timeArrayList);
        System.out.println("TimeLinkedList remove middle = " + timeLinkedList);

        assertTrue(timeArrayList < timeLinkedList);

        startTime = System.currentTimeMillis();
        arrayList.remove(0);
        finishTime = System.currentTimeMillis();
        timeArrayList = finishTime - startTime;

        startTime = System.currentTimeMillis();
        linkedList.remove(0);
        finishTime = System.currentTimeMillis();
        timeLinkedList = finishTime - startTime;

        System.out.println("TimeArrayList remove first = " + timeArrayList);
        System.out.println("TimeLinkedList remove first = " + timeLinkedList);

        assertTrue(timeArrayList > timeLinkedList);

        startTime = System.currentTimeMillis();
        arrayList.remove(arrayList.size() - 1);
        finishTime = System.currentTimeMillis();
        timeArrayList = finishTime - startTime;

        startTime = System.currentTimeMillis();
        linkedList.remove(linkedList.size() - 1);
        finishTime = System.currentTimeMillis();
        timeLinkedList = finishTime - startTime;

        System.out.println("TimeArrayList remove last = " + timeArrayList);
        System.out.println("TimeLinkedList remove last = " + timeLinkedList);

        assertEquals(timeArrayList, timeLinkedList);

    }


    /**
     * Iterator.remove() - (LinkedList) - Время выполнения операции константно O(1)
     *
     * Iterator.remove() - (ArrayList) - Время выполнения операции линейно O(n)
     */

    @Test
    public void checkIteratorRemoveMethodArrayListAndLinkedList() {
        long startTime;
        long finishTime;

        long timeArrayList;
        long timeLinkedList;

        ArrayList<Double> arrayList = new ArrayList<Double>();
        LinkedList<Double> linkedList = new LinkedList<Double>();

        int range = 10000000;

        for(int i = 0; i < 200000; i++) {
            arrayList.add(Math.random() * range);
            linkedList.add(Math.random() * range);
        }

        startTime = System.currentTimeMillis();

        Iterator<Double> iteratorArrayList = arrayList.iterator();
        while (iteratorArrayList.hasNext()) {
            iteratorArrayList.next();
            iteratorArrayList.remove();
        }

        finishTime = System.currentTimeMillis();
        timeArrayList = finishTime - startTime;

        startTime = System.currentTimeMillis();

        Iterator<Double> iteratorLinkedList = linkedList.iterator();
        while (iteratorLinkedList.hasNext()) {
            iteratorLinkedList.next();
            iteratorLinkedList.remove();
        }

        finishTime = System.currentTimeMillis();
        timeLinkedList = finishTime - startTime;

        System.out.println("TimeArrayList iteratorArrayList remove = " + timeArrayList);
        System.out.println("TimeLinkedList iteratorLinkedList remove = " + timeLinkedList);

        assertTrue(timeArrayList > timeLinkedList);

    }


    /**
     * ListIterator.add() - (LinkedList) - Время выполнения операции константно O(1)
     *
     * ListIterator.add() - (ArrayList) - Время выполнения операции линейно O(n)
     */

    @Test
    public void checkListIteratorAddMethodArrayListAndLinkedList() {
        long startTime;
        long finishTime;

        long timeArrayList;
        long timeLinkedList;

        ArrayList<Double> arrayList = new ArrayList<Double>();
        LinkedList<Double> linkedList = new LinkedList<Double>();

        int range = 10000000;

        for (int i = 0; i < 20000000; i++) {
            arrayList.add(Math.random() * range);
            linkedList.add(Math.random() * range);
        }

        startTime = System.currentTimeMillis();
        ListIterator<Double> doubleListIteratorArrayList = arrayList.listIterator();
        doubleListIteratorArrayList.add(5000.);
        finishTime = System.currentTimeMillis();
        timeArrayList = finishTime - startTime;

        startTime = System.currentTimeMillis();
        ListIterator<Double> doubleListIteratorLinkedList = linkedList.listIterator();
        doubleListIteratorLinkedList.add(5000.);
        finishTime = System.currentTimeMillis();
        timeLinkedList = finishTime - startTime;

        System.out.println("TimeArrayList ListIteratorAdd  = " + timeArrayList);
        System.out.println("TimeLinkedList ListIteratorAdd = " + timeLinkedList);

        assertTrue(timeArrayList > timeLinkedList);
    }
}