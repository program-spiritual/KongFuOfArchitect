type extract1 = Extract<"a" | "b" | "c", "a" | "f">;
//    ^ = type T0 = "a"
type extract2 = Extract<string | number | (() => void), Function>;
//    ^ = type T1 = () => void
