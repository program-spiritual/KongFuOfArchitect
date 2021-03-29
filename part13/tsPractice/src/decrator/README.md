## 前言

这里我将使用简单的示例,展示装饰器的常见使用示例。

## 简介

随着TypeScript和ES6中类的引入,现在存在某些情况,这些情况依赖附加函数来支持注释或修改类和类成员。

装饰器提供了一种为类声明和成员添加注释和元编程语法的方法。

装饰器是JavaScript的第2阶段提议,可作为TypeScript 的实验函数使用。

## 装饰器的定义

装饰器是一种特殊的声明,可以附加到类声明,方法,访问器,属性或参数上。

装饰器使用 `@expression` 形式,其中 `expression` 必须为一个函数,该函数将在运行时使用有关修饰声明的信息进行调用。

例如,给定装饰器 `@sealed`,我们可以编写密封函数,如下所示：

```
function sealed(target) {
  // do something with 'target' ...
}
```

## 装饰工厂方法

如果要自定义将装饰器应用于声明,则可以编写一个装饰工厂函数。

Decorator Factory 是一个简单的函数,它返回装饰器在运行时将调用的表达式。

我们可以按照以下方式编写装饰器工厂：

```
function color(value: string) {
  // this is the decorator factory, it sets up
  // the returned decorator function
  return function (target) {
    // this is the decorator
    // do something with 'target' and 'value'...
  };
}
```
## 装饰组合

当多个修饰符应用于一个声明时,其求值类似于数学中的函数组成。

在这个模型中,当组合函数f和g时,所得的合成`(f ∘ g)(x)`等效于` f(g(x))`。

这样,在 TypeScript 中的单个声明上评估多个装饰器时,将执行以下步骤：

- 从上到下执行每个装饰器的表达式。

- 然后结果将从下到上调用函数。

下面是一个示例：

```
function first() {
  console.log("first(): factory evaluated");
  return function (target: any, propertyKey: string, descriptor: PropertyDescriptor) {
    console.log("first(): called");
  };
}

function second() {
  console.log("second(): factory evaluated");
  return function (target: any, propertyKey: string, descriptor: PropertyDescriptor) {
    console.log('target:',target)
    console.log('propertyKey:',propertyKey)
    console.log('PropertyDescriptor:',descriptor)
    console.log("second(): called");
  };
}

class ExampleClass {
  @first()
  @second()
  method() {
    console.log('method called')
  }

}

const a = new ExampleClass()

console.log(a)

a.method()

```

这段代码我在官网的基础上增加了打印输出,为了更好的描述装饰器的作用。

打印的结果如下所示:

```
[LOG]: "first(): factory evaluated" 
[LOG]: "second(): factory evaluated" 
[LOG]: "target:",  ExampleClass: {} 
[LOG]: "propertyKey:",  "method" 
[LOG]: "PropertyDescriptor:",  {
  "writable": true,
  "enumerable": false,
  "configurable": true
} 
[LOG]: "second(): called" 
[LOG]: "first(): called" 
[LOG]: ExampleClass: {} 
[LOG]: "method called" 
```

这个打印结果来自于 TS PlayGround

## 装饰器执行

对于应用应用于类内部各种声明的装饰器,有一个明确定义的顺序：对每个实例成员应用参数装饰器,后跟方法装饰器,访问器或属性装饰器。

- 参数修饰符,后跟方法修饰符,访问修饰符或属性修饰符将应用于每个实例成员。
- 参数修饰符,后跟方法,访问器或属性修饰符将应用于每个静态成员。

- 参数修饰符应用于构造函数。

- 类装饰器应用于该类。

## 类装饰器

在类声明之前声明一个类装饰器。

类装饰器应用于类的构造函数,可用于观察,修改或替换类定义。

不能在声明文件或任何其他环境上下文中(例如,在声明(`declare`)类上)使用类装饰器。

类装饰器的表达式将在运行时作为函数调用,装饰类的构造函数作为其唯一参数。

如果类装饰器返回一个值,它将用提供的构造函数替换类声明。

以下是应用于 BugReport 类的类装饰器(`@sealed`)的示例：

```
@sealed
class BugReport {
  type = "report";
  title: string;

  constructor(t: string) {
    this.title = t;
  }
}
```

我们可以使用以下函数声明来定义 `@sealed` 装饰器：
```
function sealed(constructor: Function) {
  Object.seal(constructor);
  Object.seal(constructor.prototype);
}
```
当执行 `@sealed` 时,它将同时密封构造函数及其原型,这将不允许在运行时对类进行子类化。

接下来,我们有一个示例,说明如何重写构造函数以设置新的默认值。

```
function reportableClassDecorator<T extends { new (...args: any[]): {} }>(constructor: T) {
  return class extends constructor {
    reportingURL = "http://www...";
  };
}

@reportableClassDecorator
class BugReport {
  type = "report";
  title: string;

  constructor(t: string) {
    this.title = t;
  }
}

const bug = new BugReport("Needs dark mode");
console.log(bug.title); // Prints "Needs dark mode"
console.log(bug.type); // Prints "report"

console.log(bug.reportingURL)
```

## 方法装饰器

