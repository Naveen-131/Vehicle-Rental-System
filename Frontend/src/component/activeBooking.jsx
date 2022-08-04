import React, { Component } from 'react';
import activeBoookingService from '../service/activeBoookingService';
import {Link} from 'react-router-dom';
import ActiveBookingTable from './activeBookingTable';

class ActiveBooking extends Component {
    state = { 
        activeBooking:[],
        
     }
     
     componentDidMount(){
        activeBoookingService.viewAllActiveBooking().then(res=>this.setState({activeBooking:res.data})
        );
    }

    handleDelete=(id)=>{
        activeBoookingService.deleteActiveBookingbyId(id).then(
            (res)=>{
                const activeBooking=this.state.activeBooking.filter((ab)=>ab.activeBookingId !== id);
                this.setState({activeBooking})
               
            }
        )
    }

    handleSearch = (event) => {
        console.log("handleSearch");
        this.setState({ search: event.target.value });
    
        const filteredEmps = this.state.activeBooking.filter(
          (ab) => ab.status.toLowerCase().startsWith(event.target.value.toLowerCase())
           );
        this.setState({ activeBooking: filteredEmps });
      };

    render() { 
        return (

            <div className="mt-3 w-75 mx-auto">
            <div className="d-flex justify-content-end">
            <div>
            <form>
              <input
                type="search"
                className="form-control mb-3"
                placeholder="Search by status"
                value={this.state.search}
                onChange={this.handleSearch}
              />
            </form>
          </div>
            
               <Link to="/activebookings/add">
                     <input 
                     type="button"
                     className="rounded button" 
                     value="Add" />
                 </Link>
                 
                 <Link to="/status">
                 <input 
                 type="button"
                 className="rounded button" 
                 value="Status" />
             </Link>
            
            </div>
               <ActiveBookingTable 
               activeBooking={this.state.activeBooking} 
               handleDelete={this.handleDelete} />
            </div>
            
            
          );
    }
}
 
export default ActiveBooking;