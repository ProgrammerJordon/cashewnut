import React from 'react';
import Nav from "../nav/nav";
import Footer from "../footer/footer";
import login from "./login.css";
import {useNavigate} from "react-router-dom";

function Login() {

    const moveLink = useNavigate();
    const KakaoButtonClick = () => {
        moveLink('/kakao');
    };

    const GoogleButtonClick = () => {
        moveLink('/Google');
    };

    const AppleButtonClick = () => {
        moveLink('/Apple');
    };

    const MetaButtonClick = () => {
        moveLink('/Meta');
    };

    return (
        <>
            <Nav/>
            <div className="login-container">
                <div className="login-contents">
                    <div className="login-content"><h1>로그인</h1></div>
                    <div className="login-content"><button onClick={KakaoButtonClick}><img src="./logo192.png" alt="kakao" style={{height:"30px", width:"30px"}}/>카카오 로그인</button></div>
                    <div className="login-content"><button onClick={GoogleButtonClick}><img src="./logo192.png" alt="google" style={{height:"30px", width:"30px"}}/>구글 로그인</button></div>
                    <div className="login-content"><button onClick={AppleButtonClick}><img src="./logo192.png" alt="apple" style={{height:"30px", width:"30px"}}/>애플 로그인</button></div>
                    <div className="login-content"><button onClick={MetaButtonClick}><img src="./logo192.png" alt="meta" style={{height:"30px", width:"30px"}}/>페이스북 로그인</button></div>
                </div>
            </div>
            <Footer/>
        </>
    )
}

export default Login;