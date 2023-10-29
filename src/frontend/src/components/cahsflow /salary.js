import React, {useState} from 'react';
import Footer from "../footer/footer";
import Nav from "../nav/nav";
import {Link} from "react-router-dom";

const underLine = {
    textDecoration: 'none',
}
function Salary() {

    // 상태 관리를 위한 state 변수 선언
    const [isChecked, setIsChecked] = useState(false);

    // 체크박스 상태를 변경하는 함수
    const handleCheckboxChange = () => {
    setIsChecked(!isChecked);
     };

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
                        <div className="cashflow-content">
                            <div className="cashflow-content-title">연봉계산기</div>
                            <div className="cashflow-content-resetbutton"><button>초기화</button></div>
                            <div className="cashflow-content-select-container">
                                <div>연봉/월급선택</div>
                                <div>퇴직금 포함여부</div>
                            </div>
                            <div className="cashflow-content-button-container">
                                <div><button>연봉</button><button>월급</button></div>
                                <div><button>별도</button><button>포함</button></div>
                                <div>연봉일 경우에만 선택</div>
                            </div>
                            <div className="cashflow-content-tax-container">
                                <div>부양가족수(본인포함)</div>
                                <div>20세 이하 자녀수</div>
                            </div>
                            <div className="cashflow-content-person-container">
                                <div>1명 밑줄</div>
                                <div>0명 밑줄</div>
                            </div>
                            <div className="cashflow-content-taxfree-container">
                                <div>비과세액</div>
                                <div><label><input type='checkbox' checked={isChecked} onChange={handleCheckboxChange}/>직접선택</label></div>
                            </div>
                            <div className="cashflow-content-submit-container">
                                <div><button>게산하기</button></div>
                            </div>
                        </div>
                    </div>
                    <div className="cashflow-content-result-container">
                        <div>
                            <div>한 달 기준 공제액</div>
                        </div>    
                        <div>
                            <div>국민연금</div>
                            <div>국민연금 금액 000 원</div>
                        </div>
                        <div>
                            <div>건강보험</div>
                            <div>건강보험 금액 000 원</div>
                        </div>
                        <div>
                            <div>장기요양</div>
                            <div>장기요양 금액 000 원</div>
                        </div>
                        <div>
                            <div>고용보험</div>
                            <div>고용보험 금액 000 원</div>
                        </div>
                        <div>
                            <div>소득세</div>
                            <div>소득세 금액 000 원</div>
                        </div>
                        <div>
                            <div>지방소득세</div>
                            <div>지방소득세 금액 000 원</div>
                        </div>
                        <div>
                            <div>공제액 합계</div>
                            <div>공제액 합계 금액 000 원</div>
                        </div>
                        <div>
                            <div>월 예상 실수령액</div>
                        </div>
                        <div>
                            <div>2,644,000원 입니다.</div>
                        </div>
                    </div>
                </div>
            </div>
            <Footer/>
        </>
    )
}

export default Salary;