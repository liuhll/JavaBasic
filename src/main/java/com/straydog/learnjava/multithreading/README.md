# Java多线程

## 线程的生命周期及五种基本状态

![线程的生命周期与状态](http://images.cnitblog.com/i/426802/201406/232002051747387.jpg)

**Java线程具有五中基本状态**:

- **新建状态（New）**：当线程对象对创建后，即进入了新建状态，如：Thread t = new MyThread();

- **就绪状态（Runnable）**：当调用线程对象的`start()`方法（`t.start();`），线程即进入就绪状态。处于就绪状态的线程，只是说明此线程已经做好了准备，随时等待CPU调度执行，并不是说执行了`t.start()`此线程立即就会执行；

- **运行状态（Running）**：当CPU开始调度处于就绪状态的线程时，此时线程才得以真正执行，即进入到运行状态。注：就     绪状态是进入到运行状态的唯一入口，也就是说，线程要想进入运行状态执行，首先必须处于就绪状态中；

- **阻塞状态（Blocked）**：处于运行状态中的线程由于某种原因，暂时放弃对CPU的使用权，停止执行，此时进入阻塞状态，直到其进入到就绪状态，才 有机会再次被CPU调用以进入到运行状态。根据阻塞产生的原因不同，阻塞状态又可以分为三种：

   1. *等待阻塞* --运行状态中的线程执行`wait()`方法，使本线程进入到等待阻塞状态；

   2. *同步阻塞* -- 线程在获取`synchronized`同步锁失败(因为锁被其它线程所占用)，它会进入同步阻塞状态；

   3. *其他阻塞* -- 通过调用线程的`sleep()`或`join()`或发出了I/O请求时，线程会进入到阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。

- **死亡状态（Dead）**：线程执行完了或者因异常退出了`run()`方法，该线程结束生命周期。


## Java多线程的创建及启动

1. 继承`Thread`类，重写该类的`run()`方法

```java
class MyThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
```

2. 实现`Runnable`接口，并重写该接口的`run()`方法，该`run()`方法同样是线程执行体，创建`Runnable`实现类的实例，并以此实例作为`Thread`类的target来创建`Thread`对象，该`Thread`对象才是真正的线程对象

`MyRunnable`:

```java
class MyRunnable implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
```

`ThreadTest`:

```java
public class ThreadTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Runnable myRunnable = new MyRunnable(); // 创建一个Runnable实现类的对象
                Thread thread1 = new Thread(myRunnable); // 将myRunnable作为Thread target创建新的线程
                Thread thread2 = new Thread(myRunnable);
                thread1.start(); // 调用start()方法使得线程进入就绪状态
                thread2.start();
            }
        }
    }
}

```

3. 使用`Callable`和`Future`接口创建线程。具体是创建`Callable`接口的实现类，并实现`clall()`方法。并使用`FutureTask`类来包装`Callable`实现类的对象，且以此`FutureTask`对象作为`Thread`对象的target来创建线程

```java
public class ThreadTest {

    public static void main(String[] args) {

        Callable<Integer> myCallable = new MyCallable();    // 创建MyCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable); //使用FutureTask来包装MyCallable对象

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Thread thread = new Thread(ft);   //FutureTask对象作为Thread对象的target创建新的线程
                thread.start();                      //线程进入到就绪状态
            }
        }

        System.out.println("主线程for循环执行完毕..");

        try {
            int sum = ft.get();            //取得新创建的新线程中的call()方法返回的结果
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}


class MyCallable implements Callable<Integer> {
    private int i = 0;

    // 与run()方法不同的是，call()方法具有返回值
    @Override
    public Integer call() {
        int sum = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }

}
```

## Java多线程的就绪、运行和死亡状态转换

- **就绪状态转换为运行状态**：
    - 当此线程得到处理器资源；

- **运行状态转换为就绪状态**：
    1. 当此线程主动调用`yield()`方法
    2. 在运行过程中**失去处理器资源**。

- **运行状态转换为死亡状态**：
    1. 当此线程线程执行**体执行完毕**
    2. 发生了异常。

## Java多线程的阻塞状态与线程控制

1. `join()`

 - **让一个线程等待另一个线程完成才继续执行**。如A线程线程执行体中调用B线程的`join()`方法，则A线程被阻塞，直到B线程执行完为止，A才能得以继续执行

 2. `sleep()`

 - **让当前的正在执行的线程暂停指定的时间，并进入阻塞状态**。在其睡眠的时间段内，该线程由于不是处于就绪状态，因此不会得到执行的机会。即使此时系统中没有任何其他可执行的线程，出于`sleep()`中的线程也不会执行。因此sleep()方法常用来暂停线程执行。

## 后台线程（Daemon Thread）

### 概念：
 - **后台线程**主要是为其他线程（相对可以称之为前台线程）提供服务，或**守护线程**

### 生命周期
- 后台线程的生命周期与前台线程生命周期有一定关联。主要体现在：当所有的前台线程都进入死亡状态时，后台线程会自动死亡。

### 设置后台线程：
- 调用`Thread`对象的`setDaemon(true)`方法可以将指定的线程设置为后台线程。

## 线程的优先级
每个线程在执行时都具有一定的优先级，优先级高的线程具有较多的执行机会。每个线程默认的优先级都与创建它的线程的优先级相同。

`main线程`默认具有普通优先级

### 设置线程优先级
- `setPriority(int priorityLevel)`

- 参数`priorityLevel`范围在1-10之间，常用的有如下三个静态常量值：

   - MAX_PRIORITY:10

   - MIN_PRIORITY:1

   - NORM_PRIORITY:5

- 获取线程优先级：`getPriority()`。

> **Notes**

> 具有较高线程优先级的线程对象仅表示此线程具有较多的执行机会，而非优先执行

## 线程安全

- 如果你的代码在多线程下执行和在单线程下执行永远都能获得一样的结果，那么你的代码就是线程安全的

- [线程安全笔记](ThreadSafety.md)

## 生产者-消费者模式

## volatile关键字

## 学习资料
- [40个Java多线程问题总结](http://www.imooc.com/article/3306)

