import React from 'react';
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import Main from "./components/main/main";
import Home from "./components/home/home";
import Nav from "./components/nav/nav";
import Info from "./components/info/info";
import Login from "./components/login/login";
import CashFlow from "./components/cahsflow /cashflow";
import downloadApp from "./components/downloadapp/downloadapp";
import DownloadApp from "./components/downloadapp/downloadapp";

function App() {
    return (
        <BrowserRouter>
                <Routes>
                        <Route path="/" element={<Main/>}></Route>
                        <Route path="/home" element={<Home/>}></Route>
                        <Route path="/dividend" element={<Main/>}></Route>
                        <Route path="/etf" element={<Main/>}></Route>
                        <Route path="/pension" element={<Main/>}></Route>
                        <Route path="/cashflow" element={<CashFlow/>}></Route>
                        <Route path="/info" element={<Info/>}></Route>
                        <Route path="/login" element={<Login/>}></Route>
                        <Route path="/download" element={<DownloadApp/>}></Route>
                </Routes>
        </BrowserRouter>
    );
}

export default App;