import React from 'react'
import Nav from "../nav/nav";
import Footer from "../footer/footer";
import info from "./info.css";

function Info() {
    return (
        <>
            <Nav/>
            <div className="info-container">
                <div className="info-view">
                    <img className="info-view-img" src='./common0.png' alt="회사로고"/>
                </div>
            </div>
            <Footer/>
        </>
    )
}

export default Info;