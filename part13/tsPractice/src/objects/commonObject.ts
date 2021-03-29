interface Box{
  contents:any
}

interface IBox<Type> {
  contents:Type
}

let boxA: IBox<string> = { contents: "hello" };

function setContents<Type>(box:IBox<Type>,newContents:Type) {
  box.contents  = newContents
}

type IBox2<T> = {
  contents: T;
}

type OrNull<Type> = Type | null;

type OneOrMany<Type> = Type | Type[];

type OneOrManyOrNull<Type> = OrNull<OneOrMany<Type>>;

type OneOrManyOrNullStrings = OneOrManyOrNull<string>;