在方法声明之前声明方法装饰器。

装饰器将应用于方法的属性描述符,并可用于观察,修改或替换方法定义。

方法修饰器不能在声明文件,重载或任何其他环境上下文(例如,声明类)中使用。

方法装饰器的表达式将在运行时作为函数调用,并带有以下三个参数：

- 静态成员的类的构造函数或实例成员的类的原型。

- 成员的名称。

- 成员的属性描述符。

> 注意：如果您的脚本目标小于ES5,则属性描述符将是未定义的。

如果方法装饰器返回一个值,它将用作方法的属性描述符。

> 注意：如果您的脚本目标小于ES5,则忽略返回值。

以下是应用于Greeter类上的方法的方法装饰器(`@enumerable`)的示例：

```
class Greeter {
  greeting: string;
  constructor(message: string) {
    this.greeting = message;
  }

  @enumerable(false)
  greet() {
    return "Hello, " + this.greeting;
  }
}
```

定义装饰器：

```
class Greeter {
  greeting: string;
  constructor(message: string) {
    this.greeting = message;
  }

  @enumerable(false)
  greet() {
    return "Hello, " + this.greeting;
  }
}

function enumerable(value: boolean) {
  return function (target: any, propertyKey: string, descriptor: PropertyDescriptor) {
    console.log('target:',target)
    console.log('propertyKey:',propertyKey)
    console.log('descriptor:',descriptor)
    descriptor.enumerable = value;
  };
}

const gretter = new Greeter("this is one new message!")
console.log(gretter.greet())
```

打印的日志输出如下所示：

```
[LOG]: "target:",  Greeter: {} 
[LOG]: "propertyKey:",  "greet" 
[LOG]: "descriptor:",  {
  "writable": true,
  "enumerable": false,
  "configurable": true
} 
[LOG]: "Hello, this is one new message!" 
```
`@enumerable(flase)` 装饰器是装饰器工厂。

调用 `@enumerable(flase)` 装饰器时,它将修改属性描述符的可枚举属性。

## 访问符装饰器

访问器装饰器在访问器声明之前被声明。

访问器修饰符应用于访问器的属性描述符,可用于观察,修改或替换访问器的定义。

访问修饰符不能在声明文件或任何其他环境上下文(例如,声明类)中使用。

> TypeScript不允许装饰单个成员的get和set访问器。
而是,该成员的所有装饰器必须应用于按文档顺序指定的第一个访问器。
这是因为装饰器应用于属性描述符,该属性描述符将get和set访问器组合在一起,而不是分别将每个声明组合在一起。

访问修饰器的表达式将在运行时作为函数调用,并带有以下三个参数：

- 静态成员的类的构造函数或实例成员的类的原型。

- 成员的名称。

- 成员的属性描述符。

> 如果您的脚本目标小于ES5,则属性描述符将是未定义的。

> 如果访问器装饰器返回一个值,它将用作该成员的属性描述符。

以下是应用于 Point 类的成员的访问器装饰器(`@configurable`)的示例：
```
class Point {
  private _x: number;
  private _y: number;
  constructor(x: number, y: number) {
    this._x = x;
    this._y = y;
  }

  @configurable(false)
  get x() {
    return this._x;
  }

  @configurable(false)
  get y() {
    return this._y;
  }
}

function configurable(value: boolean) {
  return function (target: any, propertyKey: string, descriptor: PropertyDescriptor) {
    descriptor.configurable = value;
  };
}

const point = new Point(10,20)

console.log(point.x)
console.log(point.y)
```
## 属性装饰器

属性装饰器在属性声明之前被声明。

不能在声明文件或任何其他环境上下文(例如,声明类)中使用属性装饰器。

属性装饰器的表达式将在运行时作为函数调用,并带有以下两个参数：

- 静态成员的类的构造函数或实例成员的类的原型。
- 成员的名称。

> 由于在TypeScript中如何初始化属性装饰器,因此未将属性描述符作为参数提供给属性装饰器。
这是因为当前在定义原型成员时没有描述实例属性的机制,也没有观察或修改该属性的初始化程序的方法。
返回值也将被忽略。
因此,属性装饰器只能用于观察已为类声明了特定名称的属性。

我们可以利用这些信息来记录有关的元数据属性,如下面的例子：

```
class Greeter {
  @format("Hello, %s")
  greeting: string;
  constructor(message: string) {
    this.greeting = message;
  }
  greet() {
    let formatString = getFormat(this, "greeting");
    return formatString.replace("%s", this.greeting);
  }
}
```

然后,我们可以使用以下函数声明来定义`@format`装饰器和 `getFormat` 函数：

```
import "reflect-metadata";
const formatMetadataKey = Symbol("format");
function format(formatString: string) {
  return Reflect.metadata(formatMetadataKey, formatString);
}
function getFormat(target: any, propertyKey: string) {
  return Reflect.getMetadata(formatMetadataKey, target, propertyKey);
}
```

