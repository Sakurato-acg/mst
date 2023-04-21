# SSM 尚硅谷

## Mybatis

### mybatis-config.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--类型别名 对应Mapper.xml的resultType-->
    <typeAliases>
        <package name="com.atguigu.mybatis.pojo"/>
    </typeAliases>

    <settings>
    <!--将下划线映射为驼峰-->
    <setting name="mapUnderscoreToCamelCase" value="true"/>
    </settings>

    <plugins>
        <!--设置分页插件-->
        <plugin interceptor="com.github.pagehelper.PageInterceptor"></plugin>
    </plugins>
    <!---
    environments：配置数据库连接环境信息。可以配置多个environment，通过default属性切换不同的environment
    -->
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!--数据库连接信息-->
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url"
                          value="jdbc:mysql://localhost:3306/anime_library?characterEncoding=utf8&amp;useSSL=false&amp;serverTimezone=UTC&amp;rewriteBatchedStatements=true"/>
                <property name="username" value="2120400146"/>
                <property name="password" value="210019"/>
            </dataSource>
        </environment>

    </environments>


    <mappers>
        <package name="com.atguigu.mybatis.mapper"/>
    </mappers>


</configuration>
```

### pom.xml

```xml
/mybatis/
<dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.5</version>
</dependency>
/mysql/
<dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.23</version>
</dependency>
/fastjson/
<dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.58</version>
</dependency>
/日志/
<dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
</dependency>
/测试/
<dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
            <scope>test</scope>
</dependency>
```

### log4j.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "log4j.dtd">

<log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">

    <appender name="STDOUT" class="org.apache.log4j.ConsoleAppender">
        <param name="Encoding" value="UTF-8" />
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%-5p %d{MM-dd HH:mm:ss,SSS} %m  (%F:%L) \n" />
        </layout>
    </appender>
    <logger name="java.sql">
        <level value="debug" />
    </logger>
    <logger name="org.apache.ibatis">
        <level value="info" />
    </logger>
    <root>
        <level value="debug" />
        <appender-ref ref="STDOUT" />
    </root>
</log4j:configuration>
```

### SqlSessionFactoryUtils

```java
package com.atguigu.mybatis.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        //静态代码块会随着类的加载而自动执行，且只执行一次

        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}

```

---

### 分页插件

#### 配置

```xml
/分页插件/
<dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>5.2.0</version>
</dependency>
<plugins>
<!--mybatis-config.xml设置分页插件-->
<plugin interceptor="com.github.pagehelper.PageInterceptor"></plugin>
</plugins>
```

#### _使用_

```javascript
 SqlSession sqlSession = SqlSessionUtil.getSqlSession();
 EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
 //查询功能之前开启分页功能
 Page<Object> page = PageHelper.startPage(5, 4);
 List<Emp> list = mapper.selectByExample(null);
 //查询功能之后可以获取分页相关的所有数据
 PageInfo<Emp> pageInfo = new PageInfo<>(list, 5);
 list.forEach(System.out::println);
 System.out.println(pageInfo)
```

---

### MyBatis 的逆向工程

#### mybatis-config.xml

```xml
<!-- 控制Maven在构建过程中相关配置 -->
<build>
    <!-- 构建过程中用到的插件 -->
    <plugins>
        <!-- 具体插件，逆向工程的操作是以构建过程中插件形式出现的 -->
        <plugin>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-maven-plugin</artifactId>
            <version>1.3.0</version>
            <!-- 插件的依赖 -->
            <dependencies>
                <!-- 逆向工程的核心依赖 -->
                <dependency>
                    <groupId>org.mybatis.generator</groupId>
                    <artifactId>mybatis-generator-core</artifactId>
                    <version>1.3.2</version>
                </dependency>
                <!-- MySQL驱动 -->
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>8.0.16</version>
                </dependency>
            </dependencies>
            <!--设置分页插件-->
        </plugin>
    </plugins>
</build>
```

