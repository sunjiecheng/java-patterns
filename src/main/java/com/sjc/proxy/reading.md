# 定义：代理模式是对象的结构模式。代理模式给某一个对象提供一个代理对象，并由代理对象控制对原对象的引用。

# 代理模式的作用是：为其他对象提供一种代理以控制对这个对象的访问。在某些情况下，一个客户不想或者不能直接引用另一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用。

静态代理：将一个成员对象置于所要构造的类中（就像组合），但与此同时我们在新类中暴露了该成员对象的所有方法（就像继承）。

```puml
abstract class AbstractObject {
+operation() : void
}
class RealObject {
+operation() : void
}
class ProxyObject {
-realObject : RealObject
+operation() : void
}
AbstractObject <|-- RealObject
AbstractObject <|-- ProxyObject
RealObject *-- ProxyObject
```


