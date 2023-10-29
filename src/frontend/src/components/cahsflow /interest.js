import React from 'react';
import Nav from "../nav/nav";
import Footer from "../footer/footer";
import {Link} from "react-router-dom";

const underLine = {
    textDecoration: 'none'
}
function Interest () {
    
    return (
    <>
        <Nav/>
            <div className="cashflow-container">
            <div className="cashflow-contents-containers">
                <div className="cashflow-contents-buttons">
                    <div className="cashflow-contents-buttons"><Link to="/salary" style={underLine}><button>연봉계산기</button></Link></div>
                    <div className="cashflow-contents-buttons"><Link to="/parttimejob" style={underLine}><button>알바계산기</button></Link></div>
                    <div className="cashflow-contents-buttons"><Link to="/interest" style={underLine}><button>이자계산기</button></Link></div>
                </div>
                <div className="cashflow-contents">
                    <div className="cashflow-content-container">
                        <div>
                            <div>이자계산기</div>
                        </div>
                        <div>
                            <div>대출원금</div>
                            <div>1,000만원</div>
                        </div>
                        <div>
                            <div><input type="text" placeholder='만원' style={{ textAlign: 'right' }}/></div>
                        </div>
                        <div>
                            <div>연금리</div>
                        </div>
                        <div>
                            <div><input type="text" placeholder='%' style={{ textAlign: 'right' }}/></div>
                        </div>
                        <div>
                            <div>대출 기간</div>
                            <div>2년</div>
                        </div>
                        <div>
                            <div><input type="text" placeholder='개월' style={{ textAlign: 'right' }}/></div>
                        </div>
                    </div>
                    <div className="cashflow-buttton-container">
                        <div>상환 방법</div>
                        <div>
                            <div><button>원리금 균등</button></div>
                            <div><button>원금 균등</button></div>
                            <div><button>만기 일시</button></div>
                        </div>
                    </div>
                    <div className="cashflow-fixedmoney-container">
                        <div>
                            <div>거치 기간</div>
                            <div>1년</div>
                        </div>
                        <div>
                            <div><input type="text" placeholder='개월' style={{ textAlign: 'right' }}/></div>
                        </div>
                    </div>
                    <div className="cashflow-result-container">
                        <div>
                            <div>총 대출이자</div>
                            <div>나의 계산내역</div>
                        </div>
                        <div>
                            <div>1,083,205 원</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <Footer/>
    </>
    )
}

export default Interest;
