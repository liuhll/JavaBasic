# Class<?>与Class<T>的区别

## 区别

`Class<T>` 在实例化的时候， `T` 要替换成具体类
`Class<?>` 它是个通配泛型，`?` 可以代表任何类型，主要用于声明时的限制情况

例如
---
- 可以声明:

  ```java
  public Class<?> clazz;
  ```

- 但是不能声明:

  ```java
  public Class<T> clazz; // 因为T需要指定类型

  //可以如下的生声明
  public Class<Employee> eClazz;
  ```

- **Notes:**
   - 不知道定声明什么类型的`Class`的时候可以定义一个`Class<?>`,`Class<?>`可以用于参数类型定义，方法返回值定义等
   - `Class<?>` 中的 `?` 是通配符，其实就是表示任意符合泛类定义条件的类，和直接使用 `Class` 效果基本一致，**但是这样写更加规范**，在某些类型转换时可以避免不必要的 `unchecked` 错误