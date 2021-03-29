interface Todo {
  title:string
  description:string
}

function updateTodo(todo:Todo,fieldsToUpdate:Partial<Todo>) {
  return { ...todo, ...fieldsToUpdate };
}

const todo1 = {
  title: "organize desk",
  description: "clear clutter",
}

const todo2 = updateTodo(todo1,{
  description:"throw new error"
})

console.log(`时间：2021/3/22-文件：main.ts-行：19`,todo2)

