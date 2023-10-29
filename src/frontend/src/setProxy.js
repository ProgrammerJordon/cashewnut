const { createProxyMiddleware } = require('http-proxy-middleware');
const express = require('express');

module.exports = function(app) {
    app.use(
        '/api',
        createProxyMiddleware({
            target: 'http://localhost:5252',
    changeOrigin: true,
        })
    );
};

const app = express();

// 다른 미들웨어 및 라우트 설정

// CORS 설정
app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*'); // 모든 도메인에서 접근 허용
    res.header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS');
    res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept, Authorization');
    next();
});

const port = 9443;
app.listen(port, () => {
    console.log(`Server is running on port ${port}`);
});

module.exports = function (app) {
    app.use(
        "/uapi",
        createProxyMiddleware({
            target: "https://openapi.koreainvestment.com",
            changeOrigin: true,
        })
    );
};