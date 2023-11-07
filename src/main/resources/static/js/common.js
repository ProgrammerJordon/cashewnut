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


