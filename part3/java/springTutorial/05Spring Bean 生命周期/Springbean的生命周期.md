### 一、前言

​	说到生命周期，我们应该就可以想到初始化--》被使用--》被销毁回收这三个过程。那么SpringBean的生命周期分别经过哪些阶段呢？

### 二、Springbean 的生命周期

​	SpringBean的生命销毁周期大致分为四个阶段

#### 	1、实例化阶段

​		① ResourceLoader从存储介质中加载Spring配置信息，并使用Resource表示这个配置文件的资源（即 这一步就是用来读取配置文件）

​			这个接口中有一个getResource (String location) 这样的方法，返回接口Resource的实例，Spring内所有的ApplicationContext实例(包括Spring自启动容器或者用户手动创建的其他容器)，都实现了这个方法。

```java
public class ResourceTest implements ApplicationContextAware{
	
	ApplicationContext applicationContext ;
	
	public void getResourceTest() {
		//通过applicationContext，只一步getResource()，就可以获取资源，读取classpath目录下
		Resource resource = applicationContext.getResource("spring-mvc.xml");
		//TODO: 用此resource来获取想要的资源
		//......
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {		
		this.applicationContext = applicationContext;		
	}
}
```

​		②BeanDefinitionReader读取Resource所指向的配置文件资源，然后解析配置文件。配置文件中每一个bean标签解析成一个BeanDefinition对象，并保存到BeanDefinitionRegistry中；	

BeanDefinitionReader接口：

```java
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    ClassLoader getBeanClassLoader();

    BeanNameGenerator getBeanNameGenerator();

    // 通过 Resource 加载 Bean 

    int loadBeanDefinitions(Resource resource) 
        throws BeanDefinitionStoreException;

    int loadBeanDefinitions(Resource... resources) 
        throws BeanDefinitionStoreException;

    // 通过 location 加载资源

    int loadBeanDefinitions(String location) 
        throws BeanDefinitionStoreException;

    int loadBeanDefinitions(String... locations) 
        throws BeanDefinitionStoreException;
}
```

因为前面我们使用的是xml配置，默认使用的是XmlBeanDefinitionReader实现类中的loadBeanDefinitions方法。

**BeanDefinition**源码：

