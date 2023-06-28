import React, {useEffect, useState} from 'react';
import {BrowserRouter, Route, Link, Routes, useNavigate} from 'react-router-dom';
import nav from './nav.css';
import Home from "../home/home";
import App from "../../App";

const underline = {
    textDecoration: 'none',
}

function Nav() {
    const moveLink = useNavigate();
    const LoginButtonClick = () => {
        moveLink('/login');
    };
    const DownLoadAppButtonClick = () => {
        moveLink('/download');
    }
    return (
        <div className="nav-container">
            <div className="nav-containers">
                <div className="nav-routers">
                    <div className="nav-content"><Link to="/" style={underline}><h1>CASHEWNUT</h1></Link></div>
                    <div className="nav-content"><Link to="/home" style={underline}><h3>HOME</h3></Link></div>
                    <div className="nav-content"><Link to="/dividend" style={underline}><h3>DIVIDEND</h3></Link></div>
                    <div className="nav-content"><Link to="/etf" style={underline}><h3>ETF</h3></Link></div>
                    <div className="nav-content"><Link to="/pension" style={underline}><h3>PENSION</h3></Link></div>
                    <div className="nav-content"><Link to="/cashflow" style={underline}><h3>CASH FLOW</h3></Link></div>
                    <div className="nav-content"><Link to="/info" style={underline}><h3>INFO</h3></Link></div>
                    <div className="nav-content">
                        <button><img className="search-button" src="./logo192.png" alt="search-button"/></button>
                        <input className="search-input"></input>
                    </div>
                </div>
                <div className="nav-routers">
                    <div className="nav-content">
                        <div className="nav-right-button">
                            <button onClick={LoginButtonClick}>LOGIN</button>
                            <button onClick={DownLoadAppButtonClick}>DOWNLOAD APP</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Nav;