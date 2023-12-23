package com.revature.service.imple;

import com.revature.dao.imple.TypesOfServiceImple;
import com.revature.service.ServicesService;

public class ServicesServiceImple implements ServicesService {
    TypesOfServiceImple typesOfServiceImple=new TypesOfServiceImple();
    @Override
    public void getServices() {
        typesOfServiceImple.getTypesOfService();
    }
}
