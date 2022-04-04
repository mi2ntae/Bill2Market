import React, {Fragment, Component} from "react";
import "./header.css";
import {NavLink, Link} from "react-router-dom";
import {Cascader} from "antd";


function HeaderPage()  {
                {/* 초기화면에서 액세스 권한관련 자바 스크립트  */}
    const options = [
        {
            value: '남성',
            label: '남성',
            children: [
                {value: '상의',
                    label: '상의',
                    children: [
                        {
                            value: '셔츠',
                            label: '셔츠',},],
                },
                {
                    value: '하의',
                    label: '하의',
                    children: [
                        {
                            value: '바지',
                            label: '바지',
                        },
                    ],

                },
            ],
        },
        {
            value: '여성',
            label: '여성',
            children: [
                {
                    value: '상의',
                    label: '상의',
                    children: [
                        {
                            value: '블라우스',
                            label: '블라우스',
                        },
                    ],
                },
                {
                    value: '하의',
                    label: '하의',
                    children: [
                        {
                            value: '치마',
                            label: '치마',
                        },
                    ],
                },
            ],
        },
    ];
    function onChange(value) {
        console.log(value);

    }


        
    return (
        <Fragment>
         {/* NavLink 이미지 클릭시 화면이동 */}
          <div>
            <NavLink to={"/MainPage"} >
            <img src={require("./HeaderImage/billi.png")} className = "img_logo"/>
            </NavLink>

          </div>
            <div className="links">
                <Link to={"/login"} className="link_text">
                    로그인/회원가입
                </Link>
                {/* 마이페이지 화면과 연결 */}
                {/* <Link to={""} className="link_text">
                    마이페이지
                </Link> */}
                <a href='' className="link_text" onClick={()=>{console.log('the link')}}>마이페이지</a>
            </div>

            <div className="links_button">
                <a href=''><img src={require("./HeaderImage/sell.png")} height="40px" width="40px" /> 글쓰기</a>
                <a href=''><img src={require("./HeaderImage/chat.png")} height="40px" width="40px"/> 채팅</a>
                <a href=''><img src={require("./HeaderImage/bell.png")} height="40px" width="40px"/> 알림</a>
            </div>



            

            {/* 검색창 껍데기 */}
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
                  <Cascader
                      options={options}
                      expandTrigger="hover"
                      onChange={onChange}
                      placeholder="카테고리"
                  />


              </nav>

        

       

    </Fragment>
    )

}

export default HeaderPage;