# 编程语言

> 请你说说Java的特点和优点,为什么要选择Java？

1. 一次编译，到处运行，即`平台无关性`；是纯`面向对象`的语言。
2. JAVA语言的优点有：内置的类库简化了开发人员的设计工作；具有较好的安全性和健壮性；开发人员`不需要`对`内存`的使用进行`管理`。
3. 选择JAVA的原因是：使用范围很广，安卓操作系统的应用软件目前大部分还是使用JAVA语言编写。

> 请你说说Java基本数据类型和引用类型

1. 提供8种基本数据类型：byte(8), short(16), int(32), long(64), float(32), double(64), char(16), boolean，这些基本数据类型有对应的封装类；这基本数据类型在声明之后就会立刻在**栈**上被分配内存空间
2. 其他类型都是引用类型：类，接口，数组，String等，这些变量在声明时**不会被分配内存空间**，只是存储了一个**内存地址**。

> 请你说一下抽象类和接口的区别

相同点：

1、两者都`不能实例化`；

2、可以拥有`抽象方法`。 

区别：

1、抽象类定义的关键字是abstract class，接口定义的关键字是interface；

2、属性上，抽象类可以有静态变量、常量和成员变量，接口只能有常量；

3、抽象方法可以有普通方法，而接口jdk1.8之前只能有抽像方法（1.8之后，增加了静态方法和默认方法）；

4、抽象方法可以有构造方法，接口不可以有构造方法。

5、一个类只能单继承一个父类，而一个接口可以继承多个父接口，同时，一个类可以实现多个接口却没有实现多个父类这一说法；

6、抽象方法在业务编程上更像一个模板，有自己的功能，同时也可以有优化补充的多种形式，而接口更像是一种规范和要求，实现就要按照要求来进行。

> 请你说一下final关键字

1. final可以修饰类，方法，变量。 
2. final修饰类，该类不可被继承。 
3. final修饰方法，该方法不能被重写。 final修饰变量，如果是基本变量则值不能再改变，如果是引用变量则引用地址不能改变，但值可以改变。

> 说说static修饰符的用法

1. static修饰变量：属于静态变量也叫类变量，直属于类对象而不是实例，可以通过类名访问，它一般会在类加载过程中被初始化。生命周期贯穿整个程序。存储在方法区中。
2.  static修饰方法：即静态方法，一个类中的静态方法不能访问该类的实例变量，只能访问静态变量。同时还存在一个静态初始化块，他在类加载过程中被调用用于对该类中的静态变量进行操作。 
3. static修饰类：即静态内部类，他只能以内部类的形式存在，可通过外部类的类名调用。它是他也只能访问到外部的的静态成员。

> 请你说说String类,以及new和

1. String类被final修饰，所以不能被继承。
2. 创建String对象时可以使用字符串直接量，如String str="1abc", 另一种String str=new String("1abc")
3. 前者使用常量池来管理，后者先判断常量池中是否已存在此字符串，不存在就也在常量池创建，再在堆内存创建一个新的对象，因此后者开销更大

> String、StringBuffer、Stringbuilder有什么区别

1. String是不可变字符序列，从它创建到销毁前，都不可变。
2. StringBuilder是可变字符序列，但不是线程安全的。
3. StringBuffer是可变字符序列，与StringBuilder功能相似，区别是它是线程安全的。 
4. 相比String，StringBuilder有append()方法，即追加字符串。最后toString()转换成String

> 请你说说==与equals()的区别

1. == 比较基本数据类型时，比较的是两个数值是否相等； 比较引用类型是，比较的是对象的内存地址是否相等。 
2. equals() 没有重写时，Object默认以==来实现，即比较两个对象的内存地址是否相等； 重写以后，按照对象的内容进行比较

> 请你说说hashCode()和equals()的区别,为什么重写equals()就要重写hashcode()

1. hashCode()：获取哈希码,equals()：比较两个对象是否相等。
2. 二者两个约定：如果两个对象相等,它们必须有相同的哈希码；若两个对象的哈希码相同,他们却不一定相等。也就是说,equals()比较两个对象相等时hashCode()一定相等,hashCode()相等的两个对象equqls()不一定相等。
3. 加分回答：由于hashCode()与equals()具有联动关系,equals()重写时,hashCode()进行重写,使得这两个方法始终满足相关的约定。

> 请你讲一下Java 8的新特性

