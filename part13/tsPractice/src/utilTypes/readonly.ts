interface ReadOnlyTodo {
  title:string
}

const readonlyTodo :Readonly<ReadOnlyTodo> = {
  title:'delete inactive users'
}
readonlyTodo
// readonlytodo.title = "he;;p"


// function freeze<T>(obj:T):Readonly<T>


