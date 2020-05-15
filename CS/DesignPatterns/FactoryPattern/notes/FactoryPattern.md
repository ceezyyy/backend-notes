# 烘烤 OO 的精华：工厂模式

## 1.1 美味的比萨

<div align="center"> <img src="pizza.jpg" width="50%"/> </div><br>

加入你是一家 pizza 店的 CEO，你们家有许多风味的 pizza

**Pizza.java**

```java
public abstract class Pizza {
    private String name;
    private String dough;
    private String sauce;

    public void prepare() {
        System.out.println("I'm preparing" + name);
        System.out.println("Tossing dough");
        System.out.println("Adding sauce");
    }

    public void bake() {
        System.out.println("I'm baking");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
```

该类是一个抽象类，不同种类的 pizza 分别继承其



**GreekPizza.java**

```java
public class GreekPizza extends Pizza {
}
```



**VeggiePizza.java**

```java
public class VeggiePizza extends Pizza {
}
```



**CheesePizza.java**

```java
public class CheesePizza extends Pizza {
}
```



**Pepperoni.java**

```java
public class PepperoniPizza extends Pizza {
}
```



**Main.java**

```java
public Pizza orderPizza(String type) {
        Pizza pizza = null;

        // might change
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("greek".equals(type)) {
            pizza = new GreekPizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new PepperoniPizza();
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        } else {
            // do nothing
        }

        // will not change
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
```

明显地，实例化某些具体类，将使 `orderPizza` 出问题，而且无法让其对修改关闭。但是，现在我们已经知道哪些会改变，哪些不会改变，该是使用封装的时候了



## 1.2 封装创建对象的代码

现在最好将创建对象的代码移到 `orderPizza` 之外，搬到另一个对象中，这个新对象只管如何创建 pizza，

而此时， `orderPizza` 成为了它的用户（显然不止一家店需要创建 pizza）



这里，就引出了一个新的词：**工厂（Factory）**

工厂处理创建对象的细节，**现在 `orderPizza` 只关心从从工厂对象得到了一个 pizza**（至于什么口味的一点儿也不在乎）





> **:bulb:THERE ARE NO DUMB QUESTIONS**
>
> **我曾经看过一个类似的设计方式，把工厂定义成一个静态的方法，这有什么差别？**
>
> 利用静态方法定义一个简单的工厂，这是很常见的技巧，被称为静态工厂。为何使用静态方法？因为不需要使用创建对象的方法来实例化对象。但请记住，这也有缺点，不能通过继承来改变创建方法的行为





## 1.3 定义工厂方法模式

你的 pizza 店做得越来越好，现在来自各地的 pizza 店想加盟

你希望：

1. 确保加盟店的质量：希望这些店都使用你经过时间考验的代码
2. 每个店有自己的创新：每家加盟店都想要提供不同风味的 pizza



定义一家 pizza 店：

**PizzaStore.java**

```java
public abstract class PizzaStore {

    // factory method
    protected abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {
        Pizza pizza;

        // create a pizza
        pizza = createPizza(type);

        // process of making a pizza
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}

```



`PizzaStore`：类似于一家总部抽象店，定义好一套规范，但具体的 pizza 风味由每家子店实现

`createPizza`：抽象方法，每家实际店铺必须实现



```java
public abstract class PizzaStore {

    // factory method
    protected abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {
        Pizza pizza;

        // create a pizza
        pizza = createPizza(type);

        // process of making a pizza
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
```



**总结：**

1. 工厂方法是抽象的，必须依赖子类处理对象的创建（保持了每家店独有的特色）
2. 工厂方法必须返回一个产品（工厂就是用来创建产品，但隐藏了创建的细节）
3. 工厂方法将客户是实际创建具体产品的代码分离
4. 工厂方法一般需要传入参数来指定创建所要的产品（也可以不指定）



