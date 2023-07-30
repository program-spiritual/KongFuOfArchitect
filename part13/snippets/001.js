 // 不使用 for 循环 重复
 
 //bad  Method
 for(var i = 0; i<5; i++)
 {
   console.log("") //
 }
 // good Method
 console.log("".repeat(5)) //
 
 
 /**
  * @function ArrayDiff
  * @description
  * 这段代码定义了一个名为 `ArrayDiff` 的函数，接受两个数组 `a` 和 `b` 作为参数。该函数的目的是找出这两个数组之间的差异。
  *
  * 在函数内部，使用 `Set` 构造函数创建了两个集合 `setX` 和 `setY`。`Set` 对象允许存储任意类型的唯一值，包括原始值或对象引用。
  *
  * `setX` 集合使用数组 `a` 的元素进行初始化，`setY` 集合使用数组 `b` 的元素进行初始化。
  *
  * 然后，该函数返回一个新数组，其中包含在 `a` 或 `b` 中出现但不同时出现的元素。这是通过使用扩展运算符 (`...`) 和 `filter` 方法实现的。
  *
  * 返回数组的第一部分 `a.filter(x=>!setY.has(x))` 使用 `filter` 方法过滤数组 `a` 的元素。它使用 `Set` 对象的 `has` 方法检查 `a` 的每个元素是否不存在于 `setY` 中。如果元素不在 `setY` 中，则包含在过滤后的数组中。
  *
  * 返回数组的第二部分 `b.filter(x=>!setX.has(x))` 使用相同的逻辑过滤数组 `b` 的元素。它检查 `b` 的每个元素是否不存在于 `setX` 中，并在不在时将其包含在过滤后的数组中。
  *
  * 通过使用扩展运算符将两个过滤后的数组合并，该函数有效地找出了 `a` 和 `b` 之间的差异，并将其作为一个新数组返回。
  *
  * 总体而言，这段代码使用集合和数组过滤的方式提供了一种简洁的方法来找出两个数组之间的对称差异。
  * */
 function ArrayDiff(a, b){
   const setX = new Set(a)
   const setY = new Set(b)
   return [
     ...a.filter(x=>!setY.has(x)),
     ...b.filter(x=>!setX.has(x))
   ]
 }
 const Array1 = [1, 2, 3];
 const Array2 = [1, 2, 3, 4, 5];
 console.log(ArrayDiff(Array1, Array2)) // [4, 5]

 
 /**
  * @function isJSON
  * @description
  * 这段代码定义了一个名为 `isJSON` 的函数，该函数用于检查给定的字符串是否为有效的 JSON 格式。
  *
  * 函数内部使用了一个 `try...catch` 语句块。在 `try` 代码块中，使用 `JSON.parse()` 方法尝试将字符串解析为 JSON 对象。如果解析成功，即字符串是有效的 JSON 格式，那么代码将继续执行。
  *
  * 如果在解析过程中发生了错误，即字符串不是有效的 JSON 格式，那么控制流将转到 `catch` 代码块。在 `catch` 代码块中，函数会立即返回 `false`，表示字符串不是有效的 JSON。
  *
  * 如果没有发生任何错误，函数会在 `try` 代码块的末尾返回 `true`，表示字符串是有效的 JSON。
  *
  * 总体而言，这段代码通过尝试解析字符串为 JSON 对象，并根据解析的结果返回布尔值来判断字符串是否为有效的 JSON 格式。
  * */
 function isJSON(str)
 {
   try
   {
     JSON.parse(str)
   }
   catch
   {
     return false
   }
   return true
 }
 var str = "JavaScript"
 console.log(isJSON(str)) //false
 
 
 /**
  * @function NumberToArray
  * @description
  * 这段代码展示了如何将一个数字转换为对应的数字数组。
  *
  * 首先，调用了一个名为 `NumberToArray` 的函数，并传入一个数字作为参数。该函数的目的是将这个数字转换为对应的数字数组。
  *
  * 在代码中，函数被调用了三次，分别传入了不同的数字作为参数。
  *
  * 每次函数调用后，使用 `console.log` 打印出函数的返回结果，即转换后的数字数组。
  *
  * 根据代码的输出结果可以看出：
  *
  * - `NumberToArray(86734)` 的返回结果是 `[8, 6, 7, 3, 4]`，表示将数字 `86734` 转换为了数组 `[8, 6, 7, 3, 4]`。
  * - `NumberToArray(1234)` 的返回结果是 `[1, 2, 3, 4]`，表示将数字 `1234` 转换为了数组 `[1, 2, 3, 4]`。
  * - `NumberToArray(9000)` 的返回结果是 `[9, 0, 0, 0]`，表示将数字 `9000` 转换为了数组 `[9, 0, 0, 0]`。
  *
  * 总体而言，这段代码展示了如何使用 `NumberToArray` 函数将一个数字转换为对应的数字数组，并通过 `console.log` 打印出转换结果。
 * */
 const NumberToArray = number => [...`${number}`].map(i => parseInt(i));
 console.log(NumberToArray(86734)) //[8,6,7,3,4]
 console.log(NumberToArray(1234)) //[1,2,3,4]
 console.log(NumberToArray(9000)) //[9,0,0,0]
 
 /**
  * @description
  * 这段代码展示了如何将一个十进制数字转换为二进制表示形式。
  *
  * 首先，定义了三个变量 `n1`、`n2` 和 `n3`，分别赋值为 `500`、`4` 和 `5004`。
  *
  * 然后，通过调用 `toString()` 方法，并传入参数 `2`，将这些变量的值转换为二进制表示形式。
  *
  * 每次调用 `console.log` 打印出转换后的结果。
  *
  * 根据代码的输出结果可以看出：
  *
  * - `n1.toString(2)` 的返回结果是 `"111110100"`，表示将数字 `500` 转换为二进制表示形式。
  * - `n2.toString(2)` 的返回结果是 `"100"`，表示将数字 `4` 转换为二进制表示形式。
  * - `n3.toString(2)` 的返回结果是 `"1001110001100"`，表示将数字 `5004` 转换为二进制表示形式。
  *
  * 总体而言，这段代码展示了如何使用 `toString()` 方法将一个十进制数字转换为二进制表示形式，并通过 `console.log` 打印出转换结果。
  * */
 var n1 = 500
 console.log(n1.toString(2)) // 111110100
 var n2 = 4
 console.log(n2.toString(2)) // 100
 var n3 = 5004
 console.log(n3.toString(2)) // 1001110001100
 
 /**
  * @function DeepFlat
  * @description
  * 这段代码定义了一个名为 `DeepFlat` 的函数，用于将多层嵌套的数组展开为一维数组。
  *
  * 函数接受一个数组 `array` 作为参数。
  *
  * 在函数内部，使用了递归的方式来处理数组的每个元素。通过调用 `array.map()` 方法遍历数组的每个元素，并对每个元素进行处理。
  *
  * 对于每个元素，使用三元运算符 `Array.isArray(value)` 来判断该元素是否为数组。如果是数组，则递归调用 `DeepFlat` 函数对该数组进行展开。如果不是数组，则直接将该元素作为值。
  *
  * 通过使用扩展运算符 `...` 和 `concat()` 方法，将递归展开的结果与空数组 `[]` 进行合并，从而得到展开后的一维数组。
  *
  * 最后，通过 `console.log` 打印出函数调用的结果，即将多层嵌套的数组展开为一维数组的结果。
  *
  * 根据代码的输出结果可以看出：
  *
  * `DeepFlat([1,[2,[4,6,6,[9]],0,],1])` 的返回结果是 `[1, 2, 4, 6, 6, 9, 0, 1]`，表示将多层嵌套的数组 `[1,[2,[4,6,6,[9]],0,],1]` 展开为一维数组。
  *
  * 总体而言，这段代码展示了如何使用递归来实现深度展开多层嵌套的数组，并通过 `DeepFlat` 函数将其转换为一维数组。
  * */
 function DeepFlat(array)
 {
   return [].concat(...array.map(value=>  (Array.isArray(value) ? DeepFlat(value) : value)));
 }
 console.log(DeepFlat([1,[2,[4,6,6,[9]],0,],1])) // [1, 2, 4, 6, 6, 9, 0, 1]
 
 
 // byte size calculation
 /**
  * @function ByteSize
  * @description
  * 这段代码定义了一个名为 `ByteSize` 的函数，用于计算给定字符串的字节大小。
  *
  * 函数接受一个字符串 `string` 作为参数。
  *
  * 在函数内部，使用 `new Blob([string])` 创建了一个 Blob 对象。Blob 对象表示一个不可变的、原始数据的类文件对象。
  *
  * 然后，通过访问 Blob 对象的 `size` 属性，获取该 Blob 对象的字节大小。
  *
  * 最后，通过 `console.log` 打印出函数调用的结果，即给定字符串的字节大小。
  *
  * 根据代码的输出结果可以看出：
  *
  * - `ByteSize("Codding")` 的返回结果是 `7`，表示字符串 "Codding" 的字节大小为 7。
  * - `ByteSize(true)` 的返回结果是 `4`，表示布尔值 `true` 的字节大小为 4。
  * - `ByteSize("")` 的返回结果是 `4`，表示空字符串的字节大小为 4。
  *
  * 总体而言，这段代码展示了如何使用 Blob 对象来计算给定字符串的字节大小，并通过 `ByteSize` 函数打印出计算结果。
  * */
 const ByteSize = string => new Blob([string]).size;
 console.log(ByteSize("Codding")) // 7
 console.log(ByteSize(true)) // 4
 console.log(ByteSize("")) // 4
 
 
 //code example
 /**
  * @function
  * LastElement
  * @description
  * 这段代码定义了一个名为 `LastElement` 的函数，用于获取数组的最后一个元素。
  *
  * 函数接受一个数组 `array` 作为参数。
  *
  * 在函数内部，通过访问数组的 `length` 属性，减去 1，来获取数组的最后一个元素的索引。
  *
  * 然后，通过使用该索引来访问数组，并返回最后一个元素。
  *
  * 最后，通过 `console.log` 打印出函数调用的结果，即数组的最后一个元素。
  *
  * 根据代码的输出结果可以看出：
  *
  * - `LastElement([2,3,4])` 的返回结果是 `4`，表示数组 `[2,3,4]` 的最后一个元素为 4。
  * - `LastElement([2,3,4,5])` 的返回结果是 `5`，表示数组 `[2,3,4,5]` 的最后一个元素为 5。
  * - `LastElement([2,3])` 的返回结果是 `3`，表示数组 `[2,3]` 的最后一个元素为 3。
  *
  * 总体而言，这段代码展示了如何通过索引获取数组的最后一个元素，并通过 `LastElement` 函数打印出获取的结果。
  * */
 const LastElement = array => array[array.length - 1];
 console.log(LastElement([2,3,4])) // 4
 console.log(LastElement([2,3,4,5])) // 5
 console.log(LastElement([2,3])) // 3
 
 
