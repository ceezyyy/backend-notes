# 工厂模式（创建型）

工厂模式分为两种：

- 工厂方法模式
- 抽象工厂模式





Table of Contents
-----------------


* [1. 工厂方法模式](#1-工厂方法模式)
   * [1.1 什么是工厂方法模式？](#11-什么是工厂方法模式)
   * [1.2 为什么要使用工厂方法模式？](#12-为什么要使用工厂方法模式)
   * [1.3 什么时候使用？](#13-什么时候使用)
   * [1.4 Demo](#14-demo)
   * [1.5 依赖倒置](#15-依赖倒置)
* [2. 抽象工厂模式](#2-抽象工厂模式)
   * [2.1 什么是抽象工厂模式？](#21-什么是抽象工厂模式)
   * [2.2 为什么要使用抽象工厂模式？](#22-为什么要使用抽象工厂模式)
   * [2.3 什么时候使用？](#23-什么时候使用)
   * [2.4 Demo](#24-demo)



## 1. 工厂方法模式

### 1.1 什么是工厂方法模式？

工厂方法模式（`Factory method pattern`）是处理在不指定对象具体类型的情况下创建对象的问题

实质是定义一个创建对象的接口，但让实现这个借口的类来决定实例化哪一个类。工厂方法让实例化推迟到子类中进行





### 1.2 为什么要使用工厂方法模式？

**封装细节**

创建一个对象需要复杂的过程，所以不适合包含在一个复合对象中。创建对象可能会导致大量重复代码，可能会需要复合对象访问不到的信息，也可能提供不了足够级别的抽象，还可能并不是复合对象概念的一部分。

举个例子，

当我们需要买一部汽车时，我们关心的只是产品，只需去汽车工厂提一辆车，而并不关心汽车的生产流程以及加工工艺



<div align="center"> <img src="bentley.jpg" width="50%"/> </div><br>



**解耦**

扩展性高，若想增加一个产品，只需扩展一个工厂类即可







### 1.3 什么时候使用？

我们明确地计划不同条件下创建不同实例时



### 1.4 Demo

创建接口

**Shape.java**

```java
public interface Shape {
    void draw();
}
```

创建接口实现的具体类

**Circle.java**

```java
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle here!");
    }
}
```

**Rectangle.java**

```java
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle here!");
    }
}
```

**Triangle.java**

```java
public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Triangle here!");
    }
}
```

创建工厂

**ShapeFactory.java**

```java
public class ShapeFactory {

    public Shape getShape(String typeOfShape) {
        if (typeOfShape == null) {
            return null;
        }
        if (typeOfShape.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (typeOfShape.equalsIgnoreCase("triangle")) {
            return new Triangle();
        } else if (typeOfShape.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }
        return null;
    }
}
```

客户端类

**Client.java**

```java
public class Client {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("circle");  // Circle here!
        circle.draw();

        Shape rectangle = shapeFactory.getShape("rectangle");  // Rectangle here!
        rectangle.draw();

        Shape triangle = shapeFactory.getShape("triangle");  // Triangle here!
        triangle.draw();

    }

}
```



### 1.5 依赖倒置


<div align="center"> <img src="image-20200815170633554.png" width="40%"/> </div><br>

**设计原则：**

要依赖抽象，不要依赖具体类



本例中，

高层组件 `ShapeFactory` 和低层组件 `Rectangle`, `Triangle`, `Circle` 都依赖于抽象类 `Shape`




## 2. 抽象工厂模式

### 2.1 什么是抽象工厂模式？

抽象工厂模式（`Abstract Factory Pattern`）提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体类

简言之，抽象工厂也称为其他工厂的工厂



### 2.2 为什么要使用抽象工厂模式？

详见 1.2



### 2.3 什么时候使用？

系统的产品有多于一个的产品族，而系统只消费其中某一族的产品







### 2.4 Demo

<div align="center"> <img src="afp.jpg" width="80%"/> </div><br>





定义抽象工厂（工厂的工厂）

**AbstractFactory.java**

```java
/**
 * Abstract factory
 */
public interface AbstractFactory {

    // get shape through ShapeFactory
    Shape getShape(String typeOfShape);

    // get color through ColorFactory
    Color getColor(String typeOfColor);

}
```



定义两个工厂：`ColorFactory` 和 `ShapeFactory`

**ColorFactory.java**

```java
/**
 * Color factory
 */
public class ColorFactory implements AbstractFactory {
    @Override
    public Shape getShape(String typeOfShape) {
        return null;
    }

    /**
     * Get color
     *
     * @param typeOfColor
     * @return
     */
    @Override
    public Color getColor(String typeOfColor) {
        if (typeOfColor.equalsIgnoreCase("grey")) {
            return new Grey();
        } else if (typeOfColor.equalsIgnoreCase("green")) {
            return new Green();
        } else if (typeOfColor.equalsIgnoreCase("blue")) {
            return new Blue();
        } else {
            return null;
        }
    }
}
```



**ShapeFactory.java**

```java
/**
 * Shape factory
 */
public class ShapeFactory implements AbstractFactory {

    /**
     * Get shape
     *
     * @param typeOfShape
     * @return
     */
    @Override
    public Shape getShape(String typeOfShape) {
        if (typeOfShape.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (typeOfShape.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (typeOfShape.equalsIgnoreCase("triangle")) {
            return new Triangle();
        } else {
            return null;
        }
    }

    @Override
    public Color getColor(String typeOfColor) {
        return null;
    }
}
```



定义商品：`Color`，`Shape`

**Color.java**

```java
public interface Color {
    void fill();
}
```

**Shape.java**

```java
public interface Shape {
    void draw();
}
```



定义商品的子类（实例化）

`Color` 的子类：

<div align="center"> <img src="image-20200817105221465.png" width="40%"/> </div><br>

**Blue.java**

```java
/**
 * Color: Blue
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Filling blue");
    }
}
```

**Green.java**

```java
/**
 * Color: Green
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Filling green");
    }
}
```

**Grey.java**

```java
/**
 * Color: Grey
 */
public class Grey implements Color {
    @Override
    public void fill() {
        System.out.println("Filling grey");
    }
}
```



`Shape` 的子类：


<div align="center"> <img src="image-20200817105420327.png" width="40%"/> </div><br>

**Circle.java**

```java
/**
 * Shape: Circle
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing circle");
    }
}
```

**Rectangle.java**

```java
/**
 * Shape: Rectangle
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
    }
}
```

**Triangle.java**

```java
/**
 * Shape: Triangle
 */
public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing triangle");
    }
}
```



最后，定义客户端 `Client`

**Client.java**

```java
/**
 * Client
 */
public class Client {
    public static void main(String[] args) {

        AbstractFactory shape = FactoryProducer.getFactory("shape");
        Shape circle = shape.getShape("circle");
        circle.draw();  // Drawing circle

        AbstractFactory color = FactoryProducer.getFactory("color");
        Color green = color.getColor("green");
        green.fill();  // Filling green

    }

}
```