import React, {useEffect, useState} from 'react';
import main from './main.css';

function MainB() {
    const images = ['./common0.png', './common1.png', './common2.png', './common3.png', './common4.png'];
    const [currentImageIndex, setCurrentImageIndex] = useState(0);

    useEffect(() => {
        // 자동 슬라이드 타이머 설정
        const timer = setInterval(() => {
            goToNextImage();
        }, 3000);

        // 컴포넌트가 언마운트될 때 타이머 정리
        return () => clearInterval(timer);
    }, [currentImageIndex]);

    const goToNextImage = () => {
        const nextIndex = (currentImageIndex + 1) % images.length;
        setCurrentImageIndex(nextIndex);
    };

    const goToPreviousImage = () => {
        const previousIndex = (currentImageIndex - 1 + images.length) % images.length;
        setCurrentImageIndex(previousIndex);
    };
    return (
        <div className="main-container">
            <div className="main-view">
                <button className="prev-button" onClick={goToPreviousImage}>이전</button>
                <img className="main-view-picture" src={images[currentImageIndex]} alt="slide"/>
                <button className="next-button" onClick={goToNextImage}>다음</button>
            </div>
        </div>
    )
}

export default MainB;