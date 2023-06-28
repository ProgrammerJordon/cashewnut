import React, {useEffect, useState} from 'react';
import Nav from "../nav/nav";
import downloadapp from "./downloadapp.css";
import Footer from "../footer/footer";

function DownloadApp() {
    return (
        <>
            <Nav/>
            <div className="app-container">
                <div className="app-download-container">
                    <div className="app-download">
                        <div><h1>모든 투자 이야기 캐슈넛과 함께</h1></div>
                        <div><h3>개인 투자자들이 신뢰할 수 있는 금융데이터를 기반으로 서로 소통하며 투자를 지속하는 서비스를 만듭니다.</h3></div>
                        <div className="app-download-button">
                            <button className="app-download-app"><img src="./appstore.png" alt="app"/> APP STORE
                            </button>
                            <button className="app-download-app"><img src="./googleplay.png" alt="app"/> GOOGLE PLAY
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <Footer/>
        </>
    )
}

export default DownloadApp;