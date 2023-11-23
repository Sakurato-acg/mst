# java基础

## 1.请你说说Java的特点和优点,为什么要选择Java？



1. 一次编译，到处运行，即`平台无关性`；是纯`面向对象`的语言。
2. JAVA语言的优点有：内置的类库简化了开发人员的设计工作；具有较好的安全性和健壮性；开发人员`不需要`对`内存`的使用进行`管理`。
3. 选择JAVA的原因是：使用范围很广，安卓操作系统的应用软件目前大部分还是使用JAVA语言编写。



## 2.请你说说Java基本数据类型和引用类型



1. 提供8种基本数据类型：byte(8), short(16), int(32), long(64), float(32), double(64), char(16), boolean，这些基本数据类型有对应的封装类；这基本数据类型在声明之后就会立刻在**栈**上被分配内存空间
2. 其他类型都是引用类型：类，接口，数组，String等，这些变量在声明时**不会被分配内存空间**，只是存储了一个**内存地址**。



## 3.请你说一下抽象类和接口的区别



相同点：

1. 两者都`不能实例化`；
2. 可以拥有`抽象方法`。
3. 都有default方法

 

区别：

1. abstract class,interface；
2. 属性上，抽象类可以有静态变量、常量和成员变量，接口只能有常量`public static final`；
3. 抽象方法可以有构造方法，接口不可以有构造方法。
4. 抽象方法在业务编程上更像一个模板，有自己的功能，同时也可以有优化补充的多种形式，而接口更像是一种规范和要求，实现就要按照要求来进行。



## 4.请你说一下final关键字



1. final可以修饰类，方法，变量。 
2. final修饰类，该类不可被继承。 
3. final修饰方法，该方法不能被重写。 final修饰变量，如果是基本变量则值不能再改变，如果是引用变量则引用地址不能改变，但值可以改变。



## 5.说说static修饰符的用法



1. `static修饰变量`：属于静态变量也叫类变量，直属于类对象而不是实例，可以通过类名访问，它一般会在类加载过程中被初始化。生命周期贯穿整个程序。存储在方法区中。
2.  `static修饰方法`：即静态方法，一个类中的静态方法不能访问该类的实例变量，只能访问静态变量。同时还存在一个静态初始化块，他在类加载过程中被调用用于对该类中的静态变量进行操作。 
3. `static修饰类`：即静态内部类，他只能以内部类的形式存在，可通过外部类的类名调用。它是他也只能访问到外部的的静态成员。

## 6.请你说说String类



1. String类被final修饰，所以不能被继承。
2. 创建String对象时可以使用字符串直接量，如String str="1abc", 另一种String str=new String("1abc")
3. 前者使用常量池来管理，后者先判断常量池中是否已存在此字符串，不存在就也在常量池创建，再在堆内存创建一个新的对象，因此后者开销更大



## 7.String、StringBuffer、Stringbuilder有什么区别



1. `String`是`final`不可变字符序列，从它创建到销毁前，都不可变。
2. `StringBuilder`是可变字符序列，但`不是线程安全`的。
3. `StringBuffer`是可变字符序列，与StringBuilder功能相似，区别是它是`线程安全`的。 
4. 相比String，StringBuilder有append()方法，即追加字符串。最后toString()转换成String



## 8.请你说说==与equals()的区别



1. == 比较基本数据类型时，比较的是两个数值是否相等； 比较引用类型是，比较的是对象的内存地址是否相等。 
2. equals() 没有重写时，Object默认以==来实现，即比较两个对象的内存地址是否相等； 重写以后，按照对象的内容进行比较



## 9.请你说说hashCode()和equals()的区别,为什么重写equals()就要重写hashcode()



1. hashCode()：获取哈希码,equals()：比较两个对象是否相等。
2. 二者两个约定：如果两个对象相等,它们必须有相同的哈希码；若两个对象的哈希码相同,他们却不一定相等。也就是说,equals()比较两个对象相等时hashCode()一定相等,hashCode()相等的两个对象equqls()不一定相等。
3. 加分回答：由于hashCode()与equals()具有联动关系,equals()重写时,hashCode()进行重写,使得这两个方法始终满足相关的约定。



## 10.请你说说Java的异常处理机制



`java异常提醒`：

​	Throwable = Exception + Error

​	Exception = Checked Exception + Unchecked Exception (extend RuntimeException)



1. `容错性`和`健壮性`,程序运行出现状况时,系统会生成一个`Exception对象`来通知程序

2. 由`try`、`catch`、`finally`三部分组成。

   try块用于包裹业务代码,catch块用于捕获并处理某个类型的异常,finally块则用于回收资源。

   `finally` 最终执行

   

## 11.说说你对面向对象的理解



1. 面向对象三大基本特征：`封装`、`继承`、`多态`。
2. `封装`：将对象的状态信息隐藏在对象内部,不允许外部程序直接访问对象内部信息,让外部程序通过该类提供的方法来实现对内部信息的操作和访问,提高了代码的可维护性；
3. `继承`：实现代码复用的重要手段,通过extends实现类的继承,实现继承的类被称为子类,被继承的类称为父类；
4. `多态`的实现离不开继承,在设计程序时,我们可以将参数的类型定义为父类型。在调用程序时根据实际情况,传入该父类型的某个子类型的实例,这样就实现了多态。



## 12.请介绍一下访问修饰符



1. Java中的访问修饰符有四种，分别为	`private`,`default`,`protected`,`public`。
2. `private`：类中被private修饰的只能在被`当前类`内部访问
3. `default`：类中被default修饰的只能在`当前类`和`当前类所在包`的其他类访问。
4. `protected`：类中被protected修饰的可以被`当前类`和`当前类所在的包`的其他类以及`子类`访问。
5. `public`：类中被public修饰的能被`当前项目`下的所有类访问。



## 13.序列化



如果我们需要`持久化 Java 对象`比如将 Java 对象保存在文件中，或者在`网络传输 Java 对象`，这些场景都需要用到序列化。

**序列化**：将数据结构或对象转换成二进制字节流的过程

**反序列化**：将在序列化过程中所生成的二进制字节流转换成数据结构或者对象的过程



## 14.请说说你对反射的了解



1. 反射就是在程序运行期间动态的获取对象的属性和方法的功能叫做反射。它能够在程序运行期间，对于任意一个类，都能知道它所有的方法和属性，对于任意一个对象，都能知道他的属性和方法。
2. 反射的优缺点： 
   1. 优点：运行期间能够动态的获取类，提高代码的灵活性。
   2. 缺点：性能比直接的Java代码要慢很多。 应用场景：spring的xml配置模式，以及动态代理模式都用到了反射



## 15.设计模式

### 代理



思想:

​	我们使用`代理对象`来代替对真实对象(real object)的访问，这样就可以在`不修改`原目标对象的前提下，提供`额外`的功能`操作`，扩展目标对象的功能。



主要作用：

​	扩展目标对象的功能，比如说在目标对象的`某个方法执行前后`(AOP?)你可以增加一些自定义的操作



JDK动态代理 vs CGLIB

1. `JDK` 面向`接口`，要有实现类

2. `CGLib` 通过字节码底层`继承`要代理类来实现

   

> springBoot与spring中的动态代理

如果代理对象`有接口`，就用 `JDK 动态代理`

如果代理对象`没有接口`，那么就直接是 `CGlib` 动态代理

---

从 `Spring Boot2.0` 开始，如果用户什么都没有配置，那么`默认`情况下使用的是 `CGlib` 代理

**@Transactional 是cglib动态代理**

---

[^tips]:如果我们想用 JDK 来代理，那么只需要在application.properties 中添加如下配置即可：

```go
spring.aop.proxy-target-class=false
```

# java集合

## 概述

