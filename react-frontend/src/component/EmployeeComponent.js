import React, { useState, useEffect } from 'react';
import axios from 'axios'

const EmployeeComponent = () => {

    const EMPLOYEE__SERVICE_BASE_URL = "http://localhost:8081/api/employees";
    const EMPLOYEE_ID = 2;
    const [employee, setEmployee] = useState({});
    const [department, setDepartment] = useState({});
    const [organization, setOrganization] = useState({});
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(EMPLOYEE__SERVICE_BASE_URL + '/' + EMPLOYEE_ID);
                const result = await response.json();
                setEmployee(result.employee)
                setDepartment(result.department);
                setOrganization(result.organzation);
                console.log(result.employee)
                console.log(result.department)
                console.log(result.organzation)
            } catch (error) {
                setError(error);
            } finally {
                setLoading(false);
            }
        };

        fetchData();
    }, []);
    console.log(employee)
    console.log(department)
    console.log(organization)
    if (loading) {
        return <p>"loading...."</p>
    }
    if (error) {
        <p >{error}</p>
    }
    return (
        <div><br /><br />
            <div className='card col-md-6 offset-md-3'>
                <h3 className='text-center card-header'>View Employee Details</h3>
                <div className='card-body'>
                    <div className='row'>
                        <p><strong>Employee First Name: </strong>{employee.firstName}</p>
                    </div>
                    <div className='row'>
                        <p><strong>Employee Last Name: </strong>{employee.lastName}</p>
                    </div>
                    <div className='row'>
                        <p><strong>Employee Email: </strong>{employee.email}</p>
                    </div>
                </div>
                <h3 className='text-center card-header'>View Department Details</h3>
                <div className='card-body'>
                    <div className='row'>
                        <p><strong>Department Name: </strong>{department.departmentName}</p>
                    </div>
                    <div className='row'>
                        <p><strong>Depatment Description: </strong>{department.departmentDescription}</p>
                    </div>
                    <div className='row'>
                        <p><strong>Department Code: </strong>{department.departmentCode}</p>
                    </div>
                </div>
                <h3 className='text-center card-header'>View Organisation Details</h3>
                <div className='card-body'>
                    <div className='row'>
                        <p><strong>Organisation Name: </strong>{organization.organizationName}</p>
                    </div>
                    <div className='row'>
                        <p><strong>Organisation Description: </strong>{organization.organizationDescription}</p>
                    </div>
                    <div className='row'>
                        <p><strong>Organisation Code: </strong>{organization.organizationCode}</p>
                    </div>
                    {/* <div className='row'>
                        <p><strong>Date created: </strong>{organization.createdDate}</p>
                    </div> */}
                </div>
            </div>
        </div>
    );
};

export default EmployeeComponent;