@format(' Hello,％s”)装饰器是装饰器工厂。

调用@format(' Hello,％s”)时,它将使用reflect-metadata库中的Reflect.metadata函数为该属性添加元数据条目。

调用getFormat时,它将读取该格式的元数据值。

```ts
import "reflect-metadata";
const formatMetadataKey = Symbol("format");
function format(formatString: string) {
  return Reflect.metadata(formatMetadataKey, formatString);
}
function getFormat(target: any, propertyKey: string) {
  return Reflect.getMetadata(formatMetadataKey, target, propertyKey);
}
class Greeter {
  @format("Hello, %s")
  greeting: string;
  constructor(message: string) {
    this.greeting = message;
  }
  greet() {
    let formatString = getFormat(this, "greeting");
    return formatString.replace("%s", this.greeting);
  }
}

const greeter = new Greeter("JavaScript")

console.log(greeter.greet())
```
## 参数装饰器

在参数声明之前就声明了一个参数装饰器。

参数装饰器应用于类构造函数或方法声明的函数。

参数修饰符不能在声明文件,重载或任何其他环境上下文(例如,声明类)中使用。

参数装饰器的表达式将在运行时作为函数调用,并带有以下三个参数：

- 静态成员的类的构造函数或实例成员的类的原型。

- 成员的名称。

- 函数的参数列表中参数的序号索引。

参数装饰器的返回值将被忽略。

以下是将参数修饰符(`@required`)应用于BugReport类成员的参数的示例：

```ts
import "reflect-metadata"

const requiredMetadataKey = Symbol("required")

function required(target: Object, propertyKey: string | symbol, parameterIndex: number) {
  let existingRequiredParameters:number[] = Reflect.getOwnMetadata(requiredMetadataKey,target,propertyKey)
  existingRequiredParameters.push(parameterIndex)
  Reflect.defineMetadata(requiredMetadataKey,existingRequiredParameters,target,propertyKey)
}

function validate(target:any,propertyName:string,descriptor:TypedPropertyDescriptor<Function>) {
  let method = descriptor.value!;
  descriptor.value = function () {
    let requiredParameters:number[] = Reflect.getOwnMetadata(requiredMetadataKey,target,propertyName)
    if (requiredParameters) {
      for (const parameterIndex of requiredParameters) {
        if (parameterIndex >= arguments.length || arguments[parameterIndex] === undefined) {
          throw new Error("Missing required argument.");
        }
      }
    }
    return method.apply(this, arguments);
  }
}

class BugReport {
  type = "report";
  title: string

  constructor(t: string) {
    this.title = t
  }
  @validate
  print(@required verbose: boolean) {
    if (verbose) {
      return this.title;
    } else {
      return `type: ${this.type}\ntitle: ${this.title}`;
    }
  }
}

```

## 元数据

一些示例使用了反射元数据库,该库为实验性元数据API添加了polyfill。

该库尚未成为ECMAScript(JavaScript)标准的一部分。

但是,一旦装饰器被正式采纳为ECMAScript标准的一部分,这些扩展将被提议采用。

您可以通过npm安装此库：

```shell
npm i reflect-metadata --save
```
或者使用 yarn

```shell
yarn add reflect-metadata --save
```

TypeScript包含实验性支持,用于为具有修饰符的声明发出某些类型的元数据。

要启用此实验性支持,必须在命令行上或在tsconfig.json中设置embedDecoratorMetadata编译器选项：


```shell
tsc --target ES5 --experimentalDecorators --emitDecoratorMetadata
```

ts 配置文件:

```json
{
  "compilerOptions": {
    "target": "ES5",
    "experimentalDecorators": true,
    "emitDecoratorMetadata": true
  }
}
```
启用后,只要导入了反射元数据库,就会在运行时公开其他设计时类型信息。

我们可以在下面的示例中看到这一点：

TypeScript编译器将使用`@Reflect.metadata`装饰器注入设计时类型信息。

```ts
import "reflect-metadata";
function validate<T>(target: any, propertyKey: string, descriptor: TypedPropertyDescriptor<T>) {
  console.log('target:',target)
  console.log('propertyKey:',propertyKey)
  console.log('descriptor:',descriptor)
  let set = descriptor.set!;
  console.log('set:',set)
  descriptor.set = function (value: T) {
    let type = Reflect.getMetadata("design:type", target, propertyKey);

    if (!(value instanceof type)) {
      throw new TypeError(`Invalid type, got ${typeof value} not ${type.name}.`);
    }

    set.call(this, value);
  };
}

class Point {
  constructor(public x: number, public y: number) {}
}

class Line {
  private _start: Point;
  private _end: Point;

  @validate
  set start(value: Point) {
    this._start = value;
  }

  get start() {
    return this._start;
  }

  @validate
  set end(value: Point) {
    this._end = value;
  }

  get end() {
    return this._end;
  }
}


const line = new Line()
line.start = new Point(0, 0)
```

您可以认为它等同于以下TypeScript：

```ts
class Line {
  private _start: Point;
  private _end: Point;
  @validate
  @Reflect.metadata("design:type", Point)
  set start(value: Point) {
    this._start = value;
  }
  get start() {
    return this._start;
  }
  @validate
  @Reflect.metadata("design:type", Point)
  set end(value: Point) {
    this._end = value;
  }
  get end() {
    return this._end;
  }
}
```
