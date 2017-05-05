# Java集合

## 集合的概念

所谓*集合*，就是来保存，盛装数据，也可称为容器类；使用的类 在 `java.util` 包里

- 数组的局限性: 数组的长度一旦确定了，数组就确定了，当需要动态传入值的时候，数据的局限性就产生了。

## Java集合的分类
1. `Collection` 
- 集合类的 *根接口*，Java中没有提供这个接口的直接的实现类。
但是却让其被继承产生了两个接口，就是`Set`和`List`。
   1. `Set` (无序不可重复)
     - 中不能包含重复的元素。
   2.  `List` (有序可重复) 
     - 是一个有序的集合，可以包含重复的元素，提供了按索引访问的方式。
   3. `Queue` (队列，先进先出) 
   - Queue是在两端出入的List，所以也可以用数组或链表来实现。

2. `Map`
- `Java.util`包中的另一个接口，它和 `Collection`接口没有关系，是相互独立的，但是都属于集合类的一部分。`Map`包含了 `key-value`对
              
3. `Iterator`
- 所有的集合类，都实现了 `Iterator` 接口，这是一个用于遍历集合中元素的接口，主要包含以下三种方法:
   1. `hasNext()` 是否还有下一个元素         
   2. `next()` 返回下一个元素
   3. `remove()` 删除当前元素

- 支持 `foreach` 遍历

## 层次关系

![集合的从层次次关系](http://images2015.cnblogs.com/blog/875181/201609/875181-20160921100733106-1187286566.png)
   
 
## 集合主要实现类的区别小结
   
### `Vector`和 `ArrayList`
1. `vector` 是线程同步的，所以它也是 *线程安全* 的，而 `arraylist` 是 *线程异步* 的，是不安全的。如果不考虑到线程的安全因素，一般用arraylist效率比较高。
2. 如果集合中的元素的数目大于目前集合数组的长度时， `vector`增长率为目前数组长度的100%，而 `arraylist`增长率为目前数组长度的50%。如果在集合中使用数据量比较大的数据，用`vector`有一定的优势。
3. 如果查找一个指定位置的数据，`vector`和`arraylist`使用的时间是相同的，如果频繁的访问数据，这个时候使用`vector`和`arraylist`都可以。而如果移动一个指定位置会导致后面的元素都发生移动，这个时候就应该考虑到使用`linklist`,因为它移动一个指定位置的数据时其它元素不移动。
`ArrayList` 和`Vector`是采用数组方式存储数据，此数组元素数大于实际存储的数据以便增加和插入元素，都允许直接序号索引元素，但是插入数据要涉及到数组元素移动等内存操作，所以索引数据快，插入数据慢，`Vector`由于使用了`synchronized`方法（线程安全）所以性能上比`ArrayList` 要*差*，`LinkedList`使用双向链表实现存储，按序号索引数据需要进行向前或向后遍历，但是插入数据时只需要记录本项的前后项即可，所以插入数度较快。

### arraylist和linkedlist
1. `ArrayList` 是实现了基于动态数组的数据结构，`LinkedList`基于链表的数据结构。
2. 对于随机访问`get`和`set`，`ArrayList`觉得优于`LinkedList`，因为`LinkedList`要移动指针。
3. 对于新增和删除操作`add`和`remove`，`LinedList`比较占优势，因为`ArrayList`要移动数据。 这一点要看实际情况的。若只对单条数据插入或删除，`ArrayList`的速度反而优于`LinkedList`。但若是批量随机的插入删除数据，`LinkedList`的速度大大优于`ArrayList`. 因为`ArrayLis`t每插入一条数据，要移动插入点及之后的所有数据。
4. `LinkedList`经常用在增删操作较多而查询操作很少的情况下，`ArrayList`则相反

### HashMap与TreeMap
1. `HashMap`通过`hashcode`对其内容进行快速查找，而`TreeMap`中所有的元素都保持着某种固定的顺序，如果你需要得到一个有序的结果你就应该使用`TreeMap`（`HashMap`中元素的排列顺序是不固定的）。

2. 在`Map` 中插入、删除和定位元素，`HashMap`是最好的选择。但如果您要按自然顺序或自定义顺序遍历键，那么`TreeMap`会更好。使用`HashMap`要求添加的键类明确定义了`hashCode()`和 `equals()`的实现。
两个`map`中的元素一样，但顺序不一样，导致`hashCode()`不一样。

- 同样做测试：
   - 在`HashMap`中，同样的值的`map`,顺序不同，`equals`时，`false`;
   - 而在`treeMap`中，同样的值的`map`,顺序不同,`equals`时，`true`，说明，`treeMap`在`equals()`时是整理了顺序了的。

### `HashTable`与`HashMap`
1. 同步性: `Hashtable` 是线程安全的，也就是说是同步的，而`HashMap`是线程序不安全的，不是同步的。
2. `HashMap`允许存在一个为 `null`的 `key`，多个为`null`的`value` 。
3. `hashtable`的`key`和`value`都不允许为 `null`。

## 与集合相关的包
- 与集合相关的类或接口都被封装在 `java.util` 包中
- [API文档](http://tool.oschina.net/apidocs/apidoc?api=jdk-zh)