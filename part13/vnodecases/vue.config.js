const path = require('path')
function resolve(dir) {
  return path.join(__dirname, dir)
}
module.exports = {
  lintOnSave: true,
  configureWebpack: {
    resolve: {
      extensions: ['.tsx', '.ts', '.mjs', '.js', '.jsx', '.vue', '.json', '.wasm'],
      alias: {
        '@': resolve('src')
      }
    }
  },
  chainWebpack: config => {
    // 处理ts文件 (新增loader)
    config.module
      .rule('ts')
      .test(/\.tsx?$/)
      .exclude
      .add(resolve('node_modules'))
      .end()
      .use('cache-loader')
      .loader('cache-loader')
      .options({
        cacheDirectory: resolve('node_modules/.cache/ts-loader')
      })
      .end()
      .use('babel-loader')
      .loader('babel-loader')
      .end()
      .use('ts-loader')
      .loader('ts-loader')
      .options({
        transpileOnly: true, // 关闭类型检查，即只进行转译(类型检查交给webpack插件(fork-ts-checker-webpack-plugin)在另一个进程中进行,这就是所谓的多进程方案,如果设置transpileOnly为false, 则编译和类型检查全部由ts-loader来做, 这就是单进程方案.显然多进程方案速度更快)
        appendTsSuffixTo: ['\\.vue$'],
        happyPackMode: false
      })
      .end()
    
    // eslint 自动修复 (修改已经存在的loader)
    config.module
      .rule('eslint')
      .test(/\.(vue|(j|t)sx?)$/)
      .pre() // eslint是pre处理的
      .use('eslint-loader')
      .loader('eslint-loader')
      .tap(options => { // 修改已经存在loader的配置
        options.fix = true
        return options
      })
      .end()
  }
}
