# Java内部类

## 什么是Java内部类

可以将一个类的定义放在另一个类的定义内部，这就是**内部类**

## 为什么要使用内部类

*Think in java*: 使用**内部类**最吸引人的原因是：每个**内部类**都能独立地继承一个（接口的）实现，所以无论外围类是否已经继承了某个（接口的）实现，**对于内部类都没有影响**

**而内部类使得多重继承的解决方案变得更加完整**

> 示例

```java
public interface Father {

    }

    public interface Mother {

    }

    public class Son implements Father, Mother {

    }

    public class Daughter implements Father{

        // Java内部类
        class Mother_ implements Mother{

        }
    }
```

> **Notes**
> - 如果 `Father`、`Mother` 不是接口，而是抽象类或者具体类呢？这个时候我们就**只能使用内部类才能实现多重继承了**
> - 其实使用内部类最大的优点就在于它能够非常好的解决多重继承的问题

总的来说，使用内部类可以为我们带来如下的特性：

1. 内部类可以用多个实例，每个实例都有自己的状态信息，并且与其他外围对象的信息相互独立。

2. 在单个外围类中，可以让多个内部类以不同的方式实现同一个接口，或者继承同一个类。

3. 创建内部类对象的时刻并不依赖于外围类对象的创建。

4. 内部类并没有令人迷惑的“is-a”关系，他就是一个独立的实体。

5. 内部类提供了更好的封装，除了该外围类，其他类都不能访问。

## 内部类基础

**内部类**如何使用**外部类**的属性和方法，以及使用`.this`与`.new` ？

- 当我们在创建一个内部类的时候，它无形中就与外围类有了一种联系，依赖于这种联系，它可以无限制地访问外围类的元素

- 如果我们需要创建某个内部类对象，必须要利用外部类的对象通过`.new` 来创建内部类： `OuterClass.InnerClass innerClass = outerClass.new InnerClass()`;

- 如果我们需要生成对外部类对象的引用，可以使用 `OuterClassName.this`，这样就能够产生一个正确引用外部类的引用了。当然这点实在编译期就知晓了，没有任何运行时的成本


> **Notes**

> 内部类是个**编译时的概念**，一旦编译成功后，它就与外围类属于两个完全不同的类（当然他们之间还是有联系的）。对于一个名为 `OuterClass` 的外围类和一个名为 `InnerClass` 的内部类，在编译成功后，会出现这样两个 `class` 文件：`OuterClass.class` 和`OuterClass$InnerClass.class`


## 内部类的使用和分类

在 Java 中内部类主要分为`成员内部类`、`局部内部类`、`匿名内部类`、`静态内部类`

### 成员内部类

成员内部类也是最普通的内部类，它是外围类的一个成员，所以他是可以无限制的访问外围类的所有 成员属性和方法，尽管是 `private` 的，**但是**外围类要访问内部类的成员属性和方法则需要通过内部类实例来访问

**注意：**


1. 成员内部类中不能存在任何 `static` 的变量和方法；
2. 成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类
3. 推荐使用 `getxxx()` 来获取成员内部类，尤其是该内部类的构造函数无参数时

### 局部内部类

有这样一种内部类，它是嵌套在方法和作用域内的，对于这个类的使用主要是应用与解决比较复杂的问题，想创建一个类来辅助我们的解决方案，到那时又不希望这个类是公共可用的，所以就产生了**局部内部类**

**局部内部类**和**成员内部类**一样被编译，只是它的作用域发生了改变，它只能在该方法和属性中被使用，出了该方法和属性就会失效

- 定义在方法里：

```java

    public class Parcel5 {
        public Destionation destionation(String str){
            class PDestionation implements Destionation{
                private String label;
                private PDestionation(String whereTo){
                    label = whereTo;
                }
                public String readLabel(){
                    return label;
                }
            }
            return new PDestionation(str);
        }

        public static void main(String[] args) {
            Parcel5 parcel5 = new Parcel5();
            Destionation d = parcel5.destionation("chenssy");
        }
    }
```

- 定义在作用域内的

```java
 public class Parcel6 {
        private void internalTracking(boolean b){
            if(b){
                class TrackingSlip{
                    private String id;
                    TrackingSlip(String s) {
                        id = s;
                    }
                    String getSlip(){
                        return id;
                    }
                }
                TrackingSlip ts = new TrackingSlip("chenssy");
                String string = ts.getSlip();
            }
        }

        public void track(){
            internalTracking(true);
        }

        public static void main(String[] args) {
            Parcel6 parcel6 = new Parcel6();
            parcel6.track();
        }
    }
```

### 匿名内部类

没有名字的内部类

1. 匿名内部类是没有访问修饰符的。

2. ``new`` 匿名内部类，这个类首先是要存在的。如果我们将相应的 `InnerClass` 接口注释掉，就会出现编译出错。

3. 注意 getInnerClass() 方法的形参，第一个形参是用 final 修饰的，而第二个却没有。同时我们也发现第二个形参在匿名内部类中没有使用过，所以当所在方法的形参需要被匿名内部类使用，那么这个形参就必须为 final。

4. 匿名内部类是**没有构造方法**的。因为它连名字都没有何来构造方法。

**示例**

```java
  public class OuterClass {
        public InnerClass getInnerClass(final int   num,String str2){

            // 匿名内部类，直接实现了接口
            return new InnerClass(){
                int number = num + 3;
                public int getNumber(){
                    return number;
                }
            };        /* 注意：分号不能省 */
        }

        public static void main(String[] args) {
            OuterClass out = new OuterClass();
            InnerClass inner = out.getInnerClass(2, "chenssy");
            System.out.println(inner.getNumber());
        }
    }

    interface InnerClass {
        int getNumber();
    }

    ----------------
    Output:
    5

```


### 静态内部类
使用 `static` 修饰的内部类我们称之为**静态内部类**，不过我们更喜欢称之为**嵌套内部类**

- 静态内部类与非静态内部类的区别

   - 我们知道**非静态内部类**在编译完成之后会隐含地保存着一个引用，该引用是指向创建它的外围内，但是**静态内部类却没有**

- 静态内部类与他的外围类之间的关系

  1. 它的创建是不需要依赖于外围类的。

  2. 它不能使用任何外围类的非static成员变量和方法。



