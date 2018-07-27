package com.atguigu.jqueryeasyui.mappers;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Randomly implements ActionListener, Runnable {
	//设置一个标记
	private boolean flag = false;
	private JFrame randomFrame = new JFrame("随机抽取");
	
	// 创建一个Panel对象。
	private JPanel randomPanel = new JPanel();
	private TextField tf = new TextField(30);
	private JButton randomButton1 = new JButton("Run");
	private JButton randomButton2 = new JButton("Stop");
	private JButton randomButton3 = new JButton("Question");
	private JButton randomButton4 = new JButton("Answer");
	private JButton randomButton5 = new JButton("Delete");
	private JButton randomButton6 = new JButton("Number");
	private List<String> nameage = Arrays.asList("刘勇勇","沈磊","谢昊","吴兴华","田绍鹏","张帅磊","高斌","刘毅","罗家辉","杨俊龙",
												"郝文","蔡均宇","曹凯","高凡","虎才进","兰建喜","林一明","袁泽辉","张豪杰","张立刚",
												"刘伟伟","梁东全","李锦浩","黄诗勇","何鸿谦","傅子锐","孙俊伟","王思栋","朴龙学","陈泽豪",
												"程文锋","胡志龙","刘百庄","柳文强","彭松","肖刚","朱浅雨","欧阳宇飞","焦启轩","王飞",
												"李高山","赵亚文","简巍巍","叶东成","郑桂春","施勇强","魏守强","杨梦恒","周盼","唐骏",
												"龙绪昊","沈章东","陈和伟","李明珠","狄沈栋","潘超","柯欲文","吴才进","曹庭建","刘云志",
												"陈雅文","范博文","覃田爽","王国华","李俊元","陈欢","黄远鹏","周云飞","孟贤","赵东");
	ArrayList<String> name = new ArrayList<String>(nameage);
	int length = name.size();
	
	HashMap<String, String> answer = new HashMap<String,String>() ;
	

	public Randomly() {
		
		// 向JPanel容器中添加三个组件
		randomPanel.add(tf);
		randomPanel.add(randomButton1);
		randomPanel.add(randomButton2);
		randomPanel.add(randomButton3);
		randomPanel.add(randomButton4);
		randomPanel.add(randomButton5);
		randomPanel.add(randomButton6);
		randomFrame.add(randomPanel);
		
		// 设置组件不可改变大小
		randomFrame.setResizable(false);
		// 设置关闭窗体时结束程序
		randomFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置组件大小
		randomFrame.setSize(250, 120);
		// 设置组件位置
		randomFrame.setLocationRelativeTo(null);
		// 设置组件可见
		randomFrame.setVisible(true);
		randomFrame.setLayout(null);
		addListener();
	}
	
	private void addListener() {
		randomButton1.addActionListener(this);
		randomButton2.addActionListener(this);
		randomButton3.addActionListener(this);
		randomButton4.addActionListener(this);
		randomButton5.addActionListener(this);
		randomButton6.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == randomButton1) {
			synchronized (this) {
				notify();
				flag = true;
			}
		}
		if (obj == randomButton2) {
			synchronized (this) {
				flag = false;
			}
		}
		if(obj == randomButton3) {
			Map<String, String> question = new HashMap<String,String>();
			//第一组
			//"刘勇勇","沈磊","谢昊","吴兴华","田绍鹏","张帅磊","高斌","刘毅","罗家辉","杨俊龙"
			question.put("刘勇勇","如何用基于Java配置的方式配置Spring？");
			question.put("沈磊","Spring管理事务有几种方式？");
			question.put("谢昊","简述下事务的4大特性（ACID）：");
			question.put("吴兴华","关于springIOC容器的问题；IOC容器其全称为inverse of control,也即是控制反转<br>1、请问怎么理解控制？谁控制谁，这样对我们的开发有什么好处？<br>2、怎么理解反转，反转是什么意思？");
			question.put("田绍鹏","请说下@Autowired注入的原理？");
			question.put("张帅磊","@ModelAttribute三个常见作用是什么？");
			question.put("高斌","如何用基于Java配置的方式配置Spring？");
			question.put("刘毅","SpingMvc中的控制器的注解一般用哪个？有没有别的注解可以替代 ？");
			question.put("罗家辉","Spring 中的自动装配有哪些限制？");
			question.put("杨俊龙","将Spring配置到应用开发中有哪三种方式？");
			
			//第二组
			//"郝文","蔡均宇","曹凯","高凡","虎才进","兰建喜","林一明","袁泽辉","张豪杰","张立刚"
			question.put("郝文", "Log4j一共有几个常用级别？分别是哪些？级别的高低有什么区别？");
			question.put("蔡均宇", "什么是MVC？MVC有什么作用？");
			question.put("曹凯", "简要描述cookie和session，以及他们的运行原理？");
			question.put("高凡", "JSP有哪些内置对象？作用分别是什么？");
			question.put("虎才进", "简述JQuery 中方法empty和remove区别？");
			question.put("兰建喜", "forward 和 redirect 的区别？");
			question.put("林一明", "如何避免JSP页面自动生成session对象？为什么要这么做？");
			question.put("袁泽辉", "GET请求和POST请求的区别？");
			question.put("张豪杰", "什么是JSTL标签库？它的作用是什么？最主要的是哪个库？");
			question.put("张立刚", "JQuery对象和dom对象如何相互转化？");
			
			//第三组
			//"刘伟伟","梁东全","李锦浩","黄诗勇","何鸿谦","傅子锐","孙俊伟","王思栋","朴龙学","陈泽豪"
			question.put("刘伟伟", "简述String 、StringBuffer和StringBuilder的区别？");
			question.put("梁东全", "简述Overload和Override的区别。Overloaded的方法是否可以改变返回值的类型？");
			question.put("李锦浩", "简述final、finally、finalize的区别？");
			question.put("黄诗勇", "简述抽象类和接口的区别？");
			question.put("何鸿谦", "简述ArrayList,Vector, LinkedList的存储性能和特性？");
			question.put("傅子锐", "是否可以从一个static方法内部发出对非static方法的调用？原因是什么？");
			question.put("孙俊伟", "多线程有几种实现方法？同步有几种实现方法？");
			question.put("王思栋", "创建一个对象都在内存中做了什么事情？不用考虑静态代码块<br>public static void main(String[] args){<br>Person p = new Person();<br>}");
			question.put("朴龙学", "简述线程的5大状态？");
			question.put("陈泽豪", "如何以最快的速度将变量a由2变成8？");
			
			//第四组
			//"程文锋","胡志龙","刘百庄","柳文强","彭松","肖刚","朱浅雨","欧阳宇飞","焦启轩","王飞"
			question.put("程文锋", "简述异步请求的流程？");
			question.put("胡志龙", "都有哪些类加载器？简述Java的双亲委派机制？以及为何要这样设计");
			question.put("刘百庄", "简述maven的依赖原则");
			question.put("柳文强", "简述RBAC权限模型的四种级别？");
			question.put("彭松", "Maven依赖范围常用的有哪几种？作用范围分别是什么？");
			question.put("肖刚", "简述Maven中聚合的作用？");
			question.put("朱浅雨", "在众筹项目中，是如何控制访问权限的？请分后台用户登陆前和用户登陆后这两个时间段回答 ");
			question.put("欧阳宇飞", "什么是同步请求，什么是异步请求？同步和异步的区别？使用JQuery实现异步请求有几种方式？");
			question.put("焦启轩", "简述 RBAC？（重复问题）");
			question.put("王飞", "什么是绝对路径，什么是相对路径？");
			
			//第五组
			//"李高山","赵亚文","简巍巍","叶东成","郑桂春","施勇强","魏守强","杨梦恒","周盼","唐骏",
			question.put("李高山", "什么是集群？什么是分布式？");
			question.put("赵亚文", "什么是反ACID模型？");
			question.put("简巍巍", "请简述乐观锁和悲观锁的区别？Redis采用的何种策略及原因？");
			question.put("叶东成", "如何实时查看一个文本末尾新增的内容(比如log日志文件),如何退出查看？");
			question.put("郑桂春", "查看文件内容有哪些命令可以使用？");
			question.put("施勇强", "test目录下有一目录dir(其目录下有jpg格式图片，任意子目录下也有jpg格式图片)，试用Linux命令查出dir目录里所有jpg图片");
			question.put("魏守强", "RDB和AOF各自的优劣势？");
			question.put("杨梦恒", "linux中VIM编辑器的分为哪三种工作模式？并举例说明怎样进入。");
			question.put("周盼", "请说出redis支持的五大数据类型？");
			question.put("唐骏", "为什么redis需要把所有数据放到内存中？");
			
			//第六组
			//"龙绪昊","沈章东","陈和伟","李明珠","狄沈栋","潘超","柯欲文","吴才进","曹庭建","刘云志",
			question.put("龙绪昊", "Activiti 的常用服务类有哪些？ 它们的作用是什么？");
			question.put("沈章东", "简述Springboot自动配置的原理？");
			question.put("陈和伟", "spring cloud中采用什么断路器技术，简述其作用？");
			question.put("李明珠", "简述众筹项目的架构？用了哪些框架？");
			question.put("狄沈栋", "使用 SpringBoot 进行项目开发有什么好处？");
			question.put("潘超", "SpringBoot 常用的 starter 有哪些？");
			question.put("柯欲文", "开发中如何使用 Spring Boot 热部署？");
			question.put("吴才进", "FreeMarker 模板引擎中常用的语句有哪些？");
			question.put("曹庭建", "Activiti 框架中都有哪些常用网关？");
			question.put("刘云志", "Spring Cloud如何实现服务的注册和发现？");
			
			//第七组
			//"陈雅文","范博文","覃田爽","王国华","李俊元","陈欢","黄远鹏","周云飞","孟贤","赵东"
			question.put("陈雅文", "简述数据库的4种隔离级别？");
			question.put("范博文", "注册Jdbc驱动程序的三种方式？");
			question.put("覃田爽", "简述什么是PRIMARY KEY 主键约束？");
			question.put("王国华", "当多个事务同时访问数据库中相同的数据时，如果没有采取必要的隔离机制，可能会导致哪些并发问题？");
			question.put("李俊元", "在employees表中有department_id和salary两列 	<br>如下SQL语句想要查询到什么数据？该语句是否存在问题？如果有,请写出正确的语句？ "
					+ "<br>SELECT department_id,MAX(salary) "
					+ "<br>FROM employees "
					+ "<br>GROUP BY department_id "
					+ "<br>WHERE AVG(salary) >= 8000 LIMIT 2 "
					+ "<br>ORDER BY department_id DESC");
			question.put("陈欢", "MyBatis的参数传递 对于多个普通数据类型，传递方式有哪几种？");
			question.put("黄远鹏", "MyBatis中使用#和$书写占位符有什么区别？");
			question.put("周云飞", "Mybatis中的#和$有什么区别？");
			question.put("孟贤", "MyBatis中用于实现动态SQL的元素主要有哪些？");
			question.put("赵东", "union和union all有什么不同？");
			
			String key = tf.getText();
			JFrame quest = new JFrame(key+"的问题");
			quest.setSize(400, 300);
			String que = "<html>"+question.get(key)+"</html>";
			JLabel label = new JLabel(que,JLabel.CENTER);
			label.setFont(new java.awt.Font("Dialog",   1,   15));
			label.setForeground(Color.RED);
			
			quest.add(label);
			quest.setLocationRelativeTo(null);
			quest.setVisible(true);
			
		}
		if(obj == randomButton4) {
			Map<String, String> answer = new HashMap<String,String>();
			//第一组
			answer.put("刘勇勇","org.springframework.jdbc.datasource.DataSourceTransactionManager");
			answer.put("沈磊","答：	1.编程式事务，在代码中硬编码。<br>"
					+ "2.声明式事务，在配置文件中配置："
					+ "<br>&emsp;a:基于XML的声明式事务"
					+ "<br>&emsp;b:基于注解的声明式事务");
			answer.put("谢昊","原子性(Atomicity)：事务是数据库的逻辑工作单位，它对数据库的修改要么全部执行，要么全部不执行。"
							+ "<br>一致性(Consistemcy)：事务前后，数据库的状态都满足所有的完整性约束。"
							+ "<br>隔离性(Isolation)：并发执行的事务是隔离的，一个不影响一个。"
								+ "如果有两个事务，运行在相同的时间内，执行相同的功能，事务的隔离性将确保每一事务在系统中认为只有该事务在使用系统。"
								+ "这种属性有时称为串化，为了防止事务操作间的混淆，必须串行化或序列化请求，使得在同一时间仅有一个请求用于同一数据。"
								+ "通过设置数据库的隔离级别，可以达到不同的隔离效果。"
							+ "<br>持久性(Durability)：在事务完成以后，该事务所对数据库所作的更改便持久的保存在数据库之中，并不会被回滚。");
			answer.put("吴兴华","Answer1：原始的编程开发我们创建的对象的生命周期以及依赖都是我们自己控制。"
								+ "<br>现在引入IOC容器可以代替我们程序员自己进行对象的控制和创建。"
								+ "所以很显然控制的主体就是IOC容器，我们的对象的外部资源获取。"
								+ "好处就是：<br>&emsp;①减低了程序的耦合度；"
										+ "<br>&emsp;②提升了编程效率；"
										+ "<br>&emsp;③方便了测试人员的测试和维护；"
										+ "<br>&emsp;④使程序的整体架构变得灵活多变；（答对两条算对）"
							+ "<br>Answer2：反转的意思是对对象的控制权的反转。"
										+ "主要对于对象的依赖注入，现在需要由IOC容器代替我们完成这个操作，而被控制的对象只能被动的接受。");
			answer.put("田绍鹏","首先，根据类型查找，如果查找到一个就直接注入，如果查找到多个，可以通过数组或集合《必须指定泛型》来接受多个；"
							+ "<br>或者：根据名称再进行查找，如果多个对象中的名字之一与属性名称一致，直接注入。如果多个对象的名称没有与之匹配的，报错；");
			answer.put("张帅磊","1、被标注了@ModelAttribute的方法都会在Controller的目标方法之前执行。"
							+ "<br>2、目标方法的参数（JavaBean对象）会先从隐含模型中获取值传入。"
							+ "<br>3、@ModelAttribute被标注在目标的参数上，参数值会按照指定的key从隐含模型中获取值。");
			answer.put("高斌","Spring对Java配置的支持是由@Configuration注解和@Bean注解来实现的。"
							+ "<br>由@Bean注解的方法将会实例化、配置和初始化一个新对象，这个对象将由Spring的IoC容器来管理。"
							+ "<br>@Bean声明所起到的作用与<bean/> 元素类似。被@Configuration所注解的类则表示这个类的主要目的是作为bean定义的资源。"
							+ "被@Configuration声明的类可以通过在同一个类的内部调用@bean方法来设置嵌入bean的依赖关系。");
			answer.put("刘毅","1 一般用@Conntroller注解，表示是表现层"
					+ "<br>	2 @Component注解同样可以做到，所以是可以替代的"
					+ "<br>3 开发中控制器优先使用@Controller 注解，因为可以更好的区分模块的功能（@Controller注解的作用是把标注的类加入IOC容器，@Component注解同样可以做到，所以是可以替代的。@RestController等于@Controller+@ResponseBody）");
			answer.put("罗家辉","1如果使用了构造器注入或者 setter 注入，那么将覆盖自动装配的依赖关系。"
							+ "<br>2 基本数据类型的值、字符串字面量、类字面量无法使用自动装配来注入。 "
							+ "<br>3 优先考虑使用显式的装配来进行更精确的依赖注入而不是使用自动装配。");
			answer.put("杨俊龙", "①基于XML的配置	<br>②基于注解的配置		<br>③基于Java的配置");
			
			//第二组
			answer.put("郝文", "5个级别。<br>1 DEBUG level：DEBUG级别打印信息粒度最细，适合调试程序；"
									+ "<br>2 INFO level：消息在粗粒度级别上突出强调应用程序的运行过程；"
									+ "<br>3 WARN level：表明会出现潜在错误的情形；"
									+ "<br>4 ERROR level：指出虽然发生错误事件，但仍然不影响系统的继续运行；"
									+ "<br>5 FATAL level：指出每个严重的错误事件将会导致应用程序的退出。");
			answer.put("蔡均宇", "1 MVC：Model 模型、 View 视图、Controller 控制器。"
							+ "<br>2 Model模型：将与业务逻辑相关的数据封装为具体的Java类，其中不掺杂任何与数据处理相关的代码——JavaBean/domain/entity。"
							+ "<br>3 View视图：只负责数据和界面的显示，不接受任何与显示数据无关的代码，便于程序员和美工的分工合作——JSP/HTML。"
							+ "<br>4 Controller控制器：只负责接收请求，调用业务层的代码处理请求，然后派发页面，是一个“调度者”的角色——Servlet。"
							+ "<br>5 MVC 最早出现在JavaEE三层中的Web层，它可以有效的指导Web层的代码如何有效分离，单独工作。"
							+ "<br>MVC的理念是将软件代码拆分成为组件，单独开发，组合使用（目的还是为了解耦合）");
			answer.put("曹凯", "1 Cookie：浏览器端保存数据的一种技术，可以是服务器发送给浏览器的数据，让其暂存"
							+ "<br>2 Session：服务器端保存会话数据的一种技术。"
							+ "<br>3 Cookie运行原理：<br>&emsp;1）、浏览器发请求给服务器，服务器可以创建一个Cookie让浏览器保存"
											+ "<br>&emsp;2）、浏览器收到响应，发现响应头中会有Set-Cookie字段。浏览器就会按照要求保存内容"
											+ "<br>&emsp;3）、浏览器以后访问对应的项目就会带上cookie"
							+ "<br>4 会话控制（Session）原理："
											+ "<br>&emsp;1）、当新会话进来，服务器创建一个session对象，每个session对象有一个id与他对应。"
											+ "<br>&emsp;2）、服务器创建好session对象后，将session的id作为cookie发给浏览器。"
											+ "<br>&emsp;3）、浏览器保存JSESSIONID这个cookie"
											+ "<br>&emsp;4）、以后只要访问这个项目，就会带上JSESSIONID。"
											+ "<br>&emsp;5）、服务器收到任何一个请求，如果要获取session，服务器会在请求头中获取JSESSIONID的值，按照值去找对应的Session对象。如果找到了，使用找到的对象。如果没找到，创建新的session对象。回到第一步。");
			answer.put("高凡", "1 JSP一共有9个内置对象："
							+ "<br>2 request:负责得到客户端请求的信息，对应类型：javax.servlet.http.HttpServletRequest"
							+ "<br>3 response:负责向客户端发出响应，对应类型：javax.servlet.http.HttpServletResponse"
							+ "<br>4 session:负责保存同一客户端一次会话过程中的一些信息，对应类型：javax.servlet.http.httpsession"
							+ "<br>5 out:负责管理对客户端的输出，对应类型：javax.serlvet.jsp.jspwriter"
							+ "<br>6 application:表示整个应用环境的信息，对应类型：javax.servlet.servletcontext"
							+ "<br>7 config:表示ServletConfig，对应类型：javax.servlet.servletconfig"
							+ "<br>8 exception:表示页面中发生的异常，可以通过它获得页面异常信息，对应类型：java.lang.exception"
							+ "<br>9 pagecontext:表示这个JSP页面上下文，对应类型：javax.servlet.jsp.pagecontext"
							+ "<br>10 page:表示当前JSP页面本身");
			answer.put("虎才进", "1 empty()是清空节点，它能清空元素中所有的后代节点，但不能删除自己本身这个节点"
								+ "<br>2 remove() 该节点与该节点所包含的所有后代节点将同时被删除提供传递一个筛选的表达式，用来指定删除选中合集中的元素");
			answer.put("兰建喜", "1 forward(转发)：<br>&emsp;1.是服务器内部的重定向，服务器直接访问目标地址的 url网址，把里面的东西读取出来，但是客户端并不知道，因此用forward的话，客户端浏览器的网址是不会发生变化的。 "
											 + "<br>&emsp;2.关于request: 由于在整个定向的过程中用的是同一个request，因此forward会将request的信息带到被重定向的jsp或者servlet中使用。"
							  + "<br>2 redirect（重定向）：<br>&emsp;1.是客户端的重定向，是完全的跳转。即服务器返回的一个url给客户端浏览器，然后客户端浏览器会重新发送一次请求，到新的url里面，因此浏览器中显示的url网址会发生变化。 "
							  					 + "<br>&emsp;2.因为这种方式比forward多了一次网络请求，因此效率会低于forward。"
							  					 + "<br>&emsp;3.不能够访问WEB-INF目录下的资源");
			answer.put("林一明", "1 在默认情况下，在对一个JSP页面发出请求时，如果session还没有建立，那么JSP页面会自动为请求创建一个session对象，但是session是比较消耗资源的，如果没有必要保持和使用session，就不应该创建session。"
							  + "<br>2 例如一些只用来宣传产品的网页，往往没必要使用session来保存信息，可以在JSP中使用page指令进行设置，避免JSP页面为每个请求都自动创建session。实例代码如下：<br><%@page session=\"false\"%>");
			answer.put("袁泽辉", "1 GET请求的特点：<br>&emsp;1 浏览器地址栏上是action属性值?请求的参数请求的参数的格式是：url?name=value&name=value问号后面是提交的参数（也就是表单项的信息）"
							  				+ "<br>&emsp;2 GET请求不安全"
							  				+ "<br>&emsp;3 有长度限制（每个浏览器长度的限制可能不同，浏览器都有兼容性问题）		"
							  + "<br>2 POST请求的特点："
							  				+ "<br>&emsp;1 浏览器地址栏上只有action的属性值"
							  				+ "<br>&emsp;2 POST请求安全"
							  				+ "<br>&emsp;3 提交的数据，没有长度限制");
			answer.put("张豪杰", "1 jstl标签库就是JSP标准标签库"
							  + "<br>2 jstl标签库是为了替换代码脚本使jsp页面变得简洁"
							  + "<br>3 最主要的是核心标签库");
			answer.put("张立刚", "1 dom对象 转 JQuery对象: <br>&emsp;对dom对象进行包装<br>&emsp;var $jqeuryObj = $(domObj) <br>2 JQuery对象 转 dom对象: <br>&emsp;根据下标取出jquery对象中的每一个元素，就是dom对象<br>&emsp;var $juqeryObj = $(\"button\")<br>&emsp;var domObj = $buttonObj[下标]");
			
			//第三组
			answer.put("刘伟伟", "String:不可变的字符序列，任何对String的改变都会引发新的String对象的生成,底层用char[]保存数据"
							 + "<br>StringBuffer:可变的字符序列，任何对它所指代的字符串的改变都不会产生新的对象,底层用char[]保存数据的，支持并发操作，线程安全的"
							 + "<br>StringBuilder:可变的字符序列，底层用char[]保存数据的，不支持并发操作，线程不安全的,性能比StringBuffer高");
			answer.put("梁东全", "1 Overload：重载，同一个类中，方法名相同，参数列表不同。与返回值类型无关。"
							  + "<br>2 Override：重写，存在于子父类，或者子父接口中，方法声明相同。子类方法不能抛出比父类方法范围更大的异常；子类方法返回值不能超过父类方法返回值的范围；"
							  + "<br>3 Overload的方法可以改变返回值的类型，因为它与返回值类型无关。");
			answer.put("李锦浩", "1 final：用来声明属性，方法和类，分别表示属性不可变，方法不能被重写，类不被继承能"
							 + "<br>2 finally：异常处理语句的一部分，表示总是执行"
							 + "<br>3 finalize：Object类中的一个方法，用来调用垃圾回收机制的(GC)");
			answer.put("黄诗勇", "1 抽象类有构造器,接口没有"
							  + "<br>2 抽象类中可以有成员变量,而接口没有（接口中的成员变量都会自动成为常量）"
							  + "<br>3 抽象类中可以有非抽象的普通方法,而接口则全部都是抽象方法[JDK1.8中可以有实现方法]"
							  + "<br>4 抽象类中的抽象方法访问权限可以是public protected,接口的方法则必须是public"
							  + "<br>5 抽象类中可以有静态方法,接口中不能有"
							  + "<br>6 一个类只能继承一个抽象类,但可以实现多个接口");
			answer.put("何鸿谦", "1 ArrayList(主要实现类)：底层是用数组实现的，线程不安全的，比Vector效率高。增删慢 查找快。"
							  + "<br>2 Vector：底层是用数组实现的，线程安全的，效率低"
							  + "<br>3 LinkedList:底层是用链表实现的，线程不安全的，增删快，查找慢");
			answer.put("傅子锐", "不可以。因为非static方法是要与对象关联在一起的，必须创建一个对象后，才可以在该对象上进行方法调用，而static方法调用时不需要创建对象，可以直接调用。也就是说，当一个static方法被调用时，可能还没有创建任何实例对象，如果从一个static方法中发出对非static方法的调用，那个非static方法是关联到哪个对象上的呢？这个逻辑无法成立，所以，一个static方法内部发出对非static方法的调用。");
			answer.put("孙俊伟", "多线程有四种实现方法：<br>1 继承 Thread 方法 <br>&emsp;1.创建一个类并继承Thread，"
													+ "<br>&emsp;2.重写Thread中的run方法，"
													+ "<br>&emsp;3.创建Thread子类的对象，"
													+ "<br>&emsp;4.调用Thread子类对象的start方法。"
											+ "<br>2 实现 Runnable 接口<br>&emsp; 1.实现Runnable接口，"
															 + "<br>&emsp;2.重写run方法，"
															 + "<br>&emsp;3.创建Runnable接口实现类的对象，"
															 + "<br>&emsp;4.创建Thread对象并将Runnable实现类的对象作为参数传递给Thread，"
															 + "<br>&emsp;5.调用Thread对象的start方法。"
									  	    + "<br>3 实现Callable接口   <br>&emsp;1.实现Callable接口，"
									  	    				 + "<br>&emsp;2.重写call方法，"
									  	    				 + "<br>&emsp;3.创建Callable的实现类的对象，"
									  	    				 + "<br>&emsp;4.创建FutureTask对象 并将Callable实现类的对象作为实参传入，"
									  	    				 + "<br>&emsp;5.创建Thread的对象并调用start方法。"
									  	    + "<br>4 线程池 <br>&emsp;1.调用Executors 类的静态方法newFixedThreadPool(int nThreads)，创建一个可重用的、具有固定线程数的线程池ExecutorService对象"
									  	    	  + "<br>&emsp;2.创建Runnable实例，作为线程执行任务"
									  	    	  + "<br>&emsp;3.调用ExecutorService对象的submit()提交Runnable实例"
									  	    	  + "<br>&emsp;4.调用ExecutorService对象的shutDown()方法关闭线程池"
							 + "<br>同步有两种实现方法：<br>&emsp; 1 synchronized <br>&emsp;2 wait与notify");
			answer.put("王思栋", "1 先将硬盘上指定位置的Person.class文件加载进内存。"
						 + "<br>2 执行main方法时，在栈内存中开辟了main方法的空间（压栈-进栈），然后在main方法的栈区分配了一个变量p。"
						 + "<br>3 在堆内存中开辟一个实体空间，分配了一个内存首地址值。new"
						 + "<br>4 进行默认初始化。"
						 + "<br>5 进行显示初始化。"
						 + "<br>6 进行代码块初始化。"
						 + "<br>7 调用构造函数，进行构造函数初始化。"
						 + "<br>8 将首地址赋值给p，p变量就引用了该实体。（指向了该对象）");
			answer.put("朴龙学", "1 新建状态 <br>2 就绪状态 <br>3 运行状态 <br>4 阻塞状态 <br>5 死亡状态");
			answer.put("陈泽豪", "通过位运算<br>int a=2;<br> a<<=2;");
			
			//第四组
			answer.put("程文锋", "1 发起同步连接请求，跳转列表页面(无数据展示，只是静态页面展示) <br>2 发起异步ajax请求，加载数据，局部刷新页面");
			answer.put("胡志龙", "1 有哪些加载器 ①启动类加载器 ②扩展类加载器 ③应用类加载器"
							  + "<br>2 双亲委派机制描述 某个特定的类加载器在接到加载类的请求时，首先将加载任务委托给父类加载器，依次递归，如果父类加载器可以完成类加载任务，就成功返回；只有父类加载器无法完成此加载任务时，才自己去加载。"
							  + "<br>3 为什么要使用 ：防止内存中出现多份同样的字节码");
			answer.put("刘百庄", "1 路径最短者优先 <br>2 路径相同时先声明者优先");
			answer.put("柳文强", "1 RBAC级别 - RABC0，核心模型, 其他的级别都是建立在该级别的基础上。"
									+ " 	四部分组成：<br>&emsp;⑴用户（User）<br>&emsp;⑵角色（Role）<br>&emsp;⑶许可（Permission）<br>&emsp;⑷会话（Session）"
							 + "<br>2 RBAC级别 - RABC1，基于RBAC0模型，进行了角色的分层，也就是说角色上有了上下级的区别。"
							 + "<br>3 RBAC级别 - RABC2，RBAC2，也是基于RBAC0模型的基础上，进行了角色的访问控制。"
							 + "<br>4 RBAC级别 - RBAC3，RBAC3，也就是最全面级的权限管理，它是基于RBAC2的基础上，将RBAC1和RBAC2进行整合了，最全面，也最复杂的。");
			answer.put("彭松", "1 Compile	<br>&emsp;Main和test目录下的类可以使用	&emsp;可以部署	&emsp;可以传递"
							+ "<br>2 Test		<br>&emsp;只有test目录下的类可以使用	Main目录下的类不能使用	&emsp;不能部署	&emsp;不能传递"
							+ "<br>3 Privided		<br>&emsp;Main和test目录下的类可以使用	&emsp;不能部署	&emsp;不能传递");
			answer.put("肖刚", "聚合之后就可以批量进行Maven工程的构建、安装、清理工作");
			answer.put("朱浅雨", "1  用户没有登陆就能访问所有页面。 解决方法：<br>&emsp;定义一个拦截器Interceptor为loginInterceptor继承HandlerInterceptorAdapter，在其preHandle方法中将首页，登陆，注册，dologin，doassign页面加入到白名单中，将request域中取出来的url与白名单进行验证，如果白名单中有就放行，如果没有就跳回登陆页面，在mvc的xml中声明该拦截器。"
							+ "<br>2 所有的登陆用户都能点击并访问所有后台界面。 解决方法：<br>&emsp;1.给用户分配角色，给角色分配权限。<br>&emsp;2.在用户登陆验证的流程中加入用户permission节点的查询与封装进一个根节点中以供页面显示。提取所有后台页面的许可树html，通过ztree显示该用户的所有许可，封装成main .jsp页面。所有页面包含该页面。"
							+ "<br>3 登陆用户能通过输入url访问不在其权限范围内的页面。解决方法：<br>&emsp;定义一个访问权限拦截器，将permission中取出来的全部url封装到list中，如果request中取出来的url（request.getRequestUrl()）不包含在该list中，就返回true说明不需要验证，直接放行。若包含就在session中取出该用户的所有许可地址，验证输入的地址是否包含在许可地址中，不包含就跳转error页面，包含就放行。在mvc中声明该拦截器。另外还需要改下登陆验证流程，将Permission的Url取出并封装成list放到session域对象中。");
			answer.put("欧阳宇飞", "1 同步的思想是：所有的操作都做完，才返回给用户。这样用户在线等待的时间太长，给用户一种卡死了的感觉，这种情况下，用户不能关闭界面，如果关闭了，即迁移程序就中断了。同步，是所有的操作都做完，才返回给用户结果。即写完数据库之后，再响应用户，用户体验不好。"
					+ "<br>2 异步将用户请求放入消息队列，并反馈给用户，系统迁移程序已经启动，你可以关闭浏览器了。然后程序再慢慢地去写入数据库去。这就是异步。但是用户没有卡死的感觉，会告诉你，你的请求系统已经响应了。你可以关闭界面了 异步，不用等所有操作等做完，就相应用户请求。即先相应用户请求，然后慢慢去写数据库，用户体验较好。"
					+ "<br>3 方式：<br>&emsp;1、$.ajax({})<br>&emsp;2、$.get({})		<br>&emsp;3、$.post({})");
			answer.put("焦启轩", "就是用户通过角色与权限进行关联。简单地说，一个用户拥有若干角色，每一个角色拥有若干权限。      	这样，就构造成“用户-角色-权限”的授权模型。在这种模型中，用户与角色之间，角色与权限之间，一般都是多对多的关系");
			answer.put("王飞", "完整的描述文件或资源位置的路径是绝对路径"
					+ "<br>本地路径：以盘符开始的路径称之为绝对路径, c:/test/test.html "
					+ "<br>网络路径：以协议，域名,端口号所组合的路径为绝对路径 "
					+ "<br>http://localhost:8080/atcrowdfunding/image/xxx.jpg "
					+ "<br>http://www.xxx.com/test/index.html"
					+ "<br> 	相对于某一位置描述文件或资源的路径称为相对路径"
					+ "<br>相对路径需要一个参考的位置，一般取值为当前资源的访问路径作为参考路径");
			
			//第五组
			
			answer.put("李高山", "1多个Tomcat服务器上运行的是同一个Web应用的多份拷贝，集群服务器之间是同构。"
					+ "			<br>2多个Tomcat服务器上各自运行的一个Web应用的一个模块，分布式服务器之间是异构的。");
			answer.put("赵亚文", "1 Basically Available 基本可用：支持分区失败(e.g. sharding碎片划分数据库)"
					+ "			<br>2 Soft state软状态：状态可以有一段时间不同步，异步。"
					+ "			<br>3 Eventually consistent 最终一致：最终数据是一致的就可以了，而不是时时高一致。");
			answer.put("简巍巍", "1 乐观锁：对当前环境的判断是：发生碰撞的几率很小，可以在操作前假设不会发生碰撞，不锁定数据，以达到更好的性能。万一发生了碰撞，放弃自己的操作，不会导致数据不一致。"
					+ "			<br>2 悲观锁：对当前环境的判断是：很有可能发生碰撞，所以操作前需要给数据加锁，避免数据不一致情况。"
					+ "			<br>3 Redis采取的是乐观锁的策略。因为Redis大部分应用场景是扮演缓存的角色，写操作相对少，碰撞的几率相对低。所以可以通过采用乐观锁策略已到达更好性能。");
			answer.put("叶东成", "tail &emsp;-f 加文件名  Ctrl+c退出");
			answer.put("郑桂春", "1 vim 文件名 #编辑方式查看，可修改"
					+ "			<br>2 cat 文件名 #显示全部文件内容"
					+ "			<br>3 more 文件名 #分页显示文件内容"
					+ "			<br>4 less 文件名 #与 more 相似，更好的是可以往前翻页"
					+ "			<br>5 tail 文件名 #仅查看尾部，还可以指定行数"
					+ "			<br>6 head 文件名 #仅查看头部,还可以指定行数");
			answer.put("施勇强", "find &emsp;  dir1 &emsp; -name &emsp; *.jpg"
					+ "			<br>&emsp;-name：指定字符串作为寻找文件或目录的范本样式");
			answer.put("魏守强", "1 RDB优势：适合大规模的数据恢复，速度较快"
					+ "			<br>2 RDB劣势：会丢失最后一次快照后的所有修改，不能绝对保证数据的高度一致性和完整性。Fork的时候，内存中的数据被克隆了一份，大致2倍的膨胀性需要考虑，但上述成立有条件，Linux也有优化手段"
					+ "			<br>3 AOF优势：选择appendfsync always方式运行时理论上能够做到数据完整一致，但此时性能又不好。文件内容具备一定可读性，能够用来分析Redis工作情况。"
					+ "			<br>4 AOF劣势：持久化相同的数据，文件体积比RDB大，恢复速度比RDB慢。效率在同步写入时低于RDB，不同步写入时与RDB相同。");
			answer.put("杨梦恒", "一般模式，编辑模式（输入“i/I或a/A或o/O或r/R”），指令模式（输入“:或/或？”）");
			answer.put("周盼", "zset类型，set类型，hash类型，list类型，string类型");
			answer.put("唐骏", "1 Redis为了达到最快的读写速度将数据都读到内存中"
					+ "			<br>2 并通过异步的方式将数据写入磁盘。所以redis具有快速和数据持久化的特征"
					+ "			<br>3 如果不将数据放在内存中，磁盘I/O速度为严重影响redis的性能");
			
			//第六组
			
			answer.put("龙绪昊", "1 RepositoryService 	&emsp;提供了部署，删除，读取流程资源等功能"
						+ "		<br>2 RuntimeService	&emsp;提供了启动流程、查询流程实例、设置获取流程实例变量等功能"
						+ "		<br>3 TaskService	&emsp;提供了运行时任务查询、领取、完成、删除以及变量设置等功能"
						+ "		<br>4 HistoryService	&emsp;提供了获取正在运行或已经完成的流程实例的信息的功能");
			answer.put("沈章东", "程序的所有自动配置都是从@SpringBootApplication引入的，它了三个重要的注解"
						+ "		1 @EnableAutoConfiguration用来启动自动配置，并将导入一些自动配置的类定义"
						+ "		<br>2 @ComponentScan将扫描和加载应用中的一些自定义的类"
						+ "		<br>3 @SpringBootConfiguration表明一个这个类提供了Spring配置"
						+ "		<br>4 @EnableAutoConfiguration类中引用了SpringFactoriesLoader"
						+ "		<br>5 SpringFactoriesLoader会查询META-INF/spring.factories文件中包含的JAR文件名称，这些 JAR 文件都是包含了配置信息的配置类"
						+ "		<br>6 SpringFactoriesLoader进行逐个自动配置，将这些类加载到容器中。"
						+ "		<br>7 同时在装载一个类的配置时，首先读取项目中的配置，只有在项目中没有相关配置的时候才启用配置的默认值。");
			answer.put("陈和伟", "1 Spring Cloud中采用的是Hystrix断路器"
					+ "			<br>2 对特定服务调用的不可用达到一个阀值（Hystric 是5秒20次） 时断路器将会被打开，之后的请求就不会请求到该服务节点"
					+ "			<br>3 避免由于单个节点出现故障导致的连锁故障");
			answer.put("李明珠", "1 表现层：SpringMVC	<br>2 业务层：Spring	<br>3 持久化层框架：Mybatis		<br>4 权限模型：RBAC	<br>5 JS框架：JQuery		<br>6 前端框架：Bootstrap		<br>7 流程框架：Activiti5		<br>8 分布式框架：SpringBoot SpringCloud");
			answer.put("狄沈栋", "1 SpringBoot简化了框架的使用	<br>2 简化了Spring众多框架中所需的大量且繁琐的配置文件		<br>3 能够自动添加一些常用依赖");
			answer.put("潘超", "1 spring-boot-starter-web 嵌入tomcat和web开发需要servlet与jsp支持"
					 + "		<br>2 spring-boot-starter-data-redis redis数据库支持"
					 + "		<br>3 mybatis-spring-boot-starter 第三方的mybatis集成starter"
					 + "		<br>4 spring-boot-starter-freemarker freemarker模板引擎"
					 + "		<br>5 spring-cloud-starter-eureka eureka 服务发现和注册服务"
					 + "		<br>6 spring-cloud-starter-zookeeper-discovery zookeeper 集群服务"
					 + "		<br>7 spring-cloud-starter-feign feign 远程方法调用"
					 + "		<br>8 spring-cloud-starter-hystrix hystrix 熔断器");
			answer.put("柯欲文", "通过 Maven 引入 spring-boot-devtools 依赖即可");
			answer.put("吴才进", "1 条件语法：<#if condition>...condition是条件	<#elseif condition2>...<#elseif condition3>...<#else>...</#if>"
					+ "		<br>2 循环语法：<#list users as user></#list>users代表循环的集合 user代表循环的元素	"
					+ "		<br>3 获取对象属性：${user.name}"
					+ "		<br>4 获取索引：${user_index}");
			answer.put("曹庭建", "1 排它网关		<br>2 并行网关		<br>3 包含网关");
			answer.put("刘云志", "1 服务在发布时通过配置文件指定对应的服务名和注册中心地址，将服务注册到注册中心（eureka或者zookeeper）"
					+ "<br>2 调用方法：传递服务名称通过注册中心获取所有的可用实例 通过负载均衡策略调用（ribbon和feign）对应的服务");
			
			//第七组
			
			answer.put("陈雅文", "1 读已提交 (read-uncommitted)<br>T1事务在T2事务尚未提交时读取T2所修改的数据，不能解决任何并发问题"
					+ "			<br>2 读未提交 (read-committed)<br>T1事务要读取一个数据，T2事务要修改这个数据，T1要等到T2提交后才读取。可以避免脏读的并发问题。"
					+ "			<br>3 可重复读 (repeatable-read)<br>T1事务要求在自己执行期间，多次读取同一个数据时，数据保持不变。需要把数据锁定。能够避免脏读和不可重复读的并发问题。"
					+ "			<br>4 串行化 (serializable)<br>T1事务执行期间整个表锁定，能够避免脏读、不可重复读和幻读问题，但是性能低下。");
			answer.put("范博文", "1 DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());"
					+ "			<br>2 System.setProperty(\"jdbc.drivers\", \"com.microsoft.sqlserver.jdbc.SQLServerDriver\");"
					+ "			<br>3 Class.forName(\"com.microsoft.sqlserver.jdbc.SQLServerDriver\");");
			answer.put("覃田爽", "1 主键约束相当于唯一约束+非空约束的组合，主键约束列不允许重复，也不允许出现空值。<br>"
					+ "			<br>2 如果是多列组合的主键约束，那么这些列都不允许为空值，并且组合的值不允许重复。<br>"
					+ "			<br>3 每个表最多只允许一个主键，建立主键约束可以在列级别创建，也可以在表级别上创建。<br>"
					+ "			<br>4 MySQL的主键名总是PRIMARY，当创建主键约束时，系统默认会在所在的列建立索引<br>");
			answer.put("王国华", "1 脏读 事务A读取了事务B更新的数据，然后B回滚操作，那么A读取到的数据是脏数据"
					+ "			<br>2 幻读系统管理员A将数据库中所有学生的成绩从具体分数改为ABCDE等级，但是系统管理员B就在这个时候插入了一条具体分数的记录，当系统管理员A改结束后发现还有一条记录没有改过来，就好像发生了幻觉一样，这就叫幻读。"
					+ "			<br>3 不可重复读 事务 A 多次读取同一数据，事务 B 在事务A多次读取的过程中，对数据作了更新并提交，导致事务A多次读取同一数据时，结果 不一致。");
			answer.put("李俊元", "1 根据部门id分组，得到平均工资大于8000的部门id和该部门的最高工资，需要按部门id降序显示，每页显示2个数据。"
					+ "		<br>2 正确的SQL：	"
					+ "		<br>&emsp;SELECT department_id,MAX(salary)"
					+ "		<br>&emsp;FROM employees	GROUP BY department_id"
					+ "		<br>&emsp;HAVING AVG(salary) >= 8000"
					+ "		<br>&emsp;ORDER BY department_id DESC"
					+ "		<br>&emsp;LIMIT 2");
			answer.put("陈欢", "1 使用#{ param1 }、#{param2}..#{paramN}"
					+ "			<br>2 使用@Param注解的方式命名参数");
			answer.put("黄远鹏", "1 #将传入的数据都当成一个字符串，会对传入的数据自动加上引号；最终交给JDBC处理时会转化成“?”占位符<br>2 $将传入的数据直接显示生成在SQL中。<br>3 使用$占位符可能会导致SQL注射攻击，能用#的地方就不要使用$，写order by子句的时候应该用$而不是#。");
			answer.put("周云飞", "1 #将传入的数据都当成一个字符串，会对自动传入的数据加一个双引号。能够很大程度防止sql注入。"
					+ "			<br>2 $将传入的数据直接显示生成在sql中。一般用于传入数据库对象");
			answer.put("孟贤", "1 if和where	<br>2 choose（when，otherwise）<br>	3 trim	<br>4 set	<br>5 foreach");
			answer.put("赵东", "1 Union：对两个结果集进行并集操作，不包括重复行，同时进行默认规则的排序 <br>"
					+ "		<br>2 Union All：对两个结果集进行并集操作，包括重复行，不进行排序");
			
			
			String key = tf.getText();
			JFrame quest = new JFrame(key+"的答案");
			quest.setSize(400, 300);
			String ans = "<html>"+answer.get(key)+"</html>";
			JLabel label = new JLabel(ans,JLabel.CENTER);
			label.setSize(500,500);
			label.setFont(new java.awt.Font("Dialog", 1, 15));
			
			quest.add(label);
			quest.setLocationRelativeTo(null);
			quest.setVisible(true);
		}
		if(obj == randomButton5) {
			String key = tf.getText();
			int i = JOptionPane.showConfirmDialog(null, "你确定要删除"+key+"的题库吗?", "警告",JOptionPane.YES_NO_OPTION);
			//点击是i为0，否为1
			if(i == 0) {
				name.remove(key);
				length = length -1;
				JOptionPane.showMessageDialog(null, "删除成功，当前题库还剩"+length+"道题", "提示",JOptionPane.WARNING_MESSAGE); 
			}
		}
		if(obj == randomButton6) {
			JOptionPane.showMessageDialog(null, "当前题库还剩"+length+"道题","提示",JOptionPane.INFORMATION_MESSAGE); 
			//JOptionPane.showMessageDialog(null, "当前题库还剩"+length+"道题", "提示",JOptionPane.WARNING_MESSAGE); 
		}
	}

	public void run() {
		
		while (true) {
			try {
				if (!flag) {
					synchronized (this) {
						this.wait();
					}
				}
				Random myRandomName = new Random();
				int RN = myRandomName.nextInt(length);
				tf.setText(name.get(RN));
				Thread.sleep(1);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		Randomly rn = new Randomly();
		Thread t1 = new Thread(rn);
		t1.start();
	}
}