#### generatorConfig.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
<generatorConfiguration>
    <!--
            targetRuntime: 执行生成的逆向工程的版本
                    MyBatis3Simple: 生成基本的CRUD（清新简洁版）
                    MyBatis3: 生成带条件的CRUD（奢华尊享版）
     -->
    <context id="DB2Tables" targetRuntime="MyBatis3">
        <!-- 数据库的连接信息 -->
        <jdbcConnection driverClass="com.mysql.cj.jdbc.Driver"
                        connectionURL="jdbc:mysql://localhost:3306/anime_library?characterEncoding=utf8&amp;useSSL=false&amp;serverTimezone=UTC&amp;rewriteBatchedStatements=true&amp;nullCatalogMeansCurrent=true"
                        userId="2120400146"
                        password="210019">
        </jdbcConnection>
        <!-- javaBean的生成策略-->
        <javaModelGenerator targetPackage="com.atguigu.mybatis.pojo" targetProject=".\src\main\java">
            <property name="enableSubPackages" value="true" />
            <property name="trimStrings" value="true" />
        </javaModelGenerator>
        <!-- SQL映射文件的生成策略 -->
        <sqlMapGenerator targetPackage="com.atguigu.mybatis.mapper"  targetProject=".\src\main\resources">
            <property name="enableSubPackages" value="true" />
        </sqlMapGenerator>
        <!-- Mapper接口的生成策略 -->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.atguigu.mybatis.mapper"  targetProject=".\src\main\java">
            <property name="enableSubPackages" value="true" />
        </javaClientGenerator>
        <!-- 逆向分析的表 -->
        <!-- tableName设置为*号，可以对应所有表，此时不写domainObjectName -->
        <!-- domainObjectName属性指定生成出来的实体类的类名 -->
        <table tableName="bangumi" domainObjectName="Bangumi"/>
        <table tableName="user" domainObjectName="User"/>
<!--        <table tableName="*"></table>-->
    </context>
</generatorConfiguration>
```

#### 使用

```css
1. 会生成User.java 和 UserExample.java(条件查询)
2. 添加条件
   BangumiExample bangumiExample = new BangumiExample();
   bangumiExample.createCriteria().andYearGreaterThanOrEqualTo(2022);
```

---

### CRUD

#### Mapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="com.lpl.mapper.BangumiMapper">
</mapper>
```

#### select

```xml
<select id="selectByCondition" resultType="Bangumi">
        select `id`, `name`, `type`, `time`, `status`, `year`, `picture`, `userId`
        from anime_library.bangumi
        <where>
            <if test="anime.name!='' and anime.name!=null">
                and name like #{anime.name}
            </if>
            <if test="anime.type!=0">
                and type=#{anime.type}
            </if>
            <if test="anime.time!=0">
                and time=#{anime.time}
            </if>
            <if test="anime.status!=0">
                and status=#{anime.status}
            </if>
            <if test="anime.year!=0 and anime.year>=2010">
                and year=#{anime.year}
            </if>
            <if test="anime.year!=0 and anime.year&lt;2010">
                and year &lt;#{anime.year}
            </if>
            <if test="anime.userId!=0">
                and userId=#{anime.userId}
            </if>
        </where>
        order by id desc
        limit #{start},#{count};
</select>
```

#### insert

```java
@Update("insert into bangumi(name, type, time, status, year, picture, userId) VALUES (#{anime.name},#{anime.type},#{anime.time},#{anime.status},#{anime.year},#{anime.picture},#{anime.userId})")
void addBangumi(@Param("anime") Bangumi anime);
```

#### update

```java
@Update("update anime_library.bangumi set `name`=#{anime.name}, type=#{anime.type} , time=#{anime.time} , `status`=#{anime.status} , `year`=#{anime.year} , picture=#{anime.picture}  where id=#{anime.id}")
void update(@Param("anime") Bangumi anime);
```

#### delete

```xml
<delete id="deleteByIds">
        delete from anime_library.bangumi where id
        in
        <foreach collection="ids" item="id" separator="," open="(" close=")">
            #{id}
        </foreach>
</delete>
```

---

### resultMap

#### 基本使用

```xml
<resultMap id="userMap" type="User">
<id property="id" column="id"></id>
<result property="userName" column="user_name"></result>
<result property="password" column="password"></result>
<result property="age" column="age"></result>
<result property="sex" column="sex"></result>
</resultMap>
```

#### 多对一的映射关系(association)

