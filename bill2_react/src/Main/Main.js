import React, {Fragment} from "react";
import "./Main.css";
import {Link} from "react-router-dom";

function MainPage()  {
                {/* 초기화면에서 액세스 권한관련 자바 스크립트  */}
    return (
        <Fragment>

            <title>빌리마켓</title>
            <body>
        <header>
            {/* 버튼 5개 a태그로 구현 로그인/회원가입의 하이퍼링크를 로그인페이지로 연결 나머지는 팝업후 확인 누르면 현재 페이지 새로고침 */}
            <div className="links">
                <Link to={"/login"} className="link_text">
                    로그인/회원가입
                </Link>



                <a href='' className="link_text">마이페이지</a>
            </div>

            <div className="links_button">
                <a href=''><img src={require("./HeaderImage/sell.png")} height="40px" width="40px" /> 글쓰기</a>
                <a href=''><img src={require("./HeaderImage/chat.png")} height="40px" width="40px"/> 채팅</a>
                <a href=''><img src={require("./HeaderImage/bell.png")} height="40px" width="40px"/> 알림</a>
            </div>



            {/* 지금은 로고이미지 클릭했을때 새로고침인데 하이퍼링크로 초기페이지로 돌아오게 해야하고 로그인 기능후 화면에서는 메인페이지로 연결해야함  */}
            <a href='' > <img src={require("./HeaderImage/billi.png")} className="img_logo" />  </a>

            {/* 검색창 껍데기만  */}
            <form>
                <fieldset>
                  <legend className="visually-hidden"/>
                  <div className="search_box">
                    <input type="text" maxLength="225" tabIndex="1" />
                    <button type="submit" tabIndex="2">
                      검색
                    </button>
                  </div>
                </fieldset>

              </form>

               {/* 카테고리 껍데기  */}
              <nav>
                <div className="nav_items">
                    <div className="keyword">
                        <span className="category"/>
                        <span>카테고리</span>
                        <select id="browsers" name="browsers">
                            <option value="a">전체</option>
                            <option value="b">a</option>
                            <option value="c">b</option>
                            <option value="d">c</option>
                            <option value="e">d</option>
                            <option value="f">e</option>
                        </select>
                      </div>
                </div>
              </nav>

        </header>

        <main>HOT한 아이템보기/ 주변물품보기</main>

      </body>

    </Fragment>
    )
}

export default MainPage;