![Java 集合框架概览](https://oss.javaguide.cn/github/javaguide/java/collection/java-collection-hierarchy.png)

##  1.ArrayList 与 LinkedList 区别

1. **是否保证线程安全**：都不保证线程安全
2. **底层数据结构**：`ArrayList`底层使用的是`Object数组`；`LinkedList`底层使用的是`双向链表`



## 2.Comparable 和 Comparator 的区别

实现`Comparable`接口要重写这个类的compareTo方法

`Comparator `类似于 c 中 qsort 里的`排序规则`



## 3.HashMap 和 Hashtable 的区别

1. **线程是否安全**：`HashMap` 是非线程安全的，`Hashtable` 是线程安全的
2. **对 Null key 和 Null value 的支持：**`HashMap` 可以存储 null 的 key 和 value，但 null 作为键只能有一个，null 作为值可以有多个；Hashtable 不允许有 null 键和 null 值，否则会抛出 `NullPointerException`。



## 4.HashMap 的底层实现

​		  当`链表长度大于`阈值（默认为`8`）（将链表转换成红黑树前会判断，如果当前数组的`长度小于 64`，那么会选择先进行`数组扩容`，而不是转换为红黑树）时，将链表转化为`红黑树`，以减少搜索时间。

![jdk1.8之后的内部结构-HashMap](https://oss.javaguide.cn/github/javaguide/java/collection/jdk1.8_hashmap.png)



> 请你说说HashMap底层原理

1. 在1.8之前，HashMap的底层是数组加链表，在1.8之后是数组+链表+红黑树； 
2. 它的put流程是：基于哈希算法来确定元素位置，当我们向集合存入数据时，他会计算传入的key的哈希值，并利用哈希值取绝对值再根据集合长度取余来确定元素的位置，如果这个位置已经存在其他元素了，就会发生哈希碰撞，则hashmap就会通过链表将这些元素组织起来，如果链表的长度达到8时，就会转化为红黑树，从而提高查询速度。 
3. 扩容机制：HashMap中数组的默认初始容量为16，当达到默认负载因子0.75时，会以2的指数倍进行扩容。 Hashmap时非线程安全的，在多线程环境下回产生循环死链，因此在多线程环境下建议使用ConcurrentHashMap



## 5.ConcurrentHashMap

**底层数据结构**：数组+链表/红黑二叉树



## 6.ArrayList 扩容机制

构建：

1. **无参**：初始的是一个空数组。对数组进行添加时，才分配容量为10
2. **有参**：用户自己指定容量

扩容：

​	ArrayList 每次扩容之后容量都会变为原来的 1.5 倍左右



# java IO

## 概述

`InputStream`/`Reader`: 所有的输入流的基类，前者是字节输入流，后者是字符输入流。

`OutputStream`/`Writer`: 所有输出流的基类，前者是字节输出流，后者是字符输出流。

## BIO 同步阻塞模型

同步阻塞 IO 模型中，应用程序发起 read 调用后，会一直阻塞，直到内核把数据拷贝到用户空间。

## 同步非阻塞 IO 

<img src="https://oss.javaguide.cn/p3-juejin/bb174e22dbe04bb79fe3fc126aed0c61~tplv-k3u1fbpfcp-watermark.png" alt="图源：《深入拆解Tomcat & Jetty》" style="zoom:67%;" />

## NIO多路复用模型

O 多路复用模型中，线程首先发起 select 调用，询问内核数据是否准备就绪，等内核把数据准备好了，用户线程再发起 read 调用。read 调用的过程（数据从内核空间 -> 用户空间）还是阻塞的。

<img src="https://oss.javaguide.cn/github/javaguide/java/io/88ff862764024c3b8567367df11df6ab~tplv-k3u1fbpfcp-watermark.png" alt="img" style="zoom:67%;" />

## AIO异步 IO 模型。

异步 IO 是基于事件和回调机制实现的，也就是应用操作之后会直接返回，不会堵塞在那里，当后台处理完成，操作系统会通知相应的线程进行后续的操作。

<img src="https://oss.javaguide.cn/github/javaguide/java/io/3077e72a1af049559e81d18205b56fd7~tplv-k3u1fbpfcp-watermark.png" alt="img" style="zoom:67%;" />



# juc

## 1. 请你说说多线程

1. 线程是程序执行的最小单元，一个进程可以拥有多个线程 
2. 各个线程之间共享程序的内存空间（代码段、数据段和堆空间）和系统分配的资源（CPU，I/O，打开的文件），但是各个线程拥有自己的栈空间
3. 多线程优点：减少程序响应时间；提高CPU利用率；创建和切换开销小；数据共享效率高；简化程序结构



## 2.说说线程的创建方式

创建线程有3种方式：

1. 继承Thread类，重写run()方法；
2. 实现Runnable接口，并实现该接口的run()方法；
3. 3.实现Callable接口，重写call()方法。
4. 前两种方式线程执行完后都没有返回值，最后一种带返回值；一般推荐实现Runnable接口的方式。



## 3.说说你对ThreadLocal的理解

1. ThreadLocal是线程变量，它将需要共享的数据复制多份，每个线程各一份。
2. 内部使用了一个ThreadLoadMap来存储信息，key是当前线程，而value是我们需要传输的数据，我们可以在线程执行的过程中通过get/set，操作map中的数据
3. 不过需要注意的是在使用线程池的时候，线程执行完毕不会被销毁，而是进入线程池中等待，这个时候我们需要手动释放一下map中的数据，以免造成内存浪费。



# java8

## 新特性

- **Lambda 表达式** − Lambda 允许把函数作为一个方法的参数（函数作为参数传递到方法中）。
- **方法引用** − 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
- **默认方法** − 默认方法就是一个在接口里面有了一个实现的方法。
- **Stream API** −新添加的Stream API（java.util.stream） 把真正的函数式编程风格引入到Java中。
- **Date Time API** − 加强对日期与时间的处理。
- **Optional 类** − Optional 类已经成为 Java 8 类库的一部分，用来解决空指针异常。



## Lambda表达式

让我们不用关注是什么对象。而是更关注我们对数据进行了什么操作。

> lambda实现的条件为：1：接口，2：只能有一个抽象方法需要实现

我们在创建线程并启动时可以使用匿名内部类的写法：

~~~~java
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("你知道吗 我比你想象的 更想在你身边");
    }
}).start();
~~~~

可以使用Lambda的格式对其进行修改。修改后如下：

~~~~java
new Thread(()->{
    System.out.println("你知道吗 我比你想象的 更想在你身边");
}).start();
~~~~

## stream流

Java8的Stream使用的是函数式编程模式，如同它的名字一样，它可以被用来对集合或数组进行链状流式的操作。可以更方便的让我们对集合或数组操作

### 创建

