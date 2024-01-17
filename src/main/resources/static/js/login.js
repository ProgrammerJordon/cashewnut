// =============================================== KAKAO LOGIN ===============================================

// 카카오 로그인 앱키 1cf7949d3eb1d9695896d35734ccd915
// SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해야 합니다.
Kakao.init('1cf7949d3eb1d9695896d35734ccd915');
Kakao.isInitialized();
// SDK 초기화 여부를 판단합니다.
console.log(Kakao.isInitialized());
function loginWithKakao() {
Kakao.Auth.login({
    // scpope에 들어갈수 있는 항목
    // name(이름), phone_number(전화번호),
    // birthyear(생년), account_ci(연계정보), shipping_address(배송지정보), plusfriends(카카오플러스친추)
    scope:'profile_nickname, account_email, gender, age_range, birthday, friends',
    success: function (authObj) {
        console.log(authObj); // access토큰 값
        Kakao.Auth.setAccessToken(authObj.access_token); // access토큰값 저장
        getInfo(authObj);
    },
    fail: function (err) {
        console.log(err);
    }
});
}

function getInfo(authObj) {
Kakao.API.request({
    url: '/v2/user/me',
    success: function (res) {

        // authObj 접근 토큰
        let access_token = authObj.access_token;

        // res 기본정보 조회
        let id = res.id;
        let connected_at = res.connected_at;
        let email = res.kakao_account.email;
        let age_range = res.kakao_account.age_range;
        let gender = res.kakao_account.gender;
        let profile_nickname = res.kakao_account.profile.nickname;
        let birthday = res.kakao_account.birthday;
        let birthday_type = res.kakao_account.birthday_type;
        let profile_image_url = res.kakao_account.profile.profile_image_url;

        let data = {
            "access_token" : access_token,
            "id" : id,
            "connected_at" : connected_at,
            "email" : email,
            "gender" : gender,
            "profile_nickname": profile_nickname,
            "birthday" : birthday,
            "age_range" : age_range,
            "birthday_type" : birthday_type,
            "profile_image_url" : profile_image_url
        }

        let callback = () => {
            console.log("============세션 충전 완료============")
            window.location.href = '/home';
        }
        console.log("============세션 충전 중============")
        RequestUrl("/login/kakaoSession", "POST", data, callback);
    },
    fail: function (error) {
        alert('카카오 로그인에 실패했습니다. 관리자에게 문의하세요.' + JSON.stringify(error));
    }
});
}

function kakaoLogout() {
    if (!Kakao.Auth.getAccessToken()) {
        alert('Not logged in.');
    return;
    }
    Kakao.Auth.logout(function() {
        alert('logout ok\naccess token -> ' + Kakao.Auth.getAccessToken());
    });
}



// =============================================== GOOGLE LOGIN ===============================================
// {"web":{"client_id":"587091627099-m8d7ok8kut3di0hdk82h43fmsconuups.apps.googleusercontent.com","project_id":"cashewnut","auth_uri":"https://accounts.google.com/o/oauth2/auth","token_uri":"https://oauth2.googleapis.com/token","auth_provider_x509_cert_url":"https://www.googleapis.com/oauth2/v1/certs","client_secret":"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","redirect_uris":["http://localhost/google/oauth"]}}
// sercurePassword : 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
// API KEY : AIzaSyAqQNw8z9o9VSp5IEhKMz2Y1THcqZ-bkhQ


function onSignIn(googleUser) {
    let profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
}

function onSignInFailure(error) {
    // Code to handle sign-in failure
}