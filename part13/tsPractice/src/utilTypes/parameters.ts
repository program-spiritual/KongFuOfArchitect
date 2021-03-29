declare function f1(arg:{a:number,b:string}):void;

type parametersT0 = Parameters<() => string>

const t1 :parametersT0 = []

type parametersT1 = Parameters<(s: string) => void>

type parametersT2 = Parameters<<T>(arg:T) => T>

type parametersT3 = Parameters<typeof f1>

type parametersT4 = Parameters<any>

type parametersT5 = Parameters<never>

