# Java注解

## 什么是注解
**注解**相当于是一种嵌入在程序中的 *元数据*，可以使用注解解析工具或编译器对其进行解析，也可以指定注解在编译期或运行期有效.

## 注解的类型
### 按运行机制分
1. 源码注解
   - 注解只在源码中存在，编译成 `.class`文件后就不存在了
2. 编译是注解
   - 注解在源码和 `.class` 文件中都存在，例如JDK自带的 `@Override` 、`@Deprecated` 、`@SuppressWarnings` 等。
3. 运行时注解
   - 在运行阶段期起作用，甚至会影响代码逻辑的注解

### 按来运分
1. 来自 JDK的注解
   - `@Override`
   - `@Deprecated`
   - `@SupperssWarnings`
2. 来自第三方的注解
   - Sping
   - Mybaties
   - ...
3. 自定义的注解

### 元注解
  - 注解的注解,定义注解时需要用到的注解  
   
                            
## 自定义注解

1. 使用 `@interface` 关键字定义注解
2. 成员以无参数无异常的方式声明
3. 可用`default`为成员指定默认值
4. 成员的类型为 `基本类型`、`String`、`Class`、`Annotation`以及`Enumeration`
5. 如果注解只有一个成员，约定取名为`value()`，使用时可忽略*成员名*和 *=*


### 元注解

- `@target`：取值为 `CONSTRUCTOR` / `FIELD` / `LOCAL_VARIABLE` / `METHOD` / `PACKAGE` / `PARAMETER` / `TYPE`，表示自定义注解的作用范围

   - `CONSTRUCTOR`：构造方法声明
   - `FIELD`：字段生命
   - `LOCAL_VARIABLE`：局部变量声明
   - `METHOD`：方法声明
   - `PACKAGE`：包声明
   - `PARAMTER`：参数声明
   - `TYPE`：类接口
- `@Retention`：取值为`SOURCE` / `CLASS` / `RUNTIME`，表示自定义注解的存在阶段
   - `SOURCE`：只在源码中显示，编译时会丢弃
   - `CLASS`：编译时会记录到.class文件中，运行时忽略
   - `RUNTIME`：运行时存在，可通过反射获取
- `@Inherited`：表示允许子注解继承
- `@Documented`：生成`javadoc`会包括注解信息

- 例子

```java
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Decription {

    String desc();

    String author();

    int age() default 18;

}
```

### 其他资料
- [深入理解Java注解](http://www.cnblogs.com/peida/archive/2013/04/23/3036035.html)

