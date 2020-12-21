module.exports={
    publicPath: './',   //
    // transpileDependencies: process.env.NODE_ENV === "development" ? ["*"] : [],  //
    // productionSourceMap:false,   //
    devServer: {
        host: "localhost",  // ip地址
        port: 8080, // 端口号
        https: false,   // https:{type:Boolean}
        open: false, // 是否自动启动浏览器
        // 配置多个代理
        proxy: {
            "/api": {
                target: "http://localhost:8081/",   // 要访问源地址
                ws: true,   // 是否启用 websockets
                // 是否跨域，开启代理：在本地会创建一个虚拟服务端，然后发送请求的数据，并同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题
                changeOrigin: true,
                // secure: false,
                pathRewrite: {
                    // 路径重写：即使用'/api'代替 target 中的源地址；例'http://127.0.0.1:8080/user/add'，可直接写成'/api/user/add'
                    '^/api': '',
                },
            },
            // "/for": {
            //     target: "http://localhost:8082/",   // 要访问源地址
            //     ws: true,   // 是否启用 websockets
            //     // 是否跨域，开启代理：在本地会创建一个虚拟服务端，然后发送请求的数据，并同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题
            //     changeOrigin: true,
            //     pathRewrite: {
            //         // 路径重写：即使用'/api'代替 target 中的源地址；例'http://127.0.0.1:8080/user/add'，可直接写成'/api/user/add'
            //         '^/for': '',
            //     },
            // },
        },
    }
}