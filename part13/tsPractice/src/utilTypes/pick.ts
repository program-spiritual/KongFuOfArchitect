interface PickTodo   {
  title:string,
  desc:string,
  completed:boolean
}


type PickTodoPreview = Pick<PickTodo,"title"| "desc">

const todos :PickTodoPreview = {
  title: "clear room",
  desc:'clearing '
}

console.log(`时间：2021/3/22-文件：pick.ts-行：15`,todos)
