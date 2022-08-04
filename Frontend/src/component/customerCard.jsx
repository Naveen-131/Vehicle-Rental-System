// import React, { useState, useEffect } from "react";
// import {
//   Grid,
//   Paper,
//   Box,
//   Container,
//   Drawer,
//   List,
//   ListItem,
//   ListItemText,
//   Card,
//   CardActionArea,
//   CardMedia,
//   CardContent,
//   Typography,
//   Button,
// } from "@material-ui/core";
// import "./css/AddCustomer.css"
// import { makeStyles } from "@material-ui/core/styles";


// import axios from "axios";
// import { Link } from "react-router-dom";
// import { NavLink } from "react-router-dom";
// import { useSelector, useDispatch } from "react-redux";

// import { getAllCustomersAction } from "../actions/customerAction"

// const useStyles = makeStyles((theme) => ({
//   root: {
//     display: "flex",
//   },

//   // necessary for content to be below app bar
//   toolbar: theme.mixins.toolbar,
//   content: {
//     flexGrow: 1,
//     backgroundColor: theme.palette.background.default,
//     padding: theme.spacing(3),
    
//   },
//   media: {
//     height: 140,
//   },
// }));

// const CustomersCard = () => {
//   const dispatch = useDispatch();

//   useEffect(() => {
//     dispatch(getAllCustomersAction());
//   }, []);

//   const customers = useSelector((state) => state.customer.customers);
  


//   console.log(customers);

//   const classes = useStyles();

//   return (
//     <Container style={{ marginTop: "30px" }}>
//       <Grid container spacing={3} >
//       <Paper elevation={3} square/>
//         <Grid item sm={12}>
//           <Grid container spacing={3}>
//             {customers.map((c) => (
//               <Grid item xs={12} sm={6} md={4} lg={3} key={c.customerId}>
                
//                   <Card
//                     style={{
//                       margin: "10px",
//                       height: "280px",
//                     }}
//                   >
//                     <CardActionArea>
//                       <CardMedia
//                         className={classes.media}
//                         image="/vehicleSample.jpeg"
//                         title="Vehicle image"
//                     />                    
//                     <CardContent>                   
//                         <Box textAlign="left">
//                           <Typography>Customer Id :{c.customerId} </Typography>                    
//                         </Box>                        
//                         <Box textAlign="left">
//                           <Typography>First Name :{c.firstName} </Typography>                    
//                         </Box>
                    
//                         <Box alignContent="center" className="mt-2">
//                           <Button variant="contained" fullWidth="100"   component={NavLink} to={`/customer/customerdetails/${c.customerId}`}>Customer Details</Button>
//                         </Box>
//                       </CardContent>
//                     </CardActionArea>
//                   </Card>
                
//               </Grid>
//             ))}
//           </Grid>
//       </Grid>
      
//       </Grid>
//     </Container>
//   );
// };

// export default CustomersCard;