```xml
<!--多个员工对应一个部门-->
User类{
...
Dept dept
}_
<!--实现-->
<resultMap id="empDeptMap" type="Emp">
	<id column="eid" property="eid"></id>
	<result column="ename" property="ename"></result>
	<result column="age" property="age"></result>
	<result column="sex" property="sex"></result>
	<association property="dept" javaType="Dept">
		<id column="did" property="did"></id>
		<result column="dname" property="dname"></result>
	</association>
</resultMap>
<select id="getEmpAndDeptByEid" resultMap="empDeptMap">
	select emp.*,dept.* from t_emp emp left join t_dept dept on emp.did =
	dept.did where emp.eid = #{eid}
</select>

<!--分步查询-->
<resultMap id="empDeptStepMap" type="Emp">
	<id column="eid" property="eid"></id>
	<result column="ename" property="ename"></result>
	<result column="age" property="age"></result>
	<result column="sex" property="sex"></result>
	<!--
	select：设置分步查询，查询某个属性的值的sql的标识（namespace.sqlId）
	column：将sql以及查询结果中的某个字段设置为分步查询的条件
	-->
	<association property="dept"
			    select="com.atguigu.MyBatis.mapper.DeptMapper.StepTwo"
                 column="did">
	</association>
</resultMap>
	<!--Emp getEmpByStep(@Param("eid") int eid);-->
	<select id="StepOne" resultMap="empDeptStepMap">
	select * from t_emp where eid = #{eid}
	</select>

	<!--Dept getEmpDeptByStep(@Param("did") int did);-->
	<select id="StepTwo" resultType="Dept">
	select * from t_dept where did = #{did}
	</select>
```

#### 延迟加载(Mybatis-config.xml)

```xml
<settings>
    <!--开启延迟加载-->
    <setting name="lazyLoadingEnabled" value="true"/>
    <!--按需加载-->
    <setting name="aggressiveLazyLoding" value="true"/>
</settings>
```

#### 一对多 [ collection ]

```xml
<!--一个部门对应多个员工-->
List<Emp> emps

<!--实现-->
<resultMap id="deptEmpMap" type="Dept">
	<id property="did" column="did"></id>
	<result property="dname" column="dname"></result>
	<!--
	ofType：设置collection标签所处理的集合属性中存储数据的类型
	-->
	<collection property="emps" ofType="Emp">
		<id property="eid" column="eid"></id>
		<result property="ename" column="ename"></result>
		<result property="age" column="age"></result>
		<result property="sex" column="sex"></result>
	</collection>
</resultMap>
<!--分步查询-->
    <collection property="emps"
                fetchType="......Mapper.get"
                column="did"
	</collection>
```

---

## Sping

### IOC

#### 简介

BeanFactory --> ApplicationContext --> ConfigurableApplicationContext --> ClassPathXmlApplicationContext

| 类型名                          | 简介                                                         |
| :------------------------------ | ------------------------------------------------------------ |
| ClassPathXmlApplicationContext  | 通过读取类路径下的 XML 格式的配置文件创建 IOC 容器对象       |
| FileSystemXmlApplicationContext | 通过文件系统路径读取 XML 格式的配置文件创建 IOC 容器对象     |
| ConfigurableApplicationContext  | ApplicationContext 的子接口，包含一些扩展方法refresh() 和 close() ，让 ApplicationContext 具有启动、refresh() 和 close() ，让 ApplicationContext 具有启动、 |
| WebApplicationContext           | 基于 Web 环境创建 IOC 容器对象，并将对象引入存入 ServletContext 域中。 |

---
#### Xml

##### 配置

```xml
<dependencies>
<!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>5.3.1</version>
	</dependency>	
<!-- junit测试 -->
	<dependency>
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
 		<version>4.12</version>
		<scope>test</scope>
	</dependency>
</dependencies>

<!--Spring-config.xml-->
<bean id="helloWord" class="com.atguigu.spring.bean.HelloWorld"></bean>

```

##### 使用案例

```java
@Test
public void testHelloWorld(){
 ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
 HelloWorld helloworld = (HelloWorld) ac.getBean("helloworld"); 
 helloworld.sayHello();
}
```

##### 获取bean

- ioc.getBean ( HelloWorld.class )；

- ioc.getBean ( "helloworld"， HelloWorld.class)；

- ioc.getBean ( "id值" )；

##### Bean 赋值

 ```xml
 <bean id="studentOne" class="com.atguigu.spring.bean.Student">
 	<property name="id" value="1001"></property>
 	<property name="name" value="张三"></property>
 	<property name="age" value="23"></property>
 	<property name="sex" value="男"></property>
 </bean>
 ```
