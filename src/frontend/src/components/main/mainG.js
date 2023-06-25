import React, {useEffect, useState} from 'react';

function MainG() {
    return (
        <div className="main-container">
            <div className="main-download-container">
                <div className="main-download">
                    <div><h1>모든 투자 이야기 캐슈넛과 함께</h1></div>
                    <div><h3>개인 투자자들이 신뢰할 수 있는 금융데이터를 기반으로 서로 소통하며 투자를 지속하는 서비스를 만듭니다.</h3></div>
                    <div>
                        <button className="main-download-app"><span><img src="./logo192.png" alt="app"/></span> 앱스토어</button>
                        <button className="main-download-app"><span><img src="./logo192.png" alt="app"/></span> 구글플레이</button>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default MainG;