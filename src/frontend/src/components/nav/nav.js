import React, {useEffect, useState} from 'react';
import nav from './nav.css';

function Nav() {
    return (
        <div className="nav-container">
            <div className="nav-routers">
                <div className="nav-content"><h1>CASHEWNUT</h1></div>
                <div className="nav-content"><h3>HOME</h3></div>
                <div className="nav-content"><h3>BIZ</h3></div>
                <div className="nav-content"><h3>CATEGROY</h3></div>
                <div className="nav-content"><h3>CONTACT</h3></div>
                <div className="nav-content"><h3>CARRER</h3></div>
                <div className="nav-content">
                    <button><img src="./logo192.png" alt="search-button"/></button>
                    <input className="search-input"></input>
                </div>
            </div>
            <div className="nav-routers">
                <div className="nav-right">
                    <button>LOGIN</button>
                    <button>DOWNLOAD APP</button>
                </div>
            </div>
        </div>
    )
}
export default Nav;