###### 类类型

```xml
<!--方式1
-->
<bean id="clazzOne" class="com.atguigu.spring.bean.Clazz">
	<property name="clazzId" value="1111"></property>
	<property name="clazzName" value="财源滚滚班"></property>
</bean>

<bean id="studentFour" class="com.atguigu.spring.bean.Student">
	<property name="id" value="1004"></property>
	<property name="name" value="赵六"></property>
	<property name="age" value="26"></property>
	<property name="sex" value="女"></property>
	<!-- ref属性：引用IOC容器中某个bean的id，将所对应的bean为属性赋值 -->
	<property name="clazz" ref="clazzOne"></property>
</bean>

<!--方式2-->
<bean id="studentFour" class="com.atguigu.spring.bean.Student">
	<property name="id" value="1004"></property>
	<property name="name" value="赵六"></property>
	<property name="age" value="26"></property>
	<property name="sex" value="女"></property>
	<property name="clazz">
	<!-- 在一个bean中再声明一个bean就是内部bean -->
	<!-- 内部bean只能用于给属性赋值，不能在外部通过IOC容器获取，因此可以省略id属性 -->
		<bean id="clazzInner" class="com.atguigu.spring.bean.Clazz">
			<property name="clazzId" value="2222"></property>
			<property name="clazzName" value="远大前程班"></property>
		</bean>
	</property>
</bean>
```

###### 数组

```xml
<bean id="studentFour" class="com.atguigu.spring.bean.Student">
	<property name="id" value="1004"></property>
	<property name="name" value="赵六"></property>
	<property name="age" value="26"></property>
	<property name="sex" value="女"></property>
	<!-- ref属性：引用IOC容器中某个bean的id，将所对应的bean为属性赋值 -->
	<property name="clazz" ref="clazzOne"></property>
	<property name="hobbies">
		<array>
			<value>抽烟</value>
			<value>喝酒</value>
			<value>烫头</value>
		</array>
	</property>
</bean>
```

###### 集合

```xml
<bean id="clazzTwo" class="com.atguigu.spring.bean.Clazz">
	<property name="clazzId" value="4444"></property>
	<property name="clazzName" value="Javaee0222"></property>
	<property name="students">
		<list>
			<ref bean="studentOne"></ref>
			<ref bean="studentTwo"></ref>
			<ref bean="studentThree"></ref>
		</list>
	</property>
</bean>

<!--list集合类型的bean-->
<util:list id="students">
	<ref bean="studentOne"></ref>
	<ref bean="studentTwo"></ref>
	<ref bean="studentThree"></ref>
</util:list>
<!--map集合类型的bean-->
<util:map id="teacherMap">
	<entry>
		<key>
			<value>10010</value>
		</key>
		<ref bean="teacherOne"></ref>
	</entry>
	<entry>
		<key>	
			<value>10086</value>
		</key>
		<ref bean="teacherTwo"></ref>
	</entry>
</util:map>
<!---->
<bean id="clazzTwo" class="com.atguigu.spring.bean.Clazz">
<property name="students" ref="students"></property>
</bean>
<!---->
<bean id="studentFour" class="com.atguigu.spring.bean.Student">
	<property name="id" value="1004"></property>
	<property name="name" value="赵六"></property>	
	<property name="teacherMap" ref="teacherMap"></property>
</bean>
```

##### 引入外部属性文件

- 依赖

  ```xml
  <!-- MySQL驱动 -->
  <dependency>
  	<groupId>mysql</groupId>
  	<artifactId>mysql-connector-java</artifactId>
  	<version>8.0.16</version>
  </dependency>
  <!-- 数据源 -->
  <dependency>
  	<groupId>com.alibaba</groupId>
  	<artifactId>druid</artifactId>
  	<version>1.0.31</version>
  </dependency>
  ```

  - jdbc.properties

  ```properties
  jdbc.user=root
  jdbc.password=atguigu
  jdbc.url=jdbc:mysql://localhost:3306/ssm?serverTimezone=UTC
  jdbc.driver=com.mysql.cj.jdbc.Driver
  ```

  - 配置Bean
  
  ```xml
  <!-- 引入外部属性文件 -->
  <context:property-placeholder location="classpath:jdbc.properties"/>
  
  <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
  	<property name="url" value="${jdbc.url}"/>
  	<property name="driverClassName" value="${jdbc.driver}"/>
  	<property name="username" value="${jdbc.user}"/>
  	<property name="password" value="${jdbc.password}"/>
  </bean>
  ```
  
 ##### bean的作用域

  - singleton 单例
  - protocol   多例

  <bean scope="singleton"/>

