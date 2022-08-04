import React, { Component } from 'react';
import activeBoookingService from '../service/activeBoookingService';
import ActiveBookingTable from './activeBookingTable';


class ActiveBookingPending extends Component {
    state = { 
        activeBooking:[],
     }
     
     componentDidMount(){
        activeBoookingService.findByPending().then(res=>this.setState({activeBooking:res.data})
        );
    }
    handleDelete=(id)=>{
        activeBoookingService.deleteActiveBookingbyId(id).then(
            (res)=>{
                const activeBooking=this.state.activeBooking.filter((ab)=>ab.activeBookingId != id);
                this.setState({activeBooking})
               
            }
        )
    }
   
     
    
    render() { 
        return ( 
           <div  className="mt-3 w-75 mx-auto">
           <ActiveBookingTable activeBooking={this.state.activeBooking} handleDelete={this.handleDelete} />
           </div>
         );
    }
}
 
export default ActiveBookingPending;