```java
public interface BeanDefinition extends AttributeAccessor, BeanMetadataElement {

	/**
	 * Scope identifier for the standard singleton scope: "singleton".
	 * <p>Note that extended bean factories might support further scopes.
	 * @see #setScope
	 */
	String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

	/**
	 * Scope identifier for the standard prototype scope: "prototype".
	 * <p>Note that extended bean factories might support further scopes.
	 * @see #setScope
	 */
	String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;


	/**
	 * Role hint indicating that a {@code BeanDefinition} is a major part
	 * of the application. Typically corresponds to a user-defined bean.
	 */
	int ROLE_APPLICATION = 0;

	/**
	 * Role hint indicating that a {@code BeanDefinition} is a supporting
	 * part of some larger configuration, typically an outer
	 * {@link org.springframework.beans.factory.parsing.ComponentDefinition}.
	 * {@code SUPPORT} beans are considered important enough to be aware
	 * of when looking more closely at a particular
	 * {@link org.springframework.beans.factory.parsing.ComponentDefinition},
	 * but not when looking at the overall configuration of an application.
	 */
	int ROLE_SUPPORT = 1;

	/**
	 * Role hint indicating that a {@code BeanDefinition} is providing an
	 * entirely background role and has no relevance to the end-user. This hint is
	 * used when registering beans that are completely part of the internal workings
	 * of a {@link org.springframework.beans.factory.parsing.ComponentDefinition}.
	 */
	int ROLE_INFRASTRUCTURE = 2;


	// Modifiable attributes

	/**
	 * Set the name of the parent definition of this bean definition, if any.
	 */
	void setParentName(String parentName);

	/**
	 * Return the name of the parent definition of this bean definition, if any.
	 */
	String getParentName();

	/**
	 * Specify the bean class name of this bean definition.
	 * <p>The class name can be modified during bean factory post-processing,
	 * typically replacing the original class name with a parsed variant of it.
	 * @see #setParentName
	 * @see #setFactoryBeanName
	 * @see #setFactoryMethodName
	 */
	void setBeanClassName(String beanClassName);

	/**
	 * Return the current bean class name of this bean definition.
	 * <p>Note that this does not have to be the actual class name used at runtime, in
	 * case of a child definition overriding/inheriting the class name from its parent.
	 * Also, this may just be the class that a factory method is called on, or it may
	 * even be empty in case of a factory bean reference that a method is called on.
	 * Hence, do <i>not</i> consider this to be the definitive bean type at runtime but
	 * rather only use it for parsing purposes at the individual bean definition level.
	 * @see #getParentName()
	 * @see #getFactoryBeanName()
	 * @see #getFactoryMethodName()
	 */
	String getBeanClassName();

	/**
	 * Override the target scope of this bean, specifying a new scope name.
	 * @see #SCOPE_SINGLETON
	 * @see #SCOPE_PROTOTYPE
	 */
	void setScope(String scope);

	/**
	 * Return the name of the current target scope for this bean,
	 * or {@code null} if not known yet.
	 */
	String getScope();

	/**
	 * Set whether this bean should be lazily initialized.
	 * <p>If {@code false}, the bean will get instantiated on startup by bean
	 * factories that perform eager initialization of singletons.
	 */
	void setLazyInit(boolean lazyInit);

	/**
	 * Return whether this bean should be lazily initialized, i.e. not
	 * eagerly instantiated on startup. Only applicable to a singleton bean.
	 */
	boolean isLazyInit();

	/**
	 * Set the names of the beans that this bean depends on being initialized.
	 * The bean factory will guarantee that these beans get initialized first.
	 */
	void setDependsOn(String... dependsOn);

	/**
	 * Return the bean names that this bean depends on.
	 */
	String[] getDependsOn();

	/**
	 * Set whether this bean is a candidate for getting autowired into some other bean.
	 * <p>Note that this flag is designed to only affect type-based autowiring.
	 * It does not affect explicit references by name, which will get resolved even
	 * if the specified bean is not marked as an autowire candidate. As a consequence,
	 * autowiring by name will nevertheless inject a bean if the name matches.
	 */
	void setAutowireCandidate(boolean autowireCandidate);

	/**
	 * Return whether this bean is a candidate for getting autowired into some other bean.
	 */
	boolean isAutowireCandidate();

	/**
	 * Set whether this bean is a primary autowire candidate.
	 * <p>If this value is {@code true} for exactly one bean among multiple
	 * matching candidates, it will serve as a tie-breaker.
	 */
	void setPrimary(boolean primary);

	/**
	 * Return whether this bean is a primary autowire candidate.
	 */
	boolean isPrimary();

	/**
	 * Specify the factory bean to use, if any.
	 * This the name of the bean to call the specified factory method on.
	 * @see #setFactoryMethodName
	 */
	void setFactoryBeanName(String factoryBeanName);

	/**
	 * Return the factory bean name, if any.
	 */
	String getFactoryBeanName();

	/**
	 * Specify a factory method, if any. This method will be invoked with
	 * constructor arguments, or with no arguments if none are specified.
	 * The method will be invoked on the specified factory bean, if any,
	 * or otherwise as a static method on the local bean class.
	 * @see #setFactoryBeanName
	 * @see #setBeanClassName
	 */
	void setFactoryMethodName(String factoryMethodName);

	/**
	 * Return a factory method, if any.
	 */
	String getFactoryMethodName();

	/**
	 * Return the constructor argument values for this bean.
	 * <p>The returned instance can be modified during bean factory post-processing.
	 * @return the ConstructorArgumentValues object (never {@code null})
	 */
	ConstructorArgumentValues getConstructorArgumentValues();

	/**
	 * Return the property values to be applied to a new instance of the bean.
	 * <p>The returned instance can be modified during bean factory post-processing.
	 * @return the MutablePropertyValues object (never {@code null})
	 */
	MutablePropertyValues getPropertyValues();


	// Read-only attributes

	/**
	 * Return whether this a <b>Singleton</b>, with a single, shared instance
	 * returned on all calls.
	 * @see #SCOPE_SINGLETON
	 */
	boolean isSingleton();

	/**
	 * Return whether this a <b>Prototype</b>, with an independent instance
	 * returned for each call.
	 * @since 3.0
	 * @see #SCOPE_PROTOTYPE
	 */
	boolean isPrototype();

	/**
	 * Return whether this bean is "abstract", that is, not meant to be instantiated.
	 */
	boolean isAbstract();

	/**
	 * Get the role hint for this {@code BeanDefinition}. The role hint
	 * provides the frameworks as well as tools with an indication of
	 * the role and importance of a particular {@code BeanDefinition}.
	 * @see #ROLE_APPLICATION
	 * @see #ROLE_SUPPORT
	 * @see #ROLE_INFRASTRUCTURE
	 */
	int getRole();

	/**
	 * Return a human-readable description of this bean definition.
	 */
	String getDescription();

	/**
	 * Return a description of the resource that this bean definition
	 * came from (for the purpose of showing context in case of errors).
	 */
	String getResourceDescription();

	/**
	 * Return the originating BeanDefinition, or {@code null} if none.
	 * Allows for retrieving the decorated bean definition, if any.
	 * <p>Note that this method returns the immediate originator. Iterate through the
	 * originator chain to find the original BeanDefinition as defined by the user.
	 */
	BeanDefinition getOriginatingBeanDefinition();

}
```

