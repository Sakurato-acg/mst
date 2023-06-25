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

1. `prepareRedresh()`:

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

# 数据库

> 谈谈你对SQL注入的理解

SQL注入的原理是`将SQL代码伪装到输入参数`中，传递到服务器解析并执行的一种攻击手法。

也就是说，在一些对SERVER端发起的请求参数中植入一些SQL代码，SERVER端在执行SQL操作时，会拼接对应参数，同时也将一些SQL注入攻击的“SQL”拼接起来，导致会执行一些预期之外的操作。

> 请你说说MySQL索引,以及它们的好处和坏处

- MySQL索引是一种帮助快速查找数据的数据结构，可以把它理解为书的目录，通过索引能够快速找到数据所在位置。
- 场景的索引数据结构有：`Hash表`（通过hash算法快速定位数据，但不适合范围查询，因为需要每个key都进行一次hash）、`二叉树`（查找和修改效率都比较高）
- 但是在InnoDB引擎中使用的索引是`B+Tree`，相较于二叉树，B+Tree这种多叉树，更加矮宽，更适合存储在磁盘中。使用索引增加了数据查找的效率，但是相对的由于索引也需要存储到磁盘，所以增加了存储的压力，并且新增数据时需要同步维护索引。但是合理的使用索引能够极大提高我们的效率！

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

> 请你介绍一下数据库的ACID

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
