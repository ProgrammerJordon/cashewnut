import React, {useState, useEffect} from 'react';
import {FullPage, Slide} from 'react-full-page';
import app from './styles/app.css';

import Nav from './components/nav/nav'
import MainA from "./components/main/mainA";
import MainB from "./components/main/mainB";
import MainC from "./components/main/mainC";
import MainD from "./components/main/mainD";
import MainE from "./components/main/mainE";
import MainF from "./components/main/mainF";
import MainG from "./components/main/mainG";
import MainH from "./components/main/mainH";

function App() {
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

    return (
        <div style={{height: '100vh'}}>
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
                    <div className={`section ${activeSlide === 6 ? 'active' : ''}`}>
                        <MainH/>
                    </div>
                </Slide>
                {/* Add more slides as needed */}
                <div className="nav">
                    <button onClick={() => handleSlideChange(1)}>Slide 1</button>
                    <button onClick={() => handleSlideChange(2)}>Slide 2</button>
                    <button onClick={() => handleSlideChange(3)}>Slide 3</button>
                    <button onClick={() => handleSlideChange(4)}>Slide 4</button>
                    <button onClick={() => handleSlideChange(5)}>Slide 5</button>
                    <button onClick={() => handleSlideChange(6)}>Slide 6</button>
                    <button onClick={() => handleSlideChange(7)}>Slide 7</button>
                    <button onClick={() => handleSlideChange(8)}>Slide 8</button>
                    {/* Add more navigation buttons for each slide */}
                </div>
            </FullPage>
        </div>
    );
}
export default App;