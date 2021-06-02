### Java核心技术（进阶）

#### 第一章节 Maven

##### 第一节 构建工具  

+ 求两个整数的最大公约数
  + 辗转相除法
  + 已有的第三方库 Apache Commons Math中现成函数 API ArithmeticUtils
    + 传统方法：下载jar包——导入jar包（工作量大且不易）
    + *Maven方法* ： 自动甄别和下载第三方库，完成整个项目编译，完成整个项目单元测试流程，完成项目打包（调用jar.exe）
    + 当前的主要Java构建工具
      + **Maven**，Gradle，Ivy，Builder，Ant等

##### 第二节 Maven基础概念和实战

* Maven开发流程
  * 新建Maven项目
  * 在中央仓库（https://mvnrepository.com/）查找第三方jar的依赖文本
  * 拷贝依赖文本至项目的pom.xml
  * Run
* Java project可以convert为一个maven project
* Maven生命周期
  * 清理
  * 编译
  * 测试
  * 打包
  * 安装
  * 部署

#### 第二章节 单元测试和Junit

##### 第一节 单元测试

+ 软件测试**经典定义**：在规定的条件下对程序进行操作，以发现**程序错误**，衡量软件质量，并对其是否能**满足设计要求**进行评估的过程
+ 软件测试分类
  + 单元 vs 集成测试
    1. 单元测试是对软件中**最小可测试单元**进行检查和验证，通常是一个函数/方法，属于白盒测试
    2. 集成测试是对**整体协调性进行测试**
  + 白盒 vs 黑盒测试
    1. 白盒测试全面了解**程序内部逻辑结构**（透明），对所有逻辑路径都进行测试。一般由程序员完成
    2. 黑盒测试又名功能测试（非透明），在完全不考虑程序内部结构和内部特性的情况下，检查程序功能。一般由独立的使用者完成
  + 自动 vs 手动测试
    1. 自动测试：用程序**批量**、**反复**测试程序，并可**自动检查**程序结果是否满足预定的要求
    2. 手动测试：手动执行，手动检查
  + 回归测试
    + 修改旧代码以后，重新进行测试以确认修改没有引入新的错误或者导致其他代码产生错误。
  + 压力测试
+ 单元测试框架比main函数测试策略更好，显示界面更加直观

##### 第二节 Junit

+ Junit：一个Java语言的单元测试框架
+ 测试用例：
  + 给定三个整数，判断以此为边长能否构成三角形
    1. 三个整数均大于零
    2. 任意两边之和大于第三边
  + import static 导入某一个类的所有静态方法
  + Maven可以一次执行多个test

#### 第三章 高级文本处理

##### 第一节 Java字符编码

+ 字符是不可在分割的，计算机依靠二进制组合识别字符
+ 中文编码
  + GB18030（70244个汉字和符号） > GBK > GB2312
+ Unicode（字符集）
  + 目标：不断扩充，存储全世界所有的字符
+ 编码方案
  - UTF-8，兼容ASCII，边长（1-4个字节存储字符），经济，方便传输
  - UTF-16，用变长（2-4个字节）来存储所有字符
  - UTF-32，用 32 bits（4个字节）存储所有字符

##### 第二节 Java国际化编程

+ Java是第一个设计成支持国家化的编程语言
  + java.util.ResourceBundle用于加载一个语言_国家语言包
  + java.util.Local定义一个语言_国家
+ Locale（zh_CN，en_US，...）
  + **语言**，zh，en等
  + **国家/地区**，CN，US等
+ Locale方法
  + getAvailableLocales() 返回所有可用的Locale
  + getDefault() 返回默认的Locale
+ 语言文件
  + 一个Properties文件
  + 包含K-V对，每一个K-V，例如：age = 20
  + 命名规则
    + *包名 + 语言 + 国家地区.Properties*
    + message.Properties
    + message_zh.Properties
    + message_zh_CN.Properties
  + 根据key找value的查找路径
    + 先找指定语言再找默认语言，最后找包名

##### 第三节 正则表达式

+ 如何认定一个字符串满足一定的规律

+ 正则表达式

  + 规则表达式，计算机科学的一个基础概念
  + **用事先定义好的一些特定字符、及这些特定字符的组合，组成一个“规则字符串”**
  + ^[A-Za-z]+$，代表一个字符串，只能由26英文字母组成
  + 作用
    1. 测试字符串内的模式
    2. 识别/替换文本
    3. 提取文本
  + 正则表达式独立于特定的编程语言
  + 正则表达式的匹配模板
    + 定界符
    + 原子
    + 特殊功能字符（元字符）
    + 模式修正符

  ---

  + Java的正则表达式
    + java.util.regex包
      + **Pattern**正则表达式的编译表示
        + compile——编译一个正则表达式为Pattern对象
        + matcher——用Pattern对象匹配一个字符串，返回匹配结果
      + Matcher
        + Index Methods（位置方法）	// start()	start(int group)	end()	end(int group)
        + Study Methods（查找方法)      // lookingAt()    find()    find(int start)    matches()
        + Replacement Methods（替换方法）    // replaceAll(String replacement) 

