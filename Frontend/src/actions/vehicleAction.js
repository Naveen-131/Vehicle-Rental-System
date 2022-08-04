import VehicleService from "../service/vehicleService";

export const getAllVehiclesAction = () => async (dispatch) => {
  const response = await VehicleService.getAllVehicles();
  console.log(response.data);
  dispatch({
    type: "GET_ALL_VEHICLES",
    payload: response.data,
  });
};

export const getVehicleByIdAction = (id) => async (dispatch) => {
  const response = await VehicleService.getVehicleById(id);
  console.log(response.data);
  dispatch({
    type: "GET_VEHICLE_BY_ID",
    payload: response.data,
  });
};

export const getVehiclesByLocationAction = (location) => async (dispatch) => {
  const response = await VehicleService.getVehicleByLocation(location);
  console.log(response.data);
  dispatch({
    type: "GET_VEHICLES_BY_LOCATION",
    payload: response.date,
  });
};

export const getVehiclesByTypeAction = (type) => async (dispatch) => {
  const response = await VehicleService.getVehicleByType(type);
  console.log(response.data);
  dispatch({
    type: "GET_VEHICLES_BY_TYPE",
    payload: response.date,
  });
};

export const getVehiclesByCapacityAction = (capacity) => async (dispatch) => {
  const response = await VehicleService.getVehicleByCapacity(capacity);
  console.log(response.data);
  dispatch({
    type: "GET_VEHICLES_BY_CAPACITY",
    payload: response.date,
  });
};
