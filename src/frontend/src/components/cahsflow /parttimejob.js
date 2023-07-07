import React, {useEffect, useState} from 'react';
import Nav from "../nav/nav";
import Footer from "../footer/footer";
import {Link} from "react-router-dom";
import cashflow from "./cashflow.css";


const underLine = {
    textDecoration: 'none',
}

function PartTimeJob() {

    const [preType, setPreType] = useState("H")
    const [afterType, setAfterType] = useState("M")
    const [wage, setWage] = useState(9620)
    const [workTime, setWorkTime] = useState(8)
    const [period, setPeriod] = useState(1)
    const [extended, setExtended] = useState(0)
    const [holidayWage, setHolidayWage] = useState("Y")
    const [taxRange, setTaxRange] = useState("1")
    const [holidayWageButton, setHolidayWageButton] = useState(true)
    const [totalAmt, setTotalAmt] = useState(0)
    const Calculator = (e) => {
        let totalAmt = 0;

        totalAmt = (((wage * workTime * period) + (wage * extended) + (((workTime * period / 40) * 8 * wage))) * taxRange);

        if (preType === 'H' && afterType === 'D') {
            totalAmt = totalAmt / period;
        } else if (preType === 'H' && afterType === 'W') {
            totalAmt = totalAmt * 1;
        } else if (preType === 'H' && afterType === 'M') {
            totalAmt = totalAmt * (52 / 12);
        } else if (preType === 'H' && afterType === 'Y') {
            totalAmt = totalAmt * 52;
        } else if (preType === 'D' && afterType === 'H') {
            totalAmt = (totalAmt / period) / (workTime * period);
        } else if (preType === 'D' && afterType === 'W') {
            totalAmt = (totalAmt / period) * period;
        } else if (preType === 'D' && afterType === 'M') {
            totalAmt = totalAmt * (52 / 12)
        } else if (preType === 'D' && afterType === 'Y') {
            totalAmt = totalAmt * 52
        } else if (preType === 'W' && afterType === 'H') {
            totalAmt = totalAmt / (workTime * period);
        } else if (preType === 'W' && afterType === 'D') {
            totalAmt = totalAmt / period;
        } else if (preType === 'W' && afterType === 'M') {
            totalAmt = (wage * (52 / 12)) + (((wage * (52 / 12)) - ((wage * (52 / 12)))) * taxRange)
        } else if (preType === 'W' && afterType === 'Y') {
            totalAmt = (wage * 52) + ((wage * 52) - ((wage * 52)) * taxRange)
        } else if (preType === 'M' && afterType === 'H') {
            totalAmt = ((((wage * taxRange) / (52 / 12)) / period) / workTime);
        } else if (preType === 'M' && afterType === 'D') {
            totalAmt = (((wage* taxRange) / (52 / 12)) / period);
        } else if (preType === 'M' && afterType === 'W') {
            totalAmt = ((wage * taxRange) / (52 / 12));
        } else if (preType === 'M' && afterType === 'Y') {
            totalAmt = (wage * 12) + ((wage * 12) - ((wage * 12)) * taxRange);
        } else if (preType === 'Y' && afterType === 'H') {
            totalAmt = ((wage * taxRange) / 52) / 40;
        } else if (preType === 'Y' && afterType === 'D') {
            totalAmt = ((wage * taxRange) / 52) / 7;
        } else if (preType === 'Y' && afterType === 'W') {
            totalAmt = (wage * taxRange) / 52;
        } else if (preType === 'Y' && afterType === 'M') {
            totalAmt = (wage * taxRange) / 12
        }

        Math.floor(totalAmt);
        console.log(totalAmt)
        setTotalAmt(Math.floor(totalAmt));
    }

    const preTypeChange = (e) => {
        setPreType(e.target.value);
    };

    const afterTypeChange = (e) => {
        setAfterType(e.target.value);
    }

    useEffect(() => {

        if((preType ==='W' || preType ==='M' || preType ==='Y') && (afterType === 'M' || afterType === 'Y')) {

            document.getElementById('worktime').disabled = true;
            document.getElementById('period').disabled = true;
            document.getElementById('extended').disabled = true;
            document.getElementById('holidayWageChangeY').disabled = true;
            document.getElementById('holidayWageChangeN').disabled = true;
        }else {
            document.getElementById('worktime').disabled = false;
            document.getElementById('period').disabled = false;
            document.getElementById('extended').disabled = false;
            document.getElementById('holidayWageChangeY').disabled = false;
            document.getElementById('holidayWageChangeN').disabled = false;
        }
    }, [preType, afterType]);

    const wageChange = (e) => {
        setWage(e.target.value);
    }

    const workTimeChange = (e) => {
        setWorkTime(e.target.value);
    }

    const periodChange = (e) => {
        setPeriod(e.target.value);
    }

    const extendedChange = (e) => {
        setExtended(e.target.value);
    }

    const holidayWageChangeY = (e) => {
        setHolidayWage("Y")
        setHolidayWageButton(true)
    }

    const holidayWageChangeN = (e) => {
        setHolidayWage("N")
        setHolidayWageButton(false)
    }

    const taxRangeChange = (e) => {
        setTaxRange(e.target.value);
    }

    return (
        <>
            <Nav/>
            <div className="cashflow-container">
                <div className="cashflow-contents-containers">
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
                    <div className="cashflow-contents">
                        <div className="cashflow-content-title">
                            <div><h1>알바계산기</h1></div>
                        </div>
                        <div className="cashflow-content-cases">
                            <div>
                                <select id="preType" value={preType} onChange={preTypeChange}>
                                    {afterType !== "H" && <option value="H">시급</option>}
                                    {afterType !== "D" && <option value="D">일급</option>}
                                    {afterType !== "W" && <option value="W">주급</option>}
                                    {afterType !== "M" && <option value="M">월급</option>}
                                    {afterType !== "Y" && <option value="Y">연봉</option>}
                                </select>
                            </div>
                            <div> =></div>
                            <div>
                                <select id="afterType" value={afterType} onChange={afterTypeChange}>
                                    {preType !== "H" && <option value="H">시급</option>}
                                    {preType !== "D" && <option value="D">일급</option>}
                                    {preType !== "W" && <option value="W">주급</option>}
                                    {preType !== "M" && <option value="M">월급</option>}
                                    {preType !== "Y" && <option value="Y">연봉</option>}
                                </select>
                            </div>
                        </div>
                        <div className="cashflow-content-wage">
                            <div>{preType.valueOf()}</div>
                            <div><input type="number" id="wage" name="wage" value={wage} onChange={wageChange}
                                        placeholder="시급" step="10" min="0"/></div>
                        </div>
                        <div className="cashflow-content-worktime">
                            <div>일일 근무시간</div>
                            <div><input type="number" id="worktime" name="worktime" value={workTime}
                                        onChange={workTimeChange} placeholder="근무시간" step="0.5" max="24" min="0"/></div>
                        </div>
                        <div className="cashflow-content-period">
                            <div>일주 근무일수</div>
                            <div>
                                <select id="period" value={period} onChange={periodChange}>
                                    <option value="1">주 1일</option>
                                    <option value="2">주 2일</option>
                                    <option value="3">주 3일</option>
                                    <option value="4">주 4일</option>
                                    <option value="5">주 5일</option>
                                    <option value="6">주 6일</option>
                                    <option value="7">주 7일</option>
                                </select>
                            </div>
                        </div>
                        <div className="cashflow-content-extended-hours">
                            <div>월 연장 근무시간</div>
                            <div><input type="number" id="extended" value={extended} onChange={extendedChange}
                                        placeholder="월 연장 근무시간" step="0.5" max="48" min="0"/></div>
                        </div>
                        <div className="cashflow-content-holiday-wage" id="cashflow-content-holiday-wage">
                            <div>주휴수당</div>
                            <div>
                                <button className={holidayWageButton ? "cashflow-content-holiday-wage-button" : ""} id="holidayWageChangeY"
                                        value={holidayWage} onClick={holidayWageChangeY}>주휴수당 포함
                                </button>
                            </div>
                            <div>
                                <button className={holidayWageButton ? "" : "cashflow-content-holiday-wage-button"} id="holidayWageChangeN"
                                        value={holidayWage} onClick={holidayWageChangeN}>주휴수당 미포함
                                </button>
                            </div>
                        </div>
                        <div className="cashflow-content-tax-range">
                            <div>세금</div>
                            <div>
                                <select id="taxrange" value={taxRange} onChange={taxRangeChange}>
                                    <option value="1">미적용</option>
                                    <option value="0.967">3.3%</option>
                                    <option value="0.906">9.4%</option>
                                </select>
                            </div>
                        </div>
                        <div className="cashflow-content-calculator">
                            <div>
                                <button onClick={Calculator}>계산하기</button>
                            </div>
                        </div>
                        <div className="cashflow-content-info">
                            <div><span>{totalAmt}</span></div>
                            <div>info</div>
                        </div>
                    </div>
                </div>
            </div>
            <Footer/>
        </>
    )
}

export default PartTimeJob;