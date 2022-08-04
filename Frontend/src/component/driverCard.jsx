import React from 'react';
import { withRouter } from 'react-router-dom';
import vehicleService from '../service/vehicleService';

const DriverCard = ({driver,history}) => {
    const getVehicle=async()=>{
        const response = await vehicleService.getVehicleInfoByDriverId(driver.driverId);
        history.push(`/user/vehicle-details/${response.data.vehicleId}`)
    }
    return (
        <div className="card m-3 shadow" style={{width:"18rem",borderColor:"#ffbe00",borderWidth:"2px"}}>
        <img src="https://img.lovepik.com/element/40101/5709.png_860.png" className="card-img-top" alt="..."/>
        <div className="card-body">
            <h5 className="card-title">{driver.firstName+" "+driver.lastName}</h5>
        </div>
        <ul className="list-group list-group-flush">
            <li className="list-group-item">Location: {driver.address}</li>
            <li className="list-group-item">Conatct Number: {driver.contactNumber}</li>
            <li className="list-group-item">Rating: &#11088;&#11088;&#11088;&#11088;</li>
        </ul>
        <div className="card-body">
            <button onClick={getVehicle} style={{borderColor:"#ffbe00",color:"black",backgroundColor:"white",borderRadius:"8px"}}>Book Vehicle</button>
        </div>
        </div>
      );
}
 
export default withRouter(DriverCard);