﻿# Java大作业实验报告
## 一、游戏简介

***葫芦娃救爷爷***
---
1. 游戏背景
这是一个很久很久以前，发生的故事
葫芦娃啊，为了救爷爷，然后一个一个去找妖精单挑，然后就一去不复返了。当然正义最终要打败邪恶，所以这次游戏的开始在七个葫芦娃找到了爷爷，但是蛇精和蝎子精发现了，带了一群喽啰要来捉拿他们，战斗一触即发，葫芦娃他们能逃离生天吗？
---
2. 游戏人物
```
```
| 姓名 | 阵营 | 介绍 | 技能 |
|:--:|:--:|:--:|:--:|
|大娃|葫芦娃|老大，红色，翻天掀地，力大无穷。他是七兄弟中的老大哥，生来就是一个大力士，身体可以任意变大或缩小。|游戏中，可以近战，并发射葫芦攻击敌人。|
|二娃|葫芦娃|老二，橙色，慧眼千里，耳闻八方。橙娃天生便拥有一双千里眼和一对顺风耳，妖怪的一切秘密都瞒不住他。|游戏中，可以近战，并发射葫芦攻击敌人。|
|三娃|葫芦娃|老三，黄色，铜头铁臂，刀枪不入。黄娃三弟是个拥有钢筋铁骨的神娃，刀枪箭炮对他丝毫无伤。|游戏中，可以近战，并发射葫芦攻击敌人。|
|四娃|葫芦娃|老四，绿色，炉火纯青，刚阳烈焰。绿娃四弟乃天界火神下凡，可任意吞吐烈火。|游戏中，可以近战，并发射火焰攻击敌人。|
|五娃|葫芦娃|老五，蓝色，惊涛骇浪，气吞山河。青娃五弟乃江河水神转世，可任意吞吐江河之水，难怪吞饮百坛烈酒而不醉。|游戏中，可以近战，并发射水流攻击敌人。|
|六娃|葫芦娃|老六，蓝色，来无影，去无踪。蓝娃六弟是七兄弟中最灵敏，最聪明的。他的隐身法令妖怪束手无策。|游戏中，可以近战，并发射葫芦攻击敌人。|
|七娃|葫芦娃|老七，紫色，镇妖之宝，本领无穷。紫娃七弟自身没多大本事，但他有个宝葫芦，是太上老君修炼仙丹用的紫金神葫。|游戏中，可以近战，并发射葫芦攻击敌人。|
|爷爷|人类|善良勇敢的老爷爷播下葫芦籽，种出七个葫芦娃。|游戏中，可以近战，并发射葫芦攻击敌人。|
|蛇精|妖精|从葫芦山中逃脱的蛇精，法术高强，诡计多端，身有如意、魔镜和刚柔阴阳剑三件宝物，残害众生。|游戏中，可以近战，并发射光波攻击敌人。|
|蝎子精|妖精|蝎子精性情暴虐，武艺高强，但有勇无谋。|游戏中，可以近战，并发射光波攻击敌人。|
|喽啰|妖精|一众小妖|游戏中，可以近战，并发射光波攻击敌人。|
```
```
---
3.  游戏运行
 - 游戏初始：打开游戏，首先看到引导画面，拥有两个按钮——“开始游戏”和“退出游戏”。点击前者进入游戏，开始时，葫芦娃阵营站左边，妖精阵营站右边，两队均呈长蛇阵。此时葫芦娃为随机排列，可以通过点击File菜单中的restart可以改变葫芦娃的排队顺序，实现随机站队。
 - 变换阵型：点击“妖精阵型”和“葫芦娃阵型”两个菜单中点击任意阵型，即可看到画面上对应的阵型变换。
 - 开始运行：点击start或者按键盘SPACE键均可控制游戏开始。一般在真正开始前，我会要求选择存储路径，选择之后，开始游戏，同时记录文件开始记录。两方开始向对方进攻。我为每个Creature设置一个简单的寻找对手的算法，找到最近的对手，开始移动并且发出技能进行远程攻击，直到和对手碰面，双方近战肉搏并随机死亡。一旦在移动过程中中受到远程攻击直接死亡。死后即显示墓碑，有人经过墓碑即消失。直到有一方全部死亡，弹出弹框告知获胜。
 - 游戏回放：战斗结束后可以选择存储的记录文件进行回放，点击open找到刚才存储的路径选择文件，即可回放（目前仅支持人物回放，不支持技能回放）。
 - 重新开始：点击restart可以重新开始下一轮游戏，
 - 版本信息：点击Help菜单中about显示版本和开发者信息
 - 退出游戏：直接点击右上角关闭即可退出。
 ---