1. `集合对象.stream()`
2. `Arrays.stream(数组) `
3. ``Stream.of`

### 中间操作

1. ##### filter

   ​	可以对流中的元素进行条件过滤，符合过滤条件的才能继续留在流中。

2. ##### map

   ​	可以把对流中的元素进行计算或转换。

3. ##### distinct

   ​	可以去除流中的重复元素。

4. ##### sorted

   ​	可以对流中的元素进行排序。

5. ##### limit	

   ​	可以设置流的最大长度，超出的部分将被抛弃。

6. ##### skip

   ​	跳过流中的前n个元素，返回剩下的元素

7. ##### flatMap

   ​	map只能把一个对象转换成另一个对象来作为流中的元素。而flatMap可以把一个对象转换成多个对象作为流中的元素。



### 终结操作

1. ##### forEach

   ​	对流中的元素进行遍历操作，我们通过传入的参数去指定对遍历到的元素进行什么具体操作

2. ##### count

   ​	可以用来获取当前流中元素的个数。

3. ##### max&min

   ​	可以用来或者流中的最值。

4. ##### collect

   ​	把当前流转换成一个集合。

5. anyMatch

   ​	可以用来判断是否有任意符合匹配条件的元素，结果为boolean类型。

6. allMatch

   ​	可以用来判断是否都符合匹配条件，结果为boolean类型。如果都符合结果为true，否则结果为false

7.  noneMatch

   ​	可以判断流中的元素是否都不符合匹配条件。如果都不符合结果为true，否则结果为false

8. findAny

   ​	获取流中的任意一个元素。该方法没有办法保证获取的一定是流中的第一个元素。

9. findFirst

   ​	获取流中的第一个元素。

10. reduce归并



###  注意事项

- 惰性求值（如果没有终结操作，没有中间操作是不会得到执行的）
- 流是一次性的（一旦一个流对象经过一个终结操作后。这个流就不能再被使用）
- 不会影响原数据（我们在流中可以多数据做很多处理。但是正常情况下是不会影响原来集合中的元素的。这往往也是我们期望的）

## 函数式接口

​	**只有一个抽象方法**的接口我们称之为函数接口。

​	JDK的函数式接口都加上了**@FunctionalInterface** 注解进行标识。但是无论是否加上该注解只要接口中只有一个抽象方法，都是函数式接口。

### Consumer 消费接口

根据其中抽象方法的参数列表和返回值类型知道，我们可以在方法中对传入的参数计算或转换，把结果返回

![image-20231122193536130](picture/image-20231122193536130.png)

### Function 计算转换接口

根据其中抽象方法的参数列表和返回值类型知道，我们可以在方法中对传入的参数计算或转换，把结果返回

![image-20231122193641152](picture/image-20231122193641152.png)

### Predicate 判断接口

根据其中抽象方法的参数列表和返回值类型知道，我们可以在方法中对传入的参数条件判断，返回判断结果

![image-20231122193644199](picture/image-20231122193644199.png)

### Supplier 生产型接口

根据其中抽象方法的参数列表和返回值类型知道，我们可以在方法中创建对象，把创建好的对象返回

![image-20231122193658839](picture/image-20231122193658839.png)















> 说说怎么保证线程安全

 		 线程安全问题是指在多线程背景下，线程没有按照我们的预期执行，导致操作共享变量出现异常。在Java中有许多同步方案提供给我们使用，从轻到重有三种方式：原子类、volatile关键字、锁。 

1. 原子类是juc atomic包下的一系列类，通过CAS比较与交换的机制实现线程安全的更新共享变量。通过预期值与内存值的比较来判断是否修改。
2. volatile关键字是轻量级的同步机制，他实现了变量的可见性、防止指令重排序。保证了【单个变量】读写的线程安全。可见性问题是JMM内存模型中定义每个核心存在一个内存副本导致的，核心只操作他们的内存副本，volatile保证了一旦修改变量则立即刷新到共享内存中，且其他核心的内存副本失效，需要重新读取。
3.  原子类和volatile只能保证单个共享变量的线程安全，锁则可以保证临界区内的多个共享变量线程安全。java中常用的锁有两种：synchronized+juc包下的lock锁。synchronized锁是互斥锁，可以作用于实例方法、静态方法、代码块，基于对象头和Monitor对象，在1.6之后引入轻量级锁、偏向锁等优化。lock锁接口可以通过lock、unlock方法锁住一段代码，基于AQS实现，其加锁解锁就是操作AQS的state变量，并且将阻塞队列存在AQS的双向队列中。除了锁以外，juc包下还提供了一些线程同步工具类，如CountDownLatch、Semaphore等等，我们还可以使用ThreadLocal定义线程局部变量！



> 请你说说ConcurrentHashMap

ConcurrentHashMap 在 JDK 1.7 时使用的是数据加链表的形式实现的，其中数组分为两类：大数组 Segment 和小数组 HashEntry，而加锁是通过给 Segment 添加 ReentrantLock 锁来实现线程安全的。而 JDK 1.8 中 ConcurrentHashMap 使用的是数组+链表/红黑树的方式实现的，它是通过 `CAS` 或 `synchronized `来实现线程安全的，并且它的锁粒度更小，查询性能也更高



# 数据库

## 基础

### 数据类型

![MySQL 常见字段类型总结](https://oss.javaguide.cn/github/javaguide/mysql/summary-of-mysql-field-types.png)

### 事务

​		  事务是一组操作的集合，事务会把所有操作作为一个整体一起向系统提交或撤销操作请求，即这些操作要么同时成功，要么同时失败。

> 四大特性ACID

- `原子性(Atomicity)`：事务是不可分割的最小操作单元，要么全部成功，要么全部失败
- `一致性(Consistency)`：事务完成时，必须使所有数据都保持一致状态
- `隔离性(Isolation)`：数据库系统提供的隔离机制，保证事务在不受外部并发操作影响的独立环境下运行
- `持久性(Durability)`：事务一旦提交或回滚，它对数据库中的数据的改变就是永久的

> 并发事务

| 问题       | 描述                                                         |
| ---------- | ------------------------------------------------------------ |
| 脏读       | 一个事务读到另一个事务还没提交的数据                         |
| 不可重复读 | 一个事务先后读取同一条记录，但两次读取的数据不同             |
| 幻读       | 一个事务按照条件查询数据时，没有对应的数据行，但是再插入数据时，又发现这行数据已经存在 |

## 进阶篇

### 体系

![img](https://oss.javaguide.cn/javaguide/13526879-3037b144ed09eb88.png)

从上图可以看出， MySQL 主要由下面几部分构成：

1. `连接器`:身份认证和权限相关(登录 MySQL 的时候)。
2. `查询缓存`：执行查询语句的时候，会先查询缓存（MySQL 8.0 版本后移除，因为这个功能不太实用）。
3. `分析器`： 没有命中缓存的话，SQL 语句就会经过分析器，分析器说白了就是要先看你的 SQL 语句要干嘛，再检查你的 SQL 语句语法是否正确。
4. `优化器`：按照 MySQL 认为最优的方案去执行。
5. `执行器`： 执行语句，然后从存储引擎返回数据。 执行语句之前会先判断是否有权限，如果没有权限的话，就会报错。
6. `插件式存储引擎`：主要负责数据的存储和读取，采用的是插件式架构，支持 InnoDB、MyISAM、Memory 等多种存储引擎。

### InnDB

​		  存储引擎就是`存储数据`、建立索引、更新/查询数据等`技术的实现方式`。存储引擎是基于表而不是基于库的，所以存储引擎也可以被称为表引擎。
`默认`存储引擎是`InnoDB`。

> 特点

1. DML 操作遵循 ACID 模型，支持**事务**
2. *行级锁**，提高并发访问性能**
3. **支持**外键**约束，保证数据的完整性和正确性

> MyISAM 缺点

MyISAM `不支持` `事务`和`行级锁`，而且最大的缺陷就是崩溃后`无法安全恢复`。



### 性能分析

> 查看执行频次

查看当前数据库的 INSERT, UPDATE, DELETE, SELECT 访问频次：

1. `SHOW GLOBAL STATUS LIKE 'Com_______';` 
2. `SHOW SESSION STATUS LIKE 'Com_______';`



> 慢日志查询

慢查询日志记录了所有执行时间超过指定参数（long_query_time，单位：秒，默认10秒）的所有SQL语句的日志。
MySQL的慢查询日志默认没有开启，需要在MySQL的配置文件（/etc/my.cnf）中配置如下信息：

```properties
# 开启慢查询日志开关
slow_query_log=1
# 设置慢查询日志的时间为2秒，SQL语句执行时间超过2秒，就会视为慢查询，记录慢查询日志
long_query_time=2
```

更改后记得重启MySQL服务，日志文件位置：/var/lib/mysql/localhost-slow.log

查看慢查询日志开关状态：
`show variables like 'slow_query_log';`



> explain

EXPLAIN 或者 DESC 命令获取 MySQL 如何执行 SELECT 语句的信息，包括在 SELECT 语句执行过程中表如何连接和连接的顺序。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210222190501349.png)

各字段的含义

1. `id`：select 查询的序列号，表示查询中执行 select 子句或者操作表的顺序（id相同，执行顺序从上到下；id不同，`值越大越先执行

2. `select_type`：select的类型

   - ==simple==：查询语句中不包含`UNION`或者子查询的查询都算作是`SIMPLE`类型，无论是单表查询还是联合查询这些查询的级别都是 simple

     ​		 这里需要说明的一点是，其实子查询严格意义上不是 simple 级别的，但是我这里举得这个例子比较特殊，原理是因为这个 SQL 在MySQL 的查询优化器上被优化成了连接查询，所以才会出现这种情况。换句话说，这个 SQL 最终执行的内容和上面的这个 SQL 是一种类型。

   - ==primary==：包含复杂的子查询或包含包含UNION、UNION ALL，最外层标记为该值

   - ==union==

3. `type`：表示连接类型

   - ==system==：表只有一行记录，相当于系统表
   - ==const==：通过索引一次就找到，只匹配一行数据
   - ==eq_ref==：通常发生在联表查询中，关联的条件是某张表的主键或者unique唯一非空索引
    -  ==ref==：当满足索引的最左原则，同时并不走主键或者unique唯一非空索引
    - ==range==：只检索给定范围的行，使用一个索引来选择行。一般使用between、>、<情况
    - ==index==：只遍历索引树
    -  ==ALL==：全表扫描，性能最差
         注：前5种情况都是理想情况的索引使用情况。通常优化至少到range级别，最好能优化到 ref

4. `possible_key`：可能应用在这张表上的`索引`，一个或多个

5. `Key`：`实际使用的索引`，如果为 NULL，则没有使用索引

6. `Key_len`：表示索引中使用的字节数，该值为索引字段最大可能长度，并非实际使用长度，在不损失精确性的前提下，长度越短越好

7. `rows`：MySQL认为必须要执行的行数，在InnoDB引擎的表中，是一个估计值，可能并不总是准确的

8. `filtered`：表示返回结果的行数占需读取行数的百分比，filtered的值越大越好

9. `extra`：包含不合适在其他列中显示但十分重要的额外信息，常见的值如下：

   ==using filesort==：

   说明 MySQL 会对数据使用一个外部的索引排序，而不是按照表内的索引顺序进行读取。出现该值，应该优化 SQL

   ==using temporary==：

   使用了临时表保存中间结果，MySQL 在对查询结果排序时使用临时表。常见于排序 order by 和分组查询 group by。出现该值，应该优化 SQL

   ==using index==：

   表示相应的 select 操作使用了覆盖索引，避免了访问表的数据行，效率不错

   ==using where==：

   where 子句用于限制哪一行

   ==using join buffer==：

   使用连接缓存
   ==distinct==：发现第一个匹配后，停止为当前的行组合搜索更多的行
   注意：出现前 2 个值，SQL 语句必须要优化。


### 索引

索引是帮助 MySQL **高效获取数据**的**数据结构（有序）**。在数据之外，数据库系统还维护着满足特定查找算法的数据结构，这些数据结构以某种方式引用（指向）数据，这样就可以在这些数据结构上实现高级查询算法，这种数据结构就是索引。

> 优缺点：

优点：

- 提高数据检索效率，降低数据库的IO成本
- 通过索引列对数据进行排序，降低数据排序的成本，降低CPU的消耗

缺点：

- 索引列也是要占用空间的
- 索引大大提高了查询效率，但降低了更新的速度，比如 INSERT、UPDATE、DELETE

> 索引结构

| 索引结构            | 描述                                                         |
| ------------------- | ------------------------------------------------------------ |
| B+Tree              | 最常见的索引类型，大部分引擎都支持B+树索引                   |
| Hash                | 底层数据结构是用哈希表实现，只有精确匹配索引列的查询才有效，不支持范围查询 |
| R-Tree(空间索引)    | 空间索引是 MyISAM 引擎的一个特殊索引类型，主要用于地理空间数据类型，通常使用较少 |
| Full-Text(全文索引) | 是一种通过建立倒排索引，快速匹配文档的方式，类似于 Lucene, Solr, ES |

