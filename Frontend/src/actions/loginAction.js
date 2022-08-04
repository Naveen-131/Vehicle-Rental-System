import axios from "axios";

export const loginAction = (user) => (dispatch) => {

  axios
    .post("http://localhost:8081/signin", user)
    .then((res) =>{
    
      dispatch({
        type: "LOGIN",
        payload: res.data,
      })
      if(user.role==="customer")
      window.location.replace("http://localhost:3000/");
      else if(user.role==="admin")
      window.location.replace("http://localhost:3000/user");
    }
    )
    .catch((error) => {
      console.log(error.response.data.message);
      dispatch({
        type: "ERR_RES",
        payload: error.response.data.message,
      });
    });
};
export const logoutAction = (email) => async (dispatch) => {

  const result = await axios.get(`http://localhost:8081/signout/${email}`);
  

  const res = result.data;
  console.log(res);
  res.errMsg = "";
  dispatch({
    type: "LOGOUT",
    payload: res,
  });
};
