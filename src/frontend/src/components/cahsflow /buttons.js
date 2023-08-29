import {Link} from "react-router-dom";
import React from "react";

function Buttons () {
    return (
        <>
<div className="cashflow-contents-buttons">
    <div className="cashflow-contents-buttons"><Link to="/salary" style={underLine}>
        <button>연봉계산기</button>
    </Link></div>
    <div className="cashflow-contents-buttons"><Link to="/parttimejob" style={underLine}>
        <button>알바계산기</button>
    </Link></div>
    <div className="cashflow-contents-buttons"><Link to="/interest" style={underLine}>
        <button>이자계산기</button>
    </Link></div>
</div>
        </>
    )
}

export default Buttons;