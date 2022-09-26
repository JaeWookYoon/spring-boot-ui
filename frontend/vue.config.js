const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  outputDir: "../src/main/resources/templates",  // 빌드 타겟 디렉토리
  indexPath: "../templates/index.html",
  devServer: {
    proxy: {
      '/api': {
        // '/api' 로 들어오면 포트 8081(스프링 서버)로 보낸다
        target: 'http://localhost:8081',
        changeOrigin: true // cross origin 허용
      }
    }
  },
  chainWebpack: config => {  
    const svgRule = config.module.rule("svg");    
    svgRule.uses.clear();    
    svgRule.use("vue-svg-loader").loader("vue-svg-loader");  
  }
})
