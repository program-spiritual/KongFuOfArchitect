export enum VNodeFlags {
  // html
  ELEMENT_HTML = 1,
  // SVG
  ELEMENT_SVG = 1 << 1,
  // 普通有状态组件
  COMPONENT_STATEFUL_NORMAL = 1 << 2,
  // 需要被keepAlive的有状态组件
  COMPONENT_STATEFUL_SHOULD_KEEP_ALIVE = 1 << 3,
  // 已经被keepAlive的有状态组件
  COMPONENT_STATEFUL_KEPT_ALIVE = 1 << 4,
  // 函数式组件
  COMPONENT_FUNCTIONAL = 1 << 5,
  // 纯文本
  TEXT = 1 << 6,
  // Fragment
  FRAGMENT = 1 << 7,
  // Portal
  PORTAL = 1 << 8,
  // html 和 svg 都是标签元素，可以用 ELEMENT 表示
  ELEMENT = ELEMENT_HTML | ELEMENT_SVG,
  // 普通有状态组件、需要被keepAlive的有状态组件、已经被keepAlice的有状态组件 都是“有状态组件”，统一用 COMPONENT_STATEFUL 表示
  COMPONENT_STATEFUL = COMPONENT_STATEFUL_NORMAL | COMPONENT_STATEFUL_SHOULD_KEEP_ALIVE | COMPONENT_STATEFUL_KEPT_ALIVE,
  // 有状态组件 和  函数式组件都是“组件”，用 COMPONENT 表示
  COMPONENT =COMPONENT_STATEFUL | COMPONENT_FUNCTIONAL
}