#### 为什么用B+tree

1. 相对于二叉树，层级更少，搜索效率高
2. 对于 B-Tree，无论是叶子节点还是非叶子节点，都会保存数据，这样导致一页中存储的键值减少，指针也跟着减少，要同样保存大量数据，只能增加树的高度，导致性能降低
3. 相对于 Hash 索引，B+Tree 支持范围匹配及排序操作

![image-20231123111945224](picture/image-20231123111945224.png)



#### 索引分类

| 分类     | 含义                                                 | 特点                     | 关键字   |
| -------- | ---------------------------------------------------- | ------------------------ | -------- |
| 主键索引 | 针对于表中主键创建的索引                             | 默认自动创建，只能有一个 | PRIMARY  |
| 唯一索引 | 避免同一个表中某数据列中的值重复                     | 可以有多个               | UNIQUE   |
| 常规索引 | 快速定位特定数据                                     | 可以有多个               |          |
| 全文索引 | 全文索引查找的是文本中的关键词，而不是比较索引中的值 | 可以有多个               | FULLTEXT |

在 InnoDB 存储引擎中，根据索引的存储形式，又可以分为以下两种：

| 分类                      | 含义                                                       | 特点                 |
| ------------------------- | ---------------------------------------------------------- | -------------------- |
| 聚集索引(Clustered Index) | 将数据存储与索引放一块，索引结构的叶子节点保存了行数据     | 必须有，而且只有一个 |
| 二级索引(Secondary Index) | 将数据与索引分开存储，索引结构的叶子节点关联的是对应的主键 | 可以存在多个         |

#### 联合索引

例子：假如创建一个（a,b)的联合索引，那么它的索引树是这样的

