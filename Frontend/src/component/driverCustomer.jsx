import React, { Component } from 'react';
import DriverService from '../service/driverService';
import DriverCard from './driverCard';

class DriverCustomer extends Component {

    constructor(props) {
        super(props);
        this.state = { 
            drivers:[]
         }
    }

    componentDidMount=async()=>{
        const res = await DriverService.getAllDriver();
        this.setState({drivers:res.data})
    }

    render() { 
        return (
            <div className="d-flex flex-row">
                {
                    this.state.drivers.map(driver=>
                <DriverCard driver={driver} key={driver.driverId}/>)
                }           
            </div>
        );
    }
}
 
export default DriverCustomer;