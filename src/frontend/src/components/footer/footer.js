import React, {useEffect, useState} from 'react';
import footer from './footer.css'

function Footer() {
    return (
        <div className="footer-container">
            <div className="footer-content">
                <div className="company-info">
                    <div><h1>(주)캐슈넛</h1></div>
                    <div><h3>사업자 등록번호 : 000-00-00000 | 대표 : 캐슈넛</h3></div>
                    <div><h3>통신판매신고 제 2023-서울강남-00443호</h3></div>
                    <div><h3>서울특별시 강남구 테헤란로217 (역삼동, 캐슈넛)</h3></div>
                    <div><h3>대표 전화: 02-0000-0000</h3></div>
                    <div className="company-info-bottom">
                        <button>F</button>
                        <button>I</button>
                        <button>Y</button>
                        <button>B</button>
                    </div>
                </div>
                <div className="company-info">
                    <div><h1>Company</h1></div>
                    <div><h3>서비스 이용약관</h3></div>
                    <div><h3>개인정보 처리방침</h3></div>
                    <div><h3> 😄 </h3></div>
                    <div><h3> 😄 </h3></div>
                </div>
                <div className="company-info">
                    <div><h1>인재영입</h1></div>
                    <div><h3>Go! Recruiting 😄</h3></div>
                    <div><h3> 😄 </h3></div>
                    <div><h3> 😄 </h3></div>
                    <div><h3> 😄 </h3></div>
                </div>
                <div className="company-info">
                    <div><h1>고객센터</h1></div>
                    <div><h3>고객문의 : cs@cashewnut.co.kr</h3></div>
                    <div><h3>광고문의 : ad@cashewnut.co.kr</h3></div>
                    <div><h3>사업제휴 : mou@cashewnut.co.kr</h3></div>
                    <div><h3>IR : ir@cashewnut.co.kr</h3></div>
                </div>
            </div>
        </div>
    )
}

export default Footer;