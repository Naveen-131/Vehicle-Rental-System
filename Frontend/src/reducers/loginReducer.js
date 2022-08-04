
const initialLoginState = {
    userId:0,
    email: "",
    role: "",
    loggedIn: false,
    errMsg: "",
  };
  
  const LoginReducer = (state = initialLoginState, action) => {
    switch (action.type) {
      case "LOGIN":
        console.log(action.payload);
        return { ...state, ...action.payload };
      case "ERR_RES":
        return { ...state, errMsg: action.payload };
      case "LOGOUT":
        return { ...state, ...action.payload };
      default:
        return state;
    }
  };
  
  export default LoginReducer;