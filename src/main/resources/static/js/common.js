/**
 * RequestUrl(
 *      // url
 *     "https://api.example.com/data",
 *     // method
 *     "GET",
 *     {
 *         // DTO JSON 파라미터
 *         param1: "value1",
 *         param2: "value2"
 *     },
 *     // callback 함수
 *     (response) => {
 *         // 성공 시 처리
 *         console.log("성공:", response);
 *     }
 * );
 * @param url
 * @param method
 * @param data
 * @param successCallback
 * @constructor
 */
function RequestUrl(url, method, data, successCallback) {
    try {
        $.ajax({
            url: url,
            type: method,
            data: JSON.stringify(data),
            contentType: 'application/json',
            success: function (result) {
                if (successCallback && typeof successCallback === 'function') {
                    successCallback(result);
                }
            }
        });
    } catch (error) {
        console.error("에러 발생:", error);
    }
}

function RequestJsonUrl(url, method, data, successCallback) {
    try {
        $.ajax({
            url: url,
            type: method,
            data: data,
            contentType: 'application/json',
            success: function (result) {
                if (successCallback && typeof successCallback === 'function') {
                    successCallback(result);
                }
            }
        });
    } catch (error) {
        console.error("에러 발생:", error);
    }
}


function bsopHourGb(param) {
    if(param == "1") {
        return "09:30"
    }
    if(param == "2") {
        return "10:00"
    }
    if(param == "3") {
        return "11:20"
    }
    if(param == "4") {
        return "12:30"
    }
    if(param == "5") {
        return "14:30"
    }
}

function prdyVrssSign(param) {
    if(param == "1") {
        return "상한가"
    }
    if(param == "2") {
        return "상승"
    }
    if(param == "3") {
        return "보합"
    }
    if(param == "4") {
        return "하한가"
    }
    if(param == "5") {
        return "하락"
    }
}

/**
 * 시장경고코드
 * @param param
 * @returns {string}
 * 00 : 없음
 * 01 : 투자주의
 * 02 : 투자경고
 * 03 : 투자위험
 */
function mrktWarnClsCode(param) {
    if(param == "00") {
        return "양호"
    }
    if(param == "01") {
        return "투자주의"
    }
    if(param == "02") {
        return "투자경고"
    }
    if(param == "03") {
        return "투자위험"
    }
}

function sstsYn(param) {
    if(param == "Y") {
        return "가능"
    }
    if(param == "N") {
        return "불가능"
    }
}

/**
 * 요일구분코드
 * @param param
 * @returns {string}
 * 01:일요일, 02:월요일, 03:화요일, 04:수요일, 05:목요일, 06:금요일, 07:토요일
 */
function wdayDvsnCd(param) {
    if(param == "01") {
        return "일요일"
    }
    if(param == "02") {
        return "월요일"
    }
    if(param == "03") {
        return "화요일"
    }
    if(param == "04") {
        return "수요일"
    }
    if(param == "05") {
        return "목요일"
    }
    if(param == "06") {
        return "금요일"
    }
    if(param == "07") {
        return "토요일"
    }
}

function opndYn(param) {
    if(param == "Y") {
        return "개장"
    }
    if(param == "N") {
        return "휴장"
    }
}

function formatYmdDate(param) {
    let year = param.substring(0, 4);
    let month = param.substring(4, 6);
    let day = param.substring(6, 8);

    return year + '/' + month + '/' + day;
}

function formatHHMMSSTime(param) {
    let hours = param.substring(0, 2);
    let minutes = param.substring(2, 4);
    let seconds = param.substring(4, 6);

    return hours + ':' + minutes + ':' + seconds;
}

function SubstringDateMd (param) {
    let year = param.substring(0, 2); // 앞의 2자리
    let month = param.substring(2, 4); // 뒤의 2자리
    return year+"/"+month;
}
