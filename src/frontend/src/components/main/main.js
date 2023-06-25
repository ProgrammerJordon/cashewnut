import React, {useState, useEffect} from 'react';
import {FullPage, Slide} from 'react-full-page';
import MainA from "./mainA";
import MainB from "./mainB";
import MainC from "./mainC";
import MainD from "./mainD";
import MainE from "./mainE";
import MainF from "./mainF";
import MainG from "./mainG";
import Footer from "../footer/footer";

import main from "./main.css"
import Nav from "../nav/nav";

function Main() {
    const [activeSlide, setActiveSlide] = useState(0);
    const [scrollTimer, setScrollTimer] = useState(null);

    useEffect(() => {
        clearTimeout(scrollTimer);
        const handleScroll = () => {
            const currentSlide = Math.floor(window.scrollY / window.innerHeight);
            setActiveSlide(currentSlide);
            setScrollTimer(setTimeout(() => {
                setScrollTimer(null);
            }, 1000));
        };

        window.addEventListener('scroll', handleScroll);
        return () => {
            window.removeEventListener('scroll', handleScroll);
        };
    }, []);

    const handleSlideChange = (newSlideIndex) => {
        setActiveSlide(newSlideIndex);
        window.scrollTo({
            top: newSlideIndex * window.innerHeight,
            behavior: 'smooth',
        });
    };

    {/* 슬라이더 */
    }

    return (
        <div>
            <div className="nav-button">
                <div>
                    <button onClick={() => handleSlideChange(0)}></button>
                </div>
                <div>
                    <button onClick={() => handleSlideChange(1)}></button>
                </div>
                <div>
                    <button onClick={() => handleSlideChange(2)}></button>
                </div>
                <div>
                    <button onClick={() => handleSlideChange(3)}></button>
                </div>
                <div>
                    <button onClick={() => handleSlideChange(4)}></button>
                </div>
                <div>
                    <button onClick={() => handleSlideChange(5)}></button>
                </div>
                <div>
                    <button onClick={() => handleSlideChange(6)}></button>
                </div>
                <div>
                    <button onClick={() => handleSlideChange(7)}></button>
                </div>
            </div>
            <button className="csButton">상담버튼</button>
            <FullPage>
                <Slide>
                    <div className={`section ${activeSlide === 0 ? 'active' : ''}`}>
                        <Nav/>
                        <MainA/>
                    </div>
                </Slide>
                <Slide>
                    <div className={`section ${activeSlide === 1 ? 'active' : ''}`}>
                        <MainB/>
                    </div>
                </Slide>
                <Slide>
                    <div className={`section ${activeSlide === 2 ? 'active' : ''}`}>
                        <MainC/>
                    </div>
                </Slide>
                <Slide>
                    <div className={`section ${activeSlide === 3 ? 'active' : ''}`}>
                        <MainD/>
                    </div>
                </Slide>
                <Slide>
                    <div className={`section ${activeSlide === 4 ? 'active' : ''}`}>
                        <MainE/>
                    </div>
                </Slide>
                <Slide>
                    <div className={`section ${activeSlide === 5 ? 'active' : ''}`}>
                        <MainF/>
                    </div>
                </Slide>
                <Slide>
                    <div className={`section ${activeSlide === 6 ? 'active' : ''}`}>
                        <MainG/>
                    </div>
                </Slide>
                <Slide>
                    <div className={`section ${activeSlide === 7 ? 'active' : ''}`}>
                        <Footer/>
                    </div>
                </Slide>
            </FullPage>
        </div>
    );
}

export default Main;