- **Lambda 表达式** − Lambda 允许把函数作为一个方法的参数（函数作为参数传递到方法中）。
- **方法引用** − 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
- **默认方法** − 默认方法就是一个在接口里面有了一个实现的方法。
- **新工具** − 新的编译工具，如：Nashorn引擎 jjs、 类依赖分析器jdeps。
- **Stream API** −新添加的Stream API（java.util.stream） 把真正的函数式编程风格引入到Java中。
- **Date Time API** − 加强对日期与时间的处理。
- **Optional 类** − Optional 类已经成为 Java 8 类库的一部分，用来解决空指针异常。
- **Nashorn, JavaScript 引擎** − Java 8提供了一个新的Nashorn javascript引擎，它允许我们在JVM上运行特定的javascript应用。

> 介绍一下包装类的自动拆装箱与自动装箱

1. 自动装箱、自动拆箱是JDK1.5提供的功能。
2. 自动装箱：把一个基本类型的数据直接赋值给对应的包装类型；
3. 自动拆箱是指把一个包装类型的对象直接赋值给对应的基本类型；
4. 通过自动装箱、自动拆箱功能,简化基本类型变量和包装类对象之间的转换过程

> 请你说说Java的异常处理机制

1. 异常处理机制让程序具有`容错性`和`健壮性`,程序运行出现状况时,系统会生成一个`Exception对象`来通知程序
2. 处理异常的语句由try、catch、finally三部分组成。try块用于包裹业务代码,catch块用于捕获并处理某个类型的异常,finally块则用于回收资源。
3. 如果业务代码发生异常,系统创建一个异常对象,并将其提交给JVM,由JVM寻找可以处理这个异常的catch块,并将异常对象交给这个catch块处理。如果JVM没有找到，运行环境终止,Java程序退出。
4. Java也允许程序主动抛出异常。当业务代码中,判断某项错误的条件成立时,可以使用throw关键字向外抛出异常。

> 说说你对面向对象的理解

1. 面向对象三大基本特征：`封装`、`继承`、`多态`。
2. 封装：将对象的状态信息隐藏在对象内部,不允许外部程序直接访问对象内部信息,让外部程序通过该类提供的方法来实现对内部信息的操作和访问,提高了代码的可维护性；
3. 继承：实现代码复用的重要手段,通过extends实现类的继承,实现继承的类被称为子类,被继承的类称为父类；
4. 多态的实现离不开继承,在设计程序时,我们可以将参数的类型定义为父类型。在调用程序时根据实际情况,传入该父类型的某个子类型的实例,这样就实现了多态。

> 请介绍一下访问修饰符

1. Java中的访问修饰符有四种，分别为private,default,protected,public。
2. private：类中被private修饰的只能在被当前类的内部访问
3. default：类中被default修饰的只能在当前类和当前类所在包的其他类访问。
4. protected：类中被protected修饰的可以被当前类和当前类所在的包的其他类以及子类访问。
5. public：类中被public修饰的能被当前项目下的所有类访问。

> 请说说你对反射的了解

1. 反射就是在程序运行期间动态的获取对象的属性和方法的功能叫做反射。它能够在程序运行期间，对于任意一个类，都能知道它所有的方法和属性，对于任意一个对象，都能知道他的属性和方法。
2.  获取Class对象的三种方式：`getClass()`;`xx.class`;`Class.forName("xxx")`; 
3. 反射的优缺点： 
   1. 优点：运行期间能够动态的获取类，提高代码的灵活性。
   2.  缺点：性能比直接的Java代码要慢很多。 应用场景：spring的xml配置模式，以及动态代理模式都用到了反射

> 请你说说多线程

1. 线程是程序执行的最小单元，一个进程可以拥有多个线程 
2. 各个线程之间共享程序的内存空间（代码段、数据段和堆空间）和系统分配的资源（CPU，I/O，打开的文件），但是各个线程拥有自己的栈空间
3. 多线程优点：减少程序响应时间；提高CPU利用率；创建和切换开销小；数据共享效率高；简化程序结构

> 说说线程的创建方式

创建线程有3种方式：

1. 继承Thread类，重写run()方法；
2. 实现Runnable接口，并实现该接口的run()方法；
3. 3.实现Callable接口，重写call()方法。
4. 前两种方式线程执行完后都没有返回值，最后一种带返回值；一般推荐实现Runnable接口的方式。

> 说说怎么保证线程安全

 		 线程安全问题是指在多线程背景下，线程没有按照我们的预期执行，导致操作共享变量出现异常。在Java中有许多同步方案提供给我们使用，从轻到重有三种方式：原子类、volatile关键字、锁。 

