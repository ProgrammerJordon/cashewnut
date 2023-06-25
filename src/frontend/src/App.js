import React from 'react';
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import Main from "./components/main/main";
import Home from "./components/home/home";
import Nav from "./components/nav/nav";

function App() {
    return (
        <BrowserRouter>
                <Routes>
                        <Route path="/" element={<Main/>}></Route>
                        <Route path="/home" element={<Home/>}></Route>
                        <Route path="/biz" element={<Main/>}></Route>
                        <Route path="/category" element={<Main/>}></Route>
                        <Route path="/contact" element={<Main/>}></Route>
                        <Route path="/carrer" element={<Main/>}></Route>
                </Routes>
        </BrowserRouter>
    );
}

export default App;