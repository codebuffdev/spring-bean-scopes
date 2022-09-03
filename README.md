# spring-bean-scopes

There are 6 bean scopes in Spring.

1. Singleton
2. Prototype
3. Request
4. Session
5. Application (added in spring 5.x)
6. Web Socket (added in spring 5.x)

There used to be 5 bean scopes.

1. Singleton
2. Prototype
3. Request
4. Session
5. Global bean scope (dropped from - spring 5.x ), this scope is used for portlet mvc programming, spring is not supporting it any more.

### Singleton

```java
 @Component("singletonDemo")
 // @Scope("singleton")
 (or)
 @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
 class SingletonDemo{}

SingletonDemo demo1 = context.getBean("singletonDemo", SingletonDemo.class);
SingletonDemo demo2 = context.getBean("singletonDemo", SingletonDemo.class);

demo1 == demo2 = true
```

### Prototype

```java
    @Component("prototypeDemo")
    @Scope("prototype")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public class PrototypeDemo {}

   PrototypeDemo demo1 = context.getBean("prototypeDemo", PrototypeDemo.class);
   PrototypeDemo demo2 = context.getBean("prototypeDemo", PrototypeDemo.class);

demo1 == demo2 = false
```

### Bean Initialization(Singleton & Prototype)

```java
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON) //eager instantiation ()
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) //lazy instantiation
```

### Injecting prototype bean inside a singleton bean

```java
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class X {
@Autowired
X x; //SCOPE_PROTOTYPE
//getter X
}

@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class Y{}

X singleton = context.getBean(X.class);
```

We should not inject Prototype bean into Singleton bean.
But we still can make inject prototype bean into singleton bean.

```java
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrototypeBean {
public PrototypeBean() {
System.out.println("PrototypeBean created");
}
}
```

Now when we inject PrototypeBean into a singleton bean , a proxy object will be injected. So, when ever we ask for a PrototypeBean inside singleton bean we gets a new object.
Proxy will be created with the help of cglib library.
cglib - Code generation library

### Look up injection

```java
@Lookup
public ReturnType m1(){
return null;
}
```

### Singleton Scoped bean Vs GOF singleton design pattern

GOF singleton - Single object per classloader hierarchies.

Singleton Scoped bean - Singleton per application context

```java
ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("application-context.xml");
ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("application-context2.xml");
SingleTonBeans singleTonBeans10 = applicationContext1.getBean("stBeans1", SingleTonBeans.class);
SingleTonBeans singleTonBeans11 = applicationContext1.getBean("stBeans1", SingleTonBeans.class);
SingleTonBeans singleTonBeans20 = applicationContext2.getBean("stBeans2", SingleTonBeans.class);
SingleTonBeans singleTonBeans21 = applicationContext2.getBean("stBeans2", SingleTonBeans.class);
System.out.println(singleTonBeans10 +" "+singleTonBeans11);
System.out.println(singleTonBeans20 +" "+singleTonBeans21);
```

## WebAware scopes

1. Request
2. Session
3. Application
4. Websocket
   Works only for web application.

### Request

    Can only be used inside a web-application.

i'm inside a standalone application -

```java
@Scope("request")
class A{}
// Here we will get IllegalStateException.
```

Request scope - for each req object will be created. (Imp - once the req come then object will be created)
@Scope(value = "request")
or
@Scope(value = WebApplicationContext.SCOPE_REQUEST)

Injecting Request scope bean object to SingleTonBeans.

```java
@Controller
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
class X {
@Autowired
A a;
}
```

Once the req comes then only the Object of A will be created.
But X has singleton scope, means while creating ApplicationContext only A should in instantiated.
X has a dependency named A.
So, here while creating X we will run into exception as the dependency can not be resolved.

To over come this we need to go into "proxyMode" for request scope bean.

```java

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS) // with each req a new Object will be created for the bean
public class MyBean {}
```

standard way of writing request scope is .
@RequestScope = @Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)

### RequestScope vs prototype scoped bean --

RequestScope bean - 1 object per req
prototype bean - each time we ask for the bean from IOC we get a new object.

### Session

@Scope(value = WebApplicationContext.SCOPE_SESSION) = @SessionScope// 1 object per session

Once the request has been comes then only the object being created. (1 object per session)

### Application

```java
 @Component
 @ApplicationScope
 public class ApplicationScopeTest {}
```

Object will be created when required & will b stored in ServletContext not IOC.

### Websocket

Websocket scope is related to spring programming.

```java
@Component
@Scope(value="websocket" , proxyMode=ScopedProxyMode.TARGET_CLASS)
class X {}
```

Only one object will be created & stored inside websocket-session.

