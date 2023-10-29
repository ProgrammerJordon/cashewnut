import React from 'react';
import Footer from "../footer/footer";
import Nav from "../nav/nav";
import {Link} from "react-router-dom";

const underLine = {
    textDecoration: 'none',
}
function Salary() {
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
                                연봉계산기1111111
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <Footer/>
        </>
    )
}

export default Salary;