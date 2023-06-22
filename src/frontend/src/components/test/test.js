import React, {useEffect, useState} from 'react';
import axios from 'axios';
// src 내에 있는 사진 파일은 컴포넌트 현재 경로에서 2개의 상위 경로로 이동해서 임포트 해야함
import TestLogo from "../../logo512.png";

function Test(){
    const [hello, setHello] = useState('리액트에서 적은거임')

    useEffect(() => {
        axios.get('/api/hello')
            .then(response => setHello(response.data))
            .catch(error => console.log(error))
    }, []);
    return (
        <div className="teststyle">
            <img src="./logo192.png" alt="logo192" /> {/* 기본경로 public , 주석 입력 방법 */}
            백엔드에서 가져온 데이터입니다 : {hello}
            <img src={TestLogo} alt="TestLogo"/>
        </div>
    )
}

export default Test;