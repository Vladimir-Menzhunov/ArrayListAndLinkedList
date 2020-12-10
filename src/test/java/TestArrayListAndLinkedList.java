import javafx.beans.binding.When;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class TestArrayListAndLinkedList {
    List<List<Double>> list = getList(20000000);
    /**
     * get(int index) - (LinkedList) - Время выполнения операции линейно O(n) (во всех случаях кроме
     * добавления в начало или конец там оно константно O(1)
     *
     * get(int index) - (ArrayList) - Время выполнения операции константно O(1)
     */

    @Test
    public void checkGetMethodArrayListAndLinkedList()  {
        Stack<Long> timesList;
        long timeLinkedList;
        long timeArrayList;


        timesList = leadTimeGetMethod(list, list.get(0).size() / 2, "get");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList get middle = " + timeArrayList);
        System.out.println("TimeLinkedList get middle = " + timeLinkedList);
        assertTrue(timeArrayList < timeLinkedList);

        timesList = leadTimeGetMethod(list, 0, "get");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList get first = " + timeArrayList);
        System.out.println("TimeLinkedList get first = " + timeLinkedList);

        assertEquals(timeArrayList, timeLinkedList);

        timesList = leadTimeGetMethod(list, list.get(0).size() - 1, "get");

        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

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
        Stack<Long> timesList;
        long timeLinkedList;
        long timeArrayList;

        timesList = leadTimeGetMethod(list, list.get(0).size() / 2, "add");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList add middle = " + timeArrayList);
        System.out.println("TimeLinkedList add middle = " + timeLinkedList);
        assertTrue(timeArrayList < timeLinkedList);

        timesList = leadTimeGetMethod(list, 0, "add");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList add first = " + timeArrayList);
        System.out.println("TimeLinkedList add first = " + timeLinkedList);

        assertTrue(timeArrayList > timeLinkedList);

        timesList = leadTimeGetMethod(list, list.get(0).size() - 1, "add");

        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

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
        Stack<Long> timesList;
        long timeLinkedList;
        long timeArrayList;

        timesList = leadTimeGetMethod(list, list.get(0).size() / 2, "remove");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList remove middle = " + timeArrayList);
        System.out.println("TimeLinkedList remove middle = " + timeLinkedList);
        assertTrue(timeArrayList < timeLinkedList);

        timesList = leadTimeGetMethod(list, 0, "remove");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList remove first = " + timeArrayList);
        System.out.println("TimeLinkedList remove first = " + timeLinkedList);

        assertTrue(timeArrayList > timeLinkedList);

        timesList = leadTimeGetMethod(list, list.get(0).size() - 1, "remove");

        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

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
        Stack<Long> timesList;
        long timeLinkedList;
        long timeArrayList;

        List<List<Double>> listForRemove = getList(200000);

        timesList = leadTimeGetMethod(listForRemove, -1, "iteratorRemove");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList iteratorRemove = " + timeArrayList);
        System.out.println("TimeLinkedList iteratorRemove = " + timeLinkedList);
        assertTrue(timeArrayList > timeLinkedList);

    }


    /**
     * ListIterator.add() - (LinkedList) - Время выполнения операции константно O(1)
     *
     * ListIterator.add() - (ArrayList) - Время выполнения операции линейно O(n)
     */

    @Test
    public void checkListIteratorAddMethodArrayListAndLinkedList() {
        Stack<Long> timesList;
        long timeLinkedList;
        long timeArrayList;

        timesList = leadTimeGetMethod(list, -1, "iteratorAdd");
        timeLinkedList = timesList.pop();
        timeArrayList = timesList.pop();

        System.out.println("TimeArrayList iteratorAdd = " + timeArrayList);
        System.out.println("TimeLinkedList iteratorAdd = " + timeLinkedList);
        assertTrue(timeArrayList > timeLinkedList);
    }


    public List<List<Double>> getList(int range) {
        List<List<Double>> list = new ArrayList<List<Double>>();
        list.add(new ArrayList<Double>());
        list.add(new LinkedList<Double>());
        for (List<Double> doubles : list) {
            for (int index = 0; index < range; index++) {
                doubles.add(Math.random() * range);
            }
        }

        return list;
    }

    public Stack<Long> leadTimeGetMethod(List<List<Double>> list, int index, String method){
        long startTime;
        long finishTime;

        Stack<Long> timesLists = new Stack<Long>();
        for (List<Double> doubles : list) {
            startTime = System.currentTimeMillis();

            if(method.contains("get")) doubles.get(index);
            if(method.contains("add")) doubles.add(index, 5000.);
            if(method.contains("remove")) doubles.remove(index);
            if(method.contains("iteratorRemove")) {
                Iterator<Double> iteratorList = doubles.iterator();
                while (iteratorList.hasNext()) {
                    iteratorList.next();
                    iteratorList.remove();
                }
            }
            if(method.contains("iteratorAdd")) {
                ListIterator<Double> doubleListIteratorList = doubles.listIterator();
                doubleListIteratorList.add(5000.);
            }

            finishTime = System.currentTimeMillis();
            timesLists.add(finishTime - startTime);
        }

        return timesLists;
    }


}