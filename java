1      代码风格
1.1      命名
原则1           为包、类、方法、变量取一个好名字，使代码易于理解

说明：好的命名，有如下特征：

1)   能清晰的表达意图：使用完整的描述性的单词，避免使用单个字母、未形成惯例的缩写来命名。例如int elapsedTimeInDays要比int d好得多；

2)   避免造成误导：有误导的名字比表达不清的名字还要有危害性，比如String accountList其实并不是一个List类型；a=l,是数字1还是字母l？；TTLCONFUSION与TTLC0NFUSION名称太相似；

3)   避免不必要的编解码：代码被人阅读的次数要远远多于计算机，因此要注意可读性，避免不必要的人脑编解码。比如在JAVA中不建议采用匈牙利命名法：Java是强类型语言，且IDE已很先进，在编译前就能及早发现类型错误，因此匈牙利命名法已无用武之地，况且它还有可能导致错误信息，比如PhoneNumber strPhone当类型变更后，名称未变更导致提供错误信息；

4)   能区分出意思：比如以下名称：product，productInfo，productData，表达的意思都差不多，让人从名称并不能区分出它们各自代表的东西到底有什么不同。因此建议不要在变量/类名后加info，data，object等一般意义的词。

5)   不用或少用缩写：小于15个字母的一般不用缩写。超过15个字母的，可采用以去掉元音字母的方法或者行业内约定俗成的缩写，且缩写保持驼峰格式，不要编造不符合惯例的缩写。比如serviceDataPoint，可以缩写为svcDataPnt，不可缩写为SDP。如果要用缩写，仅第一个字母大写其余小写，例如getHTTPRequest改为getHttpRequest。

 

规则1           禁止使用魔鬼数字

说明：直接使用数字，造成代码难以理解，也难以维护。应采用有意义的静态变量或枚举来代替。

          例外情况，有些特殊情况下，如循环或比较时采用数字0，-1，1，这些情况可采用数字。

示例：

不好：int doorState = 5;

         推荐：

         static final int CLOSE = 3;
int doorState = CLOSE;

         enum  Signal
{
GREEN, YELLOW, RED
}
public class TrafficLight
{
Signal color = Signal.RED;
public void change()
{
switch (color)
{
case RED:
color = Signal.GREEN;
break ;
case YELLOW:
color = Signal.RED;
break ;
case GREEN:
color = Signal.YELLOW;
break ;
default:
color = Signal.RED;
}
}
}

 

规则2           常量命名，由全大写单词组成，单词间用下划线分隔，且使用 static final修饰

示例：

不好：static int MAXUSERNUM = 200;
static String s = "Launcher";

推荐：      static final int MAX_USER_NUM = 200;
static final String APPLICATION_NAME = "Launcher";

 

规则3           变量、属性命名，使用名词，并采用首字母小写的驼峰命名法

说明：驼峰命名是指第一个单词字母使用小写，剩余单词首字母大写其余字母小写的大小写混合法。含有集合意义的属性，名称尽量包含复数；

示例：

不好：    String customername;
List<String> u = new ArrayList<string>();

推荐：      String customerName;
List<String> users = new ArrayList<string>();

 

规则4           方法的命名，用动词和动宾结构，并采用首字母小写的驼峰命名法

说明：格式如下

get + 非布尔属性名()

is + 布尔属性名()

set + 属性名()

has + 名词/形容词()

动词()

动词 + 宾语()

其中动词()主要用在动作作用在对象自身上，如document.print()；

示例：

不好：    public String type()
public boolean Finished()
public void visible(boolean)
public void DRAW()
public void KeyListener(Listener)

推荐：      public String getType()
public boolean isFinished()
public void setVisible(boolean)
public void draw()
public void addKeyListener(Listener)

 

规则5           类和接口的命名，采用首字母大写的驼峰命名法

说明：类的命名，不应用动词，而应使用名词，比如Customer，WikiPage，Account，避免采用类似Manager，Processor，Data，Info这样模糊的词。

示例：

不好：    public class info {}	

推荐：      public class OrderInformation {}

 

规则6           包的命名，由一个或若干个单词组成，所有的字母均为小写

说明：包名采用域后缀倒置的加上自定义的包名，采用小写字母，都应该以com.huawei开头（除一些特殊原因），再加上产品名称和模块名称。部门内部应该规划好包名的范围，防止产生冲突。

示例：com.huawei.mobilecontrol.views;

 

建议1           数组声明的时候使用 int[] index，而不要使用 int index[]

说明：例如：int[] index = new index[8];比int index[] = new index[8];看起来更符合人的阅读习惯。