---

+ 其他字符串操作

  + 字符串和集合互转

  + 字符串转义

    + 对关键字符进行转义 “  ''  ”

    + ```java
      String str = "He didn't say, \"Stop!\"";
      String escapedStr = StringEscapedUtils.escapeJava(str);
      System.out.println(escapedStr);//结果是带斜杠的
      
      String str2 = StringEscapedUtils.unescapeJava(escapedStr);
      System.out.println(str2);//结果是不带斜杠的
      ```

  + 变量名字格式化

    + 名字驼峰命名

    + ```java
      //基于Google Guava下的驼峰命名
      String s1 = "CONSTANT_NAME";
      String s2 = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL,s1);
      System.out.println(s2);//constantName
      ```
  
  
  + 字符串输入流
    + 将字符串转为一个输入流
  
    + ```java
      public static void main(String[] args) {
              //构造字符串列表
              List<String> names = new LinkedList<String>();
              names.add("Xiaohong");
              names.add("Xiaoming");
              names.add("Daming");
              names.add("Xiaohei");
      
              //合并为一个字符串，以逗号相连
              String nameStr = String.join(",",names);
      
              //将字符串作为默认的输入流
              InputStream in = IOUtils.toInputStream(nameStr, Charsets.toCharset("UTF-8"));
              //重置系统的输入流
              System.setIn(in);
      
              //模拟键盘输入，OJ平台测试用例的原理
              //此处也可以换为一个文件输入流
              Scanner input = new Scanner(System.in);
              input.useDelimiter(",");
              while (input.hasNext()) {
                  System.out.println(input.next());
              }
          }
      ```

#### 第四章 高级文件处理

##### 第一节 XML简介

+ 为什么需要XML
  + 数据是主体
  + 单独的数据含义很模糊
  + 数据 + 含义，适用于传输数据，而不是显示数据（HTML）
+ XML
  + 可扩展标记语言：意义 + 数据
  + 标签可以自行定义，具有自我描述性
  + 纯文本表示，跨系统 / 平台 / 语言
+ 常规语法
  + 任何起始标签都有一个结束标签
  + 简化写法，<name> </name> ——> </name>
  + 大小写敏感
  + 每个文件都有一个根元素
  + 标签必须按合适的顺序进行嵌套，不可错位
  + 所有特性必须有值，且在值的周围加上引号
  + 需要转义字符，如 “ < ” 需要用 “ `&lt;` ”代替
  + 注释：<!--注释内容-->
+ DTD（Document Type Definition）
  + 定义XML文档的结构
  + 使用一系列合法的元素来定义文档结构
  + 可嵌套在xml文档中，或者在xml中引用
+ XML Schema（XSD，XML Schema Definition）
  + 定义XML文档的结构，DTD的继任者
  + 支持数据类型，可扩展，功能更强大、完善
  + 采用xml编写
+ XSL
  + 扩展样式表语言
  + XSL作用于XML，等同于CSS作用于HTML
  + 内容
    1. XSLT：转换XML文档
    2. X Path：在XML文档中导航
    3. XSL-FO：格式化XML文档

##### 第二节 XML解析（DOM方法）

+ XML解析

  + XML解析方法
    + 树结构
      + DOM： Document Object Model 文档对象模型，**擅长小规模读写**
    + 流结构
      + SAX： Simple API for XML 流机制解释器（推模式），擅长读
      + Stax： The Streaming API for XML 流机制解释器（拉模式），擅长读，JDK6引入

