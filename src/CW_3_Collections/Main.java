package CW_3_Collections;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        System.out.println(list);
        list.addAll(0, Arrays.asList(1,2,5,6));
        list.remove((Integer) 2);
        list.removeIf(x->(x>=5));
        // сортировка через интерфейс Comporator
        list.sort(Comparator.naturalOrder());
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
        Collections.shuffle(list);
        ArrayList<Integer> a1= new ArrayList<>();
        a1.ensureCapacity(1000);
        a1.add(1);
        a1.trimToSize();
        System.out.println(a1);

        // связный список.
        List<Integer> list1 = new LinkedList<>(list);
        Iterator<Integer> iterator = list1.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next()+" ");
        }

        for (Integer integer2 : list) {

            System.out.print(integer2 + " ");

        }
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(7);
        queue.offer(7);
        queue.offer(7);
        queue.add(8);

       // showIter(queue);
        for (Integer integer : queue) {
            System.out.println(integer);
        }

        LinkedList<Integer> stack = new LinkedList<>();

        stack.push(7);
        stack.push(8);
        stack.push(9);
        showIter(stack);

        // СЭТ исключает дублирование
        Set<Integer> set = new HashSet<>();
        set.add(12);
        set.add(12);
        set.add(3);
        System.out.println(set);

        Set<Integer> setA = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        Set<Integer> setB = new HashSet<>(Arrays.asList(2,4,6,8,10));
        Set<Integer> setC = new HashSet<>(Arrays.asList(2,4,6,8,10));
        // Пересечение

        setA.retainAll(setB);
        System.out.println("Пересечение " + setA);

        setB.addAll(setC);
        System.out.println("Объединение " + setB);


        setB.removeAll(setA);
        System.out.println("Вычитание" +setB);


        long timeS, timeF;
        timeS=System.currentTimeMillis();
        Map<String,Integer> map = new HashMap<>();
        map.put("Amur",6);
        map.put("Barsik",2);
        map.put("Amur",3);
        map.put("Amur",4);
        map.put("Barsik",3);
        map.put("Amur",9);
        timeF=System.currentTimeMillis();
        System.out.println(map);
        System.out.println(timeF-timeS);

        timeS=System.currentTimeMillis();
        Map<String,Integer> map2= new TreeMap<>();
        map2.put("Amur",6);
        map2.put("Barsik",2);
        map2.put("Amur",3);
        map2.put("Amur",4);
        map2.put("Barsik",3);
        map2.put("Amur",9);
        System.out.println(map2);
        timeF=System.currentTimeMillis();
        System.out.println(timeF-timeS);


        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        map2.forEach((k,v)->
                {
                    System.out.println(k);
                    System.out.println(v);
                }
                );

        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();

        System.out.println(keys + " и еще " + values);
        System.out.println(map.get("Amur"));

        String ex = " ", ex2="";
        final String FINN = "ex";


            Scanner inn = new Scanner(System.in);
            while (!ex.equals(FINN))
        {
            System.out.println("ВВедите значение");
            ex=inn.next();
            System.out.println(ex);
            System.out.println(map.get(ex));
        }

            Random rnd = new Random();

            timeS=System.currentTimeMillis();

            // Определение сколько раз 0 до 10 встречается в Мапе
        Map<Integer,Integer> map3 = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int num = rnd.nextInt(10);
            Integer count = map3.getOrDefault(num,0);
            map3.put(num,count+1);
        /*    Integer count = map3.get(num);


            if (count == null)
            {
                map3.put(num,1);
            }
            else {
                 map3.put(num, count+1);
                }*/
        }
            System.out.println(map3);
        timeF=System.currentTimeMillis();
        System.out.println(timeF-timeS);
    }


    public static void showIter (List a) {
    for (Object integer : a) {
        System.out.println(integer);
        }
    }

    }