1.2      注释
原则2           尽量用代码来解释自己

说明：我们必须认识到，写注释从某种意义上来说是一种“失败”，是我们无法用代码来解释意图，而必须借助于注释。因此在写注释前，要慎重思考，看能否通过改善代码可读性来避免写注释。

示例：

不好：// Check to see if the employee is eligible for full benefits
if ((employee.flags & HOURLY_FLAG) &&
(employee.age > 65))

推荐：      if (employee.isEligibleForFullBenefits())

 

规则7           注释应解释代码的意图，而不是描述代码怎么做的

说明：如果不得不写注释，那么就要写出好的注释。好的注释能提供有用、额外的信息，能解释代码为什么要这么写，而不是再描述一遍代码是怎么做的。

示例：

不好：下面的注释只是将代码所做的事又描述了一遍，没有提供额外有用的信息 //Utility method that returns when this.closed is true. Throws an exception
//if the timeout is reached.
public synchronized void waitForClose(final long timeoutMillis)
throws Exception
{
if (!closed)
{
wait(timeoutMillis);
if(!closed)throw new Exception("MockResponseSender could not be closed");
}
}

 

规则8           保证注释与代码一致，避免产生误导

说明：注释造成误导，危害性很大，还不如不写。很多误导的产生，并不是有意为之，而是在代码修改的同时没有修改对应的注释造成的。因此，如果写了注释，就要保证注释与代码一致，避免产生误导。如果注释不再有用，必须删除。

 

规则9           注释应与其描述代码位置相邻，放在所注释代码上方或右方，并与代码采用同样缩进

说明：大部分注释应放在代码上方，变量、枚举的注释可选择在代码右方；

示例：

static final int NUMBER_THREAD = 25000;
...
//This is our best attempt to get a race condition
//by creating large number of threads.
for (int i = 0; i < NUMBER_THREAD; i++)
{
WidgetBuilderThread widgetBuilderThread =
new WidgetBuilderThread(widgetBuilder, text, parent, failFlag);
Thread thread = new Thread(widgetBuilderThread);
thread.setName("Widget Builder thread");
thread.start();
}

Image buffer; //定义图像对象
Graphics gContext; //定义图形上下文
Thread animate; //定义一个线程

 

建议2           不要用注释保留废弃代码

说明：用注释保留大量废弃的代码，对阅读是一种干扰。现代的配置管理工具能恢复任意历史时刻的代码，因此不必担心无法恢复。

示例：

         不好：

mModel.reloadIcons();
/* DTS2012052208439 xxxxx end > */
/* < DTS2012052605293 xxxxx begin */
//if (!mModel.isAllAppsLoaded()) {
//ViewGroup appsCustomizeContentParent = (ViewGroup) mAppsCustomizeContent.getParent();
//mInflater.inflate(R.layout.apps_customize_progressbar, appsCustomizeContentParent);
//}
/* DTS2012052605293 xxxxx end > */
// For handling default keys
mDefaultKeySsb = new SpannableStringBuilder();

 

建议3           不要用注释记录修改日志

说明：代码中充斥着大量修改历史信息，使代码难以阅读。现代的配置管理工具能记录每次修改的日志，因此不必将修改日志写在代码中。

示例：

         不好：

/*< DTS20120521072aa xxxxxx begin*/
private boolean mAlreadyShowFinish = false;
private boolean mIsClickEmptySpace = false;
/*DTS20120521072aa xxxxxx end >*/
/*< DTS20120521060aa xxxxxx begin*/
public View itemUnderLongClick  ;
/* DTS20120521060aa xxxxxx end>*/
/*< DTS20120519023aa xxxxxx begin*/
public int DOCK_SIZE_DRAG_BEFORE = 4;
/* DTS20120519023aa xxxxxx end >*/
/*< DTS20120611039aa xxxxxx begin */
public int mWindowWidth;
public int mWindowHeigth;
/* DTS20120611039aa xxxxxx end >*/
/*< DTS20120620052aa xxxxxx begin */

 

建议4           一般单行注释用//，块注释用/* */，JavaDoc注释用/**  */

说明：单行注释用//，比较方便。块注释一般采用/* */，在IDE支持的情况下，如Eclipse可以用ctrl-/快捷键为块增加注释，这种情况下，建议选择//为块增加注释，更方便快捷。JavaDoc对注释格式要求采用/**  */

示例：

/**
* This is the comment for the example interface.
*/
interface Example
{
// This is a long comment with whitespace that should be split in multiple
// line comments in case the line comment formatting is enabled
int foo();
/*
* These possibilities include:
<ul>
  <li>Formatting of header
  * comments.</li>
  <li>Formatting of Javadoc tags</li>
</ul>
*/
int bar(); // This is a short comment
...
}

 