+ DOM是 W3C 处理 XML 的标准 API

  + 直观易用

  + 其处理方式是将XML整个作为类似树结构的方式读入内存中以便操作

  + 解析大数据量的XML文件，会遇到**内存泄漏及程序崩溃**的风险

  + DocumentBuilder 解析类，parse 方法

  + Node 节点主接口，getChildNodes返回上一个NodeList（返回所有子节点）

  + NodeList节点列表，每个元素是一个Node

  + Document 文档根节点

  + Element 标签节点元素（每一个标签都是标签节点）

  + Text 节点（包含在XML元素内的，都算Text节点）

  + Attribute 节点 （每个属性节点）

  + ```java
    //写XML文档主要流程
    Element text = document.creatElement("text");	//创建平级节点
    object.appendChild(text);	//表示把text挂在object的下面，即object成为text的父节点
    
    TransformerFactory transformerfactory = TransformerFactory.newInstance();
    Transformer transformer = transformerfactory.newTransformer();
    DOMsource source = new DOMsource();
    
    //定义目标文件
    File file = new File("dom_result.xml");
    StreamResult result = new StreamResult(file);
    
    //将XML内容写入到文件
    transformer.transform(source, result);
    ```

##### 第三节 XML解析（SAX方法）

+ Simple API for XML
  + 采用事件 / 流模型来解析XML文档，**更快速、更轻量**
  + 有选择的解析和访问，不像DOM加载整个文档，**内存要求较低**
  + SAX对XML文档的解析为一次性读取，不创建 / 不存储文档对象，**很难同时访问文档中的多处数据**
  + 推模型。当它每发现一个节点就引发一个事件，而我们需要编写这些事件的处理程序。关键类：DefaultHandler

##### 第四节 XML解析（Stax方法）

+ Streaming API for XML
  + 流模型中的拉模型
  + 在遍历文档的时候，会把感兴趣的部分从读取器中拉出，不需要引发事件，允许我们选择性的处理节点。**大大提高了灵活性以及整体效率。**
  + 两套处理API
    + 基于指针的API，XMLStreamReader
    + 基于迭代器的API，XMLEventReader

##### 第五节 JSON简介及解析

+ JSON
  + JavaScript Object Notation，JS对象表示法
  + 是一种轻量级的数据交换格式
  + 类似XML，更小、更快、更易解析
  + 最早用于JavaScript中，容易解析，最后推广到全语言
  + 尽管使用JavaScript语言，但是**独立于编程语言**
+ JSON Object：名称 / 值对
  + JSON对象：{"name" : "Jo", "email" : "a@b.com"}
  + 数值在键值对中
  + 数据由逗号分隔
  + 花括号保存对象
+ JSON数组
  + 方括号保存数组
  + [{"name" : "Jo", "email" : "a@b.com"}, {"name" : "Jo", "email" : "a@b.com"}]

+ **Java的JSON处理**

  + org.json： JSON官方推荐的解析类
    + 简单易用，通用性强
    + 复杂功能欠缺**（放数据的过程艰难且复杂）**
    + 往里放不需要考虑数据类型，往外拿需要考虑数据类型
    
  + GSON： Google 出品
    + 基于反射，可以实现JSON对象，JSON字符串和Java对象互转
    
    + ```java
      //从一个对象变成一个JSON字符串
      //省略了org包的复杂的"放"过程
      Gson gson = new Gson();
      String s = gson.toJson(p);//p是一个Person的实例化对象
      System.out.println(s);//输出单个对象
      
      //从JSON字符串到Java对象
      Person p2 = gson.fromJson(s, Person.class);
      System.out.println(p2.getName());
      System.out.println(p2.getAge());
      System.out.println(p2.getScores());
      
      //调用GSON的JsonObject
      JsonObject json = gson.toJsonTree(p).getAsJsonObject();//将整个json解析为一棵树
      System.out.println(json.get("name"));
      System.out.println(json.get("age"));
      System.out.println(json.get("scores"));
      
      //GSON处理文件
      Gson gson = new Gson();
      File file = new File("books2.json");
      
      try(FileReader reader = new FileReader(file)) {
          List<Book> books = 	gson.fromJson(reader, new TypeToken<List<Book>>(){}.getType());
          
          for(Book book : books) {
              System.out.println(book.getAuthor + ", " + book.getTitle());
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
      ```
    
      
    
  + Jackson：号称最快的JSON处理器

    + 简单易用，社区更新和发布速度比较快

+ **JSON主要用途**
  + JSON生成
  + JSON解析
  + JSON校验
  + 和Java Bean对象进行互解析
    + 具有一个无参构造函数
    + 可以包括多个属性，所有属性都是private
    + 每个属性都有相应的Getter / Setter方法
    + Java Bean用于封装数据，又可称为POJO（Plain Old Java Object） 
+ JSON和XML比较
  + 都是数据交换格式，可读性强，可扩展性高。																						
  + 大部分情况下，JSON更具优势（编码简单，转换方便），而且JSON字符长度一般小于XML，传输效率更高
  + **XML更加注重标签和顺序**
  + **JSON会丢失信息**

##### 第六节 图形图像简介与解析

