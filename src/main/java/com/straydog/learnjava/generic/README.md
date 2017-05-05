# Java泛型

## 什么是泛型？

型是Java SE 1.5的新特性，泛型的**本质是参数化类型**，也就是说所操作的数据类型被指定为一个参数。这种参数类型可以用在类、接口和方法的创建中，分别称为**泛型类**、**泛型接口**、**泛型方法**。

### 泛型带来的好处
在Java SE 1.5之前，没有泛型的情况的下，通过对类型`Object`的引用来实现参数的“任意化”，“任意化”带来的缺点是要做显式的强制类型转换，而这种转换是要求开发者对实际参数类型可以预知的情况下进行的。对于强制类型转换错误的情况，编译器可能不提示错误，在运行的时候才出现异常，这是一个安全隐患。

泛型的好处是**在编译的时候检查类型安全**，并且所有的强制转换都是自动和隐式的，以提高代码的重用率


### 什么是参数化类型?

将类型由原来的具体的**类型参数化**，类似于方法中的变量参数，此时类型也定义成参数形式（可以称之为类型形参），然后在使用/调用时传入具体的类型（类型实参）

## Java的泛型类型
- 泛型接口
   ```java
    public interface List<E> extends Collection<E>
    {

    }

    public interface Generator<T> {
        public T next();
    }
   ```
- 泛型类
   ```java
    public class Box<T>
    {

    }
   ```

- 泛型方法
   ```java
   public <T> void myMethod(T param){

   }
   ```

## 泛型通配符
- 使用大写字母A,B,C,D......X,Y,Z定义的，就都是泛型，把`T`换成`A`也一样，这里 `T`只是名字上的意义而已

- 一般约定：
   - `?` 表示不确定的java类型
   - `T (type)` 表示具体的一个java类型
   - `K V (key value)` 分别代表java键值中的Key Value
   - `E (element)` 代表Element

### 通配符的上限

```java
<? extends Collection>
```

   类似于`C#` 对泛型的约束，`?`是一个未知类型,是一个通配符泛型,这个类型是实现`Collection`接口即可

   只有在泛型的定义时才允许泛型的通配符或指定泛型通配符的上线，在泛型使用过程中（泛型变量的声明、调用泛型方法等）的时候
   是需要指定具体的泛型类型或是使用`?`
## List<T>，List<Object>,List<?>区别

- `ArrayList<T> al=new ArrayList<T>();`
   - 指定集合元素只能是T类型

- `ArrayList<?> al=new ArrayList<?>();`
    - 集合元素可以是任意类型，这种没有意义，一般是方法中，只是为了说明用法

- `ArrayList<? extends E> al=new ArrayList<? extends E>();`
    - 泛型的限定：
        - `? extends E`:接收`E`类型或者`E`的子类型。
        - `? super E`:接收`E`类型或者`E`的父类型

### 区别比较

- `Object`和`T`不同点在于：

  `Object`是一个实打实的类,并没有泛指谁，可以直接给`List`中`add(new Object())`，而且`Object`也不能代表所有类，
  比方说`String`和`Integer`就不是`Object`的子类，所以`Object`不属于泛型类，而`T`是泛指所有类

- `?`和`T`区别:

   `？`是一个不确定类，`？`和`T`都表示不确定的类型 ，但如果是`T`的话，函数里面可以对`T`进行操作，比方 `T car = getCar()`，而不能用`？ car = getCar()`。