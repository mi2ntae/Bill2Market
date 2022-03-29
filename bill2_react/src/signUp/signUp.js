import React , {useState} from "react";
import { Form, Input, Select, Checkbox} from 'antd';
import "./signUp.css";
import "./address.js";
import {Link} from "react-router-dom"
import Post from './address.js';

function SignUpPage () {
  const onSubmit = (values) => {   //lambda 함수 사용 , 콜백함수 사용해서 form안에 입력된 값이 values안에 들어감
      console.log("로그인에 성공했습니다",values); //서버로 요청하는 값 
  };
  const onSubmitFailed = (errorInfo) => {  //exception 발생 시 에러 원인 불러오기
      console.log("로그인에 실패했습니다",errorInfo);  //서버로 요청하는 값
  };
  const { Option } = Select;


  // 주소 찾기 구현 위해 리엑트 훅 사용
  const [address, setAddress] = useState("");   
  const [popup, setPopup] = useState(false);



  return (
    <div className = "signup_container">
      <Form 
        name = "signup" 
        onFinish={onSubmit}  //콜백함수 구현 , 값 받아서 values에 넣음
        onFinishFailed={onSubmitFailed} //
      >
      <h1>빌리 마켓 회원가입</h1>


          <Form.Item

          name = "id"
          label="아이디"
          rules = {[{    //입력이 안되면 메세지 뜨는 속성
            required :true,
            message : "아이디를 입력해주세요!" },
        ]}
        >
          <Input/>
          </Form.Item>

          <Form.Item

          name = "password"
          label="비밀번호"
          rules = {[{    //입력이 안되면 메세지 뜨는 속성
            required :true,
            message : "비밀번호를 입력해주세요!" },
        ]}
          hasFeedback   //입력 창 옆 체크&x 표시
        >
          <Input.Password
          />
          </Form.Item>

          <Form.Item
            name="confirm_password"
            label="비밀번호 확인"
            dependencies={['password']}
            hasFeedback
            rules={[
              {
              required: true,
              message: '비밀번호를 입력해주세요!',
              },
              ({ getFieldValue }) => ({
                validator(_, value) {
                  if (!value || getFieldValue('password') === value) {
                    return Promise.resolve();
                  }

                  return Promise.reject(new Error('입력하신 비밀번호가 일치하지 않습니다.'));
              },
            }),
          ]}
          >
          <Input.Password />
          </Form.Item>

          <Form.Item

          name = "name"
          label="이름"
          rules = {[{    //입력이 안되면 메세지 뜨는 속성
          required :true,
          message : "이름을 입력해주세요!" },
        ]}
        >
          <Input />
          </Form.Item>

          <Form.Item

          name = "nickname"
          label="닉네임"
          tooltip="빌리마켓에서 이름 대신 보여집니다. 멋진 닉네임을 지어보세요!"
          rules = {[{    //입력이 안되면 메세지 뜨는 속성
          required :true,
          message : "닉네임을 입력해주세요!" },
        ]}
        >
          <Input />
          </Form.Item>

          <Form.Item

          name = "age"
          label="나이"
          rules = {[{    //입력이 안되면 메세지 뜨는 속성
          required :true,
          message : "나이를 입력해주세요!" },
        ]}
        >
          <Input />
          </Form.Item>

          <Form.Item

          name = "address"
          label="주소"
          rules = {[{    //입력이 안되면 메세지 뜨는 속성
            required :true,
            message : "주소를 입력해주세요!" },
          ]}>
          <Checkbox
          onClick={()=>{
            setPopup(!popup)
          }}
        
          >🔍︎ 주소 검색

          </Checkbox>
          {
            popup && 
            <Post address = {address} setAddress= {setAddress}>
              
            </Post>
          }
          <Input />
          
          </Form.Item>

          <Form.Item

          name = "phonenum"   
          label="전화번호"
          rules = {[{    //입력이 안되면 메세지 뜨는 속성
          required :true,
          message : "전화번호를 입력해주세요!" },
        ]}
        >
          <Input />
          </Form.Item>

          <Form.Item

          name = "email"
          label="이메일"
          rules = {[{
          type: 'email',      
          message : "이메일 양식을 확인해주세요!"  
          },  //입력이 안되면 메세지 뜨는 속성
        {
          required :true,
          message : "이메일을 입력해주세요!"
        },
        
        ]}
        >
          <Input />
          </Form.Item>



      </Form>




</div>

  )
};


export default SignUpPage;