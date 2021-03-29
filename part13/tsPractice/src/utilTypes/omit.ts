interface OmitTodo   {
  title:string,
  desc:string,
  completed:boolean,
  createdAt:number
}

type TodoPreview = Omit<OmitTodo, "desc">

const todo: TodoPreview = {
  title: "Clean room",
  completed: false,
  createdAt: 1615544252770,
};

todo;

type TodoInfo = Omit<OmitTodo, "completed" | "createdAt">;

const todoInfo: TodoInfo = {
  title: "Pick up kids",
  desc: "Kindergarten closes at 5pm",
};

todoInfo;
