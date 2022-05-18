package CW_5_Thread;

public class Producer implements Runnable {

    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            store.put();
        }

    }
}

class Consumer implements Runnable
{
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++) {
           store.get();

            
        }
    }
}

class Store
{
  private final Object mon = new Object();

    private int product=0;

 public void get()
 {
     // синхронизация по монитору - получение товара
     synchronized (mon)
     {
         // если продуктов нет то дальше и не идти монитор спи
         while (product<=0)
         {
             try {
                 mon.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }

         product--;
         System.out.println("Куплен 1 товар");
         System.out.println("Товаров осталось " + product);
        // уменьши товары монитор проснись:
         mon.notifyAll();

     }

 }

 public void put()
 {
     synchronized (mon) {
         while (product >= 3) {
             try {
                 mon.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         product++;
         System.out.println("Добавлен 1 товар");
         System.out.println("Товаров стало" + product);
         mon.notifyAll();
     }

 }


}
