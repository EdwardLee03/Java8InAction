

Java 8 In Action
================

This repository contains all the source code for the examples and quizzes in the book 
Java 8 in Action: Lambdas, Streams and functional-style programming.
λ演算，数据流操作，函数式编程。

You can purchase the book here: [http://manning.com/urma/](http://manning.com/urma/) or on Amazon

The source code for all examples can be found in the directory [src/main/java/lambdasinaction](https://github.com/java8/Java8InAction/tree/master/src/main/java/lambdasinaction)

* Chapter 1: Java 8: why should you care? / Java 8：你为什么要在乎？
* Chapter 2: Passing code with behavior parameterization / 传递具有参数化行为的代码
* Chapter 3: Lambda expressions / λ表达式、匿名表达式、匿名函数
* Chapter 4: Working with Streams / 数据流操作
* Chapter 5: Processing data with streams / 处理数据流
* Chapter 6: Collecting data with streams / 收集数据流
* Chapter 7: Parallel data processing and performance / 数据并行处理和性能
* Chapter 8: Refactoring, testing, debugging / 重构、测试、调试
* Chapter 9: Default methods / 默认方法
* Chapter 10: Using Optional as a better alternative to null / 使用Optional作为一个更好的null选择
* Chapter 11: CompletableFuture: composable asynchronous programming / CompletableFuture：可组合的异步编程
* Chapter 12: New Date and Time API / 新的日期和时间API
* Chapter 13: Thinking functionally / 功能思考
* Chapter 14: Functional programming techniques / 函数式编程技术
* Chapter 15: Blending OOP and FP: comparing Java 8 and Scala / 混合OOP和FP：比较Java 8和Scala
* Chapter 16: Conclusions and "where next" for Java / 结论和Java的未来
* Appendix A: Miscellaneous language updates / 语言更新
* Appendix B: Miscellaneous library updates / 包更新
* Appendix C: Performing multiple operations in parallel on a Stream / 在数据流上并行执行多个操作
* Appendix D: Lambdas and JVM bytecode / λ表达式和JVM字节码

We will update the repository as we update the book. Stay tuned!

### Make sure to have JDK8 installed
The latest binary can be found here: http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html

$ java -version

java version "1.8.0_05"
Java(TM) SE Runtime Environment (build 1.8.0_05-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.5-b02, mixed mode)


You can download a preview version here: https://jdk8.java.net/

### Compile/Run the examples
Using maven:

$ mvn compile

$ cd target/classes

$ java lambdasinaction/chap1/FilteringApples


Alternatively you can compile the files manually inside the directory src/main/java

You can also import the project in your favorite IDE:
    * In IntelliJ use "File->Open" menu and navigate to the folder where the project resides
    * In Eclipse use "File->Import->Existing Maven Projects" (also modify "Reduntant super interfaces" to report as Warnings instead of Errors
    * In Netbeans use "File->Open Project" menu

