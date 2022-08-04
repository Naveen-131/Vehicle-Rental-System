const vehicleIntialState = {
  vehicles: [],
  vehicle: {},
};

const VehicleReducer = (state = vehicleIntialState, action) => {
  switch (action.type) {
    case "GET_ALL_VEHICLES":
      return { ...state, vehicles: action.payload };
    case "GET_VEHICLE_BY_ID":
      return { ...state, vehicle: action.payload };
    case "GET_VEHICLES_BY_LOCATION":
      return { ...state, vehicles: action.payload };
    case "GET_VEHICLES_BY_TYPE":
      return { ...state, vehicles: [...action.payload] };
    case "GET_VEHICLES_BY_CAPACITY":
      return { ...state, vehicles: [...action.payload] };
    default:
      return state;
  }
};

export default VehicleReducer;
