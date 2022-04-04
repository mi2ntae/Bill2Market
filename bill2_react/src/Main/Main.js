import React, {Fragment} from "react";
import "./Main.css";
import {Link} from "react-router-dom";
import HeaderPage from "../header/header";

function MainPage()  {
                {/* 초기화면에서 액세스 권한관련 자바 스크립트  */}
    return (
        <Fragment>

            <title>빌리마켓</title>
            <body>
        <header>
            <HeaderPage></HeaderPage>

        </header>

        <main>HOT한 아이템보기/ 주변물품보기</main>

      </body>

    </Fragment>
    )
}

export default MainPage;