import React from 'react';
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import Main from "./components/main/main";
import Home from "./components/home/home";
import Info from "./components/info/info";
import Login from "./components/login/login";
import CashFlow from "./components/cahsflow /cashflow";
import DownloadApp from "./components/downloadapp/downloadapp";
import Salary from "./components/cahsflow /salary";
import Interest from "./components/cahsflow /interest";
import PartTimeJob from "./components/cahsflow /parttimejob";

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
                    <Route path="/salary" element={<Salary/>}></Route>
                    <Route path="/parttimejob" element={<PartTimeJob/>}></Route>
                    <Route path="/interest" element={<Interest/>}></Route>
                </Routes>
        </BrowserRouter>
    );
}

export default App;