##### FactoryBean

将来我们整合Mybatis时，Spring就是通过FactoryBean机制来帮我们创建SqlSessionFactory对象的。

```java
public class UserFactoryBean implements FactoryBean<User> {
	@Override
	public User getObject() throws Exception {
		return new User();
	}
	@Override
	public Class<?> getObjectType() {
		return User.class;
	}

<bean id="user" class="com.atguigu.bean.UserFactoryBean"></bean>

@Test
public void testUserFactoryBean(){
//获取IOC容器
	ApplicationContext ac = new ClassPathXmlApplicationContext("springfactorybean.xml");
	User user = (User) ac.getBean("user");
	System.out.println(user);
}
```

##### **基于**xml的自动装配

```xml
<!--获取对象，成员变量-->
<bean id="userController"
	  class="com.atguigu.autowire.xml.controller.UserController" 
      autowire="byType">
</bean>

<bean id="userService"
      class="com.atguigu.autowire.xml.service.impl.UserServiceImpl" 
      autowire="byType">
</bean>

<bean id="userDao" 
      class="com.atguigu.autowire.xml.dao.impl.UserDaoImpl">
</bean>
```

---

#### 注解

##### 配置

```xml
<dependencies>
<!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>5.3.1</version>
	</dependency>
<!-- junit测试 -->
	<dependency>
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
		<version>4.12</version>
		<scope>test</scope>
	</dependency>
</dependencies>
<!--spring配置文件-->
<context:component-scan base-package="com.atguigu">
	<context:exclude-filter type="annotation"
                            expression="org.springframework.stereotype.Controller"/>
	<context:exclude-filter type="assignable"	
                             expression="com.atguigu.controller.UserController"/>
</context:component-scan>


```

##### 注解

- @Component，@Controller，@Service，@Repository
- @Autowired

---

### AOP

#### 配置

```xml
<!--ioc 配置基础上 -->
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-aspects</artifactId>
	<version>5.3.1</version>
</dependency>

接口与实现类

<aop:aspectj-autoproxy />
```

#### 切面类

```java
// @Aspect表示这个类是一个切面类
@Aspect
// @Component注解保证这个切面类能够放入IOC容器
@Component
public class LogAspect {
    
    @Pointcut("execution(* com.atguigu.aop.annotation.*.*(..))")
	public void pointCut(){}
    
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect，方法："+signature.getName()+
                           "，参数："+ Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法："+signature.getName()+"，执行完毕");
    }

   
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法："+signature.getName()+"，结果："+result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex){
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法："+signature.getName()+"，异常："+ex);
    }

    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知-->前置通知");
            //表示目标对象方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->异常通知");
        } finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }

}
```

---

### 声明式事务

#### 配置

```xml
<dependencies>
<!-- 基于Maven依赖传递性，导入spring-context依赖即可导入当前所需所有jar包 -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>5.3.1</version>
	</dependency>
<!-- Spring 持久化层支持jar包 -->
<!-- Spring 在执行持久化层操作、与持久化层技术进行整合过程中，需要使用orm、jdbc、tx三个
jar包 -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-orm</artifactId>
		<version>5.3.1</version>
	</dependency>
<!-- Spring 测试相关 -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-test</artifactId>
		<version>5.3.1</version>
	</dependency>
<!-- junit测试 -->
	<dependency>
		<groupId>junit</groupId>
		<artifactId>junit</artifactId>
		<version>4.12</version>
		<scope>test</scope>
	</dependency>
<!-- MySQL驱动 -->
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
		<version>8.0.16</version>
	</dependency>
<!-- 数据源 -->
	<dependency>
		<groupId>com.alibaba</groupId>
		<artifactId>druid</artifactId>
		<version>1.0.31</version>
	</dependency>
</dependencies>
```

```properties
jdbc.user=root
jdbc.password=atguigu
jdbc.url=jdbc:mysql://localhost:3306/ssm
jdbc.driver=com.mysql.cj.jdbc.Driver
```