+ **图形图像基础概念**
  + 图形：Graph
    + 矢量图：根据几何特性来画的，比如点、直线、弧线等
  + 图像
    + 由像素点组成
    + 格式：jpg  png  bmp  svg  wmf  gif  tiff  等
    + 颜色：RGB
+ **Java图像关键类**
  + 图形：Graph
    + java.awt 包
    + Java 2D 库：Graphics2D，Line2D，Rectangle2D，Ellipse2D，Arc2D
    + Color，Stroke
  + 图像：Image
    + javax.imageio包
    + ImageIO，BufferedImage，ImageReader，ImageWriter
  + ![](F:\School\Notebook\pics\Java图像关键类.png)
+ **Java图像关键类描述**
  + Java原生支持**jpg，png**，bmp，wbmp，gif
  
  + javax.imageio.ImageIO
    + 自动封装多种ImageReader和ImageWriter，读写图像文件
    + read读取图片write写图片
    
  + java.awt.image.BufferedImage，图像在内存中的表示类
    + getHeight获取高度
    + getWidth获取宽度
    
  + 图像文件 读写 / 截取 / 合并
  
  + ```java
    	//不指定格式读图
        public static void readAndWrite() throws Exception {
            BufferedImage image = ImageIO.read(new File("F:/School/Notebook/pics/four_girls.jpg"));
            System.out.println("Height：" + image.getHeight());
            System.out.println("Width：" + image.getWidth());
            ImageIO.write(image, "png", new File("F:/School/Notebook/pics/four_girls_new.png"));
        }
    
        //指定格式读图
        public static void readComparison() throws Exception {
            System.out.println("============速度加载测试============");
    
            //ImageIO需要测试图片的类型，加载合适的ImageReader来读取图片，耗时更长
            long startTime = System.nanoTime();
            BufferedImage image = ImageIO.read(new File("F:/School/Notebook/pics/four_girls.jpg"));
            System.out.println("Height：" + image.getHeight());
            System.out.println("Width：" + image.getWidth());
            long endTime = System.nanoTime();
            System.out.println((endTime - startTime) / 1000000.0 + "毫秒");
    
            //指定用jpg Reader来加载，速度会快很多
            startTime = System.nanoTime();
            Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
            ImageReader reader = readers.next();
            System.out.println(reader.getClass().getName());
            ImageInputStream iis = ImageIO.createImageInputStream(new File("F:/School/Notebook/pics/four_girls.jpg"));
            reader.setInput(iis, true);
            System.out.println("Height：" + image.getHeight());
            System.out.println("Width：" + image.getWidth());
            endTime = System.nanoTime();
            System.out.println((endTime - startTime) / 1000000.0 + "毫秒");
        }
    
        //抠图
        public static void cropImage(String fromPth, String toPath, int x, int y, int width, int height
                , String readImageFormat, String writeImageFormat) throws Exception {
            FileInputStream fis = null;
            ImageInputStream iis = null;
            try {
                //读取原始图片文件
                fis = new FileInputStream(fromPth);
                Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(readImageFormat);
                ImageReader reader = it.next();
                iis = ImageIO.createImageInputStream(fis);
                reader.setInput(iis, true);
    
                //定义一个矩形，并放入切割参数中
                ImageReadParam param = reader.getDefaultReadParam();
                Rectangle rectangle = new Rectangle(x, y, width, height);
                param.setSourceRegion(rectangle);
    
                //从源文件读取一个矩形大小的图像
                BufferedImage bi = reader.read(0, param);
    
                //写入到目标文件
                ImageIO.write(bi, writeImageFormat, new File(toPath));
            } finally {
                assert fis != null;
                fis.close();
                assert iis != null;
                iis.close();
            }
        }
    
        //水平拼接图片
        public static void combineImageHorizontally(String firstPath, String secondPath, String imageFormat, String toPath) {
            try {
                //读第一张图
                File first = new File(firstPath);
                BufferedImage imageOne = ImageIO.read(first);
                int width1 = imageOne.getWidth();
                int height1 = imageOne.getHeight();
                //从第一张图片中读取RGB
                int[] firstRGB = new int[width1 * height1];
                firstRGB = imageOne.getRGB(0, 0, width1, height1, firstRGB, 0, width1);
    
                //对第二张图片相同处理
                File second = new File(secondPath);
                BufferedImage imageTwo = ImageIO.read(second);
                int width2 = imageTwo.getWidth();
                int height2 = imageTwo.getHeight();
                int[] secondRGB = new int[width2 * height2];
                secondRGB = imageTwo.getRGB(0, 0, width2, height2, firstRGB, 0, width2);
    
                //生成新图片
                int height3 = Math.max(height1, height2);
                int width3 = width1 + width2;
                BufferedImage imageNew = new BufferedImage(width3, height3, BufferedImage.TYPE_INT_RGB);
    
                //设置左半部分RGB，从（0，0）开始
                imageNew.setRGB(0, 0, width1, height1, firstRGB, 0, width1);
                //设置右半部分RGB，从（width1，0）开始
                imageNew.setRGB(width1, 0, width2, height2, secondRGB, 0, width2);
    
                //保存图片
                ImageIO.write(imageNew, imageFormat, new File(toPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    ```
  
  + 验证码生成
  
    + 验证码，一个图片文件
  
      + 外框
      + 底色
      + 干扰线
        + 随机产生的一些直线
      + 字母
        + 字母选择，不要0，o，1，i，l
        + 字母颜色（RGB）
        + 字母位置
  
    + ```java
      public static void generateCode(String filePath) throws IOException {
              //定义验证码图片框
              int width = 80;
              int height = 32;
              BufferedImage buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      
              //定义图片上的图形和干扰线
              Graphics2D gd = buffImg.createGraphics();
              gd.setColor(Color.LIGHT_GRAY);      //图像为浅灰色
              gd.fillRect(0, 0, width, height);
              gd.setColor(Color.BLACK);           //画边框
              gd.drawRect(0, 0, width - 1, height - 1);
              //随机产生16条灰色干扰线，使图像中认证码不易识别
              gd.setColor(Color.GRAY);
              //创建一个随机数生成器类，用于随机产生干扰线
              Random random = new Random();
              for (int i = 0; i < 16; i++) {
                  int x = random.nextInt(width);
                  int y = random.nextInt(height);
                  int x1 = random.nextInt(12);
                  int y1 = random.nextInt(12);
                  gd.drawLine(x, y, x + x1, y + y1);
              }
      
              //计算字的坐标位置
              int codeCount = 4;//字符个数
              int fontHeight;//字体高度
              int codeX;//第一个字符的X坐标，因为后面的字符坐标依次递增，所以他们的x轴值是codeX的
              int codeY;//验证字符的Y坐标，因为并排所以一致
              //width - 4 除去左右多余的位置，使验证码显示更集中
              //codeCount + 1等比分配显示的宽度，包括左右两边的空格
              codeX = (width - 4) / (codeCount + 1);
              fontHeight = height - 10;
              codeY = height - 7;
      
              //创建字体，字体大小依图片高度决定
              Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
              gd.setFont(font);
      
              //随机产生codeCount数字的验证码
              for (int i = 0; i < codeCount; i++) {
                  //每次随机拿一个字母，赋予随机的颜色
                  String strRand = String.valueOf(codeSequence[random.nextInt(charNum)]);
                  int red = random.nextInt(255);
                  int green = random.nextInt(255);
                  int blue = random.nextInt(255);
                  gd.setColor(new Color(red, green, blue));
                  gd.drawString(strRand, (i + 1) * codeX, codeY);
              }
              ImageIO.write(buffImg, "jpg", new File(filePath));
          }
      ```
  
  + 统计图生成
  
    + 柱状图 / 饼图 / 折线图
    + Java原生的 Graphics2D 可以画，比较繁琐
    + 基于 jFreeChart 可以快速实现统计图的生成
      + 设定数据集
      + 调用ChartFactory生产图形

##### 第七节 条形码和二维码

+ 条形码（barcode）

  + 将宽度不等的多个黑条和白条，按照一定的编码规则排列，用以表达一组信息的图形标识符
  + <font color = #FF0000>通常代表一串字母 / 数字，每一位有特殊含义</font>
  + 一般数据容量30个字母 / 数字
  + 专门机构管理：中国物品编码中心

+ 二维码，二维条形码

  + 用某种特定的几何图案按一定的规律在平面（二维方向上）分布的黑白相间的图形记录数据符号信息
    + 比一维条形码能存更多信息，表示更多数据类型
    + 能够存储数字、字母、汉字、图片等信息
    + 字符集128个字符
    + 可存储几百到几十KB字符
    + 抗损坏

  ---

+ Zxing（Zebra Crossing）

  + Google出品
  + 支持1D和2D的Barcode
  + 主要类
    1. BitMatrix 位图矩阵
    2. MultiFormatWriter 位图编辑器
    3. MtrixToImageWriter 写入图片

<img src="C:\Users\86151\AppData\Roaming\Typora\typora-user-images\image-20210601211002564.png" alt="image-20210601211002564" style="zoom: 67%;" />

​	
