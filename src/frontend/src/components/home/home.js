import React, {useEffect, useState} from 'react';
import io from 'socket.io-client';
import axios from 'axios';
import home from "./home.css";
import Nav from "../nav/nav";


// axios.defaults.withCredentials = true;
// /**
//  * HTTP 통신
//  */
//
// // GET 요청
// axios.get('https://openapi.koreainvestment.com:9443/uapi/domestic-stock/v1/quotations/inquire-price', {
//     headers: {
//         // 헤더 추가
//         'Content-Type': 'application/json',
//         'authorization': 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b2tlbiIsImF1ZCI6IjdmZWEwMzFmLWY3ZDctNDE4NS04YjdkLWE2MGY2OWIzYjAzMCIsImlzcyI6InVub2d3IiwiZXhwIjoxNjk4NTA1Nzg5LCJpYXQiOjE2OTg0MTkzODksImp0aSI6IlBTUVdaZzFOV3RjeFRUQ05ZSWdKN0xZb2FjSngzOFZ2Q1htUSJ9.PKmM6CKsFIrlfYCX4A5PUGszPyzB92yvYCvAdwqkcxfJ-K_vKVZdRr47hiXm5UBlQVdCHhE7_Wxse5cHwVa72g',
//         'appkey': 'PSQWZg1NWtcxTTCNYIgJ7LYoacJx38VvCXmQ',
//         'appsecret': 'dSPcqjO3Gdk9nJiVnkQSFE8JoDZyZ1XbrJpha+732iU8F98y45rVW45QHR392B38+tCofP6moWQCYK/S6QqW9g+aYS5EPWPEr0UvlEH1thIMqyU2yvApY+Wp/5syOY2j5cnhieyRQDcqRsN/HQalrPxPJbXHgzsu9SS3NmX4hp91w1OJ6cs=',
//         'tr_id': 'FHKST01010100'
//     },
//     params: {
//         // 파라미터 추가
//         'fid_cond_mrkt_div_code': 'J',
//         'fid_input_iscd': '000660'
//     }
// })
//     .then((response) => {
//         // 요청 성공 시 처리
//         console.log("성공임");
//         console.log(response.data);
//     })
//     .catch((error) => {
//         // 요청 실패 시 처리
//         console.log("실패임");
//         console.error(error);
//     });
//
// // POST 요청
// // const data = {
// //     key1: 'value1',
// //     key2: 'value2',
// // };
// //
// // const config = {
// //     headers: {
// //         'Authorization': 'Bearer YourAccessToken', // 헤더 추가
// //     },
// // };
// //
// // axios.post('https://api.example.com/post', data, config)
// //     .then((response) => {
// //         // 요청 성공 시 처리
// //         console.log(response.data);
// //     })
// //     .catch((error) => {
// //         // 요청 실패 시 처리
// //         console.error(error);
// //     });

/**
 * HTTP 통신
 */

/**
 * SOCKET 양방향 통신
 */



/**
 * 소켓프로그래밍
 */
function Home() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [userName, setUserName] = useState('');

    const handleLogin = () => {
        setIsLoggedIn(true);
        setUserName('John Doe');
    };

    const handleLogout = () => {
        setIsLoggedIn(false);
        setUserName('');
    };

    return (
        <>
            <Nav/>
            <div className="home-container">
                <div className="home-contents-container-left">
                    <div className="home-contents-chart"><h1>SPY 차트 API</h1></div>
                    <div className="home-contents"><h1>세계 지수</h1></div>
                    <div className="home-contents">
                        <h1>유명한 투자자</h1>
                        <div>
                            투자자 사진 입력
                        </div>
                    </div>
                </div>
                <div className="home-contents-container-center">
                    <div className="home-contents"><h1>포트폴리오</h1></div>
                    <div className="home-contents"><h1>게시판</h1>
                        <div>작업중</div>
                    </div>
                </div>
                <div className="home-contents-container-right">
                    <div className="home-contents">
                    {isLoggedIn ? (
                        <div>
                            <h1>Welcome, {userName}!</h1>
                            <button onClick={handleLogout}>Logout</button>
                        </div>
                    ) : (
                        <div>
                            <button onClick={handleLogin}>Login</button>
                        </div>
                    )}
                </div>
                    <div className="home-contents"><h1>관심종목</h1></div>
                </div>
            </div>
        </>
    )
}

export default Home;