1. 原子类是juc atomic包下的一系列类，通过CAS比较与交换的机制实现线程安全的更新共享变量。通过预期值与内存值的比较来判断是否修改。
2. volatile关键字是轻量级的同步机制，他实现了变量的可见性、防止指令重排序。保证了【单个变量】读写的线程安全。可见性问题是JMM内存模型中定义每个核心存在一个内存副本导致的，核心只操作他们的内存副本，volatile保证了一旦修改变量则立即刷新到共享内存中，且其他核心的内存副本失效，需要重新读取。
3.  原子类和volatile只能保证单个共享变量的线程安全，锁则可以保证临界区内的多个共享变量线程安全。java中常用的锁有两种：synchronized+juc包下的lock锁。synchronized锁是互斥锁，可以作用于实例方法、静态方法、代码块，基于对象头和Monitor对象，在1.6之后引入轻量级锁、偏向锁等优化。lock锁接口可以通过lock、unlock方法锁住一段代码，基于AQS实现，其加锁解锁就是操作AQS的state变量，并且将阻塞队列存在AQS的双向队列中。除了锁以外，juc包下还提供了一些线程同步工具类，如CountDownLatch、Semaphore等等，我们还可以使用ThreadLocal定义线程局部变量！

> 说说Java中常用的锁及原理

对象头、AQS标准；Java中加锁有两种方式，分别是synchronized关键字和Lock接口，而Lock接口的经典实现是ReentrantLock

> 说说你对ThreadLocal的理解

1. ThreadLocal是线程变量，它将需要共享的数据复制多份，每个线程各一份。
2. 内部使用了一个ThreadLoadMap来存储信息，key是当前线程，而value是我们需要传输的数据，我们可以在线程执行的过程中通过get/set，操作map中的数据
3. 不过需要注意的是在使用线程池的时候，线程执行完毕不会被销毁，而是进入线程池中等待，这个时候我们需要手动释放一下map中的数据，以免造成内存浪费。

> 请说说你对Java集合的了解

1. java中的集合类主要都有Collection和Map这两个接口派生而出，其中Collection又派生出List,Set,Queue。
2. 所有的集合类都是List,set,queue,map这四个接口的实现类。
3. 其中，list代表有序的，可重复的数据集合；set代表无序的，不可重复的数据集合，queue代表先进先出的队列；map是具有映射关系的集合。
4. 最常用的实现类又ArrayList,LinkedList,HashMap,TreeMap,HashSet,TreeSet,ArrayQueue。

> 请你说说HashMap底层原理

1. 在1.8之前，HashMap的底层是数组加链表，在1.8之后是数组+链表+红黑树； 
2. 它的put流程是：基于哈希算法来确定元素位置，当我们向集合存入数据时，他会计算传入的key的哈希值，并利用哈希值取绝对值再根据集合长度取余来确定元素的位置，如果这个位置已经存在其他元素了，就会发生哈希碰撞，则hashmap就会通过链表将这些元素组织起来，如果链表的长度达到8时，就会转化为红黑树，从而提高查询速度。 
3. 扩容机制：HashMap中数组的默认初始容量为16，当达到默认负载因子0.75时，会以2的指数倍进行扩容。 Hashmap时非线程安全的，在多线程环境下回产生循环死链，因此在多线程环境下建议使用ConcurrentHashMap。

> 请你说说ConcurrentHashMap

ConcurrentHashMap 在 JDK 1.7 时使用的是数据加链表的形式实现的，其中数组分为两类：大数组 Segment 和小数组 HashEntry，而加锁是通过给 Segment 添加 ReentrantLock 锁来实现线程安全的。而 JDK 1.8 中 ConcurrentHashMap 使用的是数组+链表/红黑树的方式实现的，它是通过 `CAS` 或 `synchronized `来实现线程安全的，并且它的锁粒度更小，查询性能也更高





# 框架

## springboot

> **@SpringBootApplication**

1. 首先启动类使用了`@SpringBootApplication`注解，这个复合注解包括了`@EnableAutoConfiguration` `@SpringBootConfiguration`和`@ComponentScan`三个注解
2. `@SpringBootConfiguration`是标注当前类是一个**配置类**并**注入**到IOC**容器**中
3. `@ComponentScan`是扫描指定路径下带有特定注解的类到IOC容器中。
4. 最为重要的是`@EnableAutoConfiguration`，它能通过`ImportSelector选择器`将所有带有@Configuration自动导入到容器里。

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

1. 注解完成后，通过运行SpringApplication的run方法完成`服务构建`、`环境准备`、`容器创建`、`填充容器`四项工作。

2. `服务构建`需要在SpringApplication的构造器中完成

   ①加载资源加载器、主方法类到内存中

   ②判定web应用类型是否存在并默认为servlet

   ③确定web服务器后就要加载初始化类了，这里是通过META-INFO/`spring.factories`来读取**启动注册初始化器**、**应用上下文初始化器**、**应用监听器**三类配置，当然，这里也可以对自定义三类配置

   ④通过运行时栈判断main方法所在的类是否为主启动类

