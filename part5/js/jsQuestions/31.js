//当点击按钮时，event.target是什么？
//<div onclick="console.log('first div')">
//  <div onclick="console.log('second div')">
//  <button onclick="console.log('button')">
//  Click!
//</button>
//</div>
//</div>

//导致事件的最深嵌套的元素是事件的 target。你可以通过 event.stopPropagation 来停止冒泡。