​	可以看到上面的很多属性和方法都很熟悉，例如**类名**、**scope**、**属性**、**构造函数参数列表**、**依赖的bean**、**是否是单例类**、**是否是懒加载**等，其实就是**将Bean的定义信息存储到这个BeanDefinition相应的属性中，后面对Bean的操作就直接对BeanDefinition进行**，例如拿到这个BeanDefinition后，可以**根据里面的类名、构造函数、构造函数参数，使用反射进行对象创建**。BeanDefinition只是一个接口，它的实现类有ChildBeanDefinition，RootBeanDefinition，GenericBeanDefinition。

​	**BeanDefinitionRegistry**这就是Springbean的注册中心

```java
// 它继承自 AliasRegistry 
public interface BeanDefinitionRegistry extends AliasRegistry {

	// 关键 -> 往注册表中注册一个新的 BeanDefinition 实例 
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionStoreException;
	// 移除注册表中已注册的 BeanDefinition 实例
	void removeBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;
	// 从注册中心取得指定的 BeanDefinition 实例
	BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;
	// 判断 BeanDefinition 实例是否在注册表中（是否注册）
	boolean containsBeanDefinition(String beanName);
	
	// 取得注册表中所有 BeanDefinition 实例的 beanName（标识）
	String[] getBeanDefinitionNames();
	// 返回注册表中 BeanDefinition 实例的数量
	int getBeanDefinitionCount();
	// beanName（标识）是否被占用
	boolean isBeanNameInUse(String beanName);
}

```

​		BeanDefinitionRegistry的实现类中有SimpleBeanDefinitionRegistry、DefaultListableBeanFactory、GenericApplicationContext等。其中DefaultListableBeanFactory中的子类有XmlBeanFactory。

​	DefaultListableBeanFactory源码：