1.3      排版
原则3           团队应遵守一致的排版风格

说明：代码排版在细微处，像审美一样是一个较主观的事情，比如大括号是写在右边，还是独立成行，不同的人有不同的倾向，并无优劣之分。但不统一的排版风格对代码的可阅读性影响很大，因此考虑到团队整体的阅读效率，应把个人喜好放一边，而讨论制定出共同遵守的排版风格。

 

规则10       将排版风格固化到IDE的代码格式化配置文件中，并让整个团队使用

说明：让团队内遵守一致的排版风格，最切实可行和有效率的方式就是大家使用同一个代码格式化配置，让大家在编写代码的同时，用IDE工具自动对代码进行排版。主流的JAVA IDE，如Eclipse, NetBeans, IntelliJ IDEA都支持代码格式化功能。

 

规则11       在不同的概念之间，增加空行

说明：比如方法与方法、类名与import、import与包名之间、相对独立的程序块之间、变量说明后需增加空行，来提升可读性。

示例：

不好：不同概念间没有空行

public void addChild2(String parentId, String value)
{
Entity entity = new entity();
entity.setId(genEntityId());
entity.setValue(value);
Relation relation = new Relation();
relation.setParentId(parentId);
relation.setChildEntityId(entity.getId());
saveChild(entity, relation);
}

 

package fitnesse.wikitext.widgets;
import java.util.regex.*;
public class BoldWidget extends ParentWidget
{
public static final String REGEXP = "'''.+?'''";
private static final Pattern pattern = Pattern.compile(REGEXP,
Pattern.MULTILINE + Pattern.DOTALL);
public BoldWidget(ParentWidget parent, String text) throws Exception
{
super(parent);
Matcher match = pattern.matcher(text);
match.find();
addChildWidgets(match.group(1));}
public String render() throws Exception {
StringBuffer html = new StringBuffer("<b>");
html.append(childHtml()).append("</b>");
return html.toString();
}
}

 

 

推荐：用空行区分不同概念

public void addChild2(String parentId, String value)
{
Entity entity = new entity();
entity.setId(genEntityId());
entity.setValue(value);
Relation relation = new Relation();
relation.setParentId(parentId);
relation.setChildEntityId(entity.getId());
saveChild(entity, relation);
}

package fitnesse.wikitext.widgets;
import java.util.regex.*;
public class BoldWidget extends ParentWidget
{
public static final String REGEXP = "'''.+?'''";
private static final Pattern pattern = Pattern.compile(REGEXP,
Pattern.MULTILINE + Pattern.DOTALL
);
public BoldWidget(ParentWidget parent, String text) throws Exception
{
super(parent);
Matcher match = pattern.matcher(text);
match.find();
addChildWidgets(match.group(1));
}
public String render() throws Exception
{
StringBuffer html = new StringBuffer("<b>");
html.append(childHtml()).append("</b>");
return html.toString();
}
}

 

规则12       将逻辑紧密相关的代码放在一起

说明：将相关的代码，放在一起，阅读代码时能一眼获取相关信息，避免概念的频繁切换。其他还比如，将常量的定义都放在一起，将有调用关系的方法尽量放在一起。

示例：

不好：

public  void  addChild(String parentId, String value)
{
Entity entity = new Entity();
Relation relation = new Relation();
entity.setId(genEntityId());
relation.setChildEntityId(entity.getId());
entity.setValue(value);
relation.setParentId(parentId);
saveChild(entity,  relation);
}

 

推荐：

public  void  addChild(String  parentId,  String  value)
{
Entity entity = new Entity();
entity.setId(genEntityId());
entity.setValue(value);
Relation relation = new Relation();
relation.setParentId(parentId);
relation.setChildEntityId(entity.getId());
saveChild(entity,  relation);
}

 

 

规则13       控制一行的宽度，不要超过120个字符

说明：代码行长度越短，越容易理解。而且代码超出屏幕后，需要横向滚屏，严重影响阅读代码的效率。建议一行最长不超过120个字符。代码行太长，需要折行。折行时应注意语意流畅性，在低优先级操作符处划分新行，划分出的新行要进行适当的缩进，使排版整齐（详见示例）。

示例：

不好：

一行多个语句：String xmlName = "", nodeVal = "";

过长，超过120字符，需要滚屏

不必要的折行

String commandID = Configs.findItemValue(ItemCodes.BIZDEF_HARDCFG,
bizDef);

