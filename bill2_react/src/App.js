import './App.css';
import "antd/dist/antd.css";   //antd 라이브러리 불러오기
import MainPage from "./Main/Main"
import {BrowserRouter, Route, Routes} from "react-router-dom";
import LoginPage from "./login/login";
import SignUpPage from "./signUp/signUp";

function App() {
    return (
      <div>
             <BrowserRouter>
                         <Routes>
                             <Route path = "/*" element={<MainPage />} />
                             <Route path = "/login" element={<LoginPage />} />
                             <Route path = "/signUp" element={<SignUpPage />} />
                         </Routes>
             </BrowserRouter>
         </div>
   );
}

export default App;