```xml
<!-- 导入外部属性文件 -->
<context:property-placeholder location="classpath:jdbc.properties" />
<!-- 配置数据源 -->
<bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
	<property name="url" value="${atguigu.url}"/>
	<property name="driverClassName" value="${atguigu.driver}"/>
	<property name="username" value="${atguigu.username}"/>
	<property name="password" value="${atguigu.password}"/>
</bean>
<!--事务配置-->
<bean id="transactionManager"
      class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
      <property name="dataSource" ref="dataSource"></property>
</bean>

<tx:annotation-driven transaction-manager="transactionManager" />
```

#### 测试

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JDBCTemplateTest {
	@Autowired
	private JdbcTemplate jdbcTemplate;
    
    @Test
	//测试增删改功能	
	public void testUpdate(){
		String sql = "insert into t_emp values(null,?,?,?)";
		int result = jdbcTemplate.update(sql, "张三", 23, "男");
		System.out.println(result);
	}
}

```

#### **@Transactional**

```java
@Transactional
(
    readOnly= true
    timeout = 3
    noRollbackFor = ArithmeticException.class
)
@Transactional(isolation = Isolation.DEFAULT)//使用数据库默认的隔离级别
@Transactional(isolation = Isolation.READ_UNCOMMITTED)//读未提交
@Transactional(isolation = Isolation.READ_COMMITTED)//读已提交
@Transactional(isolation = Isolation.REPEATABLE_READ)//可重复读
@Transactional(isolation = Isolation.SERIALIZABLE)//串行化

@Transactional(propagation = Propagation.REQUIRED)//一起回滚
@Transactional(propagation = Propagation.REQUIRES_NEW)//
```

## SpingMvc

### 配置

```xml
<dependencies>
	<!-- SpringMVC -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-webmvc</artifactId>
		<version>5.3.1</version>
	</dependency>
	<!-- 日志 -->
	<dependency>
		<groupId>ch.qos.logback</groupId>
		<artifactId>logback-classic</artifactId>
		<version>1.2.3</version>
</dependency>
<!-- ServletAPI -->
<dependency>
<groupId>javax.servlet</groupId>
<artifactId>javax.servlet-api</artifactId>
<version>3.1.0</version>
<scope>provided</scope>
</dependency>
<!-- Spring5和Thymeleaf整合包 -->
<dependency>
<groupId>org.thymeleaf</groupId>
<artifactId>thymeleaf-spring5</artifactId>
<version>3.0.12.RELEASE</version>
</dependency>
</dependencies>
```



```xml
<!-- 配置SpringMVC的前端控制器，对浏览器发送的请求统一进行处理 -->
<servlet>
	<servlet-name>springMVC</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servletclass>
    <init-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>classpath:springMVC.xml</param-value>
	</init-param>
	<load-on-startup>1</load-on-startup>
</servlet>

<servlet-mapping>
	<servlet-name>springMVC</servlet-name>
	<url-pattern>/</url-pattern>
</servlet-mapping>
```

```xml
<context:component-scan base-package="com.atguigu.mvc.controller"/>
<!-- 配置Thymeleaf视图解析器 -->
<bean id="viewResolver"
      class="org.thymeleaf.spring5.view.ThymeleafViewResolver">
	<property name="order" value="1"/>
	<property name="characterEncoding" value="UTF-8"/>
	<property name="templateEngine">
		<bean class="org.thymeleaf.spring5.SpringTemplateEngine">
			<property name="templateResolver">
				<bean
			class="org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver">
					<!-- 视图前缀 -->
					<property name="prefix" value="/WEB-INF/templates/"/>
					<!-- 视图后缀 -->
					<property name="suffix" value=".html"/>
					<property name="templateMode" value="HTML5"/>
					<property name="characterEncoding" value="UTF-8" />
				</bean>	
			</property>
		</bean>
	</property>
</bean>


<mvc:default-servlet-handler/>
<!-- 开启mvc注解驱动 -->
<mvc:annotation-driven>
	<mvc:message-converters>
    <!-- 处理响应中文内容乱码 -->
	<bean
		class="org.springframework.http.converter.StringHttpMessageConverter">
		<property name="defaultCharset" value="UTF-8" />
		<property name="supportedMediaTypes">
			<list>
				<value>text/html</value>
				<value>application/json</value>
			</list>
		</property>
	</bean>
	</mvc:message-converters>
