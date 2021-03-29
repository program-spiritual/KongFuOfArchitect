declare function f1():{a:number,b:string};
type returnTypeT0 = ReturnType<() => string>
type returnTypeT1 = ReturnType<(s: string)=>void>
type returnTypeT2 = ReturnType<<T>()=>T>
type returnTypeT3 = ReturnType<<T extends U, U extends number[]>()=>T>
type returnTypeT4 = ReturnType<typeof f1>
type returnTypeT5 = ReturnType<never>
