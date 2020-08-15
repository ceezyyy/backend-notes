# 单例模式（创建型）



## 1. 什么是单例？

保证一个类仅有一个实例，并提供一个访问它的全局访问点。





## 2. 为什么使用单例？

解决一个全局使用的类频繁地创建与销毁浪费资源问题





## 3. 如何使用单例？

判断系统是否已经有这个单例，如果有则返回，如果没有则创建。





## 4. 优缺点

**优点：**

- 减少内存开销（尤其是频繁地创建和销毁实例）
- 避免对资源的多重占用（比如写文件）



**缺点：**

- 没有接口，无法继承
- 与单一原则冲突



## 5. 使用场景









## 6. Demo

```java
public class Singleton {

    private static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

}
```



"单例模式"：外人要取得我的实例，必须“请求”得到一个实例，而不是自行示例化得到一个实例

值得注意的是，我可能是在这次调用被创建出来，也可能是早就被创建出来了





















## 总结












## 参考资料

- [单例模式](https://www.runoob.com/design-pattern/singleton-pattern.html)