</mvc:annotation-driven>
```

### **@RequestMapping**

```java
@RequestMapping(
	value = {"/testRequestMapping", "/test"}
	,method = {RequestMethod.GET, RequestMethod.POST}
	,params = {"username","password!=123456"}
)
public String testRequestMapping(){
	return "success";
}
```

- @GetMapping
- @PostMapping
- @PutMapping
- @DeleteMapping

#### ant 风格

```properties
？:表示任意的单个字符
*:表示任意的0个或多个字符
**:表示任意层数的任意目录
注意:在使用**时，只能使用/**/xxx的方式
```

#### rest

原始方式：/deleteUser?id=1

rest方式：/user/delete/1

```java
@RequestMapping("/testRest/{id}/{username}")
public String testRest(
    @PathVariable("id") String id,
    @PathVariable("username")String username
	){
	System.out.println("id:"+id+",username:"+username);
	return "success";
}
```

### 获取参数

```java
<a th:href="@{/testParam(username='admin',password=123456)}"></a>
    
@RequestMapping("/testParam")
public String testParam(String username, String password){
	System.out.println("username:"+username+",password:"+password);
	return "success";
}
```

#### @RequestParam ，@@RequestHeader ,@CookieValue

value：指定为形参赋值的请求参数的参数名

required：设置是否必须传输此请求参数，默认值为true

若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，且没有设置

defaultValue属性，则页面报错400：Required String parameter 'xxx' is not present；若设置为

false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为

null

defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值

为""时，则使用默认值为形参赋值

```java
 @RequestMapping("/param")
    public String getParam(
            @RequestParam(value = "userName", required = true, defaultValue = "hello")                   String username,
            String password,
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jsessionId
    ){
```

#### 乱码

```xml
<!--配置springMVC的编码过滤器-->
<filter>
	<filter-name>CharacterEncodingFilter</filter-name>
	<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
	<init-param>
		<param-name>encoding</param-name>
		<param-value>UTF-8</param-value>
	</init-param>
	<init-param>	
		<param-name>forceEncoding</param-name>
		<param-value>true</param-value>
	</init-param>
</filter>

<filter-mapping>
	<filter-name>CharacterEncodingFilter</filter-name>
	<url-pattern>/*</url-pattern>
</filter-mapping>
```

### 域共享数据

#### request

```java
/*ModelAndView*/
ModelAndViewModelAndView mav = new ModelAndView();
	//向请求域共享数据
	mav.addObject("testScope", "hello,ModelAndView");
	//设置视图，实现页面跳转
	mav.setViewName("success");
return mav;

/*Model*/
@RequestMapping("/testModel")
public String testModel(Model model){
	model.addAttribute("testScope", "hello,Model");
	return "success";
}
```

#### session

```java
@RequestMapping("/testSession")
public String testSession(HttpSession session){
	session.setAttribute("testSessionScope", "hello,session");
	return "success";
}
```

#### application

```java
@RequestMapping("/testApplication")
public String testApplication(HttpSession session){
	ServletContext application = session.getServletContext();
	application.setAttribute("testApplicationScope", "hello,application");
	return "success";
}
```

### 视图

#### 转发

```java
@RequestMapping("/testForward")
public String testForward(){
	return "forward:/testHello";
}
```

#### 重定向

```java
@RequestMapping("/testRedirect")
public String testRedirect(){
	return "redirect:/testHello";
}
```

#### 视图控制器

```xml
<!--
path：设置处理的请求地址
view-name：设置请求地址所对应的视图名称
-->
<mvc:view-controller path="/testView" view-name="success"></mvc:view-controller>
<mvc:annotation-driven />
```

### RestFul

原始方式：/deleteUser?id=1

rest方式：/user/delete/1

配合 get / put / post / delete 使用

### axios

#### 配置

```xml
<dependency>
	<groupId>com.fasterxml.jackson.core</groupId>
	<artifactId>jackson-databind</artifactId>
	<version>2.12.1</version>
</dependency>
```

```xml
<!--开启mvc的注解驱动-->
<mvc:annotation-driven />
```

#### 实现

###### @RequestBody

```java
//将json格式的数据转换为实体类对象
@RequestMapping("/test/RequestBody/json")
public void testRequestBody(@RequestBody User user){
	System.out.println(user);
}
```

###### @ResponseBody

```java
@RequestMapping("/testResponseBody")
@ResponseBody
public String testResponseBody(){
	//此时响应浏览器数据json
	return user;
}
```

###### **@RestController**

---

### **文件上传和下载**

#### 下载

```java
@RequestMapping("/testDown")
public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws
IOException {
	//获取ServletContext对象
	ServletContext servletContext = session.getServletContext();
	//获取服务器中文件的真实路径
	String realPath = servletContext.getRealPath("/static/img/1.jpg");
	//创建输入流
	InputStream is = new FileInputStream(realPath);
	//创建字节数组
	byte[] bytes = new byte[is.available()];	
	//将流读到字节数组中
	is.read(bytes);
	//创建HttpHeaders对象设置响应头信息
	MultiValueMap<String, String> headers = new HttpHeaders();
	//设置要下载方式以及下载文件的名字
	headers.add("Content-Disposition", "attachment;filename=1.jpg");
	//设置响应状态码
	HttpStatus statusCode = HttpStatus.OK;
	//创建ResponseEntity对象
	ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
	statusCode);
	//关闭输入流
	is.close();
	return responseEntity;
}
```

#### 上传

```xml
<dependency>
	<groupId>commons-fileupload</groupId>
	<artifactId>commons-fileupload</artifactId>
	<version>1.3.1</version>
