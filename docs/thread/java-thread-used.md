# java多线程的使用

## Thread中的`start`和`run`方法的区别
Thread#start ---> JVM_StartThread ---> thread_entry ---> Thread#run()

- 调用`start()`方法会创建一个新的子线程并启动
- `run()`方法只是Thread的一个普通方法的调用(不会创建新的子线程执行方法)


## Thread和Runnable是什么关系
- `Thread`是实现了`Runable`接口的类,使得`run`支持多线程
- 因类的单一继承原则，推荐所使用`Runnable`接口


## 如何给run()方法传参
实现方的方式主要有三种
1. 构造函数传参
2. 成员变量传参
3. 回调函数传参

## 如何实现处理线程的返回值 
实现的方式主要有三种
1. 主线程等待法
2. 使用`Thread`类的`join()`阻塞当前线程以等待子线程处理完毕
3. 通过`Callable`接口实现:通过`FutureTask`或是线程池获取(使用线程池可以同时提交多个线程)


## 线程的状态
六个状态:
- 新建(New): 创建后尚未启动的线程的状态
- 运行(Runnable): 包含`Running`和`Ready`
- 无限期等待(Waiting):不会被分配CPU执行时间，需要显示被唤醒
   - 没有设置`Timeout`参数的`Object.wait()`方法
   - 没有设置`Timeout`参数的`Thread.join()`方法
   - `LockSupport.park()`方法
- 限期等待(Timed Waiting): 在一定时间后会由系统自动唤醒
- 阻塞(Blocked):等待获取排它锁
- 结束(Terminated): 已终止线程的状态，线程已经结束执行

## sleep和wait的区别

### 1.基本差别
- `sleep`是`Thread`类的方法，`wait`是`Object`类定义的方法
- `sleep()`方法截图在热报个地方使用
- `wait()`方法朱本办法在`synchronized`方法或是`synchronized`块中使用
### 2.本质的区别
- `Thread.sleep`只会让出CPU,不会导致锁行为的改变
- `Object.wait`不仅让出CPU，还会释放已经占有的同步资源锁


## notify和notifyAll的区别
- `notifyAll` 会让所有处于等待池的线程全部进入所持中去竞争获取锁的机会
- `notify`只会随机选取一个处于等待池中的线程进入锁池去竞争获取锁的机会


## 两个概念(锁池EntryList、等待池WaitSet)?
### 锁池(EntryList)
假设线程A已经拥有了某个对象(不是类)的锁，而其他线程B、C想要调用这个对象的某个synchronized方法(或者块)，由于B、C线程在进入对象的synchroized方法(或者块)之前必须先获取该对象锁的拥有权，而恰巧该对象的锁目前正被线程A锁占用，此时B、C线程就会被阻塞，进入一个地方去等待锁的释放，这个地方就是该对象的锁池

### 等待池(WaitSet)
假设线程A调用了某个对象的`wait()`方法,线程A就会释放该对象的锁，同事线程A就会进入到该对象的等待池中，进入到等待池中的线程不会去竞争该对象的锁。


## yield

### 概念
当调用`Thread.yield()`函数时，会给线程调度器一个当前线程愿意让出CPU使用的暗示，但是调度器可能会忽略这个暗示。
