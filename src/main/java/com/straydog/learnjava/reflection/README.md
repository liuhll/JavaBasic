# Java反射

## 什么是反射?

**反射**可以于**运行时**加载、探知、使用编译期间完全未知的`classes`,

Java程序可以加载一个**运行时**才得知名称的 `class`，获悉其完整构造（但不包括`methods`定义），并*生成其对象实体*、或对其`fields`设值、或唤起其`methods`

简而言之：就是,java在**运行时** 动态获取的信息以及动态调用对象的方法的功能就称为**反射**。

## 反射机制能做什么?

1. 在运行时判断任意一个对象所属的类；

2. 在运行时构造任意一个类的对象(新建类的实例)；

3. 在运行时判断任意一个类所具有的成员变量和方法；

4. 在运行时调用任意一个对象的方法；

5. 生成动态代理。

## 反射机制的优点与缺点

### 静态编译用动态编译的概念
- **静态编译**：在编译时确定类型，绑定对象,即通过。
- **动态编译**：运行时确定类型，绑定对象。动态编译最大限度发挥了java的**灵活性**，体现了**多
    态**的应用，有以降低类之间的**藕合性**。

### 反射的优点
- 可以实现**动态创建对象和编译**，体现出很大的**灵活性**，特别是在J2EE的开发中它的灵活性就表现的十分明显

### 反射的缺点
- 对性能有影响。
   - 使用反射基本上是一种解释操作，我们可以告诉JVM，我们希望做什么并且它满足我们的要求。这类操作总是慢于只直接执行相同的操作
- [反射真的会降低程序的性能吗?](http://developer.51cto.com/art/201412/461500.htm)
## 类的类对象
- 什么是类对象?
   - 每一个运行中的类，都会有一个class对象，表示这个类的类对象
- 获取类对象的方法？
   1. 引用名.getClass()

   2. 类名.getClass()

   3. Class.forName("类的完全限定名")

   4. 通过子类的实例获取父类对象
      ```java
      ClassName cn =  new  ClassName();
      UserClass = cn.getClass();
      Class SubUserClass = UserClass.getSuperclass();
      ```

- `类对象` 是Java反射的入口，通过类对象就可以动态获取java对象的元数据

## 元数据（metadata）
**元数据** 是指用来描述数据的数据，更通俗一点，就是描述代码间关系，或者代码与其他资源（例如数据库表）之间内在联系的数据。
  - 字段名
  - 方法名


java语言中就有了**四种类型**（TYPE），即类(`class`)、枚举(`enum`)、接口(`interface`)和注解(`@interface`)，它们是处在同一级别的


## 与反射相关的类|包

与Java反射相关的类除了 `Class`之外都被放置在`java.lang.reflect`包下
```java
java.lang.reflect.*
java.lang.Class;
java.lang.reflect.Constructor;
java.lang.reflect.Field;
java.lang.reflect.Method;
java.lang.reflect.Modifier;
```
- [API文档](http://tool.oschina.net/apidocs/apidoc?api=jdk-zh)