![img](https://img-blog.csdnimg.cn/20190401113210176.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NpbmF0XzQxOTE3MTA5,size_16,color_FFFFFF,t_70)

可以看到a的值是有顺序的，1，1，2，2，3，3，而b的值是没有顺序的1，2，1，4，1，2。所以b = 2这种查询条件没有办法利用索引，因为联合索引首先是按a排序的，b是无序的。



> **最左匹配原则：**最左优先，以最左边的为起点任何连续的索引都能匹配上。同时遇到范围查询(>、<、between、like)就会停止匹配。
>
>  假如建立联合索引（a,b,c）

**全值匹配查询时**

```mysql
select * from table_name where a = '1' and b = '2' and c = '3' 
select * from table_name where b = '2' and a = '1' and c = '3' 
select * from table_name where c = '3' and b = '2' and a = '1' 
```

用到了索引

where子句几个搜索条件顺序调换不影响查询结果，因为Mysql中有查询优化器，会自动优化查询顺序 
[Mysql最左匹配原则_最左匹 > 会走索引吗-CSDN博客](https://blog.csdn.net/sinat_41917109/article/details/88944290)



#### 索引失效情况

1. **在索引列上进行运算操作，索引将失效。**如：`explain select * from tb_user where substring(phone, 10, 2) = '15';`

   

2. 字符串类型字段使用时，**不加引号**，索引将失效。如：`explain select * from tb_user where phone = 17799990015;`

   此处phone的值没有加引号

   

3. 模糊查询中，如果仅仅是尾部模糊匹配，索引不会是失效；如果是**头部模糊匹配**，索引失效。如：`explain select * from tb_user where profession like '%工程';`，**前后都有 % 也会失效**。

   

4. 用 or 分割开的条件，如果 or 其中一个条件的列没有索引，那么涉及的索引都不会被用到。

   

5. 如果 MySQL 评估使用索引比全表更慢，则不使用索引



#### 覆盖索引&回表查询

explain 中 extra 字段含义：
	`using index condition`：查找使用了索引，但是需要回表查询数据
	`using where; using index;`：查找使用了索引，但是需要的数据都在索引列中能找到，所以不需要回表查询

![image-20231123113555162](picture/image-20231123113555162.png)



### sql优化

> 插入

1. 采用批量插入（一次插入的数据不建议超过1000条）
2. 手动提交事务
3. 主键顺序插入

大批量插入：
如果一次性需要插入大批量数据，使用insert语句插入性能较低，此时可以使用MySQL数据库提供的load指令插入。

> 主键

主键设计原则：

- 满足业务需求的情况下，尽量降低主键的长度
- 插入数据时，尽量选择顺序插入，选择使用 AUTO_INCREMENT 自增主键
- 尽量不要使用 UUID 做主键或者是其他的自然主键，如身份证号
- 业务操作时，避免对主键的修改

> order by

如果order by字段全部使用升序排序或者降序排序，则都会走索引，但是如果一个字段升序排序，另一个字段降序排序，则不会走索引

> 总结

![image-20231123122646198](picture/image-20231123122646198.png)



### 锁

---

#### 概述

​	锁是计算机协调多个进程或线程访问某一资源的机制。



1. **全局锁**：锁定数据库中的所有表
2. **表级锁**：每次操作锁住整张表
3. **行级锁**：每次操作锁住对应的行数据



#### 全局锁

​	**全局锁**就是对**整个数据库**实例加锁，加锁后处于**只读状态**，后续的DML的写语句，DDL语句，已经更新操作的事务提交语句都将被阻塞。



#### 表级锁

==表共享读锁(read lock)==

- 多个事务同时访问，都能读，不能写

- 写：自己会失败，其他会阻塞



==表独占写锁(write lock)==

- 不允许其他事务访问



==意向锁==

1. 意向共享锁（IS）
2. 意向排他锁（IX）



#### 行级锁

---

行级锁，每次加锁操作锁住对应的行数据。

锁定粒度最小，发生锁冲突概率最低，并发度最高。



**行锁（record lock）**：锁定单个记录的锁，防止其他事务对此进行update、delete



## 高级篇

### 写入数据流程

<img src="picture/image-20231123151612066.png" alt="image-20231123151612066" style="zoom: 33%;" />

> 1.为了支持回滚，记录旧值到`undo log` 日志文件中

> 2.写入的数据插入或`更新`到`Buffer Pool`

> 3.将“`更新写入信息`”放入内存的另一个区域`Redo Log Buffer`中

> 4.将Redo Log Buffer中的信息刷盘到磁盘上的redo log

策略是在每次事务提交前将“更新写入信息”写到内存Redo Log Buffer中，与此同时添加到操作系统的内存中，并立刻进行刷盘

> 5.IO线程根据不同的策略从内存中把需要更新写入的数据读出来，同时写入磁盘

### 读取数据流程

底层增删改查都是原子命令



到内存==Buffer pool==中 通过 ==自适应哈希索引==进行查找并进行返回，

InnDB会根据规则为==热点页==建立==自适应哈希索引 AHI==，

如果Buffer Pool中没有找到所需数据对应的==页==，则会通过预读的方式从磁盘加载到Buffer Pool中











### BinLog

功能：

1. 变更历史查询
2. 数据库备份和恢复
3. 主从



### 事务

> 原子性

==undo log 机制==

在每次进行数据的增删改时，都把对应的undo log 记录下来

当操作异常时触发【回滚】，反向执行每次操作记录的undo log

> 隔离性

事务之间不能相互干扰，不能互相查看彼此未提交的数据

方法

==写+写==：锁



==写+读==：MVCC （基于undo log 版本链 + Read View）

查找规则



> 持久性

redo log

> 一致性 






































## 1.谈谈你对SQL注入的理解

SQL注入的原理是`将SQL代码伪装到输入参数`中，传递到服务器解析并执行的一种攻击手法。

也就是说，在一些对SERVER端发起的请求参数中植入一些SQL代码，SERVER端在执行SQL操作时，会拼接对应参数，同时也将一些SQL注入攻击的“SQL”拼接起来，导致会执行一些预期之外的操作。



## 2.请你介绍一下数据库的ACID

- `原子性`

  事务被视为不可分割的最小单元，事务的所有操作要么全部提交成功，要么全部失败回滚。

  回滚可以用回滚日志（Undo Log）来实现，回滚日志记录着事务所执行的修改操作，在回滚时反向执行这些修改操作即可。

- `一致性`

  数据库在事务执行前后都保持一致性状态。在一致性状态下，所有事务对同一个数据的读取结果都是相同的。

- `隔离性`

  一个事务所做的修改在最终提交以前，对其他事务是不可见的。

- `持久性`

  一旦事务提交，则其所做的修改将会永远保存到数据库中。即使系统发生崩溃，事务执行的结果也不能丢失。

  系统发生崩溃可以用重做日志（Redo Log）进行恢复，从而实现持久性。与回滚日志记录数据的逻辑修改不同，重做日志记录的是数据页的物理修改。

事务的 ACID 特性概念简单，但不是很好理解，主要是因为这几个特性不是一种平级关系：

- 只有满足一致性，事务的执行结果才是正确的。
- 在无并发的情况下，事务串行执行，隔离性一定能够满足。此时只要能满足原子性，就一定能满足一致性。
- 在并发的情况下，多个事务并行执行，事务不仅要满足原子性，还需要满足隔离性，才能满足一致性。
- 事务满足持久化是为了能应对系统崩溃的情况。

## 3.索引的优缺点

优点：

- **加快数据查找的速度** 
- 为用来排序或者是分组的字段添加索引，可以加快分组和排序的速度 
- 加快表与表之间的连接  

缺点：

- 建立索引需要**占用物理空间** 
- 会降低表的增删改的效率，因为每次对表记录进行增删改，需要进行**动态维护索引**，导致增删改时间变长

## 4. 什么情况下需要建立索引

1. 经常用于查询的字段
2. 经常用于连接的字段建立索引，可以加快连接的速度
3. 经常需要排序的字段建立索引，因为索引已经排好序，可以加快排序查询速度



## 5.索引失效

导致索引失效的情况：

- 对于组合索引，不是使用组合索引最左边的字段，则不会使用索引 
- 以%开头的like查询如`%abc`，无法使用索引；非%开头的like查询如`abc%`，相当于范围查询，会使用索引 
- 查询条件中列类型是字符串，没有使用引号，可能会因为类型不同发生隐式转换，使索引失效 
- 判断索引列是否不等于某个值时 
- 对索引列进行运算 
- 查询条件使用`or`连接，也会导致索引失效

## 6.MVCC

MVCC(`Multiversion concurrency control`) 就是同一份数据保留多版本的一种方式，进而实现并发控制。在查询的时候，通过`read view`和版本链找到对应版本的数据。

作用：提升并发性能。对于高并发场景，MVCC比行级锁开销更小。



repeatable read：在一个事务范围内，第一次select时更新这个read_view，以后不会再更新，后续所有的select都是复用之前的read_view。这样可以保证事务范围内每次读取的内容都一样，即可重复读



## 7.快照读和当前读

表记录有两种读取方式。

- 快照读：读取的是快照版本。普通的`SELECT`就是快照读。通过mvcc来进行并发控制的，不用加锁。
- 当前读：读取的是最新版本。`UPDATE、DELETE、INSERT、SELECT … LOCK IN SHARE MODE、SELECT … FOR UPDATE`是当前读。

## 7.大表怎么优化？

某个表有近千万数据，查询比较慢，如何优化？

当MySQL单表记录数过大时，数据库的性能会明显下降，一些常见的优化措施如下：

- 限定数据的范围。比如：用户在查询历史信息的时候，可以控制在一个月的时间范围内； 
- 读写分离： 经典的数据库拆分方案，主库负责写，从库负责读； 
- 通过分库分表的方式进行优化，主要有垂直拆分和水平拆分。



## 8.bin log/redo log/undo log

MySQL日志主要包括查询日志、慢查询日志、事务日志、错误日志、二进制日志等。其中比较重要的是 `bin log`（二进制日志）和 `redo log`（重做日志）和 `undo log`（回滚日志）。

**bin log**

`bin log`是MySQL数据库级别的文件，记录对MySQL数据库执行修改的所有操作，不会记录select和show语句，主要用于恢复数据库和同步数据库。

**redo log**

`redo log`是innodb引擎级别，用来记录innodb存储引擎的事务日志，不管事务是否提交都会记录下来，用于数据恢复。当数据库发生故障，innoDB存储引擎会使用`redo log`恢复到发生故障前的时刻，以此来保证数据的完整性。将参数`innodb_flush_log_at_tx_commit`设置为1，那么在执行commit时会将`redo log`同步写到磁盘。

**undo log**

除了记录`redo log`外，当进行数据修改时还会记录`undo log`，`undo log`用于数据的撤回操作，它保留了记录修改前的内容。通过`undo log`可以实现事务回滚，并且可以根据`undo log`回溯到某个特定的版本的数据，**实现MVCC**。

## 9.bin log和redo log有什么区别？

1. `bin log`会记录所有日志记录，包括InnoDB、MyISAM等存储引擎的日志；`redo log`只记录innoDB自身的事务日志。 
2. `bin log`只在事务提交前写入到磁盘，一个事务只写一次；而在事务进行过程，会有`redo log`不断写入磁盘。 
3. `bin log`是逻辑日志，记录的是SQL语句的原始逻辑；`redo log`是物理日志，记录的是在某个数据页上做了什么修改

## 10.分库分表

数据切分可以分为两种方式：垂直划分和水平划分

> 垂直划分

![img](https://uploadfiles.nowcoder.com/files/20211030/8683776_1635580314798/%E5%9E%82%E7%9B%B4%E5%88%92%E5%88%86.png)

> 水平划分

![img](https://uploadfiles.nowcoder.com/files/20211030/8683776_1635580314854/%E6%B0%B4%E5%B9%B3%E5%88%92%E5%88%86.png)

**缺点**：

- 分片事务一致性难以解决
- 跨节点`join`性能差，逻辑复杂
- 数据分片在扩容时需要迁移



## 11.乐观锁和悲观锁是什么？

==悲观锁==：假定会发生并发冲突，在查询完数据的时候就把事务锁起来，直到提交事务。实现方式：使用数据库中的锁机制。 

==乐观锁==：假设不会发生并发冲突，只在提交操作时检查是否数据是否被修改过。给表增加`version`字段，在修改提交之前检查`version`与原来取到的`version`值是否相等，若相等，表示数据没有被修改，可以更新，否则，数据为脏数据，不能更新。实现方式：乐观锁一般使用版本号机制或`CAS`算法实现。









> 请你说说MySQL的事务隔离级别

- 事务隔离级别是为了解决`脏读`、`不可重复读`、`幻读` 
- `脏读`：一个事务读取了另一个事务未提交的数据 
- `不可重复读`：事务A两次读取的数据不一致，读第二次之前可能有其他事务修改了这个数据并提交了 
- `幻读`：事务A两次读取数据库，两次查询结果的条数不同，称为幻读。行数变了即为幻读，数据变了即为不可重复度 

---

- MySQL的事务隔离级别有四种，分别是`读未提交`，`读已提交`，`可重复读`，`可串行化`。
- `读未提交`不能解决脏读，幻读和不可重复读。
- `读已提交`解决了脏读的问题，
- `可重复读`解决了脏读和不可重复读，但是幻读依然存在。
- `可串行化`解决了脏读，幻读，不可重复读，MySQL默认使用可重复读

> 数据库为什么不用红黑树而用B+树？

- 索引的数据结构会被存储在磁盘中，每次查询都需要到磁盘中访问
- 对于`红黑树`，树的`高度`可能会非常的高，会进行很多次的磁盘IO，效率会非常低
- `B+树`的高度一般为2-4，也就是说在最坏的条件下，也最多进行`2到4次磁盘IO`，这在实际中性能时非常不错的

> MySQL主从同步是如何实现的？

- 复制（replication）是MySQL数据库提供的一种高可用高性能的解决方案,一般用来建立大型的应用。总体来说,replication的工作原理分为以下3个步骤： 
  1. `主服务器（master）`把数据更改记录到二进制`日志`（binlog）中。
  2. `从服务器（slave）`把主服务器的二进制`日志复制`到自己的`中继日志`（relay log）中
  3. 从服务器重做中继日志中的日志,把更改应用到自己的数据库上,以达到数据的最终一致性







# 框架

## springboot

### Springboot与Spring

​	从本质上来说，Spring Boot就是Spring，它做了那些没有它你自己也会去做的Spring Bean配置。

​	Spring Boot使用`习惯优于配置`的理念让你的项目快速地运行起来，使用Spring Boot很容易创建一个能独立运行、准生产级别、基于Spring框架的项目，使用Spring Boot你可以不用或者只需要很少的Spring配置。

​	简而言之，Spring Boot本身并不提供Spring的核心功能，而是作为`Spring的脚手架框架`，以达到`快速构建项目`、`预置三方配置`、`开箱即用`的目的。

​	使用过 Spring 的小伙伴，一定有被 XML 配置统治的恐惧。即使 Spring 后面引入了基于注解的配置，我们在开启某些 Spring 特性或者引入第三方依赖的时候，还是需要用 XML 或 Java 进行显式配置。



### Starter

Spring Boot通过提供众多`起步依赖（Starter）`降低项目依赖的复杂度。起步依赖本质上是一个Maven项目对象模型（Project Object Model, POM），定义了对其他库的传递依赖，这些东西加在一起即支持某项功能。很多起步依赖的命名都暗示了它们提供的某种或某类功能



### 自动装配

#### 简介与流程概述

使用Spring Boot时，我们只需`引入`对应的`Starters`，Spring Boot启动时便会`自动加载`相关`依赖`，`配置`相应的初始化`参数`，以最快捷、简单的形式对第三方软件进行集成，这便是Spring Boot的自动配置功能。



整个自动装配的过程是：

1. Spring Boot通过`@EnableAutoConfiguration`注解`开启自动配置`

2. 加载`spring.factories`中注册的各种AutoConfiguration类

3. 当某个`AutoConfiguration类`满足其注解`@Conditional`指定的生效条件（Starters提供的依赖、配置或Spring容器中是否`存在某个Bean`等）时

   实例化该AutoConfiguration类中定义的Bean（组件等），并注入Spring容器，就可以完成依赖框架的自动配置。

----

`@EnableAutoConfiguration` --> `spring.factories` --> `@Conditional` --> `实例化Bean`



```java
@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan
public class SanGengBlobApplication {
    public static void main(String[] args) {
        SpringApplication.run(SanGengBlobApplication.class, args);
    }
}
```

```properties
# Auto Configure
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.info.aspect.InfoAspect
#会加载这个类，成为Bean
```

```java
@Aspect
public class InfoAspect {
}
```

```java
@ComponentScan("com.itheima.bean")
public class SpringConfig {
    @Bean
    @ConditionalOnClass(name="com.mysql.jdbc.Driver")
    public DruidDataSource dataSource(){
        return new DruidDataSource();
    }
}
```

#### @SpringBootApplication

> **@SpringBootApplication**

1. 首先启动类使用了`@SpringBootApplication`注解，这个复合注解包括了

   1. `@EnableAutoConfiguration` 

   2. `@SpringBootConfiguration`

   3. `@ComponentScan`

      三个注解

2. `@SpringBootConfiguration`是标注当前类是一个**配置类**并**注入**到IOC**容器**中

3. `@ComponentScan`是扫描指定路径下带有特定注解的类到IOC容器中。

4. 最为重要的是`@EnableAutoConfiguration`，它能通过`ImportSelector选择器`将所有带有@Configuration自动导入到容器里。

>  @EnableAutoConfiguration

`EnableAutoConfiguration` 只是一个简单地注解，自动装配核心功能的实现实际是通过 `AutoConfigurationImportSelector`类。

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import({AutoConfigurationImportSelector.class})
public @interface EnableAutoConfiguration {
    String ENABLED_OVERRIDE_PROPERTY = "spring.boot.enableautoconfiguration";

    Class<?>[] exclude() default {};

    String[] excludeName() default {};
}
```

`AutoConfigurationImportSelector` 类实现了 `ImportSelector`接口，也就实现了这个接口中的 `selectImports`方法，该方法主要用于**获取所有符合条件的类的全限定类名，这些类需要被加载到 ioc 容器中**。

```java
public class AutoConfigurationImportSelector implements DeferredImportSelector, BeanClassLoaderAware, ResourceLoaderAware, BeanFactoryAware, EnvironmentAware, Ordered {
   
    
    private static final String[] NO_IMPORTS = new String[0];
    
    
     public String[] selectImports(AnnotationMetadata annotationMetadata) {
         //1.判断自动装配注解 是否开启
        if (!this.isEnabled(annotationMetadata)) {
            return NO_IMPORTS;
        } else {
            //2.获取所有需要装配的Bean 
            AutoConfigurationImportSelector.AutoConfigurationEntry autoConfigurationEntry = this.getAutoConfigurationEntry(annotationMetadata);
            
            return StringUtils.toStringArray(autoConfigurationEntry.getConfigurations());
        }
    }
    
}
```

getAutoConfigurationEntry（）

<img src="https://p6-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/3c1200712655443ca4b38500d615bb70~tplv-k3u1fbpfcp-watermark.image" alt="img" style="zoom: 80%;margin:0;border:3px solid #d63200" />

```java
private static final AutoConfigurationEntry EMPTY_ENTRY = new AutoConfigurationEntry();

	protected AutoConfigurationEntry getAutoConfigurationEntry(AnnotationMetadata annotationMetadata) {
		
        //1.判断自动装配开关是否打开
        //默认spring.boot.enableautoconfiguration=true
        //可在 application.properties 或 application.yml 中设置
        if (!isEnabled(annotationMetadata)) {
			return EMPTY_ENTRY;
		}
        //2.用于获取EnableAutoConfiguration注解中的 exclude 和 excludeName。
		AnnotationAttributes attributes = getAttributes(annotationMetadata);
        
		//3.获取需要自动装配的所有配置类，读取META-INF/spring.factories
        //不光是这个依赖下的META-INF/spring.factories被读取到，所有 Spring Boot Starter 下的META-	INF/spring.factories都会被读取到。
         List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);
        
         //4.这一步有经历了一遍筛选，@ConditionalOnXXX 中的所有条件都满足，该类才会生效。
         //spring.factories中这么多配置，每次启动不需要全部加载
		configurations = removeDuplicates(configurations);
		
         Set<String> exclusions = getExclusions(annotationMetadata, attributes);
		checkExcludedClasses(configurations, exclusions);
		configurations.removeAll(exclusions);
		configurations = getConfigurationClassFilter().filter(configurations);
		fireAutoConfigurationImportEvents(configurations, exclusions);
		return new AutoConfigurationEntry(configurations, exclusions);
	}
```

![image-20230520150203102](picture/image-20230520150203102.png)

> debug分析

<img src="picture/image-20230520151229440.png" alt="image-20230520151229440" style="zoom:50%;margin:0;border:3px solid #d63200" />

<img src="picture/image-20230520151305552.png" alt="image-20230520151305552" style="zoom:80%;margin:0;border:3px solid #d63200" />

<img src="picture/image-20230520151850506.png" alt="image-20230520151850506" style="zoom:80%;margin:0;border:3px solid #d63200" />

### 启动流程

> springboot的启动流程

1. main的run方法
2. 判断web应用的类型
3. spring.factories获取配置
4. 初始化监听器
5. 初始化容器
6. 应用启动，开始监听
7. 显示banner
8. 加装容器
---

```java
SpringApplication.run(启动类.class, args)
                   ↓
                   ↓
public static ConfigurableApplicationContext run(Class<?> primarySource,String[]args){
    return new SpringApplication(primarySource).run(args);
}             {1}  ↓                           {2} 
                   ↓                           
                   ↓                                                                
public SpringApplication(Class<?>... primarySources){                                 
    this(null,primarySources);                                                           
}     ↓                                                                         
      ↓
{1}   ↓
public SpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
    //1.1 加载 加载器、主方法类 到内存中
    this.resourceLoader = resourceLoader;
    Assert.notNull(primarySources, "PrimarySources must not be null");
	this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
		
                                  
    //1.2 判断对应的服务类是否存在,来确定web服务的类型,默认是Servlet                 
	this.webApplicationType = WebApplicationType.deduceFromClasspath();

    //1.3   加载初始化类
    //1.3.1 读取所有spring.factories中的 "注册初始化"、"上下文初始化" 和 "监听器" 这三类配置 
	this.bootstrapRegistryInitializers = getBootstrapRegistryInitializersFromSpringFactories();             
	setInitializers((Collection) getSpringFactoriesInstances(ApplicationContextInitializer.class));		
	setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
                       
    //1.4 判断main()方法所在的类,即启动类，加载到SpringApplication中                  
	this.mainApplicationClass = deduceMainApplicationClass();
}
-------------------------------------------------------------------------------------------
 return new SpringApplication(primarySource).run(args);
                                              ↓
                                              ↓                                             {2}                                         ↓
//环境准备,初始化容器,获取Application对象
public ConfigurableApplicationContext run(String... args) {
		long startTime = System.nanoTime();
                                                  
         //2.1创建启动上下文BootstrapContext,逐一调用 "注册初始化器" 的 初始化方法
         //SpringBoot没有默认的 "注册初始器" ,所以默认不执行什么     
		DefaultBootstrapContext bootstrapContext = createBootstrapContext();
		ConfigurableApplicationContext context = null;
                                                  
         //2.2 将 "java.awt.headless" 设置为 true ,表示缺少显示器、键盘等输入设备也可以正常启动
		configureHeadlessProperty();
                                                  
         //2.3.1 启动 "运行监听器"                                           
		SpringApplicationRunListeners listeners = getRunListeners(args);
         //2.3.2 同时发布 "启动事件",它获取并加载spring-boot工程中spring.factories配置文件中的EventPublishingRunListener,
         //引入准备阶段的8个"监听器"
		listeners.starting(bootstrapContext, this.mainApplicationClass);
		try {
			ApplicationArguments applicationArguments = new DefaultApplicationArguments(args);
            
             //2.4   组装启动参数
             //2.4.1 构造一个"可配置环境" ConfigurableEnvironment，根据不同web服务类型构造不同的环境
             //2.4.2 记载"系统环境变量"systemEnvironment、"jvm系统属性"systemProperties等在内的4组配置信息，加载到propertySources内存集合中，后续使用这些信息就无序加载了。
             //2.4.3 发布环境准备完成事件，刚加载的8个"监听器"会监听到这个事件，执行相关执行器
			ConfigurableEnvironment environment = prepareEnvironment(listeners, bootstrapContext, applicationArguments);
			
             //2.5.1 表示不加载Bean的元数据信息
             configureIgnoreBeanInfo(environment);
             //2.5.2 打印banner图
			Banner printedBanner = printBanner(environment);
            
            
             //3 容器创建阶段
            
             //3.1   创建容器
             //3.1.2 根据服务类型创建"容器" ConfigurableApplicationContext,默认是servlet，所以创建"注解配置的Servlet-Web服务容器",即AnnotationConfigServletWebServerApplicationContext。
             //3.1.3 构造（存放和生产我们Bean实例的"Bean工厂"DefaultListableBeanFactory）、（用来解析@Component @ComponentScan等注解的"配置类后处理器"ConfigurationClassPostProcessor）、（用来解析@Autowird、@Value、@Inject等注解的"自动注解Bean后处理器"AutowirdAnnotationBeanPostProcessor等），放入容器
			context = createApplicationContext();
			context.setApplicationStartup(this.applicationStartup);
			
             //3.2   对容器内的部分属性进行初始化
             //3.2.1 postProcessApplicationContext()设置"Bean名称生成器"、"资源加载器"、"类型转换器"等
             //3.2.2 执行准备阶段的"上下文初始化",实现容器id、警告日志处理、日志监听
             //3.2.3 通过Bean定义加载器将"启动类"在内的资源加载到Bean定义集合中
             //3.2.4 发布资源加载完成事件
             prepareContext(bootstrapContext, context, environment, listeners, applicationArguments, printedBanner);
			
             
             //4.  填充容器
             //4.1 ioc的流程（自动装配 启动tomcat）
             refreshContext(context);
		
           
			listeners.started(context, timeTakenToStartup);
			callRunners(context, applicationArguments);
		}
		return context;
	}   
```

> SpringApplication的`run()`完成`服务构建`、`环境准备`、`容器创建`、`填充容器`四项工作。

1. `服务构建`,**组装SpringSpplication** ，需要在`SpringApplication`的构造器中完成
   1. `加载资源加载器、主方法类到内存中`
   2. `判定web应用类型`是否存在并默认为servlet
   3. 确定web服务器后就要`加载初始化类`，这里是通过META-INFO/`spring.factories`来读取**启动注册初始化器**、**应用上下文初始化器**、**应用监听器**三类配置，当然，这里也可以对自定义三类配置



2. 调用run方法进入`环境准备阶段`，主要是对容器和组件做一些前置操作。
   1. 先`创建一个启动上下文`。并逐一`调用`刚刚加载的**启动注册初始化器的初始化方法	**
   2. 接下来设置`awt.headLess=true`表示缺少显示器、键盘等设备也可正常启动	
   3. `获取并启动应用监听器`，同时发布启动事件，获取并加载spring.factories中的事件发布运行监听器，并且会将应用监听器也一并引入，以后想要在启动流程过程中加入自定义逻辑就只需要监听这些事件	
   4. 通过prepareEnvironment方法`组装启动参数`，根据不同的web构造不同的环境。构造完毕后会加载环境变量、jvm系统属性到属性集合中，后期无需加载。此时可设置启动参数并添加configuration.properties到属性集合中。接下来会发布环境准备完成的事件，一些监听器收到信号会做相应处理。
   5. 可做**忽略元数据加载**、**打印banner**的操作。



3. 环境准备好以后，就可以`创建容器`(ApplicationContext)了。

   1. 首先创建注解配置servlet容器，具体行为是创建beanfactory、用来解析一些注解的后置处理器和其他属性对象 

   2. 调用prepareContext方法对`容器中的属性`进行`初始化`

      

4. `填充容器`

   1. 填充Bean，启动tomcat，ioc流程	

   2. 发布启动事件完成的同时，会回调自定义Runner接口来处理定制化需求

      

      作者：仲夏七月梦 https://www.bilibili.com/read/cv22717345?spm_id_from=333.999.0.0 出处：bilibili



---

## spring

### Bean

#### Bean生命周期

> bean的生命周期

```java
//AbstractApplicationContext.class

 public void refresh() {
     
      this.finishBeanFactoryInitialization(beanFactory);
     //方法里使用getBean()
 }

//AbstractAutowireCapableBeanFactory.class
  protected Object doCreateBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args) {
      
      
  }
```

1. `生产`
   - 通过loadBeanDefinitions方法，扫描bean，用xml，注解扫描等方式**找到Bean**，存入beanDefinitionMap（Bean定义集合）中
   - **遍历Bean定义集合**，创建bean，createBean()
     - **构造对象**，createBeanInstance （），用反射机制获取Bean的Class类的**构造器**，加载方法参数，实例化出一个Bean
     - **属性填充**，为Bean内部所需的属性进行赋值填充，通常就是`@Autowired`注解的这些变量
     - **初始化实例**，initializeBean（）
     - **注册销毁**
   - 放入**单例池**
2. `使用`
3. `销毁`
   - 销毁前处理器PostProcessBeforeDestruction，会执行Bean中@PreDestory注解的方法；

---

`实例化Bean`->`Bean属性填充`->`初始化Bean`->`销毁Bean`

1. **反射创建Bean对象**
   - 通过loadBeanDefinitions方法，用xml，注解扫描等方式，`找到定义的Bean`，存入beanDefinitionMap（Bean定义集合）中
   
   - **遍历**Bean定义**集合**，**创建bean**，createBean()
   
     - 通过反射机制，使用构造器创建
   
2. **属性填充**，注入这个Bean依赖的其他Bean对象

   - 三级缓存，依赖注入

3. **初始化Bean**

   - **执行Aware接口的方法**，可以通过接口获取BeanName，BeanFactory
   - **执行BeanPostProcessor的前置处理方法**postProcessBeforeInitialization，对Bean进行一些中自定义的前置处理
   - **判断Bean是否实现了InitializingBean接口**，执行InitializationBean的afterPropertiesSet（）初始化方法
   - **执行用户自定义的初始化方法**，如init-method 
   - **执行BeanPostProcessor的后置处理方法**，postProcessAfterInitialization（）

4. 不需要时销毁

   - 执行**后置处理器**的**回调**方法
   - 判断是否实现了**DisposableBean接口**，调用**destory**（）方法
   - 判断是否配置了destroy-method等**自定义的销毁**方法，执行

![image-20230520154340964](picture/image-20230520154340964.png)

---

#### Bean作用域

> 说说Bean的作用域,以及默认的作用域

Bean单例的,但我们可以通过@Scope注解来修改Bean的作用域。

这个注解有五个不同的取值,

- singleton ：在Spring容器中仅存在一个实例,即Bean以单例的形式存在。 
- prototype ：每次调用getBean()时,都会执行new操作,返回一个新的实例。 
- request ：每次HTTP请求都会创建一个新的Bean。 
- session ：同一个HTTP Session共享一个Bean,不同的HTTP Session使用不同的Bean。 
- globalSession：同一个全局的Session共享一个Bean,一般用于Portlet环境。

---

### IOC

#### 什么是IOC

> IOC

**控制反转**，让spring管理Bean

有了Spring框架，我们就很少自己进行对象的创建了，而我们使用到的对象当然就是交给Spring的工厂模式来创建的了。其中**BeanFactory**是Spring容器的顶层接口，也是Bean工厂最上层的接口，其会有很多工厂实现例如，我们可以把BeanFactory看成是一种工厂方法模式。

BeanFactory以及FactoryBean可以看做是工厂方法模式的实现，BeanFactory融合了反射以及配置，提高了工厂创建对象的灵活程度，FactoryBean为BeanFactory创建的对象提供了定制化的对象工厂实现，也能够提高Spring创建和管理对象的能力

————————————————
版权声明：本文为CSDN博主「猿梦学码」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_44420511/article/details/125185404

- [前言](https://blog.csdn.net/weixin_44420511/article/details/125185404#_3)
- [一、工厂模式介绍](https://blog.csdn.net/weixin_44420511/article/details/125185404#_8)
- - [1、简单工厂模式](https://blog.csdn.net/weixin_44420511/article/details/125185404#1_10)
  - - [（1）静态工厂模式](https://blog.csdn.net/weixin_44420511/article/details/125185404#1_12)
    - [（2）利用反射机制实现的简单工厂](https://blog.csdn.net/weixin_44420511/article/details/125185404#2_42)
  - [2、工厂方法模式](https://blog.csdn.net/weixin_44420511/article/details/125185404#2_75)
  - [3、抽象工厂模式](https://blog.csdn.net/weixin_44420511/article/details/125185404#3_107)
- [二、Spring框架中工厂模式的重要应用](https://blog.csdn.net/weixin_44420511/article/details/125185404#Spring_154)
- - [1、BeanFactory](https://blog.csdn.net/weixin_44420511/article/details/125185404#1BeanFactory_156)
  - [2、FactoryBean](https://blog.csdn.net/weixin_44420511/article/details/125185404#2FactoryBean_160)
- [总结](https://blog.csdn.net/weixin_44420511/article/details/125185404#_18

---

#### IOC执行流程

![image-20230517133834964](picture/image-20230517133834964.png)

---

```java
//AbstractApplicationContext.class 
public void refresh() {
     synchronized(this.startupShutdownMonitor) {
         
         //1.准备环境
         this.prepareRefresh();
         
         //2.创建容器，实例化DefaultListaleBeanFactory对象，解析Bean到成员变量
         ConfigurableListableBeanFactory beanFactory = this.obtainFreshBeanFactory();
         
         //3.准备Bean工厂，这是一些BeanFactory的一些属性
         this.prepareBeanFactory(beanFactory);
         
         try {
             
             //4.Spring提供PostProcessBeanFactory（）方法给我们扩展，可以注册一些特殊的后置处理器
             this.postProcessBeanFactory(beanFactory);
             
             //5.执行BeanFactoryPostProcessor，回调
             this.invokeBeanFactoryPostProcessors(beanFactory);
             
             //6.检索注册并排序Bean后置处理器
             this.registerBeanPostProcessors(beanFactory);
             
             //7.国际化处理
             this.initMessageSource();
             //消息广播
             this.initApplicationEventMulticaster();
             
             //8.启动tomcat服务器
             this.onRefresh();
             
             //9.注册监听器
             this.registerListeners();
             
             //10.生产Bean
             this.finishBeanFactoryInitialization(beanFactory);

             //11
             this.finishRefresh();
             
             
         }catch (BeansException var10) {
             
         }
         
     }
     
 }
```

![image-20230517150938055](picture/image-20230517150938055.png)

1. `prepareRefresh()`:

   1. 在已有系统环境基础上，**准备**servlet相关的**环境**Environment

   

2. `obtainFreshBeanFactory()`:

   1. 会通过它的**refreshBeanFactory()**方法重新构造**beanfactory**，
   2. **加载xml**文件中的<bean id="user" class="User"></bean>**到beanDefinitionMap中**

   

3. `prepareBeanFactory(beanFactory)`:

   1. 主要准备**类加载器**（BeanClassLoder）、**表达式解析器**（BeanExpressionResolver）、**配置文件处理器**（PropertyEditorRegistrar）等系统级处理器、以及**两个Bean后置处理器**用来解析Aware接口的ApplicationContextAwareProcessor、用来处理自定义监听器注册和销毁的ApplicationListenerDetector。
   2. **注册一些特殊Bean和系统级Bean**，比如容器Beanfactory和ApplicationContext、系统环境Environment、系统属性systemProperties等，将他们放入"特殊对象池"和"单例池中"




4. `postProcessBeanFactory(beanFactory)`：
   1. 对BeanFatory进行额外设置或修改。主要定义了包括request、session在内的Servlet相关作用域Scopes。同时注册与Servlet相关的一些特殊Bean，包括ServletRequest、ServletResponse、HttpSession等到特殊对象池中
   
   2. **注册一些特殊的后置处理器**
   
      
   
5. `invokeBeanFactoryPostProcessors(beanFactory)`:
   1. **执行注册的BeanFactory后置处理器**BeanFactoryPostPrecessor。
   2. 其中最重要的就是用来**加载**所有"**Bean定义**"的"**配置处理器**"ConfigurationClassPostProcessor，通过它**加载所有@Configuration配置类**，
      1. 同时检索指定的"Bean扫描路径"**componentScans**扫描每个类，将扫描出来的Bean放入BeanDefinitionMap中
      2. 扫描@Bean，@Import等注解的类与方法到BeanDefinitionMap



6. `registerBeanPostProcessors(beanFactory)`:检索所有的**Bean后置处理器**，同时根据指定的order为它们排序，放入"后置处理器"beanPostProcessors中，每个Bean后置处理器会在Bean初始化之前和之后分别执行对应的逻辑。

   ```java
   public class MyBeanPostProcessor implements BeanPostProcessor {
       @Override
       public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
           //此方法在bean的生命周期初始化之前执行
           System.out.println("MyBeanPostProcessor-->后置处理器postProcessBeforeInitialization");
           return bean;
       }
   
       @Override
       public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
           //此方法在bean的生命周期初始化之后执行
           System.out.println("MyBeanPostProcessor-->后置处理器postProcessAfterInitialization");
           return bean;
       }
   }
   ```



7.   `initMessageSource()`:国际化处理"messageSource",可以自定义名为"messageSource"的Bean，结合messages.properties配置文件就可以进行多语言的切换了
     `initApplicationEventMulticaster()`:"applicationEventMulticaster"的Bean，自定义广播事件，



8. `onRefresh()`：构造并启动web服务器
   1. 先查找实现了ServletWebServerFactory这个接口的应用服务器Bean，默认服务器为tomcat
   2. getWebServer()构造Tomcat对象，通过start（）方法启动



9. `registerListeners()`:在bean中查找所有的"监听器Bean"，将它们注册到消息广播器applicationEventMulticaster中



10. `finishBeanFactoryInitialization(beanFactory)`:生产所有的Bean，Bean的生命周期开始
    1. Bean生成之后会放入"单例池"singletonObjects中



11. `finishRefresh()`:构造并注册"生命周期管理器"lifecycleProcessor
    1. 会调用所有实现了"生命周期接口"lifecycle的Bean的start方法，在容器关闭时会调用stop
    2. 发布容器刷新完成事件





> IOC （控制反转）与 DI（依赖注入）

IOC

一种设计思想，将原本我们手动创建对象的**控制权**交给spring，spring来管理Bean的生命周期。传统程序，高度**耦合**

DI

应用程序在运行时依赖IOC容器来动态注入组件所需的某个依赖。Spring的DI具体就是通过反射实现注入的。

我们只需要通过简单的配置，就获取需要的资源

### AOP

#### 什么是AOP

> AOP @Aspect

`@Before` `@After` `@AfterReturning` `@AfterThrowing` `@Around`

AOP是面向切面编程，它是一种编程思想，它是一种通过预编译方式和运行期间动态代理的方式实现不修改源代码的情况下给程序动态添加功能的一种技术，可以降低代码的耦合度，便于管理，提高代码的可重用性。

 AOP的实现方式有两种： 

- JDK动态代理，可以在运行时创建接口的代理实例。 
- CGLIB动态代理：可以在运行期间创建子类的动态实例。 AOP的应用场景有：事务，日志管理等。

### 事务

> 说说Spring事务管理

关键点：**两种事物模型**

 ①**编程式事务**管理使用TransactionTemplate。 

 ②**声明式事务**管理建立在AOP之上的。其本质是通过AOP功能，对方法前后进行拦截，将事务处理的功能编织到拦截的方法中，也就是在目标方法开始之前启动一个事务，在执行完目标方法之后根据执行情况提交或者回滚事务。 声明式事务最大的优点就是不需要在业务逻辑代码中掺杂事务管理的代码，只需在配置文件中做相关的事务规则声明或通过**@Transactional**注解的方式，便可以将事务规则应用到业务逻辑中，减少业务代码的污染。唯一不足地方是，最细粒度只能作用到方法级别，无法做到像编程式事务那样可以作用到代码块级别。

### MVC

#### 什么是MVC

> 说说自己对于 Spring MVC 了解?

MVC 是模型(Model)、视图(View)、控制器(Controller)的简写，其核心思想是通过将业务逻辑、数据、显示分离来组织代码。



MVC是一种设计模式，将软件分为三层，分别是模型层，视图层，控制器层。其中模型层代表的是数据，视图层代表的是界面，控制器层代表的是逻辑处理，是连接视图与模型之前的桥梁。降低耦合，便于代码的维护

#### 执行流程

> 介绍一下Spring MVC的执行流程

1. 用户点击某个请求路径，发起一个 HTTP request 请求，该请求会被提交到 DispatcherServlet`前端控制器`；
2. 由 DispatcherServlet 请求一个或多个 `HandlerMapping`（处理器映射器），并返回一个`执行链`（HandlerExecutionChain）。
3. DispatcherServlet 将执行链返回的 Handler 信息发送给 HandlerAdapter（处理器适配器）；
4. HandlerAdapter 根据 Handler 信息找到并执行相应的 Handler（常称为 Controller）；
5. Handler 执行完毕后会返回给 HandlerAdapter 一个 ModelAndView 对象（Spring MVC的底层对象，包括 Model 数据模型和 View 视图信息）；
6. HandlerAdapter 接收到 ModelAndView 对象后，将其返回给 DispatcherServlet ；
7. DispatcherServlet 接收到 ModelAndView 对象后，会请求 ViewResolver（视图解析器）对视图进行解析；
8. ViewResolver 根据 View 信息匹配到相应的视图结果，并返回给 DispatcherServlet；
9. DispatcherServlet 接收到具体的 View 视图后，进行视图渲染，将 Model 中的模型数据填充到 View 视图中的 request 域，生成最终的 View（视图）；
10. 视图负责将结果显示到浏览器（客户端）。

----

`http` ----> `DispatcherServlet`前端控制器---->`HandlerMapping`处理器映射器，返回`执行链`

`执行链`---->`HandlerAdapter`处理器适配器---->找到并执行相应的 Handler（常称为 `Controller`）

----> 返回`ModelAndView `---->·`ViewResolver`视图解析器---->`渲染返回`

---

## MyBatis

> 在MyBatis中$和#有什么区别

`$` MyBatis会创建普通的SQL语句,然后在执行SQL 语句时将参数拼入SQL

`#`MyBatis会创建预编译的SQL语句,然后在执行SQL时MyBatis会为预编译SQL中的占位符赋值。预编译的SQL语句执行效率高,并且可以防止注入攻击,效率和安全性都大大优于前者

```mysql
# 会转换成字符串
select * from user where id=#{}
```

---