</dependency>

<!--必须通过文件解析器的解析才能将文件转换为MultipartFile对象-->
<bean id="multipartResolver"
class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
</bean>
```

```java
@RequestMapping("/testUp")
public String testUp(MultipartFile photo, HttpSession session) throws
IOException {
	//获取上传的文件的文件名
	String fileName = photo.getOriginalFilename();
	//处理文件重名问题
	String hzName = fileName.substring(fileName.lastIndexOf("."));
	fileName = UUID.randomUUID().toString() + hzName;
	//获取服务器中photo目录的路径
	ServletContext servletContext = session.getServletContext();
	String photoPath = servletContext.getRealPath("photo");
	File file = new File(photoPath);
	if(!file.exists()){
	file.mkdir();
	}
	String finalPath = photoPath + File.separator + fileName;
	//实现上传功能
	photo.transferTo(new File(finalPath));
	return "success";
}
```

### 拦截器

#### 配置

```xml
<bean class="com.atguigu.interceptor.FirstInterceptor"></bean>
<ref bean="firstInterceptor"></ref>
<!-- 以上两种配置方式都是对DispatcherServlet所处理的所有的请求进行拦截 -->
<mvc:interceptor>
	<mvc:mapping path="/**"/>
    <mvc:exclude-mapping path="/testRequestEntity"/>
	<ref bean="firstInterceptor"></ref>
</mvc:interceptor>
<!--
以上配置方式可以通过ref或bean标签设置拦截器，通过mvc:mapping设置需要拦截的请求，通过
mvc:exclude-mapping设置需要排除的请求，即不需要拦截的请求
-->	
```

SpringMVC中的拦截器有三个抽象方法：

preHandle：控制器方法执行之前执行preHandle()，其boolean类型的返回值表示是否拦截或放行，返

回true为放行，即调用控制器方法；返回false表示拦截，即不调用控制器方法

postHandle：控制器方法执行之后执行postHandle()

afterCompletion：处理完视图和模型数据，渲染视图完毕之后执行afterCompletion()

### 异常处理器

```xml
<bean
class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
	<property name="exceptionMappings">
		<props>
<!--
properties的键表示处理器方法执行过程中出现的异常
properties的值表示若出现指定异常时，设置一个新的视图名称，跳转到指定页面
-->
			<prop key="java.lang.ArithmeticException">error</prop>
		</props>
	</property>
<!--
exceptionAttribute属性设置一个属性名，将出现的异常信息在请求域中进行共享
-->
	<property name="exceptionAttribute" value="ex"></property>
</bean>
```

```java
//@ControllerAdvice将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {
	//@ExceptionHandler用于设置所标识方法处理的异常
	@ExceptionHandler(ArithmeticException.class)
	//ex表示当前请求处理中出现的异常对象
	public String handleArithmeticException(Exception ex, Model model){
		model.addAttribute("ex", ex);
		return "error";
	}
}
```

### 注解配置

代替web.xml 和springmvc-config.xml

#### 创建初始化类，代替web.xml

WebInit.java 代替web.xml

```xml
```



