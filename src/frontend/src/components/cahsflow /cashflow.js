import React from 'react';
import Nav from "../nav/nav";
import Footer from "../footer/footer";
import cashflow from "./cashflow.css";
import {Link} from "react-router-dom";

const underLine = {
    textDecoration: 'none',
}

function CashFlow () {
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
                            <div>
                                <div>오른쪽 첫번째</div>
                                <div>오른쪽 두번째</div>
                            </div>
                            <div>
                                <div>왼쪽 첫번째</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <Footer/>
        </>
    )
}

export default CashFlow;