```java
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
		implements ConfigurableListableBeanFactory, BeanDefinitionRegistry, Serializable {
	...
	/** Map of bean definition objects, keyed by bean name */
	private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
	// 保存所有的Bean名称
	/** List of bean definition names, in registration order */
	private volatile List<String> beanDefinitionNames = new ArrayList<>(256);

	// 注册Bean定义信息~~
	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
			throws BeanDefinitionStoreException {
		...
		BeanDefinition oldBeanDefinition = this.beanDefinitionMap.get(beanName);
		// 如果不为null，说明这个beanName对应的Bean定义信息已经存在了~~~~~
		if (oldBeanDefinition != null) {
			// 是否允许覆盖（默认是true 表示允许的）
			if (!isAllowBeanDefinitionOverriding()) {
				// 抛异常
			}
			// 若允许覆盖  那还得比较下role  如果新进来的这个Bean的role更大			
			// 比如老的是ROLE_APPLICATION（0）  新的是ROLE_INFRASTRUCTURE(2) 
			// 最终会执行到put，但是此处输出一个warn日志，告知你的bean被覆盖啦~~~~~~~（我们自己覆盖Spring框架内的bean显然就不需要warn提示了）
			else if (oldBeanDefinition.getRole() < beanDefinition.getRole()) {
				// 仅仅输出一个logger.warn
			}
			// 最终会执行put，但是内容还不相同  那就提醒一个info信息吧
			else if (!beanDefinition.equals(oldBeanDefinition)) {
				// 输出一个info信息
			}
			else {
				// 输出一个debug信息
			}
			// 最终添加进去 （哪怕已经存在了~） 
			// 从这里能看出Spring对日志输出的一个优秀处理，方便我们定位问题~~~
			this.beanDefinitionMap.put(beanName, beanDefinition);
			// 请注意：这里beanName并没有再add了，因为已经存在了  没必要了嘛
		}
		else {
			// hasBeanCreationStarted:表示已经存在bean开始创建了（开始getBean()了吧~~~）
			if (hasBeanCreationStarted()) {
				// 注册过程需要synchronized，保证数据的一致性	synchronized (this.beanDefinitionMap) {
					this.beanDefinitionMap.put(beanName, beanDefinition); // 放进去
					List<String> updatedDefinitions = new ArrayList<>(this.beanDefinitionNames.size() + 1);
					updatedDefinitions.addAll(this.beanDefinitionNames);
					updatedDefinitions.add(beanName);
					this.beanDefinitionNames = updatedDefinitions;
			
					// 
					if (this.manualSingletonNames.contains(beanName)) {
						Set<String> updatedSingletons = new LinkedHashSet<>(this.manualSingletonNames);
						updatedSingletons.remove(beanName);
						this.manualSingletonNames = updatedSingletons;
					}
				}
			}
			else {
				// Still in startup registration phase
				// 表示仍然在启动  注册的状态~~~就很好处理了 put仅需，名字add进去
				this.beanDefinitionMap.put(beanName, beanDefinition);
				this.beanDefinitionNames.add(beanName);
				
				// 手动注册的BeanNames里面移除~~~ 因为有Bean定义信息了，所以现在不是手动直接注册的Bean单例~~~~
				this.manualSingletonNames.remove(beanName);
			}

			// 这里的意思是：但凡你新增了一个新的Bean定义信息，之前已经冻结的就清空呗~~~
			this.frozenBeanDefinitionNames = null;
		}
		
		// 最后异步很有意思：老的bean定义信息不为null（beanName已经存在了）,或者这个beanName直接是一个单例Bean了~
		if (oldBeanDefinition != null || containsSingleton(beanName)) {
			// 做清理工作：
			// clearMergedBeanDefinition(beanName)
			// destroySingleton(beanName);  销毁这个单例Bean  因为有了该bean定义信息  最终还是会创建的
			// Reset all bean definitions that have the given bean as parent (recursively).  处理该Bean定义的getParentName  有相同的也得做清楚  所以这里是个递归
			resetBeanDefinition(beanName);
		}
	}

	@Override
	public void removeBeanDefinition(String beanName) throws 		NoSuchBeanDefinitionException {
		// 移除整体上比较简单：beanDefinitionMap.remove
		// beanDefinitionNames.remove
		// resetBeanDefinition(beanName);

		BeanDefinition bd = this.beanDefinitionMap.remove(beanName);
		// 这里发现移除，若这个Bean定义本来就不存在，事抛异常，而不是返回null 需要注意~~~~
		if (bd == null) {
			throw new NoSuchBeanDefinitionException(beanName);
		}

		if (hasBeanCreationStarted()) {
			synchronized (this.beanDefinitionMap) {
				List<String> updatedDefinitions = new ArrayList<>(this.beanDefinitionNames);
				updatedDefinitions.remove(beanName);
				this.beanDefinitionNames = updatedDefinitions;
			}
		} else {
			this.beanDefinitionNames.remove(beanName);
		}
		this.frozenBeanDefinitionNames = null;
		resetBeanDefinition(beanName);
	}

	// 这个实现非常的简单，直接从map里拿
	@Override
	public BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
		BeanDefinition bd = this.beanDefinitionMap.get(beanName);
		if (bd == null) {
			throw new NoSuchBeanDefinitionException(beanName);
		}
		return bd;
	}

@Override
	public boolean containsBeanDefinition(String beanName) {
		return this.beanDefinitionMap.containsKey(beanName);
	}
	@Override
	public int getBeanDefinitionCount() {
		return this.beanDefinitionMap.size();
	}
	@Override
	public String[] getBeanDefinitionNames() {
		String[] frozenNames = this.frozenBeanDefinitionNames;
		if (frozenNames != null) {
			return frozenNames.clone();
		}
		else {
			return StringUtils.toStringArray(this.beanDefinitionNames);
		}
	}
	
	// ==========这个方法非常有意思：它是间接的实现的===============
	// 因为BeanDefinitionRegistry有这个方法，而它的父类AbstractBeanFactory也有这个方法，所以一步小心，就间接的实现了这个接口方法
	public boolean isBeanNameInUse(String beanName) {
		// 增加了一个hasDependentBean(beanName);  或者这个BeanName是依赖的Bean 也会让位被使用了
		return isAlias(beanName) || containsLocalBean(beanName) || hasDependentBean(beanName);
	}
}

```

​	③容器扫描BeanDefinitionRegistry中的BeanDefinition，使用Java的反射机制自动识别出Bean工厂后处理后器（实现BeanFactoryPostProcessor接口）的Bean，然后调用这些Bean工厂后处理器对BeanDefinitionRegistry中的BeanDefinition进行加工处理。

​	④Spring容器从BeanDefinitionRegistry中取出加工后的BeanDefinition，并调用InstantiationStrategy着手进行Bean实例化的工作；

#### 	2、属性赋值

#### 	3、初始化

#### 	4、销毁