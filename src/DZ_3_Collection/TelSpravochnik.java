package DZ_3_Collection;

import java.util.*;
 /* 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с помощью метода add()
          можно добавлять записи. С помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
          Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
          делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main()
          прописывая add() и get().*/


public class TelSpravochnik {



 private Map<String, Set<String>> map = new HashMap<>();

 public void addPhone (String surname, String telefonNumber)
 {
  // если телефона нет для этой фамилии то добавлям в Множество СЭТ (для исключения дубля)
  // Возвращает значение, соответствующее ключу key. Если такой ключ не существует — возвращает значение по умолчанию.
  Set<String> set = map.getOrDefault(surname,new HashSet<>());
  set.add(telefonNumber);
  map.put(surname,set);
  /*if (map.get(surname)==null)
  {
      set.add(telefonNumber);
      map.put(surname, set);
   System.out.println("Добавлена новая запись в справочник для " + surname);
  }

  else
  {
   set = map.get(surname);
   set.add(telefonNumber);
   map.put(surname,set);
   System.out.println("Добавлен доп. телефон для " + surname);
  }*/

 }

 public void getPhone (String surname)
 {
  Set<String> set = map.get(surname);
  // список телефонов:
  System.out.println("Вот список телефонов для " + surname);
  System.out.println(set);
  }


}
