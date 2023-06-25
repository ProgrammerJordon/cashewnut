import React, {useEffect, useState} from 'react';
import home from "./home.css";
import Nav from "../nav/nav";

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
                    <div className="home-contents"><h1>게시판</h1></div>
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