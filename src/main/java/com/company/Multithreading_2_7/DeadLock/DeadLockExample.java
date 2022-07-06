package main.java.com.company.Multithreading_2_7.DeadLock;


import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();

    }
}

class Runner {
    private Account account1 = new Account();
    private Account account2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    //чтобы избежать дедлока сделаем новый метод для забирания локов
    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while (true) {
            try {
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {
                // тут будем делать анлок
                if (firstLockTaken && secondLockTaken) { //если оба значения тру мы просто возвращаемся из метода
                    return;
                }

                // мы выходим из метода только когда успешно забираем два лока, чтобы дать другим потокам забрать лок
                if (firstLockTaken) {
                    lock1.unlock();
                }

                if (secondLockTaken) {
                    lock2.unlock();
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
//            lock1.lock();
//            // при дедлоке первый поток взял лок1 и не может взять лок2, потому что его взял второй поток
//            lock2.lock();
            takeLocks(lock1, lock2);
            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }

        // после добавление синхронайзд блоков общее кол-во денег всегда будет 20000, потому что не будет
        // рейс кондишн, тк каждый из потоков вызывает метод трансфер только после того как получит мониторы
        // обоих аккаунтов, в это время второй потов ждет
        // for(int i = 0; i < 10000; i++){
//            synchronized (account1) {
//                synchronized (account2) {
//                // код будет выполняться только в случае поток получит мониторы этого объекта
//                    Account.transfer(account1, account2, random.nextInt(100));
//                }
//            }
//        }
    }
    /*
    когда мониторы забираются в разном порядке у локов возникает deadlock

    */

    public void secondThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            takeLocks(lock2, lock1);
//            lock2.lock();
//            // при дедлоке второй поток взял лок2 и не может взять лок1
//            lock1.lock();
            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
// если в синхронайзд блоке синхронизироваться на объектах в разном порядке,
// то тоже будет дедлок в этом случае можно только исправить порядок синхронизации
//        for(int i = 0; i < 10000; i++){
//               synchronized (account2) {
//                    synchronized (account1) {
//                        Account.transfer(account2, account1, random.nextInt(100));
//                    }
//               }
//        }
    }


    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount) { //метод который переводит деньги с аккаунта1 на аккаунт2
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }

}