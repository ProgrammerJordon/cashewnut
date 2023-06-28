import React from 'react';
import Nav from "../nav/nav";
import Footer from "../footer/footer";
import cashflow from "./cashflow.css";

function CashFlow () {
    return (
        <>
            <Nav/>
            <div className="cashflow-container">
                <div className="cashflow-contents-containers">
                    <div className="cashflow-contents-buttons">
                        <div className="cashflow-contents-buttons"><button>연봉계산기</button></div>
                        <div className="cashflow-contents-buttons"><button>알바계산기</button></div>
                        <div className="cashflow-contents-buttons"><button>이자계산기</button></div>
                    </div>
                    <div className="cashflow-contents">
                        <div className="cashflow-content"></div>
                    </div>
                </div>
            </div>
            <Footer/>
        </>
    )
}

export default CashFlow;