```
```
4. 运行效果图：

![葫芦兄弟](https://github.com/njuzyh/CalabashBrothers/blob/9f89cf7eb74552efb30d6c9ecc5761d12efbc3c6/finalProject/Calabash.gif?raw=true)
```
```
 5. 游戏特色
 - 基本功能：
	完成所有要求的基本功能，包括实现战斗记录与回放、增加注解、编写单元测试用例、使用maven进行构建管理等等。
 - 设计思路：
	这个游戏一开始想设计成为一款纯粹的弹幕游戏，通过双方射子弹进行躲避攻击。但是最后依然保留了近战，所以两相结合成了现在的版本。
 - 新的想法：
   - 首先实现了远程攻击，两方通过远程攻击和近战肉搏两种方式进行战斗，更加添加游戏的趣味性。并且给不同人物增加不同的远程攻击技能，包括葫芦、火球、火焰和水波等，增加人物多样性
   - 其次实现了背景音乐，一点击开始游戏，葫芦娃原声大碟带你回到童年，享受打怪的快感。
   - 第三实现了关卡切换，当然这里的关卡主要是指背景切换，主要是图个乐子。
---
## 二、实现说明
### 代码结构
1. #### package GUI

-   class Main是整个工程项目的入口。
-   class StagePageController是JavaFX框架，使用FXML Scene Builder工具的一个控制器，用来显示引导页，并且点击开始游戏时加载CalabashWorldController进入游戏。
-   class CalabashWorldController也是JavaFX框架，使用FXML Scene Builder工具的一个控制器。主要用于处理程序的各种外部事件处理函数以及控制整个游戏的UI刷新。
-   class Battle是自己定义的一个线程，用于开始游戏后的子线程管理和监测，在 CalabashWorldController中产生，控制各个Creature的运行。
2. #### package Field
-   class Position是二维平面坐标，显示具体在平面上的横纵坐标。
-   class Unit是二维平面的基本组成单位，生物体能够放置在Unit上。T其具有一系列接口可以判断该对象上是否存在生物体、移除对象上的生物体、放置生物体等。
-   class BattleMap实现一个由Unit组成的二维平面地图。可以对该对象的某一个具体坐标单元进行操作，可以显示GUI平面和输出普通平面。
- class BattleField是主体类，用于实现双方在其上战斗的相关功能，同时又包含记录和重放的相关接口，并且负责向javafx主线程发送UI刷新信号。
3. #### package Creature
-   class Creature是所有生物体的基类，能够在地图上行走战斗。并且实现了Runnable接口，用于多线程的运行。
-   class Sprite继承于Creature。
-   class CalabashBoy继承于Creature。
-   class Grandpa继承于Creature。
-   class Snake继承于Creature。
-   class Scorpion继承于Creature。
-   class Bullet继承Creature 。新添加的类，作为子弹同样包括Creature的部分属性，所以将其加入子类中。
-   class CalabashBrother是七个CalabashBoy的集合，为了实现排序等功能，所以将其构造进一个类。
-   class Heroes为英雄阵营的集合，包括爷爷和七个葫芦娃。
-   class Monsters为妖怪阵营集合，包括蛇精、蝎子精和一群小喽啰，喽啰数可根据阵型进行调整。
-   Enum Color为颜色，用于构造葫芦娃时进行标记。
-   Interface Queueup为实现摆出阵型的接口，每个阵营类有这个接口，可以摆出相应的阵型。

![Creature](https://github.com/njuzyh/CalabashBrothers/blob/9f89cf7eb74552efb30d6c9ecc5761d12efbc3c6/finalProject/Creature.PNG?raw=true)

4.  #### package Formation
-   class Formation是一个抽象类，并具有抽象接口用于排列阵型。
-   class Changshe继承了Formation类，具体实现了长蛇阵法。
-   class Fangyuan继承了Formation类，具体实现了方圆阵法。
-   class Fengshi继承了Formation类，具体实现了锋矢阵法。
-   class Chonge继承了Formation类，具体实现了冲轭阵法。
-   class Heyi继承了Formation类，具体实现了鹤翼阵法。
-   class Yanxing继承了Formation类，具体实现了雁行阵法。
-   class Yanyue继承了Formation类，具体实现了偃月阵法。
-   class Yulin继承了Formation类，具体实现了鱼鳞阵法。

![Formation](https://github.com/njuzyh/CalabashBrothers/blob/9f89cf7eb74552efb30d6c9ecc5761d12efbc3c6/finalProject/Formation.PNG?raw=true)

#### package Music
-   class MusicPlayer使用AudioClip进行音乐读取和播放，并设置循环播放。
#### package XML
-   class XMLFormat定义了xml文件的基本结构，用于以后实现读写。
-   class FileReader继承XMLFormat类，定义了一些接口，用于BattleField进行文件读取重放。
-   class FileWriter继承XMLFormat类，定义了一些接口，用于BattleField进行文件记录。

![XMLUML](https://github.com/njuzyh/CalabashBrothers/blob/9f89cf7eb74552efb30d6c9ecc5761d12efbc3c6/finalProject/XML.PNG?raw=true)

### 功能实现
####  阵型排列
-   用户可以通过菜单栏中的按钮布置阵型。用户点击按钮后通过按钮的触发事件处理函数，将生物体排列成相应的阵型。妖精和葫芦娃阵型可以单独排队。
#### 战斗功能
-   CalabashWorldController类中有一个成员BattleField newbattle包含了游戏所有的二维空间和生物体们。
-   当用户按下空格后， CalabashWorldController类中的键盘事件处理函数捕捉到该事件，然后通过调用Battle类运行所有的生物体线程。
-   在生物体子线程void run()函数里，生物体会执行while循环，条件自己是否已经死亡或者胜利，在其中会检测对手是否全部死亡，若死亡则胜利。
-   通过Battle类中定义CountDown计数器进行判断，在其不为零时，Battle线程阻塞，直至某一方全部死亡所有生物体子线程结束运行，计数器归零。
-   子线程运行时会在findEnemy和nearstEnemy函数中寻找离该生物体曼哈顿距离最接近的一个敌人作为进攻目标。然后通过执行move函数生成路径进行移动，移动过程中会调用remoteAttack生成Bullet子线程进行远程攻击，如和目标距离只为1，会调用fight函数对附近的敌人进行攻击。
-   如果生物体已经死亡，进程立即结束，该生物体会以墓碑的形式继续存在，直到其他人到达该地，墓碑被清除。
-   最终子线程全部结束，Battle线程通知javafx游戏结束，跳出弹框通知哪一方胜利。
#### 线程安全的实现

-   首先当每个生物线程进行移动和攻击时，对方法加上synchronized锁，对BattleField对象加上锁，这样可以保证一个生物体进程在进行移动和攻击时独享BattleField资源，避免多个生物站上同一位置、多个生物同时杀死某个生物等问题。
-   其次在子线程移动攻击死亡时，会向BattleFiled调用相关函数进行UI刷新。本来我以为可以直接在子线程中进行UI的修改，但在javafx中，并不允许。所有UI的修改必须在Javafx主线程中，所以我才用Platform.runlater将其发送给主线程，进行UI的刷新，这样确实会导致画面的卡顿，但符合了实验的要求，并且更加深入了解了多线程UI刷新。
#### 记录回放
-  在记录文件的选择上我考虑到XML文件结构更加清晰，读写也比较方便，所以使用它。同时使用dom4j的支持，方便代码的编写。
-  当游戏开始时，首先选择记录文件的路径，默认游戏目录，创建xml文件，以及FileWriter对象。并且传给BattleField。然后启动所有生物体线程，当生物线程进行move和attack等操作时，BattleField会调用addRecord使得FileWriter对象记录对应的位置状态信息，然后写入对应的xml文件，实现了记录文件的功能与Creature类的功能分离。
-   进行录像回放时，首先选择打开记录文件，然后将程序游戏控制器的FileReader会根据其创建对象，此时回放考虑到其结果的固定性，我采用Timeline进行动画的实现，由FileReader每隔固定时间读取一轮各个生物的状态进行显示生成动画效果。
-   注意：每个生物体线程是并发进行的，运行时其move等操作都是顺序进行的，记录写入也是固定顺序。回放按照记录写入的顺序依次重现可以实现。
---
### 单元测试
-   使用了JUnit4对Field，Creature等几个模块的部分方法进行了单元测试，内容简单，不详述。
![JUnit Test](https://github.com/njuzyh/CalabashBrothers/blob/9f89cf7eb74552efb30d6c9ecc5761d12efbc3c6/finalProject/test.PNG?raw=true)
---
### 设计原则
#### SRP 单一职责原则
-   在CalabashWorlController里，需要对记录文件和控制子线程运行进行响应，一开始的设计是直接控制器之中里进行文件读写和子线程运行。后来考虑到文件读写的功能和控制子线程运行并不是javafx控制器职责，所以加入了一个XML包和Battle类，XML包中对读写文件操作进行了封装，直接与BattleField进行交互实现读写，而Battle类直接实现控制战斗开始和结束，实现了文件操作、战斗运行和控制器只负责对UI进行响应和刷新功能的分离。

#### OCP 开放封闭原则

- 开放封闭原则是指实体应该对扩展是开放的，对修改是封闭的。即，可扩展，不可修改。应该通过增加代码来扩展功能，而不是修改已经存在的代码。在阵法类的设计体现这条原则：所有阵型抽象成一个abstract class Formation，然后具体的阵型通过继续抽象类Formation，实现其中的抽象方法来获得不同的阵型，但接口保证统一。而生物只能通过Queueup接口选择阵型，不能改变阵型内的具体内容。

#### LSP LISKOV替换法则

-   Creature类的子类CalabashBoy、Sprite、Grandpa、Snake和Scorpion都可以替换程序中的Creature类。实际上在后续操作中，都是用ArrayList来表示生物集合。

#### CARP 合成/聚合复用原则

-   二维地图BattleMap是有一组Unit类合成而来。
-   战场类BattleField类由Creature的子类和BattleMap类聚合而成。
- Monsters由snake、Scorpion、Sprite等聚合。
- Heroes由CalabashBrother、Grandpa聚合。
- CalabashBrother由Calabashboy聚合。
---
### 注解
自定义了一个注解类用来标记编作者网站和版本：

    @Documented  
    @Target(ElementType.TYPE) 
    @Inherited  
    @Retention(RetentionPolicy.RUNTIME) 
    public @interface Author{ 
		String name() default "Zhou Yuhang";  
		String website() default "cn.edu.nju"; 
	    int revision() default 1;   
	}
	      
 调用：
 

    @Author()

## 三、思考总结
通过这学期的JAVA课学习，我真的收获了很多，对于面向对象不再是空洞的名字，而是真的要去实现“面向对象是对现实世界的刻画”。对于并发等等平时接触很少的技术有了新的认识，我还有IOS要接着去体会，感谢曹老板和余老师一学期的辛勤教导，我真的学会了很多，痛哭流涕，，，不！喜极而泣脸。
话说git用的不熟，我还需要继续熟悉一下。

>在绝望中寻找希望，生命终将辉煌。——曹老板