3. 调用run方法进入`环境准备阶段`，主要是对容器和组件做一些前置操作。

   ①先创建一个启动上下文。并逐一调用刚刚加载的**启动注册初始化器的一个初始化方法	**

   ②接下来设置**awt.headLess=true**表示缺少显示器、键盘等设备也可正常启动	

   ③**启动运行监听器**，同时发布启动事件，获取并加载spring.factories中的事件发布运行监听器，并且会将应用监听器也一并引入，以后想要在启动流程过程中加入自定义逻辑就只需要监听这些事件	

   ④**通过prepareEnvironment方法组装启动参数**，根据不同的web构造不同的环境。构造完毕后会加载环境变量、jvm系统属性到属性集合中，后期无需加载。此时可设置启动参数并添加configuration.properties到属性集合中。接下来会发布环境准备完成的事件，一些监听器收到信号会做相应处理。

   ⑤可做**忽略元数据加载**、**打印banner**的操作。

4. 环境准备好以后，就可以`创建容器`了。

   ①首先创建注解配置servlet容器，具体行为是创建beanfactory、用来解析一些注解的后置处理器和其他属性对象 

   ②调用prepareContext方法对容器中的属性进行初始化
5. 容器创建完毕后，就会对`容器做初始化`操作。这里会

      ①创建系统自带的Bean和用户自定义Bean并装配到容器里，通过启动tomcat和经历Bean的生命周期就可以使用一个完整的Bean了	

      ②发布启动事件完成的同时，会回调自定义Runner接口来处理定制化需求
          作者：仲夏七月梦 https://www.bilibili.com/read/cv22717345?spm_id_from=333.999.0.0 出处：bilibili

---

## spring

### Bean

> bean的生命周期

1. 生产
   - 扫描bean，用xml，注解扫描等方式找到Bean，存入beanDefinitionMap（Bean定义集合）中
   - 遍历Bean定义集合，创建bean，createBean()
     - **构造对象**，createBeanInstance （），用反射机制获取Bean的Class类的**构造器**，加载方法参数，实例化出一个Bean
     - **属性填充**，为Bean内部所需的属性进行赋值填充
     - **初始化实例**，initializeBean（）
     - **注册销毁**
   - 放入**单例池**
2. 使用
3. 销毁
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





---

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
- [总结](https://blog.csdn.net/weixin_44420511/article/details/125185404#_184)

---

ioc容器的启动主要在refresh（）实现

1. `准备容器`，如设置启动时间，一些状态位

2. `创建容器`，**实例化DefaultListaleBeanFactory对象**，解析Bean到成员变量beanDefinitionMap，beanDefinitionNames；

3. `准备Bean工厂`，这是一些BeanFactory的一些属性

4. Spring提供**PostProcessBeanFactory（）**方法给我们扩展，可以**注册**一些特殊的**后置处理器**

5. 执行BeanFactoryPostProcessor，回调

6. `国际化处理`

7. `初始化监听器`

8. `实例化Bean`，Bean的生命周期在这里开始

   ```properties
   1.获取之前解析的Bean名称集合
   2.挨个调用getBean（beanName）
   3.反射创建Bean
   4.属性填充
   5.初始化Bean
   ```

   

9. `完成上下文的刷新工作`

> IOC （控制反转）与 DI（依赖注入）

IOC

一种设计思想，将原本我们手动创建对象的**控制权**交给spring，spring来管理Bean的生命周期。传统程序，高度**耦合**

DI

应用程序在运行时依赖IOC容器来动态注入组件所需的某个依赖。Spring的DI具体就是通过反射实现注入的。

我们只需要通过简单的配置，就获取需要的资源







### AOP

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

>说说你对MVC的理解

MVC是一种设计模式，将软件分为三层，分别是模型层，视图层，控制器层。其中模型层代表的是数据，视图层代表的是界面，控制器层代表的是逻辑处理，是连接视图与模型之前的桥梁。降低耦合，便于代码的维护

## MyBatis

> 在MyBatis中$和#有什么区别

`$` MyBatis会创建普通的SQL语句,然后在执行SQL 语句时将参数拼入SQL

`#`MyBatis会创建预编译的SQL语句,然后在执行SQL时MyBatis会为预编译SQL中的占位符赋值。预编译的SQL语句执行效率高,并且可以防止注入攻击,效率和安全性都大大优于前者

```mysql
# 会转换成字符串
select * from user where id=#{}
```