混乱没有规则的折行

isLogRecode = "".equals(logisticRecodeLog) || null ==  logisticRecodeLog ||
"true".equals(logisticRecodeLog) || "TRUE".
equals(logisticRecodeLog) ||
"YES".equals(logisticRecodeLog)
|| "yes".equals(logisticRecodeLog) ;

        

推荐：

一行一个语句String xmlName = "";
String nodeVal = "";

过长语句合理折行

isLogRecode = "".equals(logisticRecodeLog) || null == logisticRecodeLog
|| "true".equals(logisticRecodeLog) || "TRUE".equals(logisticRecodeLog)
|| "YES".equals(logisticRecodeLog) || "yes".equals(logisticRecodeLog);

 

规则14       在不同的概念间（关键字、变量、操作符等）增加空格，以便清楚区分概念

说明：增加空格，其本质是区分概念，将逻辑相关紧密的部分凸现出来。具体来说在关键字、变量、常量进行对等操作时，它们之间的操作符之前、之后或者前后要加空格；进行非对等操作时，如果是关系密切的立即操作符（如.）和括号，前后不加空格

示例：     

         在“=”、“+=”、“,”的两边加空格，“++”、“.”和“(”前后不加空格。

private void measureLine(String line)
{
lineCount++;
int lineSize = line.length();
totalChars += lineSize;
lineWidthHistogram.addLine(lineSize, lineCount);
recordWidestLine(lineSize);
}

 

规则15       采用缩进来区分不同层次的概念

说明：没有缩进的代码几乎不可阅读。我们采用缩进，来区分不同层次，展现代码的层次关系结构，让代码更容易阅读。具体要求，每加一层大括号，就要加一层缩进。

示例：

         没有缩进的代码很难阅读

public class FitNesseServer implements SocketServer
{
private FitNesseContext context;
public FitNesseServer(FitNesseContext context)
{
this.context = context;
}
public void serve(Socket s)
{
serve(s, 10000);
}
public void serve(Socket s, long requestTimeout)
{
try { FitNesseExpediter sender = new FitNesseExpediter(s, context);
sender.setRequestParsingTimeLimit(requestTimeout);
sender.start();
}
catch(Exception e) {
e.printStackTrace();
}
}
}

 

改成下面就容易阅读多了

public class FitNesseServer implements SocketServer
{
private FitNesseContext context;
public FitNesseServer(FitNesseContext context)
{
this.context = context;
}
public void serve(Socket s)
{
serve(s, 10000);
}
public void serve(Socket s, long requestTimeout)
{
try
{
FitNesseExpediter sender = new FitNesseExpediter(s, context);
sender.setRequestParsingTimeLimit(requestTimeout);
sender.start();
}
catch (Exception e)
{
e.printStackTrace();
}
}
}

 

建议5           将局部变量的作用域最小化

说明：变量的声明应该尽可能靠近变量第一次使用的位置。循环变量的定义，应在循环体内部，不应该定义在循环体外。

示例：

         不好：变量声明离第一次使用的位置过远

public void addChild(String parentId, String value)
{
Relation relation = new Relation();
entity entity = new entity();
entity.setId(genEntityId());
entity.setValue(value);
...
relation.setParentId(parentId);
relation.setChildEntityId(entity.getId());
saveChild(entity, relation);
}

 

推荐：在靠近变量第一次使用处声明变量

public void addChild(String parentId, String value)
{
entity entity = new entity();
entity.setId(genEntityId());
entity.setValue(value);
...
Relation relation = new Relation();
relation.setParentId(parentId);
relation.setChildEntityId(entity.getId());
saveChild(entity, relation);
}

 

         循环变量在循环体内定义

public int countTestCases()
{
int count = 0;
for (Test each : tests)
{
count += each.countTestCases();
}
return count;
}

 

建议6           给if、for、do、while、switch等语句的执行体加大括号{}

说明：即使执行语句只有一条语句，也应该加括号。执行体只有一条语句时，常诱惑我们在一行内写完，但这并不容易阅读，因为大多数程序员习惯了执行体应该有括号，当执行体无括号，需要大脑做不必要的转换。而且这样做，在修改代码时，如果增加执行体语句，也不容易因忘了增加大括号而搞错。

示例：

         不好

if (someCondition) doStart();

推荐

if (someCondition)
{
doStart();
}

 

建议7           控制文件的长度，最好不要超过500行

说明：很多开源项目都表明，文件长度越短，越容易理解和维护。

示例：下图是几个开源项目的代码文件长度分布情况，平均值不超过500行，绝大多数不超过200行。
