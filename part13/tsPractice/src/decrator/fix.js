
const FS = require('fs');
let replaceFile = function(filePath){
  const data = FS.readFileSync(filePath)
  let str = data.toString()
  let str1 = str.replace(/（/ig, '(')
  let str2 = str1.replace(/）/ig, ')')
  let str3 = str2.replace(/ “/g, '\'').replace(/“/g,'\'')
  let str4 = str3.replace(/图形/g, '字符')
  let str5 = str4.replace(/签名/g,'有符号')
  let str6 = str5.replace(/，/g,',')
  let str7 = str6.replace(/ :: /g,'::')
  let str8  = str7.replace(/！=/g,'!=')
  let str9 = str8.replace(/ == /g,'==')
  let str10 = str9.replace(/ \*/g,'*')
  let str11 = str10.replace(/C \+\+/g,'C++')
  let str12 = str11.replace(/需要/g,'依赖').replace(/要求/g,'依赖')
  let str13 = str12.replace(/所需/g,'依赖').replace(/功能/g,'函数')
  let str14 = str13.replace(/导航/g,'切换')
  let str15 = str14.replace(/ \/ /g,'/')
  let str16 = str15.replace(/跑过/g,'运行')
  let str17 = str16.replace(/包括/g,'包含')
  let str18 = str17.replace(/ \/ /g,'/').replace(/地图/g,'映射').replace(/尺寸/g,'长度').replace(/二进制/g,'二叉').replace(/大小/g,'长度')
  console.log('done!')
  FS.writeFileSync(filePath, str18)
}

replaceFile('README.md')
