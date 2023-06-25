import React, {useEffect, useState} from 'react';
import {BrowserRouter, Route, Link, Routes} from 'react-router-dom';
import nav from './nav.css';
import Home from "../home/home";
import App from "../../App";

const underline = {
    textDecoration: 'none',
}

function Nav() {
    return (
        <div className="nav-container">
            <div className="nav-containers">
                <div className="nav-routers">
                    <div className="nav-content"><Link to="/" style={underline}><h1>CASHEWNUT</h1></Link></div>
                    <div className="nav-content"><Link to="/home" style={underline}><h3>HOME</h3></Link></div>
                    <div className="nav-content"><Link to="/biz" style={underline}><h3>BIZ</h3></Link></div>
                    <div className="nav-content"><Link to="/category" style={underline}><h3>CATEGORY</h3></Link></div>
                    <div className="nav-content"><Link to="/contact" style={underline}><h3>CONTACT</h3></Link></div>
                    <div className="nav-content"><Link to="/carrer" style={underline}><h3>CARRER</h3></Link></div>
                    <div className="nav-content">
                        <button><img src="./logo192.png" alt="search-button"/></button>
                        <input className="search-input"></input>
                    </div>
                </div>
                <div className="nav-routers">
                    <div className="nav-content">
                        <div className="nav-right-button">
                            <button>LOGIN</button>
                            <button>DOWNLOAD APP</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Nav;