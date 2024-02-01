import axios from 'axios'

const EMPLOYEE__SERVICE_BASE_URL = "http://localhost:9191/api/employees";
const EMPLOYEE_ID = 2;

const EmployeeService = {
    getEmployee: () => {
        return axios.get(EMPLOYEE__SERVICE_BASE_URL + '/' + EMPLOYEE_ID);
    }
  };
  
  export default EmployeeService;