# Java学习笔记

## 流程控制

### Scanner

```java
import java.util.Scanner;
Scanner scanner = new Scanner(System.in);
System.out.println("使用next方法接收：");

//判断用户有没有输入字符串
if(scanner.hasnext()){
    String str = scanner.nextLine();
    System.out.println("输出的内容为："+str);
}

//凡是属于IO流的类如果不关闭会一直占用资源，养成好习惯用完就关掉
scanner.close();

```

**next()和nextLine()区别**

![区别](C:\Users\XinLeiWang\Documents\wxl\资料\笔记\java学习笔记\scanner.PNG)

因此常用nextLine().

fori快速输入



## 数组详解 

ArrayIndexOutOfBoundsException：下标越界异常

### 使用

增强循环：可以使用arrays.for快速输入

```java
int[] arrays = {1,2,3,4,5};
for(int array:arrays){
    System.out.print(array+" ");
}
```



### 多维数组

```java
int[][] arrays = {{1,2},{3,4}};
```



### Arrays类 

Java.util.Arrays 

常用方法：

给数组赋值：fill

排序：sort，升序

比较数组：equals比较数组中元素值是否相等

查找数组元素：binarySearch对排序好的数组进行二分查找法操作

### 稀疏数组

稀疏数组长度：原数组非零元素个数+1

首个元素：记录原数组有几行几列几个非零元素

其余元素：记录每个非零元素的行列位置及值



## 常用类
### Integer缓冲区

```java
Integer integer1 = new Integer(100);
Integer integer2 = new Integer(100);
System.out.println(integer1==integer2);//false，因为每个new生成一个新的对象，而比较的是栈中存放的地址，所以false

Integer integer3 = Integer.vauleOf(100);
Integer integer4 = Integer.vauleOf(100);
System.out.println(integer3==integer4);//ture，Integer对象创建时在内存中初始创建了-128~127的数据，如果创建的integer对象值为这个范围之内，则使用缓冲区内的响应数据；

Integer integer5 = Integer.vauleOf(200);
Integer integer6 = Integer.vauleOf(200);
System.out.println(integer5==integer6);//false，超出缓冲区范围
```



### String

字符串是常量，创建后不可改变。不可变性指的是字符串池中创建的字符串本身不会更改，修改时是重新开辟一个空间；

字符串字面值存储在字符串池中，可以共享。





## 集合框架

1、对象的容器，实现了对对象常用的操作，可实现数组的功能。

2、数组长度固定，集合长度不固定

3、数组可以存储基本类型和引用，集合只能引用（想存储基本，可以借助装箱）

### Collection体系结构

collection: list, set

list: ArrayList, LinkedList, Vector

set: HashSet, SortedSet

SortedSet: TreeSet

### Collection父接口

创建集合：

```java
Collection collection = new ArrayList;
```

添加元素

```java
collection.add("apple");
```

删除元素

```java
collection.remove("apple");
collection.clear();
```

遍历元素

```java
//1使用增强for
for (Object object: collection){
    System.out.println(object);
}
//2使用迭代器（迭代器专门用来遍历集合的一种方式）（Iterator有三个方法：hasNext(),next();remove()）
Iterator it = collection.iterator();
while(it.hasNext()){
    String s = (String)it.next();
    System.out.println(s);
    //collection.remove(s);  不能使用collection删除方法，只能使用迭代器的删除方法
    it.remove();
}
```

判断

```java
System.out.println(collection.contains("apple"));
System.out.println(collection.isEmpty());
```

### Collection实际应用

```java
//保存学生信息

Collection collection = new ArrayList();
Student s1 = new Student("张三",29);
Student s2 = new Student("李四",19);
Student s1 = new Student("王五",24);
collection.add(s1);
collection.remove(s1);
collection.remove(new Student("王五",24));//无法删除，因为对象地址不同
collection.cleat();//仅从集合中删除，对象本身仍存在

```



### Lise子接口

特点：有序，有下标，元素可以重复

方法：

void add(int index, Obiect o)

boolean addAll(int index, Collection c)

Object get(int index)

List subList(int fromIndex, int toIndex)	//返回fromIndex和toIndex之间的集合元素

```java
List list = new ArrayList();
List.add("apple");
List.add("xiaomi");
List.add("huawei");
//List.remove("apple");
List.remove(0);
//使用for遍历
for(int i=0;i>list.size;i++){
    System.out.println(list.get(i));
}
//使用增强for
//使用迭代器
Iteraror it=list.iterator;
whine(it.hasNext()){
    System.out.println(it.next());
}
//使用列表迭代器，可以向双方向遍历，可以添加、删除、修改元素
ListIterarot lit=list.listIterator();
whine(lit.hasNext()){
    System.out.println(lit.nextIndex()+":"+lit.next());
}
whine(lit.hasPrevious()){
    System.out.println(lit.previousIndex()+":"+lit.previous());
}
//获取位置
System.out.println(list.getIndex("apple"));
```

### List添加数字数据

```java
List list = new ArrayList();
//添加数字数据（自动装箱）
list.add(20);
list.add(30);
list.add(40);
list.add(50);
list.add(60);
//删除操作，无法直接通过传入数字进行删除，因为list中元素为装箱后的类型
list.remove(0);//通过index删除
list.remove((Object)20);//通过强转为object类型进行删除
list.remove(new Integer(20));//通过创建装箱后的数据进行删除
//返回子集合,含头不含尾
List subList = list.subList(1,3);
```

### List实现类

1、ArrayList【重点】

数组结构实现：查询快，增删慢；

运行效率块，线程不安全。

2、Vetor

数组结构实现：查询快，增删慢；

运行效率慢，线程安全。

3、LinkedList

链表结构实现，增删块，查询慢。



